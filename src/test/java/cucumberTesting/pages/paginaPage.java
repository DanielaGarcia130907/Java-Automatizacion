package cucumberTesting.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import cucumberTesting.objects.PaginaObjects;
import cucumberTesting.utilities.ActionsUtil;
import net.thucydides.core.annotations.DefaultUrl;



@DefaultUrl("https://amrs-dev.engkantar.com/")
public class PaginaPage extends BasePage {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaginaPage.class);

	public PaginaPage() {
		if (ActionsUtil.objetosIsEmpty()) {
			LOGGER.info("Inicialización de objetos");
		}
	}

	public void verificarVisible(String elemento) {
		sharedObjet(elemento);
		ActionsUtil.verificarVisible(getDriver(), getObjetoToAction());

	}

	public void clic(String opcion) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		sharedObjet(opcion);
		wait.until(ExpectedConditions.visibilityOfElementLocated(getObjetoToAction()));
		ActionsUtil.clic(getDriver(), getObjetoToAction());
	}

	public void ingresosubmenu(String string, String string2) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		sharedObjet(string);
		wait.until(ExpectedConditions.visibilityOfElementLocated(getObjetoToAction()));
		ActionsUtil.clic(getDriver(), getObjetoToAction());

		sharedObjet(string2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(getObjetoToAction()));
		ActionsUtil.clic(getDriver(), getObjetoToAction());

	}

	public void esperaSegundos(Integer tiempo) {
		ActionsUtil.sleepSeconds(tiempo);

	}

	public void escribirTexto(String campo, String texto) {
		sharedObjet(campo);
		ActionsUtil.setTextField(getDriver(), getObjetoToAction(), texto);

	}

	public void seleccionaLista(String lista, String opcion) {
		sharedObjet(lista);
		ActionsUtil.selectText(getDriver(), getObjetoToAction(), opcion);
	}

	public void estadoCheckbox(String estado) {
		sharedObjet(estado);
		ActionsUtil.checkBox(getDriver(), getObjetoToAction(), true);

	}

	
	public void inicioSesion(String usuario, String contrasena) {
		String lbliniciosesion = "lbliniciosesion";
		String txtcorreoiniciosesion = "txtcorreoiniciosesion";
		String txtcontrasenainiciosesion= "txtcontrasena";
		String btniniciarsesion = "btniniciarsesion";
		
		clic(lbliniciosesion);
		escribirTexto(txtcorreoiniciosesion, usuario);
		escribirTexto(txtcontrasenainiciosesion, contrasena);
		
		clic(btniniciarsesion);
		
	}

	public void eliminarAtributo(String elemento, String atributo) {
		sharedObjet(elemento);
		ActionsUtil.removeAttribute(getDriver(), getObjetoToAction(), atributo);	
		
	}
	
	public void login() {
		sharedObjet("Usuario");
		ActionsUtil.setTextField(getDriver(), getObjetoToAction(), "testqa");
		sharedObjet("Contrasena");
		ActionsUtil.setTextField(getDriver(), getObjetoToAction(), "#testqa@");
		sharedObjet("Boton Login");
		ActionsUtil.clic(getDriver(), getObjetoToAction());

	}
	
	public void verificarArchivo() {
		ActionsUtil.leerArchivo();
		
	}



}