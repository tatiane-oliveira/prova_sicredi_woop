package br.com.sicredi.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public abstract class ConfigFileReader {
	
	private final static String PROPERTY_FILE_PATH = "configs//configuracao.properties";
	private final static String CHROME_DRIVER = "caminhoChromeDriver";
	
	private static String obterPropriedade(String nomeDaPropriedade) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(PROPERTY_FILE_PATH));
			Properties properties = new Properties();
			
			try {
				properties.load(reader);
				reader.close();
				return properties.getProperty(nomeDaPropriedade);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String obterPathDoChromeDriver() {
		return obterPropriedade(CHROME_DRIVER);
	}
}
