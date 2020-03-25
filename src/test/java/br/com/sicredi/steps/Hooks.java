package br.com.sicredi.steps;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.com.sicredi.core.Constantes;
import br.com.sicredi.core.DriverFactory;
import br.com.sicredi.utils.ConfigFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;

public class Hooks implements Constantes {
	
	private static boolean propriedadeChromeDriverConfigurada = false;

	@Before(value="@API")
	public void configurarAPI() {
		RestAssured.baseURI = BASE_URI;
		RestAssured.basePath = BASE_PATH;
		
		ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();
		responseBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
		RestAssured.responseSpecification = responseBuilder.build();
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}
	
	@Before(value = "@UI")
	public void inicializarProperty() {
		if (propriedadeChromeDriverConfigurada == false)
			System.setProperty("webdriver.chrome.driver", ConfigFileReader.obterPathDoChromeDriver());
	}
	
	@After(order = 1, value = "@UI")
	public void registrarEvidenciaDoTeste(Scenario cenario) {
		String dataHora = new SimpleDateFormat("dd-MM-yyyy_hh.mm.ss").format(new Timestamp(System.currentTimeMillis()));
		File evidencia = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(evidencia, new File("target" + File.separator + "screenshots" + File.separator + cenario.getName() + dataHora + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After(order = 0, value = "@UI")
	public void fecharBrower() {
		DriverFactory.killDriver();
	}
}
