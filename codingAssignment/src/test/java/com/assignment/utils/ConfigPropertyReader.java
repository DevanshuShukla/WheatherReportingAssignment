package com.assignment.utils;



import java.io.InputStream;
import java.util.Properties;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
/**
 * This is the utility class for data read write
 *
 * @author QAIT
 *
 */
public class ConfigPropertyReader {


    private static String propertyFilePath = "./Config.properties";
    

    	 public static Properties readPropertiesFile(String propertyFilePath) throws IOException {
    	      FileInputStream fis = null;
    	      Properties prop = null;
    	      try {
    	         fis = new FileInputStream(propertyFilePath);
    	         prop = new Properties();
    	         prop.load(fis);
    	      } catch(FileNotFoundException fnfe) {
    	         fnfe.printStackTrace();
    	      } catch(IOException ioe) {
    	         ioe.printStackTrace();
    	      } finally {
    	         fis.close();
    	      }
    	      return prop;
    	   }
    	 
    	}