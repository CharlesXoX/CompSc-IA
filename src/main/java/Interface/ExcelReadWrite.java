/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author charleswong
 */
public class ExcelReadWrite {
    static XSSFWorkbook workbook; 
    static XSSFSheet sheet;
    
    public ExcelReadWrite(String excelPath, String sheetName){
    try{
        
        workbook = new XSSFWorkbook(excelPath); 
        sheet = workbook.getSheet(sheetName);
        
    }catch(Exception exp){
        System.out.print(exp.getCause());
        System.out.print(exp.getMessage());
        exp.printStackTrace();
    }
    }
    
    public Object getCellData(int rowNum, int colNum) throws IOException{
        /*
        String excelPath = "./data/TestData.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook(excelPath); 
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        */
        DataFormatter formatter = new DataFormatter();
        Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
     
        //double value = sheet.getRow(1).getCell(2).getNumericCellValue();
        return value;
    }
    public int getRowCount(){
        
        //String proDir = System.getProperty("user.dir");
        //System.out.println(proDir);
        
        
        
        /* try{
           
        String excelPath = "./data/TestData.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook(excelPath); 
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        */
         int rowCount = sheet.getPhysicalNumberOfRows();
        return rowCount;
        
        /*
    }catch(Exception exp){
        System.out.print(exp.getCause());
        System.out.print(exp.getMessage());
        exp.printStackTrace();
    }
        */
    }
}
