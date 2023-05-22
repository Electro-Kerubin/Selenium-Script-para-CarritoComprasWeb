/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package seleniumtest1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.openqa.selenium.Keys;

/**
 *
 * @author rbcir
 */
public class SeleniumTest1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        //test_1NavbarProductos();
        //test_2NavbarProductos();
        //testModuloProducto();
        //test_3RepetirNombreProducto();
        //test_inputNegativos();
        //test_btnEditar();
        //test_btnEliminar();
        test_1NavbarEmpleado();
    }

    //
    public static void test_1NavbarProductos() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://localhost:8080/CarritoComprasWeb/Controlador?menu=Listar&accion=Producto";

        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver.get(baseUrl);

        driver.manage().window().maximize();

        // Obtener el código fuente de la página
        String pageSource = driver.getPageSource();

        // Imprimir el código fuente en la consola
        System.out.println(pageSource);

        WebElement txtNombre = driver.findElement(By.xpath("//input[@name='txtNombre']"));

        // Ingresar un valor en el campo de entrada
        txtNombre.sendKeys("Producto de ejemplo");

        // Seleccionar el campo de entrada para la descripción
        WebElement txtDescrip = driver.findElement(By.xpath("//input[@name='txtDescrip']"));

        // Ingresar un valor en el campo de entrada
        txtDescrip.sendKeys("Descripción de ejemplo");

        // Seleccionar el campo de entrada para el precio
        WebElement txtPrecio = driver.findElement(By.xpath("//input[@name='txtPrecio']"));

        // Ingresar un valor en el campo de entrada
        txtPrecio.sendKeys("99.99");

        // Seleccionar el campo de entrada para el stock
        WebElement txtStock = driver.findElement(By.xpath("//input[@name='txtStock']"));

        // Ingresar un valor en el campo de entrada
        txtStock.sendKeys("10");

        WebElement agregarBtn = driver.findElement(By.cssSelector("input[value='Agregar']"));
        agregarBtn.click();
    }

    /* Se testeara en esta funcion:
            - Verificar caracteres maximos en el campo producto
            - Verificar caracteres maximos del campo descripción.
            - Verificar que el campo Precio no acepte puntos ni comas
            - Verificar que el campo Stock no acepte puntos ni comas*/
    public static void test_2NavbarProductos() {

        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://localhost:8080/CarritoComprasWeb/Controlador?menu=Listar&accion=Producto";

        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver.get(baseUrl);

        driver.manage().window().maximize();

        WebElement txtNombre = driver.findElement(By.xpath("//input[@name='txtNombre']"));

        // Ingresar un valor en el campo de entrada
        txtNombre.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        // Seleccionar el campo de entrada para la descripción
        WebElement txtDescrip = driver.findElement(By.xpath("//input[@name='txtDescrip']"));

        // Ingresar un valor en el campo de entrada
        txtDescrip.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        // Seleccionar el campo de entrada para el precio
        WebElement txtPrecio = driver.findElement(By.xpath("//input[@name='txtPrecio']"));

        // Ingresar un valor en el campo de entrada
        txtPrecio.sendKeys("99,99");

        // Seleccionar el campo de entrada para el stock
        WebElement txtStock = driver.findElement(By.xpath("//input[@name='txtStock']"));

        // Ingresar un valor en el campo de entrada
        txtStock.sendKeys("10,1");

        WebElement agregarBtn = driver.findElement(By.cssSelector("input[value='Agregar']"));
        agregarBtn.click();
    }

    // Se testeara la si se pueden repetir prodcutos con los mismos valores en los campos
    public static void test_3RepetirNombreProducto() {
        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://localhost:8080/CarritoComprasWeb/Controlador?menu=Listar&accion=Producto";

        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver.get(baseUrl);

        driver.manage().window().maximize();

        // Obtener el código fuente de la página
        String pageSource = driver.getPageSource();

        // Imprimir el código fuente en la consola
        System.out.println(pageSource);

        WebElement txtNombre = driver.findElement(By.xpath("//input[@name='txtNombre']"));

        // Ingresar un valor en el campo de entrada
        txtNombre.sendKeys("Producto de ejemplo");

        // Seleccionar el campo de entrada para la descripción
        WebElement txtDescrip = driver.findElement(By.xpath("//input[@name='txtDescrip']"));

        // Ingresar un valor en el campo de entrada
        txtDescrip.sendKeys("Descripción de ejemplo");

        // Seleccionar el campo de entrada para el precio
        WebElement txtPrecio = driver.findElement(By.xpath("//input[@name='txtPrecio']"));

        // Ingresar un valor en el campo de entrada
        txtPrecio.sendKeys("99.99");

        // Seleccionar el campo de entrada para el stock
        WebElement txtStock = driver.findElement(By.xpath("//input[@name='txtStock']"));

        // Ingresar un valor en el campo de entrada
        txtStock.sendKeys("10");

        WebElement agregarBtn = driver.findElement(By.cssSelector("input[value='Agregar']"));

        agregarBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        txtNombre.sendKeys(Keys.CONTROL + "a");
        txtNombre.sendKeys("Producto de ejemplo");

        txtDescrip.sendKeys(Keys.CONTROL + "a");
        txtDescrip.sendKeys("Descripción de ejemplo");

        txtPrecio.sendKeys(Keys.CONTROL + "a");
        txtPrecio.sendKeys("99.99");

        txtStock.sendKeys(Keys.CONTROL + "a");
        txtStock.sendKeys("10");

        agregarBtn.click();
    }

    // Se testearan numeros negativos
    public static void test_inputNegativos() {
        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://localhost:8080/CarritoComprasWeb/Controlador?menu=Listar&accion=Producto";

        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver.get(baseUrl);

        driver.manage().window().maximize();

        // Obtener el código fuente de la página
        String pageSource = driver.getPageSource();

        // Imprimir el código fuente en la consola
        System.out.println(pageSource);

        WebElement txtNombre = driver.findElement(By.xpath("//input[@name='txtNombre']"));

        // Ingresar un valor en el campo de entrada
        txtNombre.sendKeys("Producto de ejemplo");

        // Seleccionar el campo de entrada para la descripción
        WebElement txtDescrip = driver.findElement(By.xpath("//input[@name='txtDescrip']"));

        // Ingresar un valor en el campo de entrada
        txtDescrip.sendKeys("Descripción de ejemplo");

        // Seleccionar el campo de entrada para el precio
        WebElement txtPrecio = driver.findElement(By.xpath("//input[@name='txtPrecio']"));

        // Ingresar un valor en el campo de entrada
        txtPrecio.sendKeys("-99.99");

        // Seleccionar el campo de entrada para el stock
        WebElement txtStock = driver.findElement(By.xpath("//input[@name='txtStock']"));

        // Ingresar un valor en el campo de entrada
        txtStock.sendKeys("-10");

        WebElement agregarBtn = driver.findElement(By.cssSelector("input[value='Agregar']"));

        agregarBtn.click();
    }

    /* Observacion: El texto de los botones estan en distintos idiomas, delete ingles y editar español */
    public static void test_btnEditar() {
        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://localhost:8080/CarritoComprasWeb/Controlador?menu=Listar&accion=Producto";

        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver.get(baseUrl);

        driver.manage().window().maximize();

        // Obtener el código fuente de la página
        String pageSource = driver.getPageSource();

        // Imprimir el código fuente en la consola
        System.out.println(pageSource);

        //WebElement deleteButton = driver.findElement(By.cssSelector("a.btn.btn-danger[href='Controlador?accion=Producto&menu=Delete&id=1']"));
        WebElement editarButton = driver.findElement(By.cssSelector("a.btn.btn-warning[href='Controlador?accion=Producto&menu=Editar&id=1']"));

        editarButton.click();

        // Seleccionar el campo de entrada para el precio
        WebElement txtPrecio = driver.findElement(By.xpath("//input[@name='txtPrecio']"));

        // Ingresar un valor en el campo de entrada
        txtPrecio.sendKeys("1");

        // Seleccionar el campo de entrada para el stock
        WebElement txtStock = driver.findElement(By.xpath("//input[@name='txtStock']"));

        // Ingresar un valor en el campo de entrada
        txtStock.sendKeys("1");

        WebElement actualizarBtn = driver.findElement(By.cssSelector("input[value='Actualizar']"));

        actualizarBtn.click();

        editarButton.click();
        //deleteButton.click();

    }

    public static void test_btnEliminar() {
        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://localhost:8080/CarritoComprasWeb/Controlador?menu=Listar&accion=Producto";

        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver.get(baseUrl);

        driver.manage().window().maximize();

        // Obtener el código fuente de la página
        String pageSource = driver.getPageSource();

        // Imprimir el código fuente en la consola
        System.out.println(pageSource);

        WebElement deleteElement = driver.findElement(By.cssSelector("a.btn.btn-danger"));
        deleteElement.click();

    }

    public static void testModuloProducto() throws MalformedURLException, IOException {

        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://localhost:8080/CarritoComprasWeb/Controlador?accion=Principal";

        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver.get(baseUrl);
        driver.manage().window().maximize();

        //WebElement homeNavBar = driver.findElement(By.linkText("Home "));
        WebElement container = driver.findElement(By.cssSelector("div.container.mt-4"));
        List<WebElement> cardElements = container.findElements(By.cssSelector("div.card"));

        for (WebElement card : cardElements) {

            //Analisis de nombres de productos
            WebElement cardHeaderElement = card.findElement(By.cssSelector("div.card-header"));
            List<WebElement> nombreProductos = cardHeaderElement.findElements(By.tagName("label"));
            for (WebElement nombre : nombreProductos) {
                if (nombre.getText().isBlank()) {
                    System.out.println("No posee titulo");
                }
            }

            //Analisis de precio
            WebElement cardBodyElement = card.findElement(By.cssSelector("div.card-body"));
            List<WebElement> precioProductos = cardBodyElement.findElements(By.tagName("i"));
            for (WebElement precio : precioProductos) {
                if (Double.parseDouble(precio.getText()) < 0) {
                    System.out.println("Problemas en el precio");
                }
            }

            WebElement imageElement = driver.findElement(By.cssSelector("img[src='ControladorIMG?id=1']"));
            String imageUrl = imageElement.getAttribute("src");

            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("La imagen existe.");
            } else {
                System.out.println("La imagen no existe.");
            }

            /*List<WebElement> labelElements = card.findElements(By.tagName("label"));

            for (WebElement label : labelElements) {
                String labelText = label.getText();
                System.out.println("Texto del elemento label: " + labelText);
            }
             */
        }

        /*
        WebElement productosContainer = driver.findElement(By.cssSelector("div.container.mt-4"));
        
        //Analisis de nombres de productos

        WebElement cardHeader = productosContainer.findElement(By.cssSelector("card-header"));
        List<WebElement> labelElements = cardHeader.findElements(By.tagName("label"));
        for (WebElement label : labelElements) {
            String labelText = label.getText();
            System.out.println("Texto del elemento label: " + labelText);
        }
        
        /*
        WebElement cardBody = productosContainer.findElement(By.cssSelector("card-body"));
        //Analisis de fotos de producto
        List<WebElement> imgElements = cardBody.findElements(By.tagName("img"));
        for (WebElement img : imgElements) {
            System.out.println(img);
        }
         */
        //Analisis de descripcion de producto
        //Analisis de precio de producto
        //Analisis de stock de producto
        driver.quit();
    }

    public static void test_1NavbarEmpleado() {
        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://localhost:8080/CarritoComprasWeb/Controlador?menu=Listar&accion=Empleado";

        String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver.get(baseUrl);

        driver.manage().window().maximize();

        // Obtener el código fuente de la página
        String pageSource = driver.getPageSource();

        // Imprimir el código fuente en la consola
        System.out.println(pageSource);
    }
}
