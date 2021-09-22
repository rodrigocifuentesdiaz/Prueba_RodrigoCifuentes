package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ClaseBase;

public class PostulaPage extends ClaseBase {
	//Centralizar los localizadores
	By locatorBtnCerrarPopUp = By.xpath("//a[@id='gafancybox-close241']");
	By locatorFramePostulacionPaso1 = By.id("202504332799659");
	By locatorBtnContinuar = By.cssSelector("#form-pagebreak-next_89");
	By locatorChkAcepto = By.cssSelector("#input_87_0");
	By locatorBtnSeguirPaso1 = By.xpath("//button[@id='form-pagebreak-next_86']");
	By locatorTxtRut = By.id("input_12");
	By locatorTxtNombreCompleto = By.id("input_32");
	By locatorTxtTelefonoContacto = By.id("input_19");
	By locatorTxtCorreoElectronico = By.id("input_20");
	By locatorImputEstanciaFE = By.id("input_5_0");
	By locatorImputNacionalidad = By.id("input_15_0");
	By locatorBtnSeguirPaso2 = By.xpath("//button[@id='form-pagebreak-next_59']");
	By locatorFramePostulacionPaso2_1 = By.id("202504332799659");
	By locatorFramePostulacionPaso2_2 = By.id("591dafece4a223da050009f9");
	By locatorTxtComuna = By.xpath("//*[@id=\"access-code\"]");
	By locatorBtnValidarComuna = By.xpath("//*[@id=\"autofill\"]");
	By locatorLblMensajeOK = By.xpath("//div[contains(text(),'OK')]");
	
	public PostulaPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//método que realiza el formulario de postulación hasta el paso 2
	public void postular(String rut,String nombreCompleto, String telefono, String correo,String comuna) {
		if(estaDesplegado(esperaExplicita(locatorBtnCerrarPopUp))) {
			click(locatorBtnCerrarPopUp);
		}
		irAFramePorID(esperaExplicita(locatorFramePostulacionPaso1));
		esperarXSegundos(4000);
		click(esperaExplicita(locatorBtnContinuar));
		click(esperaExplicita(locatorChkAcepto));
		click(esperaExplicita(locatorBtnSeguirPaso1));
		agregarTexto(esperaExplicita(locatorTxtRut),rut);
		agregarTexto(esperaExplicita(locatorTxtNombreCompleto), nombreCompleto);
		agregarTexto(esperaExplicita(locatorTxtTelefonoContacto), telefono);
		agregarTexto(esperaExplicita(locatorTxtCorreoElectronico), correo);
		click(esperaExplicita(locatorImputEstanciaFE));
		click(esperaExplicita(locatorImputNacionalidad));
		click(esperaExplicita(locatorBtnSeguirPaso2));
		System.out.println("Frames contados:" + contarFrames());
		irAframe(1);
		esperarXSegundos(3000);
		agregarTexto(esperaExplicita(locatorTxtComuna), comuna);
		click(esperaExplicita(locatorBtnValidarComuna));
	}
	
	//Metodo que obtiene la verificación del paso 2 del formulario de postulación
	public String obtenerComunaOKPostulacionPaso2() {
		return obtenerTexto(esperaExplicita(locatorLblMensajeOK));
	}

}
