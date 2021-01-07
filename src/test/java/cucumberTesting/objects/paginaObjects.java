package cucumberTesting.objects;

import org.openqa.selenium.By;

import cucumberTesting.utilities.ActionsUtil;

public class PaginaObjects {

	public PaginaObjects() {

		// Ingreso opción Menu
		ActionsUtil.objetosPut("usuario", By.xpath("//body/div/div/div/div/div/div/form/fieldset/section/label[2]/input"));
		ActionsUtil.objetosPut("contrasena", By.xpath("//body/div/div/div/div/div/div/form/fieldset/section[2]/label[2]/input"));
		ActionsUtil.objetosPut("botonlogin", By.xpath("//body/div/div/div/div/div/div/form/footer/button"));
		ActionsUtil.objetosPut("location", By.xpath("//span[contains(text(),'Location')]"));
		ActionsUtil.objetosPut("contries", By.xpath("//body/div/aside/nav/ul/li/ul/li/a"));
		ActionsUtil.objetosPut("boton1", By.xpath("//body/div/div/div/div/div/section/div/article/div/div/div/div/div/div/a"));
		ActionsUtil.objetosPut("editar", By.xpath("//tbody/tr/td/a/i"));
		ActionsUtil.objetosPut("borrar", By.xpath("//tbody/tr/td/a[4]"));
		ActionsUtil.objetosPut("campoid", By.xpath("//tbody/tr/td[2]/span/div/form/div/div/div/input"));
		ActionsUtil.objetosPut("guardar", By.xpath("//tbody/tr/td/a[3]/i"));
		ActionsUtil.objetosPut("tablero", By.xpath("//h2[contains(text(),'Countries Registration')]"));
		ActionsUtil.objetosPut("success", By.xpath("//i[contains(text(),'Country saved with success!')]"));
		ActionsUtil.objetosPut("pais", By.xpath("//tbody/tr/td/span/div/form/div/div/div/div/ul"));
		ActionsUtil.objetosPut("cvs", By.xpath("//a[@id='ToolTables_countryTable_0']"));

		
		
	}

}
