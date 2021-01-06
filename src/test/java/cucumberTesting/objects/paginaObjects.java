package cucumberTesting.objects;

import org.openqa.selenium.By;
import cucumberTesting.utilities.ActionsUtil;

public class paginaObjects {

	public paginaObjects() {

		// Ingreso
		ActionsUtil.objetosPut("txtlogin", By.xpath("//header/div[@id='logo-group']/span[@id='logo11']/img"));
		ActionsUtil.objetosPut("Usuario", By.xpath("//body/div/div/div/div/div/div/form/fieldset/section/label[2]/input"));
		ActionsUtil.objetosPut("Contrasena", By.xpath("//body/div/div/div/div/div/div/form/fieldset/section[2]/label[2]/input"));
		ActionsUtil.objetosPut("botonlogin", By.xpath("//body/div/div/div/div/div/div/form/footer/button"));
		
		// Celulares
		ActionsUtil.objetosPut("btnmenu", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[2]/dt"));
		ActionsUtil.objetosPut("btnmenucelulares", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[2]/dd[1]/a"));
		ActionsUtil.objetosPut("btnmenurenuevatuequipo", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[2]/dd[2]/a"));
		

	}

}
