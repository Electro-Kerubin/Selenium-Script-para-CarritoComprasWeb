/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package seleniumtest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author rbcir
 */
public class SeleniumTest1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        testBotonesNavbar();
        
        
    }

    public static void testBotonesNavbar() {

        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://localhost:8080/CarritoComprasWeb/Controlador?accion=home";

        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        
        driver.get(baseUrl);
        driver.manage().window().maximize();
        
        System.out.println(driver.getPageSource());
        
        WebElement homeButton = driver.findElement(By.linkText("Home"));
        homeButton.click();
        
        WebElement ofertasDelDiaButton = driver.findElement(By.linkText("Ofertas del día"));
        ofertasDelDiaButton.click();
        
        WebElement iconoButton = driver.findElement(By.linkText("Carrito de Compras"));
        iconoButton.click();
        
        driver.quit();
    }
}
