package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class comprarCursoPO {
    WebDriver driver;

    @Given("^que acesso o site papito$")
    public void queAcessoOSitePapito() {
        System.out.println("Passo 1");

    }

    @When("^pesquiso por \"([^\"]*)\"$")
    public void pesquisoPor(String arg0) throws Throwable {
        System.out.println("Passo 2");

    }

    @Then("^confirmo o nome do curso \"([^\"]*)\"$")
    public void confirmoONomeDoCurso(String arg0) throws Throwable {
        System.out.println("Passo3");

    }
}
