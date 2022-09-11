package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;


public class comprarCursoPO {


    @Dado("^que acesso o site papito$")
    public void queAcessoOSitePapito() {
        System.out.println("Passo1");

    }

    @Quando("^pesquiso por \"([^\"]*)\"$")
    public void pesquisoPor(String arg0) throws Throwable {
        System.out.println("Passo2");

    }

    @Entao("^confirmo o nome do curso \"([^\"]*)\"$")
    public void confirmoONomeDoCurso(String arg0) throws Throwable {
        System.out.println("Passo3");

    }
}
