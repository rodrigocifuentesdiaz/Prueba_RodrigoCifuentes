package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ClaseBase;

public class HomePage extends ClaseBase{
	//Aca centralizaremos los localizadores de la pagina
	By locatorLinkPostula = By.linkText("POSTULA");
	
	//sobre escribir el constructor
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Centralizaremos las acciones de la pagina
	public void irAPostulacion() {
		click(esperaExplicita(locatorLinkPostula));
	}

}
