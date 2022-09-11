package webTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Evidencias;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class seleniumSimples {
    //Atributos
    WebDriver driver;
    Evidencias evidencias;


    //Métodos e Funções


    @BeforeMethod
    public void iniciar(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

        evidencias = new Evidencias();
    }

    @Test
    public void consultarCurso() throws IOException {
    String casoDeTeste = "Consulta Iterasys";
        driver.get("https://iterasys.com.br/pt");
        evidencias.print(driver, casoDeTeste, "Passo1 -Abriu o site");


        driver.findElement(By.className("item-pill")).click();
        evidencias.print(driver, casoDeTeste, "Passo2 -Exibiu o site");

    }

}
