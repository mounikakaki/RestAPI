package com.test;
import java.io.File;
import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
//import unti.*;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertNotNull;

import utils.*;


public class LoanCreationAPI {
	String s = System.getProperty("user.dir");
	String filepath=s+"/filetemplate/mk.json";
	
	
	@DataProvider(name= "loanapi")
	public Object[][] loanInput(){
		
		String excelPath=s+"/data/loanapi.xlsx";
		ExcelUtils excel= new ExcelUtils(excelPath, "Sheet1");
		Object obj[][]= new Object [excel.getRowCount()-1][excel.getColumnCount()];
		for(int i=1;i<excel.getRowCount();i++) {
			for(int j=0;j<excel.getColumnCount();j++) {
				Object value=excel.getCelldata(i, j);
				obj[i-1][j]=value;
			}
		}
		return obj;
		
	}
	@BeforeTest
	public void setUp() {
		RestAssured.baseURI="http://blrcslcombk0037";
		RestAssured.port=8080;
	}
	
	@Test(dataProvider = "loanapi")
	public void loanPost(String customercode, 
			String productCode_replace, String mk) {
		PostBodyUtil loanapibody= new PostBodyUtil(filepath);
		LinkedHashMap<String, String> hm = new LinkedHashMap<String, String>();
		hm.put("customercode",customercode );
		hm.put("productCode_replace",productCode_replace );
		File file=loanapibody.postBodyPreparation(hm);
		System.out.println(file);
		
		Response response=given().
				contentType("application/json").
		when().
		body(file).
		post("bfweb/retail/v1/loans").
		then().
		extract().
		response();
		
		System.out.println(response.asString());
		Assert.assertEquals(mk,response.asString());
		
	}

}
