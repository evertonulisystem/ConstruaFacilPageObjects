package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    //Classe de mapeamento que possui 3 ações
    //1- Mapeamento de elementos(Atrbutos) BY ou FINDBY
    //2-Constructor entre os elementos e os passos
    //3- Funções emetdos mapeados

    //1
    Webdriver driver;

    @FindBy(className = "form-control") // similar ao .findElement(......) poderia ser (id= ...)
    WebElement caixaDePesquisa; //tem de nomear o elemento

    @FindBy(className = "btn")
    WebElement botaoProcurar;
    //ideal seria pegar todos os campos da pagina
    //2- Criar o construtor

    public Home(Webdriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //3 Funções e Metodos
    public void pesquisarPorCurso(String curso) {
        caixaDePesquisa.click();
        caixaDePesquisa.clear();
        caixaDePesquisa.sendKeys(curso);
    }

    public void clicarNaLupa() {
        botaoProcurar.click();
    }


}
