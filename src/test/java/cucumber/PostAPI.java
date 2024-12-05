package cucumber;

import io.cucumber.java.sl.In;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import cucumber.utils.Constantes;

public class PostAPI {

    public static String GET_POST = Constantes.BASE_URL + "/public/v2/posts";

    @Step("Get post")
    public void obtenerPost(Integer id, Integer user_id, String title, String body) {
        SerenityRest.given()
                .queryParam("name", id)
                .queryParam("email", user_id)
                .queryParam("gender", title)
                .queryParam("status", body);

    }


    @Step("Consultar por ID")
    public void consultarPorId(int id) {
        SerenityRest.given()
                .baseUri(GET_POST)
                .queryParam("id", id);
    }

    @Step("Consultar por User ID")
    public void consultarPorUserId(int userId) {
        SerenityRest.given()
                .baseUri(GET_POST)
                .queryParam("user_id", userId);
    }

    @Step("Consultar por Título")
    public void consultarPorTitulo(String title) {
        SerenityRest.given()
                .baseUri(GET_POST)
                .queryParam("title", title);
    }

    @Step("Consultar por Cuerpo")
    public void consultarPorCuerpo(String body) {
        SerenityRest.given()
                .baseUri(GET_POST)
                .queryParam("body", body);
    }
}
