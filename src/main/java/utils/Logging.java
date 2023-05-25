package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class Logging {

	public static void logtoFile()
	{
	    
		String logFileName = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
		try {
			PrintStream log=new PrintStream(new FileOutputStream("C:\\Users\\Subha\\LiveProjects\\NotesAPI\\logs\\log_"+logFileName));
			//PrintStream fileOutPutStream = new PrintStream(new File("somefile.txt"));
			RestAssured.config = RestAssured.config().logConfig(new LogConfig().defaultStream(log)); 
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
