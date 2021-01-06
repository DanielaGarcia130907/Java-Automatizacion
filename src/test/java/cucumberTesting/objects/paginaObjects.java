package cucumberTesting.objects;

import org.openqa.selenium.By;

import cucumberTesting.utilities.ActionsUtil;

public class PaginaObjects {

	public PaginaObjects() {

		// Ingreso opción Menu
		ActionsUtil.objetosPut("txtbuscador", By.id("searchBox"));
		// Celulares
		ActionsUtil.objetosPut("btnmenu", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[2]/dt"));
		ActionsUtil.objetosPut("btnmenucelulares", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[2]/dd[1]/a"));
		ActionsUtil.objetosPut("btnmenurenuevatuequipo", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[2]/dd[2]/a"));
		// Tecnologia
		ActionsUtil.objetosPut("btnmenutecnologia", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[3]/dt"));
		ActionsUtil.objetosPut("btnmenuaccesorios", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[3]/dd[1]/a"));
		ActionsUtil.objetosPut("btnmenuaudioyvideo", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[3]/dd[2]/a"));
		ActionsUtil.objetosPut("btnmenuvideojuegos", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[3]/dd[3]/a"));
		ActionsUtil.objetosPut("btnmenutelevisores", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[3]/dd[4]/a"));
		ActionsUtil.objetosPut("btnmenucomputadores", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[3]/dd[5]/a"));
		ActionsUtil.objetosPut("btnmenusmartwatch", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[3]/dd[6]/a"));
		ActionsUtil.objetosPut("btnmenuinternetdelascosas", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[3]/dd[7]/a"));

		// Servicios Moviles
		ActionsUtil.objetosPut("btnmenuserviciosmoviles", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[4]/dt/a"));

			// Prepago
		ActionsUtil.objetosPut("btncelular+simcard", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[4]/dd[2]/a"));
		ActionsUtil.objetosPut("btncompratusimcard+paquete", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[4]/dd[3]/a"));
		ActionsUtil.objetosPut("btncambiateaclaro", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[4]/dd[4]/a"));
		ActionsUtil.objetosPut("btnpaquetesyrecargas", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[4]/dd[5]/a"));
		
			// Postpago
		ActionsUtil.objetosPut("btncelular+plan", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[4]/dd[7]/a"));
		ActionsUtil.objetosPut("btnplanes", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[4]/dd[8]/a"));
		ActionsUtil.objetosPut("btncambiatecontumismonumero", By.xpath("//*[@id='subMenuTienda']/div[1]/dl[4]/dd[9]/a"));
		
		// Añadir a Carrito desde Catalogo
		ActionsUtil.objetosPut("anadirprimercelular", By.id("add2CartButton_19502"));
		ActionsUtil.objetosPut("anadirprimeraccesorio", By.id("add2CartButton_33954"));
		ActionsUtil.objetosPut("anadirprimeraudio", By.id("add2CartButton_33956"));
		ActionsUtil.objetosPut("anadircelular+simcard", By.id("add2CartButton_19515"));
		ActionsUtil.objetosPut("anadircomprasimcard+paquete", By.id("add2CartButton_27455"));
		ActionsUtil.objetosPut("anadirplanpostpago8gb", By.id("add2CartButton_32951"));

		// Ingreso a pagina Producto
		ActionsUtil.objetosPut("imagendelcelular", By.id("productThumbNailImage_19502"));
		ActionsUtil.objetosPut("imagendelcelular2", By.id("productThumbNailImage_19503"));
		ActionsUtil.objetosPut("imagendeaudioyvideo", By.id("productThumbNailImage_33956"));
		ActionsUtil.objetosPut("imagenvideojuegos", By.id("productThumbNailImage_23451"));
		ActionsUtil.objetosPut("imagentelevisor", By.id("productThumbNailImage_22451"));
		ActionsUtil.objetosPut("imagencomputador", By.id("productThumbNailImage_33451"));
		ActionsUtil.objetosPut("imagensmartwatch", By.id("productThumbNailImage_39451"));
		ActionsUtil.objetosPut("imagensmartwatch2", By.id("productThumbNailImage_31451"));
		ActionsUtil.objetosPut("imageninternetdelascosas", By.id("productThumbNailImage_35951"));
		ActionsUtil.objetosPut("imagenplan12gb", By.id("productThumbNailImage_32956"));
			//Prepago
		ActionsUtil.objetosPut("imagencelular+simcard", By.id("productThumbNailImage_19515"));
		ActionsUtil.objetosPut("imagencomprasimcard+paquete", By.id("productThumbNailImage_27457"));

		// Añadir a Carrito
		ActionsUtil.objetosPut("anadiramicarrito",By.xpath("/html/body/div[8]/div[6]/div/div[3]/div[6]/div[2]/div[2]/div/a/span"));
		// ActionsUtil.objetosPut("anadiralcarritosimulador",
		// By.xpath("/html/body/div[1]/div[5]/div[2]/div[8]/div[1]/button"));
		ActionsUtil.objetosPut("anadiralcarritosimulador", By.id("continueAdd3Cart4"));
		ActionsUtil.objetosPut("anadiramicarritopopup", By.xpath("//*[@id='continueAdd3Cart']/span"));
		ActionsUtil.objetosPut("anadiramicarritoserviciosmoviles", By.xpath("/html/body/div[8]/div[6]/div/div[3]/div[6]/div[1]/div[3]/div/span[1]/a"));

		// Simulador a Cuotas
		ActionsUtil.objetosPut("simuladoracuotas", By.id("simuladorACuotasDiv"));
		// ActionsUtil.objetosPut("simuladoracuotas", By.id("simuladorACuotasDivResponsive"));
		// ActionsUtil.objetosPut("plandepagos", By.xpath("//*[@id='page']/div[5]/div[2]/div[5]/div[2]/div[5]/div/div/div[4]/div/button"));
		ActionsUtil.objetosPut("plandepagos",By.xpath("//*[@id='page']/div[5]/div[2]/div[5]/div[2]/div[2]/div[2]/div[2]/div[4]/div/button"));
		ActionsUtil.objetosPut("anadiralcarritoplandepagos", By.xpath("//*[@id='page']/div[5]/div/div[9]/div[2]/button"));
		// ActionsUtil.objetosPut("anadiramicarritosimulador", By.xpath("//*[@id=\"continueAdd3Cart\"]/span"));
		ActionsUtil.objetosPut("anadiramicarritosimulador", By.xpath("//*[@id=\"continueAdd3Cart4\"]/span"));
		ActionsUtil.objetosPut("anadiralcarritodecompras", By.xpath("//*[@id='add2CartBtn']"));
		ActionsUtil.objetosPut("tablafinanciacion", By.xpath("//*[@id='page']/div[4]/div/div[4]/div[2]/div[2]"));
		ActionsUtil.objetosPut("terminosycondicionesfinanciacion",	By.xpath("//*[@id='contrato-selection']/div[1]/div[1]/label"));
		ActionsUtil.objetosPut("verplandepagos", By.xpath("//*[@id='contrato-validations']/div[1]/div/span[2]/a"));
		ActionsUtil.objetosPut("btncontinuarenplandepagos", By.id("continueBtn"));
		ActionsUtil.objetosPut("vercontrato", By.xpath("//*[@id='contrato-validations']/div[3]/div/span[2]/a"));
		ActionsUtil.objetosPut("cerrarcontrato", By.xpath("//*[@id=\"ja_160581757731439143\"]/div/div[1]"));
		ActionsUtil.objetosPut("btnsolicitarcodigoautorizacion", By.id("solicitar"));
		ActionsUtil.objetosPut("txtcodigoautorizacion", By.xpath("//*[@id=\"renewSteepTwo\"]/div[3]"));
		// ActionsUtil.objetosPut("", By.xpath(""));

		ActionsUtil.objetosPut("btnkitprepago", By.id("add22CartButton"));
		ActionsUtil.objetosPut("btncomprar", By.xpath("/html/body/div[2]/div[5]/div[1]/div[3]/div[9]/div[1]/a/div[2]"));
		ActionsUtil.objetosPut("btncomprar2", By.xpath("/html/body/div[2]/div[5]/div[1]/div[3]/div[11]/div[1]/a/div[2]"));

		// Registro Cliente Nuevo
		ActionsUtil.objetosPut("btnregistrateycompra", By.id("createAccountLinkShopCart"));
		ActionsUtil.objetosPut("txtcorreoelectronico", By.id("WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1"));
		ActionsUtil.objetosPut("lsttipodocumento", By.id("WC_UserRegistrationAddForm_FormInput_documentType_In_Register_1"));
		ActionsUtil.objetosPut("txtnumerodocumento", By.id("WC_UserRegistrationAddForm_FormInput_documentNumber_In_Register_1"));
		ActionsUtil.objetosPut("txtnombre", By.id("WC_UserRegistrationAddForm_NameEntryForm_FormInput_firstName_1"));
		ActionsUtil.objetosPut("txtapellido", By.id("WC_UserRegistrationAddForm_NameEntryForm_FormInput_lastName_1"));
		ActionsUtil.objetosPut("txttelefonomovil", By.id("WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1"));
		ActionsUtil.objetosPut("txttelefonoadicional", By.id("WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_2"));
		ActionsUtil.objetosPut("txtdireccion", By.id("WC_UserRegistrationAddForm_AddressEntryForm_FormInput_address1_1"));
		ActionsUtil.objetosPut("txtbarrio", By.id("WC_UserRegistrationAddForm_AddressEntryForm_FormInput_address2_1"));
		ActionsUtil.objetosPut("lstdepartamento", By.id("WC_UserRegistrationAddForm_AddressEntryForm_FormInput_state_1"));
		ActionsUtil.objetosPut("lstciudad", By.id("WC_UserRegistrationAddForm_AddressEntryForm_FormInput_city_1"));
		ActionsUtil.objetosPut("checkterminosycondiciones", By.xpath("//*[@id='termCondSwitch']/span"));
		ActionsUtil.objetosPut("btncontinuarregistro", By.id("continue_button_guest"));

		// Metodos de pago
		ActionsUtil.objetosPut("metodosdepago", By.id("payment_methods"));
		ActionsUtil.objetosPut("metodopagaracuotas", By.id("//*[@id='financeCheckoutButtons']/div/a"));
		ActionsUtil.objetosPut("metododebitopse", By.xpath("//*[@id='tarjetasContent']/div[1]/a"));
		ActionsUtil.objetosPut("metodotarjetacredito", By.xpath("//*[@id='tarjetasContent']/div[2]/a"));
		ActionsUtil.objetosPut("metodotarjetacodensa", By.xpath("//*[@id='tarjetasContent']/div[3]/a"));
		ActionsUtil.objetosPut("metododaviplata", By.xpath("//*[@id='tarjetasContent']/div[4]/a"));
		ActionsUtil.objetosPut("metodopindepagos", By.xpath("//*[@id='tarjetasContent']/div[5]/a"));
		ActionsUtil.objetosPut("aprobado", By.xpath("/html/body/div[1]/a[1]/input"));
		ActionsUtil.objetosPut("aprobadopindepagos", By.xpath("/html/body/div[1]/a[5]/input"));

		// Inicio de Sesion
		ActionsUtil.objetosPut("txtcorreoiniciosesion", By.id("Header_GlobalLogin_WC_AccountDisplay_FormInput_logonId_In_Logon_1"));
		ActionsUtil.objetosPut("txtcontrasena", By.id("Header_GlobalLogin_WC_AccountDisplay_FormInput_logonPassword_In_Logon_1"));
		ActionsUtil.objetosPut("btniniciarsesion", By.id("loginButton"));
		ActionsUtil.objetosPut("lbliniciosesion", By.id("Header_GlobalLogin_signInQuickLink"));

		// Pagina Mi carrito
		ActionsUtil.objetosPut("btnreducircantidad", By.xpath("//*[@id='shopCartItems']/div[2]/div[4]/div/a[1]"));
		ActionsUtil.objetosPut("btnaumentarcantidad", By.xpath("//*[@id='shopCartItems']/div[2]/div[4]/div/a[2]"));
		ActionsUtil.objetosPut("btneliminarproducto", By.id("WC_OrderItemDetailsf_links_2_1"));
		ActionsUtil.objetosPut("btnmodificarproducto", By.id("WC_OrderItemDetailsf_links_2_1"));
		ActionsUtil.objetosPut("btneliminarproductocarrito", By.xpath("/html/body/div[2]/div[5]/div[1]/div[3]/div[5]/div[1]/div[2]/div[1]/div[1]/div[2]/a"));
		
		ActionsUtil.objetosPut("btnanadirmasproductos", By.id("continueShoppingButton"));
		ActionsUtil.objetosPut("btnverpaquete", By.xpath("//*[@id='shopCartItems']/div[2]/div[1]/div[2]/div[2]/div/span[1]/a"));		
		ActionsUtil.objetosPut("btncerrarverpaquete", By.xpath("/html/body/div[13]/div/div/div[1]"));
		ActionsUtil.objetosPut("btnverplan", By.xpath("//*[@id='shopCartItems']/div[2]/div[1]/div[2]/div[2]/div/span[2]/a"));
		ActionsUtil.objetosPut("btncerrarverplan", By.xpath("/html/body/div[13]/div/div/div[1]"));
		
		ActionsUtil.objetosPut("btninfoplanabierto", By.xpath("//*[@id='shopCartItems']/div[2]/div[1]/div[2]/div[2]/div/div[1]/span/div[2]/a"));
		ActionsUtil.objetosPut("btncerrarinfoplanabierto", By.xpath("//*[@id='ja_160702874417593106']/div/div[1]"));
		ActionsUtil.objetosPut("lstequipomicarrito", By.id("quickInfoAttrValue_attributeName_8280012></select>"));

		ActionsUtil.objetosPut("btncambiarplan", By.xpath("/html/body/div[13]/div/div/div[3]/div/div[1]/div[1]/div/div[1]/input"));
		ActionsUtil.objetosPut("btnmodificarplan", By.xpath("/html/body/div[13]/div/div/div[3]/div/div[3]/div/a/div[2]"));
		
		// Comparar Productos - Celular
		ActionsUtil.objetosPut("checkcomparacionproducto1", By.id("comparebox_19502"));
		ActionsUtil.objetosPut("checkcomparacionproducto2", By.id("comparebox_19503"));
		ActionsUtil.objetosPut("checkcomparacionproducto3", By.id("comparebox_19504"));

		ActionsUtil.objetosPut("checkcomparaciontelevisor1", By.id("comparebox_36951"));
		ActionsUtil.objetosPut("checkcomparaciontelevisor2", By.id("comparebox_22451"));

		ActionsUtil.objetosPut("btncompararproductos", By.xpath("//*[@id='comparador']/div/div/div[2]/a[1]"));
		ActionsUtil.objetosPut("tablacompararproductos", By.xpath("//*[@id='contentWrapper']/div/div[2]/div/div[2]/div/div[1]/div[2]/div[1]/div/div/div/div/div"));

		// MiniCarrito
		ActionsUtil.objetosPut("btneliminarminicarrito", By.xpath("//*[@id='WC_OrderItemDetails_links_2_1']/img"));
		ActionsUtil.objetosPut("imgcarritocompras", By.xpath("//*[@id=\"headerSuperior\"]/div[2]"));

		ActionsUtil.objetosPut("resumenpedido", By.id("resumenPedido"));

		// Renovación
		ActionsUtil.objetosPut("btnrenovacion2", By.id("add222CartButton123"));
		ActionsUtil.objetosPut("btnrenovacion", By.id("add222CartButton"));
		
		//Datos Personales
		ActionsUtil.objetosPut("lstdireccion", By.xpath("//*[@id='WC_UserRegistrationAddForm_AddressEntryForm_FormInput_address_pospago_1']"));
		ActionsUtil.objetosPut("txtdireccion1", By.id("WC_UserRegistrationAddForm_AddressEntryForm_FormInput_address_pospago_text1_1"));
		ActionsUtil.objetosPut("txtdireccion2", By.id("WC_UserRegistrationAddForm_AddressEntryForm_FormInput_address_pospago_text2_1"));
		ActionsUtil.objetosPut("txtdireccion3", By.id("WC_UserRegistrationAddForm_AddressEntryForm_FormInput_address_pospago_text3_1"));
		ActionsUtil.objetosPut("btncontinuar", By.id("validatePospagoService"));
		
		ActionsUtil.objetosPut("btnfirmaterminosycondiciones", By.xpath("//*[@id='contract']/div/div[7]/div[1]/div/div[1]/div/label/span"));
		
		ActionsUtil.objetosPut("lstproductoplanes", By.id("id_producto"));
		ActionsUtil.objetosPut("lstciudadplanes", By.id("id_ciudad"));
		ActionsUtil.objetosPut("txtnumerotelefono", By.id("num_tel"));
		ActionsUtil.objetosPut("checkautorizacion", By.id("autorizo"));
		ActionsUtil.objetosPut("btncontinuarsolicitarplan", By.xpath("//*[@id='form_soluciones_fijas']/div[2]/dl/dd/button"));
		ActionsUtil.objetosPut("resumenderegistro", By.xpath("//*[@id=\"contenedorPrincipal\"]/section/form/div[1]/div[2]"));
		
		// PORTABILIDAD 
		
			//Consultar Portabilidad
		ActionsUtil.objetosPut("btnconsultatuportacion", By.xpath("//*[@id='contentWrapper']/section[1]/div/div[2]/div[2]/div/div/div[2]/div/button"));
		ActionsUtil.objetosPut("txtnumerocelularsolicitud", By.id("msisdn2"));
		ActionsUtil.objetosPut("txtdocumentoregistrado", By.id("num_doc2"));
		ActionsUtil.objetosPut("btncontinuarconsultaportacion", By.id("bttnQueryPostpaidPortabilityDesk"));
		ActionsUtil.objetosPut("informaciondelalinea", By.xpath("//*[@id='consultaPortabilidadStatusDesktopId']/div[5]"));
		ActionsUtil.objetosPut("btnfinalizarconsultaportacion", By.xpath("//*[@id='consultaPortabilidadStatusDesktopId']/div[11]/div[2]/button"));
		
		ActionsUtil.objetosPut("btncambiateaclaroportabilidad", By.xpath("//*[@id='contentWrapper']/section[1]/div/div[2]/div[1]/div/div/div[2]/div/a"));
		
			//Prepago
		ActionsUtil.objetosPut("txtcorreoelectronicoportabilidad", By.id("WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1"));
		ActionsUtil.objetosPut("txtnombreportabilidad", By.id("WC_PortabilityFormDisplay_NameEntryForm_FormInput_firstName_1"));
		ActionsUtil.objetosPut("txtapellidoportabilidad", By.id("WC_PortabilityFormDisplay_NameEntryForm_FormInput_lastName_1"));
		ActionsUtil.objetosPut("txtnumeroaportar", By.id("WC_PortabilityFormDisplay_FormInput_phoneNum_In_Register_1"));
		ActionsUtil.objetosPut("txttelefonoadicionalportabilidad", By.id("WC_PortabilityFormDisplay_FormInput_phoneNum_In_Register_2"));
		ActionsUtil.objetosPut("lsttipodocumentoportabilidad", By.id("WC_PortabilityFormDisplay_FormInput_documentType_In_Register_1"));
		ActionsUtil.objetosPut("txtnumerodocumentoportabilidad", By.id("WC_PortabilityFormDisplay_FormInput_documentNumber_In_Register_1"));
		
		ActionsUtil.objetosPut("lstdepartamentoportabilidad", By.id("WC_PortabilityFormDisplay_AddressEntryForm_FormInput_state_1"));
		ActionsUtil.objetosPut("lstciudadportabilidad", By.id("WC_UserRegistrationAddForm_AddressEntryForm_FormInput_city_1"));
		ActionsUtil.objetosPut("lstdireccionportabilidad", By.id("WC_PortabilityFormDisplay_AddressEntryForm_FormInput_addressType_1"));
		ActionsUtil.objetosPut("txtdireccionportabilidad1", By.id("WC_PortabilityFormDisplay_AddressEntryForm_FormInput_calle_1"));
		ActionsUtil.objetosPut("txtdireccionportabilidad2", By.id("WC_PortabilityFormDisplay_AddressEntryForm_FormInput_exterior_1"));
		ActionsUtil.objetosPut("txtdireccionportabilidad3", By.id("WC_PortabilityFormDisplay_AddressEntryForm_FormInput_interior_1"));		
		ActionsUtil.objetosPut("txtbarrioportabilidad", By.id("WC_PortabilityFormDisplay_AddressEntryForm_FormInput_address2_1"));
		ActionsUtil.objetosPut("btncontinuarportabilidad", By.id("botoncontinuar"));
		
		ActionsUtil.objetosPut("rdbtnenvioadomicilio", By.id("ffmTypeHd"));
		ActionsUtil.objetosPut("rdbtntienestusimclaro", By.id("ffmTypeSim"));
		ActionsUtil.objetosPut("rdbtnrecogerentiendasclaro", By.id("ffmTypePis"));
		
		ActionsUtil.objetosPut("txttarjetasimclaro1", By.id("WC_PortabilityFormDisplay_AddressEntryForm_FormInput_simclaro_1"));
		ActionsUtil.objetosPut("txttarjetasimclaro2", By.id("WC_PortabilityFormDisplay_AddressEntryForm_FormInput_simclaro_2"));
		ActionsUtil.objetosPut("txttarjetasimclaro3", By.id("WC_PortabilityFormDisplay_AddressEntryForm_FormInput_simclaro_3"));
		
		ActionsUtil.objetosPut("txtnumerocelularportabilidad", By.id("WC_PortabilityFormDisplay_AddressEntryForm_FormInput_LineaClaro_1"));
		ActionsUtil.objetosPut("btncontinuarvalidarsim", By.id("botonvalidasim"));
		
		ActionsUtil.objetosPut("validacionsimcard", By.className("alert-text-green"));
		ActionsUtil.objetosPut("validacionsimcarderronea", By.className("alert-text-red"));
		ActionsUtil.objetosPut("btnaceptarvalidacion", By.xpath("//*[@id='modalPrepagoSuccess']/div/div/div/div/a"));
		
		ActionsUtil.objetosPut("txtcodigonip1", By.id("WC_PortabilityFormDisplay_FormInput_Nip_1"));
		ActionsUtil.objetosPut("txtcodigonip2", By.id("WC_PortabilityFormDisplay_FormInput_Nip_2"));
		ActionsUtil.objetosPut("txtcodigonip3", By.id("WC_PortabilityFormDisplay_FormInput_Nip_3"));
		ActionsUtil.objetosPut("txtcodigonip4", By.id("WC_PortabilityFormDisplay_FormInput_Nip_4"));
		ActionsUtil.objetosPut("txtcodigonip5", By.id("WC_PortabilityFormDisplay_FormInput_Nip_5"));
		
			//Postpago
		ActionsUtil.objetosPut("anadirnavegalampro8gbportabilidad", By.id("add2CartButton_37951"));
		
		ActionsUtil.objetosPut("imagennavegalallite15gbportabilidad", By.id("productThumbNailImage_37956"));
		
		ActionsUtil.objetosPut("btncomprarportabilidad", By.id("guestShopperContinue"));
		
		
		ActionsUtil.objetosPut("txtfechaexpediciondocumentoportabilidad", By.id("WC_UserRegistrationAddForm_FormInput_expeditionDate_In_Register_1"));
		ActionsUtil.objetosPut("lstdepartamentoexpediciondocumentoportabilidad", By.id("WC_UserRegistrationAddForm_FormInput_expeditionDepartment_In_Register_1"));
		ActionsUtil.objetosPut("lstmunicipioexpediciondocumentoportabilidad", By.id("WC_UserRegistrationAddForm_FormInput_expeditionMunicipality_In_Register_1"));
		ActionsUtil.objetosPut("btncontinuarportabilidadpostpago", By.id("validatePospagoService"));
		ActionsUtil.objetosPut("btnvalidaridentidadsms", By.xpath("//*[@id='yourIdentityPostpaidPortId']/div[7]/div[1]/div/label[1]/span"));
		ActionsUtil.objetosPut("seleccionnumerovalidacion", By.id("phone1"));
		ActionsUtil.objetosPut("btncontinuarvalidacionidentidad", By.xpath("//*[@id='identityContinue']"));
		
		ActionsUtil.objetosPut("txtcodigovalidacionidentidad", By.id("codeValid1"));
		
		ActionsUtil.objetosPut("popupvalidacionnip", By.className("ja_body"));
		
		// Pago

		// PROD
		// ActionsUtil.objetosPut("btnmenu",
		// By.xpath("//*[@id='subMenuTienda']/div[1]/dl[1]/dt"));
		// ActionsUtil.objetosPut("btnmenucelulares",
		// By.xpath("//*[@id='subMenuTienda']/div[1]/dl[1]/dd[1]/a"));
		// ActionsUtil.objetosPut("anadirprimercelular", By.id("add2CartButton_20463"));

	}

}
