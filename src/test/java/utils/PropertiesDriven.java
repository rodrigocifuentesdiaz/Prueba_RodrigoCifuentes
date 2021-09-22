package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDriven {
	//Atributo
	private static Properties prop;

	public static String obtenerProperty(String key) {
		prop = new Properties();
		String rutaFile = System.getProperty("user.dir")+"\\src\\test\\resources\\properties.properties";
		try {
			InputStream input = new FileInputStream(rutaFile);
			
			prop.load(input);
			
		} catch (Exception e) {
			System.out.println("No fue posible encontrar el archivo properties.properties");
			System.out.println("Ruta definida para el archivo: "+rutaFile);
			e.printStackTrace();
		}
		return prop.getProperty(key);
		
	}
}
