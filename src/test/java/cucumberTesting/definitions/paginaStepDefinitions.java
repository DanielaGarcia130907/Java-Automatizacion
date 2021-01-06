package cucumberTesting.definitions;

import cucumberTesting.pages.paginaPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class paginaStepDefinitions {

	paginaPage paginapage;

	@Given("Ingreso a la pagina web")
	public void ingreso_a_la_pagina_web() {
		paginapage.open();
	}

	@And("verifico que {string} sea visible")
	public void verifico_que_Elemento_sea_visible(String elemento) {
		paginapage.verificarVisible(elemento);
	}
	
	@Given("realizo el login")
	public void realizo_el_login() {
		paginapage.login();

	}

	@And("doy clic en {string}")
	public void doy_clic_en(String opcion) {
		paginapage.clic(opcion);
	}
	
	@And("ingreso a la opción de {string} y {string}")
	public void ingreso_a_la_opción_de_y(String string, String string2) {
		paginapage.ingresosubmenu(string, string2);
		//ecommerce.clic(string);
		//ecommerce.clic(string2);
	}
	
	@When("selecciono el producto {string}")
	public void selecciono_el_producto(String producto) {
	    // Write code here that turns the phrase above into concrete actions
	   // ecommerce.seleccionProducto(producto);
	}
	
	@And("espero {int} segundos")
	public void espero_segundos(Integer tiempo) {
		paginapage.esperaSegundos(tiempo);
	}
	
	@When("en el campo de texto {string} escribo {string}")
	public void en_el_campo_de_texto_escribo(String campo, String texto) {
		paginapage.escribirTexto(campo, texto);
	}
	
	@And("en la lista {string} selecciono {string}")
	public void en_la_lista_selecciono(String lista, String opcion) {
		paginapage.seleccionaLista(lista, opcion);
	}
	
	@And("en el checkbox selecciono {string}")
	public void en_el_checkbox_selecciono(String estado) {
		paginapage.estadoCheckbox(estado);
	}
	
	@And("inicio sesión con el correo {string} y contraseña {string}")
	public void inicio_sesión_con_el_correo_y_contraseña(String usuario, String contrasena) {
		paginapage.inicioSesion(usuario, contrasena);
	}
	
	
	@And("inicio sesión con el correo {string}, contraseña {string} y acepto terminos y condiciones")
	public void inicio_sesión_con_el_correo_contraseña_y_acepto_terminos_y_condiciones(String usuario, String contrasena) {
		paginapage.inicioSesionyTerminos(usuario, contrasena);
	}
	
	@And("al elemento {string} le elimino el atributo {string}")
	public void al_elemento_le_elimino_el_atributo(String elemento, String atributo) {
		paginapage.eliminarAtributo(elemento, atributo);
	}

}
