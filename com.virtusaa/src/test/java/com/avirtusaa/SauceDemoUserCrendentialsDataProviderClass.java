
//		author                                    Umang Bhatnagar     @umangbhatnagar@virtusa.com
//		*************************************     Here the whole script is written keeping MacOS		    *************************************
//		*************************************	  in mind. "BaseUtilitiesTestClass" class has been written	    *************************************			
//		*************************************	  for the low level implementation by segregating into 	    *************************************
//		*************************************	  different methods. These methods are later called   	    *************************************
//		*************************************	  as in need in class "TestDriverClass"	to come		    *************************************
//		*************************************	  up with a meaningful script as asked for.					*************************************







package com.avirtusaa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class SauceDemoUserCrendentialsDataProviderClass {
	
	private static String path1;
	private static Object[][] userCredentials;
	
	
	
	
	

	@DataProvider(name="User Credentials")
	public static Object[][] excelReader() throws EncryptedDocumentException, IOException
	{
		path1 = System.getProperty("user.dir");
		File filePathI = new File(path1+"/sauceDemo.xlsx");
		FileInputStream fileInputStreamI = new FileInputStream(filePathI);



		Workbook workbookI = WorkbookFactory.create(fileInputStreamI);
		
		Sheet sheetI = workbookI.getSheet("Credentials");

		int rowCount = sheetI.getLastRowNum();
		
		

		System.out.println("Total state entries are: "+(rowCount-0));


		
		System.out.println(sheetI.getRow(0).getCell(0).getStringCellValue()+ '\t'+ '\t'+ '\t'+ '\t'+ sheetI.getRow(0).getCell(1).getStringCellValue());
		System.out.println("###############################################################");
		for (int row = 1; row<=rowCount; ++row)
		{
			System.out.print(sheetI.getRow(row).getCell(0).getStringCellValue()+ '\t'+ '\t'+ '\t'+ '\t'+ sheetI.getRow(1).getCell(1).getStringCellValue() );
			System.out.println();
	
			
		}
		System.out.println(""+'\n'+'\n');
		
		userCredentials = new Object[rowCount][2];
		String password = sheetI.getRow(1).getCell(1).getStringCellValue();
		
		
		//reading data from excel and caching locally here in an object array.
		
		for(int row=1; row<=rowCount; ++row)
		{
			
				userCredentials[row-1][0] = sheetI.getRow(row).getCell(0).getStringCellValue();
				userCredentials[row-1][1] = password;
		}
		
		
		
		return userCredentials;



	}


	
	
	
	
	
}
