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
	
	
	@Given("Ingreso a la pagina")
	public void ingreso_a_la_pagina() {
		paginapage.open();
	}

	@Given("verifico que {string} sea visible")
	public void verifico_que_sea_visible(String elemento) {
		paginapage.verificarVisible(elemento);
	}

	
}
