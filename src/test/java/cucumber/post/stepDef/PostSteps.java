package cucumber.post.stepDef;

import cucumber.PostAPI;
import cucumber.utils.Constantes;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.*;

public class PostSteps {

    @ParameterType(".*")
    public Integer integer(String value) {
        return Integer.parseInt(value);
    }
    @Steps
    PostAPI postAPI;

    @Given("el post sin parametros")
    public void postSinParametros() {
        SerenityRest.given();
    }

    @When("se envia solicitud de post")
    public void enviarSolicitudPost() {
        SerenityRest.when().get(PostAPI.GET_POST);
    }

    @And("validar el post de la lista de esquemas json")
    public void validarPostJsonEsquema() {
        File jsonSchema = new File("src/test/resources/Schema/ResponseUserSchemaValid.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("el post con id {integer}")
    public void postConId(Integer id) {
        postAPI.consultarPorId(id);
    }

    @Then("debería devolver el codigo {integer}")
    public void deberíaDevolverElCodigo(Integer codigoEsperado) {
        SerenityRest.then()
                .statusCode(codigoEsperado);
    }

    @And("validar el id del post el cual debe ser {integer}")
    public void validarIdPostDebeContener(Integer id) {
        SerenityRest.then()
                .assertThat()
                .body("id", everyItem(is(id)));
    }

    @Given("el post con user_id {integer}")
    public void postConUserId(Integer user_id) {
        postAPI.consultarPorUserId(user_id);
    }

    @And("validar el user_id de post debe contener {integer}")
    public void validarUsuarioIdDebeContener(Integer user_id) {
        SerenityRest.then()
                .assertThat()
                .body("user_id", everyItem(is(user_id)));
    }

    @Given("el post con title {string}")
    public void postConTitle(String title) {
        postAPI.consultarPorTitulo(title);
    }

    @And("validar el title del post debe ser {string}")
    public void validarTituloPost(String title) {
        SerenityRest.then()
                .assertThat()
                .body("title", everyItem(containsString(title)));
    }

    @Given("el post con body {string}")
    public void postConBody(String body) {
        postAPI.consultarPorCuerpo(body);
    }

    @And("validar el body del post debe contener {string}")
    public void validarBodyPost(String body) {
        SerenityRest.then()
                .assertThat()
                .body("body", everyItem(containsString(body)));
    }
}
