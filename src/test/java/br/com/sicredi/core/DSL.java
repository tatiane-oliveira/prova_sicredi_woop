package br.com.sicredi.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class DSL {

	public static void selecionarOpcaoDaCombo(String tipoPeriodo) {
		WebDriver driver = DriverFactory.getDriver();
		WebElement componenteCombo = driver.findElement(By.xpath("//*[contains(@class, 'blocoSelect')]//*[@class='btSelect']"));
		componenteCombo.click();
		String xpathOpcaoCombo = "//*[@rel='" + tipoPeriodo + "']";
		By byOpcaoCombo = By.xpath(xpathOpcaoCombo);
		SeleniumWait.aguardarElementoSerClicavel(10, byOpcaoCombo);
		WebElement opcaoDaCombo = driver.findElement(byOpcaoCombo);
		opcaoDaCombo.click();
	}
	
	public static boolean isElementoVisivel(int tempo, By by) {
		SeleniumWait.aguardarElementoPresencaDoElemento(tempo, by);
		return true;
	}
	
	public static String obterTextoDoElemento(By by) {
		return DriverFactory.getDriver().findElement(by).getText();
	}
}
