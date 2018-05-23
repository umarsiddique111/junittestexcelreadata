package com.excelunit.test.Excelunittest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.sun.research.ws.wadl.HTTPMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelunittestApplicationTests {
	
	
	private final static Logger logger = Logger.getLogger(ExcelunittestApplication.class.getName());
	
//	@Test
//	public void statustest() {
//		
//		Response res = RestAssured.post("http://localhost:8080/upload");
//		String status = res.asString();
//		System.out.println("this is  a ststus code "+status);
//		
//		
//		 
//	}
	
	@Test 
	public void checkdatatest() throws BiffException, IOException {
		String filepath1 = "D:\\detail.xls";
		 ReadExcelFile readExcelFile = new ReadExcelFile();
		 Sheet sh1 = readExcelFile.readExcel(filepath1);
		 String url = sh1.getCell(0, 1).getContents();
		 String path = sh1.getCell(1, 1).getContents();
		 logger.log( Level.INFO,"detail sheet URL"+url+"detail sheet Path!!"+path);
//		Map<String,String> requestParams = new HashMap<String,String> ();
//		requestParams.put("url",  "http://localhost:8080/upload");
//		requestParams.put("path", "D:\\\\data1.xls"); 
		
		
		ReadExcelFile readExcelFile1 = new ReadExcelFile();
		Sheet sh = readExcelFile1.readExcel(path);
		String emailexcel = sh.getCell(1,2).getContents();
		String passwordexcel = sh.getCell(2,2).getContents();
		
		User user = new User();
		user.setEmailAddress("saleem@gmail.com");
		user.setpassword("saleem12345");
		
		logger.log( Level.INFO, "get email"+sh.getCell(1,2).getContents());
		assertEquals(passwordexcel, user.getpassword());
		assertEquals(emailexcel, user.getEmailAddress());
		
		
	}
	
	
}
