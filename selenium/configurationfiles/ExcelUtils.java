package com.ults.selenium.configurationfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
   private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    private static XSSFRow row;
    private static XSSFCell cell;

   public void setExcelFile(String excelFilePath,String sheetName) throws IOException {
       //Create an object of File class to open xls file
       File file =    new File(excelFilePath);
       
       //Create an object of FileInputStream class to read excel file
       FileInputStream inputStream = new FileInputStream(file);
       
       //creating workbook instance that refers to .xls file
       workbook=new XSSFWorkbook(inputStream);
       
       //creating a Sheet object
        sheet=workbook.getSheet(sheetName);

   }

   public String getCellData(int rowNum, int colNum) {
	    try {
	        XSSFCell cell = sheet.getRow(rowNum).getCell(colNum);
	        if (cell.getCellType() == CellType.STRING) {
	            return cell.getStringCellValue();
	        } else if (cell.getCellType() == CellType.NUMERIC) {
	            return String.valueOf((int)cell.getNumericCellValue());  // Cast to int to avoid decimal points
	        } else {
	            return "";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error reading cell data";
	    }
   }

    public int getRowCountInSheet(){
       int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();
       return rowcount;
    }

    public void setCellValue(int rowNum,int cellNum,String cellValue,String excelFilePath) throws IOException {
    	//creating a new cell in row and setting value to it      
    	sheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);
        
    	FileOutputStream outputStream = new FileOutputStream(excelFilePath);
    	workbook.write(outputStream);
    }
}