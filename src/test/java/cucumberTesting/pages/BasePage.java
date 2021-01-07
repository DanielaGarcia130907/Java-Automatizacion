package cucumberTesting.pages;

import org.openqa.selenium.By;

import cucumberTesting.utilities.ActionsUtil;
import net.serenitybdd.core.pages.PageObject;

public class BasePage extends PageObject{
	
	static By objetoToAction = By.xpath("/html/body");
	
	public void sharedObjet(String opcion) {
		String nombreObjeto = (ActionsUtil.textoMinusculasSinEspacios(opcion));
		By byObjeto = ActionsUtil.getObjeto(nombreObjeto);
		setObjetoToAction(byObjeto);
	}
	public void setObjetoToAction(By objetoToCliked) {
		objetoToAction = objetoToCliked;
	}
	
	public By getObjetoToAction() {
		return objetoToAction;
	}

}
