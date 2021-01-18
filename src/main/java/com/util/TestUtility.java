package com.util;

import java.util.ArrayList;



public class TestUtility {
	
	static Xls_Reader reader;  //Creating Object of Xls_Reader
	
	//Arrau List Objects
	public static ArrayList<Object[]> getDataFromExcel(){ 	
		ArrayList<Object[]> myData = new ArrayList<Object[]>();		
		try{								//Path of Excel File
			reader = new Xls_Reader("C:\\Users\\Sikder\\Documents\\SeleniumTest\\DDF_ebay\\src\\main\\java\\com\\testdata\\ExcelData.xlsx");
		}catch(Exception e){
			e.printStackTrace();		
		}
												//Excel Sheet name, Column name
		for (int rowNum = 2; rowNum <= reader.getRowCount("RegTestData"); rowNum++){
			String fName = reader.getCellData("RegTestData", "FirstName", rowNum);
			String lName = reader.getCellData("RegTestData", "LastName", rowNum);
			String eMail = reader.getCellData("RegTestData", "Email", rowNum);
			String pWd = reader.getCellData("RegTestData", "Password", rowNum);
			
			Object ob[] = {fName,lName,eMail,pWd};  //All the Variables are being stored in "Object" array...
			myData.add(ob);
		}
		return myData;
	}
	
}
