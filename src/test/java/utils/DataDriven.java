package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataDriven {
	
	public static ArrayList<String> getData(String nombreCP)  {
		ArrayList<String> datos = new ArrayList<>();
		
		//instanciamos un objeto de tipo file con la ruta del excel
		FileInputStream file = null;
		try {
			file = new FileInputStream(PropertiesDriven.obtenerProperty("rutaExcel"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//instanciamos un objeto de tipo excel con el objeto file
		XSSFWorkbook excel = null;
		try {
			excel = new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int hojas = excel.getNumberOfSheets();
		
		
		
		
		for(int i=0; i< hojas;i++) {
		
			
			if(excel.getSheetName(i).equalsIgnoreCase(PropertiesDriven.obtenerProperty("nombreHojaExcel"))) {
				
				//instanciar un objeto como una hoja de excel
				XSSFSheet hojaExcel = excel.getSheetAt(i);
				
				//Creamos un iterador con las filas de la hoja excel seleccionada
				Iterator<Row> filas = hojaExcel.iterator();
				
				//Creamos un objeto de tipo fila con la primera fila de la hoja selecciona
				Row fila = filas.next();
				
				Iterator<Cell> celdas = fila.cellIterator();
				
				int k=0;
				int columna =0;
				
				while(celdas.hasNext()) {
					Cell celdaSeleccionada = celdas.next();
					if(celdaSeleccionada.getStringCellValue().equalsIgnoreCase(PropertiesDriven.obtenerProperty("tituloCPs"))) {
						//Es por que encontre la columna
						columna = k;
					}
					k++;
				}
				//System.out.println(columna);
				
				while(filas.hasNext()) {
					Row r = filas.next();
					
					if(r.getCell(columna).getStringCellValue().equalsIgnoreCase(nombreCP)) {
						
						Iterator<Cell> cv = r.cellIterator();
						
						while(cv.hasNext()) {
							
							Cell c = cv.next();
							
							if(c.getCellTypeEnum() == CellType.STRING) {
								//System.out.println(c.getStringCellValue());
								datos.add(c.getStringCellValue());
							}else if (c.getCellTypeEnum() == CellType.NUMERIC) {
								//System.out.println(NumberToTextConverter.toText(c.getNumericCellValue()));
								datos.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
							
						}
					}
				}
				
			}
		}
		return datos;
		
	}

}
