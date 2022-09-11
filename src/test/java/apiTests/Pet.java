package apiTests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Pet {
//Definido as variaveis para melhor gerencia
    String uri = "https://petstore.swagger.io/v2/pet";
    int petId = 123459; //alterar de string para int pois ira referenciar aqui para tudo abaixo


    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test(priority =0)
    public void incluirPet() throws IOException {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        String jsonBody = lerJson("src/test/resources/data/pet.json");
        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                //.post("https://petstore.swagger.io/v2/pet")
                .post(uri)
        .then()
                .log().all() //registrar tudo da volta
                .statusCode(200)
                .body("id", is(petId))
                .body("name", is("spike"))
                .body("category.name", is("dog"));
        System.out.println("Adicionado com Sucesso"); // + response.getStatusLine());
        //System.out.println("Response=>" + response.prettyPrint());
    }

    @Test
    public void listarPet() throws IOException {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "");
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

    }

    @Test(priority =1, dependsOnMethods = {"incluirPet"})
    public void consultarPet() {
        //String PetId ="123459"; comentado pois declarei variavel global
        given()
                .contentType("application/json")
                .log().all()
                .when()
                      .get(uri + "/" + petId)
                .then()
                .log().all()
                .statusCode(200)
                .body("name", is("spike"))
                .body("status",is("available"))
                ;
    }

    @Test(priority =2, dependsOnMethods = {"consultarPet"}) //definindo as prioridades de execução com dependencia de metodos
    public void atualizarPet() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/newPet.json");

        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .put("https://petstore.swagger.io/v2/pet")
        .then()
                .log().all()
                .statusCode(200)
                .body("status",is("sold"))
                .body("name", is("spoike"))
        ;
    }

    @Test
    public void listar2Pet() throws IOException {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("1");
        //System.out.println("Response Body is:  " + response.asString()); //saida em uma linha.: com prertty sai como o json formatado
        System.out.println("Response Body is:  " + response.prettyPrint());
    }
    //@Test(priority = 5, dependsOnMethods = {"atualizarPet"})
    @Test(priority =3 , dependsOnMethods = {"consultarPet"})
    public void excluir() throws IOException {
        System.out.println("Aqui foi a exclusao");

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .delete(uri +"/" + petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("code" ,is(200))
                .body("type",is("unknown"))
                .body("message",is(Integer.toString(petId))) //convertendo pois na swagger esta string
                ;

    }

}
