package tests;

import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.PostulaPage;
import utils.DataDriven;
import utils.PropertiesDriven;

public class CasosDePrueba {
	//Atributos
	private WebDriver driver;
	private HomePage homePage;
	private PostulaPage postulaPage;
	private String urlSitio;
	private ArrayList<String> datosCP;
	

	@BeforeTest
	public void preparacion() {
		String rutaDriver = PropertiesDriven.obtenerProperty("rutaDriver");
		String browser = PropertiesDriven.obtenerProperty("browser");
		String propertyDriver = PropertiesDriven.obtenerProperty("propertyDriver");
		homePage = new HomePage(driver);
		homePage.conexionDriver(browser, rutaDriver, propertyDriver);
		postulaPage = new PostulaPage(homePage.getDriver());
		urlSitio = PropertiesDriven.obtenerProperty("url");
		datosCP = new ArrayList<>();
	}
	
	@BeforeMethod
	public void preparacionTests() {
		homePage.cargarURL(urlSitio);
		homePage.maximizarBrowser();
	}
	
	@AfterMethod
	public void posTests() {
	}
	
	@Test
	public void CP001_FlujoPostulacion_Paso2_ComunaOK() {
		datosCP = DataDriven.getData("CP001_FlujoPostulacion_Paso2_ComunaOK");
		homePage.irAPostulacion();
		postulaPage.postular(datosCP.get(1), datosCP.get(2), datosCP.get(3), datosCP.get(4), datosCP.get(5));
		Assert.assertEquals(postulaPage.obtenerComunaOKPostulacionPaso2(), datosCP.get(6));
	}
	
	@Test
	public void CP002() {
		datosCP = DataDriven.getData("CP002");
		
	}
	
	@Test
	public void CP003() {
		datosCP = DataDriven.getData("CP003");
	}
	
	
}
