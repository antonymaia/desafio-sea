package br.antony.sea.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.*;

import br.antony.sea.model.Setor;
import br.antony.sea.service.CargoService;
import br.antony.sea.service.SetorService;
import br.antony.sea.service.TrabalhadorService;
import br.antony.sea.service.exception.ObjectNotFoundException;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

@WebMvcTest
public class SetorControllerTest {

    @Autowired
    private SetorController setorController;

    @MockBean
    private SetorService setorService;
    @MockBean
    private CargoService cargoService;
    @MockBean
    private TrabalhadorService trabalhadorService;

    @BeforeEach
    public void setup(){
        standaloneSetup(this.setorController);
    }

    @Test
    public void findByIdTest(){
        when(this.setorService.findById(1))
                .thenReturn(new Setor(1, "comercial"));

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/setor/{id}", 1)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void findByIdReturnNotFoundTest(){
        when(this.setorService.findById(1))
                .thenReturn(null);
        given()
                .accept(ContentType.JSON)
                .when()
                .get("/setor/{id}", 1)
                .then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }
}
