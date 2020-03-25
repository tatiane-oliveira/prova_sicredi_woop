package br.com.sicredi.core;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class SeleniumWait {
	
	public static void aguardarElementoPresencaDoElemento(int tempo, By by) {
		WebDriverWait driverWait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(tempo));
		driverWait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public static void aguardarElementoSerClicavel(int tempo, By by) {
		WebDriverWait driverWait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(tempo));
		driverWait.until(ExpectedConditions.elementToBeClickable(by));
	}

}
