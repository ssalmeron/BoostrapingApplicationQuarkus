package mx.com.salmeron.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookResourceTest {

    @Test
    @DisplayName("testHelloEndpoint API")
    public void testgetAllBooks() {
        given()
                .accept(MediaType.APPLICATION_JSON)
                .when().get("/api/books")
                .then()
                .statusCode(200)
                .body("size()", is(2));
    }


    @Test
    @DisplayName("count All Books Test")
    public void countAllBooksTest() {
        given()
                .accept(MediaType.TEXT_PLAIN)
                .when()
                .get("/api/books/count")
                .then()
                .statusCode(200)
                .body(is("2"));

    }

    @Test
    @DisplayName("Get a Specific Book Test")
    public void getABookTest() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)  //Difference way of achieve
                //.accept(MediaType.APPLICATION_JSON)
                .pathParam("id", 1)
                .when()
                .get("/api/books/{id}")
                .then()
                .statusCode(200)
                .body("title", is("Understanding Quarkus"))
                .body("author", is("Antonio Goncalves"))
                .body("yearOfPublication", is(2020))
                .body("genre", is("IT"));

    }
}