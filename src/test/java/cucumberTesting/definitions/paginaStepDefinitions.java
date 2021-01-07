package cucumberTesting.definitions;

import cucumberTesting.pages.PaginaPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PaginaStepDefinitions {

	PaginaPage paginapage;


	@And("doy clic en {string}")
	public void doy_clic_en(String opcion) {
		paginapage.clic(opcion);
	}
	
	@And("ingreso a la opción de {string} y {string}")
	public void ingreso_a_la_opción_de_y(String string, String string2) {
		paginapage.ingresosubmenu(string, string2);
		
	}
	
	@And("espero {int} segundos")
	public void espero_segundos(Integer tiempo) {
		paginapage.esperaSegundos(tiempo);
	}
	
	@Given("Ingreso a la pagina")
	public void ingreso_a_la_pagina() {
		paginapage.open();
	}

	@Given("realizo el login")
	public void realizo_el_login() {
		paginapage.login();
	}
	
	@When("en el campo de texto {string} escribo {string}")
	public void en_el_campo_de_texto_escribo(String campo, String texto) {
		paginapage.escribirTexto(campo, texto);
	}
	
	@And("verifico que {string} sea visible")
	public void verifico_que_Elemento_sea_visible(String elemento) {
		paginapage.verificarVisible(elemento);
	}

	@And("verificar archivo")
	public void verificar_archivo (){
		paginapage.verificarArchivo();
	}
}
