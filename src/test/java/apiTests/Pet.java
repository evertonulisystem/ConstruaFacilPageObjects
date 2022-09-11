package apiTests;

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

        String jsonBody = lerJson("src/test/resources/data/pet.json");

        given()
                .contentType("applicationJson")
                .log().all()

        .when()
                .post("https://petstore.swagger.io/v2/pet")
        .then()
                .log().all() //registrar tudo da volta
                .statusCode(200)
                .body("id", is(459))
                .body("name", is("spike"))
                .body("category.name",is("dog"))

        ;
    }
}
