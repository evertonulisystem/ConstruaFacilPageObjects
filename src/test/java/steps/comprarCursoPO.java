package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Home;

import java.util.concurrent.TimeUnit;

public class comprarCursoPO {
    WebDriver driver;
    WebDriverWait wait;

    Home home;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        home = new Home(driver);

        System.out.println("Passo 0 - Classe");
    }

    @After
    public void tearDown() {
        driver.quit();
        System.out.println("Passo Z-Classe");

    }

    @Given("^que acesso o site papito$")
    public void queAcessoOSitePapito() {
        driver.get("https://www.qacademy.io/");
        System.out.println("Passo 1");

    }

    @When("^pesquiso por \"([^\"]*)\"$")
    public void pesquisoPor(String curso) throws Throwable {
        home.pesquisarPorCurso(curso);
        System.out.println("Passo 2");
    }

    @Then("^confirmo o nome do curso \"([^\"]*)\"$")
    public void confirmoONomeDoCurso(String arg0) throws Throwable {
        home.clicarNaLupa();
        System.out.println("Passo3");

    }
}
