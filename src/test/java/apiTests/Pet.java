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

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void incluirPet() throws IOException {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        String jsonBody = lerJson("src/test/resources/data/pet.json");
        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .post("https://petstore.swagger.io/v2/pet")
        .then()
                .log().all() //registrar tudo da volta
                .statusCode(200)
                .body("id", is(123459))
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

    @Test
    public void consultarPet() {
        String PetId ="123459";
        given()
                .contentType("application/json")
                .log().all()
                .when()
                      .get("https://petstore.swagger.io/v2/pet/" + PetId)
                .then()
                .log().all()
                .statusCode(200)
                .body("name", is("spike"))
                .body("status",is("available"))
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


}
