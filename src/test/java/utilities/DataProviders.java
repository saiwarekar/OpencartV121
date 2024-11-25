package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		String path=".\\testData\\Opencart_LoginData.xlsx"; //taking excel file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path); //creating an object for excel Utility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcols]; //create for two dimensional array
		
		for(int i=1;i<=totalrows;i++) //1 //1st row is header row so we start with 2nd row which index is 2
		{
			for(int j=0;j<totalcols;j++) //0 //i is rows j is cols which start from 1st 
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);  //1,0
			}
		}

		return logindata;   //returning two dimension array
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4

}
