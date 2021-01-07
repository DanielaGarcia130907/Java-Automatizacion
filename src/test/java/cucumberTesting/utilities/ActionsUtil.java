package cucumberTesting.utilities;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActionsUtil {

	// Expresiones Regulares para los features \"([^\"]*)\" (\\d+) \"(.*?)\"

	private ActionsUtil() {
		throw new IllegalStateException("Utility class");
	}

	static HashMap<String, By> objetosPage = new HashMap<String, By>();
	static PropertiesLoader properties = PropertiesLoader.getInstance();
	private static final Logger LOGGER = LoggerFactory.getLogger(ActionsUtil.class);
	private static final long TIMEOUTS = (getProperty("webdriver.timeouts.implicitlywait")) != null
			? Long.parseLong(getProperty("webdriver.timeouts.implicitlywait"))
			: 2000L;
	private static final long PAGE_LOAD_TIMEOUTS = (getProperty("webdriver.timeouts.pageLoadTimeout")) != null
			? Long.parseLong(getProperty("webdriver.timeouts.pageLoadTimeout"))
			: 40000L;
	private static final long SET_SCRIPT_TIMEOUTS = (getProperty("webdriver.timeouts.setScriptTimeout")) != null
			? Long.parseLong(getProperty("webdriver.timeouts.setScriptTimeout"))
			: 60000L;

	public static By getObjeto(String nombreObjeto) {
		By retorno = objetosPage.get(nombreObjeto);
		String valueContains = "Objeto no mapeado";
		if (retorno == null)
			valueContains = nombreObjeto;
		assertThat("Objeto no mapeado", CoreMatchers.equalTo(valueContains));
		return retorno;
	}

	public static void objetosPut(String key, By value) {
		String validacionKey = "Objeto mapeado en objectsmap";
		By valueKey = objetosPage.get(key);
		if (valueKey != null) {
			validacionKey = "El objeto " + key + " ya fue mapeado: " + valueKey;
			objetosPage = new HashMap<String, By>();
		}
		assertThat("Objeto mapeado en objectsmap", CoreMatchers.equalTo(validacionKey));
		objetosPage.put(key, value);
	}

	public static boolean objetosIsEmpty() {
		return objetosPage.isEmpty();
	}

	public static void setProperty(String property, String url) {
		properties.setProperty(property, url);
	}

	public static String getProperty(String property) {
		return properties.getProperty(property);
	}

	public static void highlightElement(WebDriver driver, By by) {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
		for (int second = 0; second <= 60; second++) {
			try {
				driver.findElement(by);
				if (driver.findElement(by).isDisplayed())
					break;
			} catch (Exception e) {
				sleepMiliseconds(1);
			}
			sleepMiliseconds(100);
		}
		modificarEstilo(driver, by, "border: 3px solid green;");
		driver.manage().timeouts().implicitlyWait(TIMEOUTS, TimeUnit.MILLISECONDS);
	}

	private static void modificarEstilo(WebDriver driver, By by, String modifyStyle) {
		WebElement element = driver.findElement(by);
		String originalStyle = element.getAttribute("style");
		String comandoExecute = "arguments[0].setAttribute('style', arguments[1]);";
		modifyStyle = getEstiloModificado(driver, by, modifyStyle);
		for (int i = 0; i < 2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(comandoExecute, element, modifyStyle);
			sleepMiliseconds(15);
			js.executeScript(comandoExecute, element, originalStyle);
			sleepMiliseconds(5);
		}
	}

	private static String getEstiloModificado(WebDriver driver, By by, String modifyStyle) {
		final String ATRIBUTO_ESTILO = "border:";
		WebElement element = driver.findElement(by);
		String originalStyle = element.getAttribute("style");
		if (originalStyle.contains(ATRIBUTO_ESTILO)) {
			int indexInicio = 7 + originalStyle.indexOf(ATRIBUTO_ESTILO);
			String aux = originalStyle.substring(indexInicio);
			int indexFin = indexInicio + aux.indexOf(';');
			String strInicial = originalStyle.substring(0, originalStyle.indexOf(ATRIBUTO_ESTILO));
			String strMedio = modifyStyle.replace(";", "");
			String strFinal = originalStyle.substring(indexFin);
			modifyStyle = strInicial + strMedio + strFinal;
		} else {
			modifyStyle = modifyStyle + " " + originalStyle;
		}
		return modifyStyle;
	}

	public static void goToWebSide(WebDriver driver, String text) {
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(240, TimeUnit.SECONDS);
		String currentURL = driver.getCurrentUrl();
		if (!text.isEmpty() && !text.equals(currentURL)) {
			for (int i = 0; i < 3; i++) {
				try {
					driver.navigate().to(text);
					break;
				} catch (Exception e) {
					LOGGER.info("Exception NAVIGATE TO " + text + " Error:" + e);
				}
			}
		}
		driver.manage().timeouts().implicitlyWait(TIMEOUTS, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUTS, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().setScriptTimeout(SET_SCRIPT_TIMEOUTS, TimeUnit.MILLISECONDS);
	}

	public static void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public static void presionarTecla(WebDriver driver, By by, String tecla) {
		WebElement element = driver.findElement(by);
		List<WebElement> elementsToClicked = driver.findElements(by);
		for (WebElement element_ : elementsToClicked) {
			try {
				if (element_.isDisplayed()) {
					element = element_;
					break;
				}
			} catch (Exception e) {
				sleepMiliseconds(1);
			}
		}
		if (ActionsUtil.textoMinusculasSinEspacios(tecla).equalsIgnoreCase("f5")) {
			element.sendKeys(Keys.F5);
		} else if (ActionsUtil.textoMinusculasSinEspacios(tecla).equalsIgnoreCase("backspace")) {
			element.sendKeys(Keys.BACK_SPACE);
		} else if (ActionsUtil.textoMinusculasSinEspacios(tecla).equalsIgnoreCase("inicio")) {
			element.sendKeys(Keys.HOME);
		} else if (ActionsUtil.textoMinusculasSinEspacios(tecla).equalsIgnoreCase("fin")) {
			element.sendKeys(Keys.END);
		} else if (ActionsUtil.textoMinusculasSinEspacios(tecla).equalsIgnoreCase("suprimir")) {
			element.sendKeys(Keys.DELETE);
		} else if (ActionsUtil.textoMinusculasSinEspacios(tecla).equalsIgnoreCase("flechaizquierda")) {
			element.sendKeys(Keys.ARROW_LEFT);
		} else if (ActionsUtil.textoMinusculasSinEspacios(tecla).equalsIgnoreCase("flechaderecha")) {
			element.sendKeys(Keys.ARROW_RIGHT);
		} else if (ActionsUtil.textoMinusculasSinEspacios(tecla).equalsIgnoreCase("tab")) {
			element.sendKeys(Keys.TAB);
		} else if (ActionsUtil.textoMinusculasSinEspacios(tecla).equalsIgnoreCase("avanzarpagina")) {
			element.sendKeys(Keys.PAGE_DOWN);
			sleepSeconds(1);
		} else if (ActionsUtil.textoMinusculasSinEspacios(tecla).equalsIgnoreCase("retrocederpagina")) {
			element.sendKeys(Keys.PAGE_UP);
			sleepSeconds(1);
		} else if (ActionsUtil.textoMinusculasSinEspacios(tecla).equalsIgnoreCase("")) {
		} else {
			assertThat("Tecla no mapeado", CoreMatchers.equalTo(tecla));
		}
	}

	public static boolean existsElement(WebDriver driver, By objeto) {
		try {
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
			WebElement element = driver.findElement(objeto);
			driver.manage().timeouts().implicitlyWait(TIMEOUTS, TimeUnit.MILLISECONDS);
			if (element.isDisplayed())
				return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public static boolean existsElement(WebElement element) {
		try {
			if (element.isDisplayed())
				return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public static void noExiste(WebDriver driver, By objeto) {
		boolean existAny = false;
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
		List<WebElement> elementsThatNotExists = driver.findElements(objeto);
		driver.manage().timeouts().implicitlyWait(TIMEOUTS, TimeUnit.MILLISECONDS);
		for (WebElement element : elementsThatNotExists) {
			if (existsElement(element)) {
				existAny = true;
				String modifyStyle = getEstiloModificado(driver, objeto, "border: 3px solid green;");
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, modifyStyle);
				break;
			}
		}
		assertFalse("Se encontro el elemento " + objeto, existAny);
	}

	public static String textoMinusculasSinEspacios(String texto) {
		String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
		String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
		for (int i = 0; i < original.length(); i++) {
			texto = texto.replace(original.charAt(i), ascii.charAt(i));
		}
		texto = texto.replaceAll("\t|\n| ", "");
		texto = texto.toLowerCase();
		return texto;
	}

	public static void setTextField(WebDriver driver, By by, String text) {
		if (!text.isEmpty()) {
			highlightElement(driver, by);
			WebElement element = driver.findElement(by);
			element.clear();
			element.sendKeys(text);
		}
	}

	public static void setTextFieldSlowly(WebDriver driver, By by, String text) {
		if (!text.isEmpty()) {
			highlightElement(driver, by);
			WebElement element = driver.findElement(by);
			element.clear();
			for (int i = 0; i < text.length(); i++) {
				String character = text.substring(i, i + 1);
				element.sendKeys(character);
				sleepMiliseconds(5);
			}
		}
	}

	public static String[][] getTable(WebDriver driver, By by) {
		highlightElement(driver, by);
		WebElement tableElement = driver.findElement(by);
		List<WebElement> trCollection = tableElement.findElements(By.tagName("tr"));
		String[][] tabla = new String[999][999];
		int rowNum = 0;
		int colNum;
		int colMax = 0;
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
		for (WebElement trElement : trCollection) {
			List<WebElement> tdCollection = trElement.findElements(By.tagName("td"));
			if (tdCollection.isEmpty()) {
				tdCollection = trElement.findElements(By.tagName("th"));
			}
			if (tdCollection.size() > colMax)
				colMax = tdCollection.size();
			colNum = 0;
			for (WebElement tdElement : tdCollection) {
				tabla[rowNum][colNum] = tdElement.getText();
				colNum++;
			}
			rowNum++;
		}
		assertTrue(rowNum > 0);
		assertTrue(colMax > 0);
		String[][] tablaReturn = new String[rowNum][colMax];
		for (int i = 0; i < rowNum; i++) {
			System.arraycopy(tabla[i], 0, tablaReturn[i], 0, colMax);
		}
		driver.manage().timeouts().implicitlyWait(TIMEOUTS, TimeUnit.MILLISECONDS);
		return tablaReturn;
	}

	public static String[][] getTableDiv(WebDriver driver, By by) {
		highlightElement(driver, by);
		WebElement element = driver.findElement(by);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
		List<WebElement> childCollection = element.findElements(By.xpath("./*"));
		String[][] tabla = new String[999][999];
		int rowNum = 0;
		int colNum;
		int colMax = 0;
		boolean containInfo = false;
		for (WebElement childElement : childCollection) {
			List<WebElement> grandChildCollection = childElement.findElements(By.xpath("./*"));
			if (grandChildCollection.size() > colMax)
				colMax = grandChildCollection.size();
			colNum = 0;
			containInfo = false;
			for (WebElement tdElement : grandChildCollection) {
				String aux = tdElement.getText();
				tabla[rowNum][colNum] = aux;
				colNum++;
				if (aux != null && !aux.isEmpty()) {
					containInfo = true;
				}
			}
			if (containInfo) {
				rowNum++;
			}
		}
		assertTrue(rowNum > 0);
		assertTrue(colMax > 0);
		String[][] tablaReturn = new String[rowNum][colMax];
		for (int i = 0; i < rowNum; i++) {
			System.arraycopy(tabla[i], 0, tablaReturn[i], 0, colMax);
		}
		driver.manage().timeouts().implicitlyWait(TIMEOUTS, TimeUnit.MILLISECONDS);
		return tablaReturn;
	}

	public static String getText(WebDriver driver, By by) {
		highlightElement(driver, by);
		WebElement element = driver.findElement(by);
		return element.getText();
	}

	public static String getTextIfDisplayed(WebDriver driver, By by) {
		boolean wasRead = false;
		String retorno = null;
		List<WebElement> elementsToClicked = driver.findElements(by);
		for (WebElement element : elementsToClicked) {
			try {
				if (element.isDisplayed()) {
					retorno = element.getText();
					wasRead = true;
					break;
				}
			} catch (Exception e) {
				sleepMiliseconds(1);
			}
		}
		assertTrue("No se clickeo ningún elemento " + by, wasRead);
		return retorno;
	}

	public static String getTextAttribute(WebDriver driver, By by) {
		highlightElement(driver, by);
		WebElement element = driver.findElement(by);
		return element.getAttribute("value");
	}

	public static String getAttribute(WebDriver driver, By by, String atributo) {
		highlightElement(driver, by);
		WebElement element = driver.findElement(by);
		String retorno = element.getAttribute(atributo);
		if (retorno == null)
			retorno = "";
		if (retorno.isEmpty())
			retorno = element.getCssValue(atributo);
		return retorno;
	}

	public static void clicParent(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		try {
			element.findElement(By.xpath("..")).click();
			element.findElement(By.xpath("../..")).click();
		} catch (Exception e) {
			LOGGER.error("Excepcion Clic .. o ../..:", e);
		}
	}

	public static void clic(WebDriver driver, By by) {
		highlightElement(driver, by);
		if (driver.findElements(by).size() > 1) {
			clicIfDisplayed(driver, by);
		} else {
			WebElement element = driver.findElement(by);
			element.click();
		}
	}

	public static void clic(WebDriver driver) {
		WebElement currentElement = driver.switchTo().activeElement();
		currentElement.click();
	}

	public static void clicIfDisplayed(WebDriver driver, By by) {
		boolean wasCicked = false;
		List<WebElement> elementsToClicked = driver.findElements(by);
		for (WebElement element : elementsToClicked) {
			try {
				if (element.isDisplayed()) {
					element.click();
					wasCicked = true;
					break;
				}
			} catch (Exception e) {
				sleepMiliseconds(1);
			}
		}
		assertTrue("No se clickeo ningún elemento " + by, wasCicked);
	}

	public static void selectText(WebDriver driver, By by, String option) {
		highlightElement(driver, by);
		WebElement element = driver.findElement(by);
		new Select(element).selectByVisibleText(option);
	}

	public static void selectIndex(WebDriver driver, By by, int indexOption) {
		highlightElement(driver, by);
		WebElement element = driver.findElement(by);
		new Select(element).selectByIndex(indexOption);
	}

	public static void selectContains(WebDriver driver, By by, String valueContains) {
		highlightElement(driver, by);
		WebElement element = driver.findElement(by);
		String valueComboBox = element.getText();
		assertThat(valueComboBox, CoreMatchers.containsString(valueContains));
		String[] values = valueComboBox.split("\n");
		int index = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i].contains(valueContains)) {
				index = i;
				break;
			}
		}

		Select select = new Select(element);
		select.selectByIndex(index);
		WebElement option = select.getFirstSelectedOption();
		String valorActual = option.getText();
		if (!valorActual.contains(valueContains)) {
			select = new Select(element);
			select.selectByIndex(index + 1);
			option = select.getFirstSelectedOption();
			valorActual = option.getText();
		}
		assertThat(valorActual, CoreMatchers.containsString(valueContains));
	}

	public static void selectValue(WebDriver driver, By by, String valueOption) {
		highlightElement(driver, by);
		WebElement element = driver.findElement(by);
		new Select(element).selectByValue(valueOption);
	}


	public static void containsText(WebDriver driver, By by, String valorEsperado) {
		String valorObtenido = getText(driver, by);
		valorEsperado = valorEsperado.replace("\\\"", "\"");
		assertThat(valorObtenido, CoreMatchers.containsString(valorEsperado));
	}

	public static void compareTextStart(WebDriver driver, By by, String textStart) {
		String valorObtenido = getText(driver, by);
		assertThat(valorObtenido, CoreMatchers.startsWith(textStart));
	}

	public static void compareTextNotEmpty(WebDriver driver, By by) {
		String valorObtenido = getText(driver, by);
		assertThat(valorObtenido, !valorObtenido.isEmpty());
	}

	public static void compareAtributo(WebDriver driver, By by, String atributo, String valorEsperado) {
		String valorObtenido = getAttribute(driver, by, atributo);
		if (valorObtenido.isEmpty() || valorEsperado.isEmpty())
			assertEquals(valorEsperado, valorObtenido);
		else
			assertThat(valorObtenido, CoreMatchers.containsString(valorEsperado));
	}

	public static void checkBox(WebDriver driver, By by, boolean checked) {
		highlightElement(driver, by);
		WebElement element = driver.findElement(by);
		if (checked) {
			if (!element.isSelected() && element.isEnabled()) {
				element.click();
			}
		} else {
			if (element.isSelected() && element.isEnabled()) {
				element.click();
			}
		}
	}

	public static void ejecutarScript(WebDriver driver, String script, By by) {
		WebElement element = driver.findElement(by);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript(script, element);
	}

	public static void ejecutarScript(WebDriver driver, String script) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript(script);
	}


	private static ExpectedCondition<Boolean> getConditionWait(By objeto, String atributo, String valor) {
		ExpectedCondition<Boolean> condicion = null;
		if (textoMinusculasSinEspacios(atributo).equals("text")) {
			condicion = ExpectedConditions.textToBePresentInElementLocated(objeto, valor);
		} else {
			if (valor.equals("")) {
				condicion = ExpectedConditions.attributeToBe(objeto, atributo, valor);
			} else {
				condicion = ExpectedConditions.attributeContains(objeto, atributo, valor);
			}
		}
		return condicion;
	}

	public static void waitForAttribute(WebDriver driver, By objeto, String atributo, String valor) {
		WebDriverWait wait = new WebDriverWait(driver, (long) (TIMEOUTS / 1000));
		wait.until(getConditionWait(objeto, atributo, valor));
	}

	public static void waitForClickable(WebDriver driver, By objeto) {
		WebDriverWait wait = new WebDriverWait(driver, (long) (TIMEOUTS / 1000));
		wait.until(ExpectedConditions.elementToBeClickable(objeto));
	}

	public static void waitForNotAttribute(WebDriver driver, By objeto, String atributo, String valor) {
		WebDriverWait wait = new WebDriverWait(driver, (long) (TIMEOUTS / 1000));
		wait.until(ExpectedConditions.not(getConditionWait(objeto, atributo, valor)));
	}

	public static void dragAndDrop(WebDriver driver, By byDraggable, By byDroppable) {
		highlightElement(driver, byDraggable);
		WebElement elementDrag = driver.findElement(byDraggable);
		highlightElement(driver, byDroppable);
		WebElement elementDrop = driver.findElement(byDroppable);
		Actions dragAndDrop = new Actions(driver);
		dragAndDrop.dragAndDrop(elementDrag, elementDrop).perform();
	}

	public static void dragAndDrop(WebDriver driver, By byElement, int x, int y) {
		highlightElement(driver, byElement);
		WebElement elementDrag = driver.findElement(byElement);
		Actions dragAndDrop = new Actions(driver);
		dragAndDrop.dragAndDropBy(elementDrag, x, y).perform();
	}

	public static void sleepSeconds(int sleep) {
		sleepMiliseconds(1000L * sleep);
	}

	public static void sleepMiliseconds(long timeMiliSeconds) {
		try {
			Thread.sleep(timeMiliSeconds);
		} catch (Exception e) {
			LOGGER.error("Excepcion Sleep:", e);
		}
	}

	public static int byShared(WebDriver driver, By objClass1, By objClass2) {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
		int retorno = 0;
		for (int second = 0; second <= 60; second++) {
			boolean flagBreak = false;
			try {
				driver.findElement(objClass1);
				if (driver.findElement(objClass1).isDisplayed()) {
					flagBreak = true;
					retorno = 1;
				}
			} catch (Exception e) {
				sleepMiliseconds(1);
			}
			try {
				driver.findElement(objClass2);
				if (driver.findElement(objClass2).isDisplayed()) {
					flagBreak = true;
					retorno = 2;
				}
			} catch (Exception e) {
				sleepMiliseconds(1);
			}
			if (flagBreak) {
				break;
			}
			sleepMiliseconds(100);
		}
		driver.manage().timeouts().implicitlyWait(TIMEOUTS, TimeUnit.MILLISECONDS);
		return retorno;
	}

	public static int byShared(WebDriver driver, By objClass1, By objClass2, By objClass3) {
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
		int retorno = 0;
		for (int second = 0; second <= 60; second++) {
			boolean flagBreak = false;
			try {
				driver.findElement(objClass1);
				if (driver.findElement(objClass1).isDisplayed()) {
					flagBreak = true;
					retorno = 1;
				}
			} catch (Exception e) {
				sleepMiliseconds(1);
			}
			try {
				driver.findElement(objClass2);
				if (driver.findElement(objClass2).isDisplayed()) {
					flagBreak = true;
					retorno = 2;
				}
			} catch (Exception e) {
				sleepMiliseconds(1);
			}
			try {
				driver.findElement(objClass3);
				if (driver.findElement(objClass3).isDisplayed()) {
					flagBreak = true;
					retorno = 3;
				}
			} catch (Exception e) {
				sleepMiliseconds(1);
			}
			if (flagBreak) {
				break;
			}
			sleepMiliseconds(100);
		}
		driver.manage().timeouts().implicitlyWait(TIMEOUTS, TimeUnit.MILLISECONDS);
		return retorno;
	}

	//// Base URL
	private static String baseURL;

	public static String getBaseUrl() {
		return baseURL;
	}

	public static void setBaseUrl(String base) {
		try {
			new URL(base);
			baseURL = base;
		} catch (Exception e) {
			baseURL = null;
		}
	}

	public static String updateUrlWithBaseUrlIfDefined(final String startingUrl) {
		String baseUrl = baseURL;
		if ((baseUrl != null) && (!baseUrl.isEmpty())) {
			return replaceHost(startingUrl, baseUrl);
		} else {
			return startingUrl;
		}
	}

	private static String replaceHost(final String starting, final String base) {
		String updatedUrl = starting;
		try {
			URL startingUrl = new URL(starting);
			URL baseUrl = new URL(base);

			String startingHostComponent = hostComponentFrom(startingUrl.getProtocol(), startingUrl.getHost(),
					startingUrl.getPort());
			String baseHostComponent = hostComponentFrom(baseUrl.getProtocol(), baseUrl.getHost(), baseUrl.getPort());
			updatedUrl = starting.replaceFirst(startingHostComponent, baseHostComponent);
		} catch (Exception e) {
			LOGGER.error("Failed to analyse default page URL: Starting URL: {}, Base URL: {}", starting, base);
			LOGGER.error("URL analysis failed with exception:", e);
		}
		return updatedUrl;
	}

	private static String hostComponentFrom(final String protocol, final String host, final int port) {
		StringBuilder hostComponent = new StringBuilder(protocol);
		hostComponent.append("://");
		hostComponent.append(host);
		if (port > 0) {
			hostComponent.append(":");
			hostComponent.append(port);
		}
		return hostComponent.toString();
	}

	public static void switchWindowsTab(WebDriver driver, int indexTab) {
		driver.getWindowHandles();
		Set<String> currentHandlers = driver.getWindowHandles();
		String[] handle = new String[999];
		int i = 0;
		for (String pestana : currentHandlers) {
			handle[i] = pestana;
			i++;
		}
		handle = Arrays.copyOf(handle, i);
		if ((indexTab > 99) || (indexTab > handle.length)) {
			driver.switchTo().window(handle[handle.length - 1]);
		} else {
			driver.switchTo().window(handle[indexTab - 1]);
		}
		driver.findElement(By.xpath("//*"));
	}

	public static void switchFrame(WebDriver driver, int indexTab) {
		driver.switchTo().frame(indexTab);
	}

	public static void switchFrame(WebDriver driver, String nameFrame) {
		driver.switchTo().frame(nameFrame);
	}

	public static void switchFrame(WebDriver driver, By objeto) {
		WebElement elemento = driver.findElement(objeto);
		driver.switchTo().frame(elemento);
	}

	public static void closeCurrentWindowsTab(WebDriver driver) {
		driver.getWindowHandles();
		Set<String> currentHandlers = driver.getWindowHandles();
		if (currentHandlers.size() > 1) {
			By by = By.tagName("body");
			ejecutarScript(driver, "window.close();", by);
			switchWindowsTab(driver, 1);
		}
	}

	public static void resolucion(WebDriver driver, String x, String y) {

		int ancho = Integer.parseInt(x);
		int alto = Integer.parseInt(y);
		Dimension d = new Dimension(ancho, alto);
		driver.manage().window().setSize(d);

	}


	static byte[] getKeyBytes() {
		final int KEY_LENGHT = 16;
		String strKey = getProperty("segurity.cipher.key");
		int lenKey = strKey.length();
		if (lenKey > KEY_LENGHT)
			lenKey = KEY_LENGHT;
		byte[] keyBytes = new byte[KEY_LENGHT];
		try {
			System.arraycopy(strKey.getBytes(), 0, keyBytes, 0, lenKey);
		} catch (Exception e) {
			LOGGER.error("Error al copiar array de la clave de encriptación: ", e);
			return new byte[0];
		}
		return keyBytes;
	}

	static byte[] getDataBytes(String data) {
		final int DATA_MULTIPLE_LENGHT = 16;
		int lenData = data.length();
		if ((lenData % DATA_MULTIPLE_LENGHT) != 0)
			lenData += DATA_MULTIPLE_LENGHT - (lenData % DATA_MULTIPLE_LENGHT);
		byte[] byteData = new byte[lenData];
		try {
			System.arraycopy(data.getBytes(), 0, byteData, 0, data.length());
		} catch (Exception e) {
			LOGGER.error("Error al transferir el arreglo de los datos a cifrar: ", e);
			return new byte[0];
		}
		return byteData;
	}

	public static String decrypt(String data) {
		byte[] keyBytes = getKeyBytes();
		byte[] byteData = getDataBytes(data);
		try {
			byteData = Base64.getDecoder().decode(data);
		} catch (Exception e) {
			LOGGER.error("Error al decodificar la data en base64: ", e);
			return "";
		}

		try {
			byte[] resultado = aesDecryptExternKey(byteData, keyBytes);
			return new String(resultado, StandardCharsets.UTF_8);
		} catch (Exception e) {
			LOGGER.error("Error al desencriptar UTF-8: ", e);
			return "";
		}
	}

	public static byte[] aesEncryptExternKey(byte[] bytesFuente, byte[] key16B) {
		return aesEncryptExternKey(bytesFuente, key16B, new byte[16]);
	}

	public static byte[] aesEncryptExternKey(byte[] bytesFuente, byte[] key16B, byte[] iv16B) {
		Cipher cipher = null;
		byte[] resultado = null;
		SecretKeySpec keySpec = new SecretKeySpec(key16B, "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(iv16B);

		try {
			cipher = Cipher.getInstance("AES/CBC/NoPadding");
		} catch (Exception e) {
			LOGGER.error("Error al crear el cifrador AES: ", e);
			return new byte[0];
		}
		try {
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
			resultado = cipher.doFinal(bytesFuente);
			return resultado;
		} catch (Exception e) {
			LOGGER.error("Error al cifrar AES: ", e);
			return new byte[0];
		}
	}

	public static byte[] aesDecryptExternKey(byte[] bytesFuente, byte[] key16B) {
		Cipher cipher = null;
		byte[] resultado = null;
		SecretKeySpec keySpec = new SecretKeySpec(key16B, "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(new byte[16]);
		try {
			cipher = Cipher.getInstance("AES/CBC/NoPadding");
		} catch (Exception e) {
			LOGGER.error("Error al crear el decifrador AES: ", e);
			return new byte[0];
		}
		try {
			cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
			resultado = cipher.doFinal(bytesFuente);
			return resultado;
		} catch (Exception e) {
			LOGGER.error("Error al descifrar AES: ", e);
			return new byte[0];
		}
	}


	public static void validarEstilo(WebDriver driver, By by, String estilo) {
		WebElement element = driver.findElement(by);
		String style = element.getAttribute("style");
		assertFalse(style + " no contiene: " + estilo, style.trim().contains(estilo));
	}

	public static void verificarVisible(WebDriver driver, By objetoToAction) {
		WebElement element = driver.findElement(objetoToAction);
		assertTrue(element.isDisplayed());
	}

	public static void removeAttribute(WebDriver driver, By by, String atributo) {
		WebElement element = driver.findElement(by);
		String originalClass = element.getAttribute(atributo);
		String comandoExecute = "arguments[0].removeAttribute('" + atributo + "');";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(comandoExecute, element, originalClass);
		sleepMiliseconds(5);

	}

	public static final String SEPARADOR = ",";

	public static void leerArchivo() {

		BufferedReader bufferLectura = null;
		try {
			// Abrir el .csv en buffer de lectura
			bufferLectura = new BufferedReader(new FileReader("country-2021-01-07.csv"));

			// Leer una linea del archivo
			String linea = bufferLectura.readLine();

			while (linea != null) {
				// Sepapar la linea leída con el separador definido previamente
				String[] campos = linea.split(SEPARADOR);

				System.out.println(Arrays.toString(campos));

				// Volver a leer otra línea del fichero
				linea = bufferLectura.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Cierro el buffer de lectura
			if (bufferLectura != null) {
				try {
					bufferLectura.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
