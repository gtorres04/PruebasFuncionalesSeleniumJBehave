/**
 * 
 */
package com.qvision.prueba;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

/**
 * @author gerlintorres
 *
 */
public class LoginSteps {

	private WebDriver driver;
	private String driverClave, driverValor;

	/**
	 * @param driver
	 * @param driverClave
	 * @param driverValor
	 */
	public LoginSteps(String driverClave, String driverValor) {
		super();
		this.driverClave = driverClave;
		this.driverValor = driverValor;
	}
	
	@Given("La pagina de login $value")
	public void givenLaPaginaDeLogin(String value) {
		System.setProperty(driverClave, driverValor);
		instanciarDriver();
		driver.navigate().to(value);
	}

	@When("campo user digite $value")
	public void whenCampoUserDigiteTest(String value) {
		WebElement elementUser = driver.findElement(By.name("user"));
		elementUser.sendKeys(value);
	}

	@When("campo password digite $value")
	public void whenCampoPasswordDigiteSecret(String value) {
		WebElement elementPass = driver.findElement(By.name("password"));
		elementPass.sendKeys(value);
	}

	@When("y presione el boton con class $value")
	public void whenYPresioneElboton(String value) {
		WebElement elementBoton = driver.findElement(By.className(value));
		elementBoton.click();
	}

	@Then("redireccionar a la pagina con titulo $value")
	public void thenRedireccionarALaPaginaConTituloBooks(String value) {
		String titlePaginaResultado = driver.getTitle();
		driver.close();
		driver = null;
		assertEquals(value, titlePaginaResultado);
	}
	
	private void instanciarDriver() {
		switch (driverClave) {
		case "webdriver.gecko.driver":
			driver = new FirefoxDriver();
			break;
		case "webdriver.chrome.driver":
			driver = new ChromeDriver();
			break;
		}
	}
}
