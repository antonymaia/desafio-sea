package br.antony.sea.service;

import br.antony.sea.model.Cargo;
import br.antony.sea.model.Setor;
import br.antony.sea.model.Trabalhador;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class TrabalhadorServiceTest {

    @Autowired
    private TrabalhadorService trabalhadorService;
    @Autowired
    private SetorService setorService;
    @Autowired
    private CargoService cargoService;

    private Setor setor ;
    private Cargo cargo ;



    @Test
    public void test01CreateTest(){
        setor = setorService.create(new Setor(null, "comercial"));
        cargo = cargoService.create(new Cargo(null, "vendedor", setor));
        Trabalhador trabalhador = trabalhadorService.create(new Trabalhador(
                null,
                "13245689718",
                "Caio",
                "M",
                true,
                cargo
        ));
        assertNotNull(trabalhador.getId());
    }

    @Test
    public void test02FindByIdTest(){
        setor = setorService.create(new Setor(null, "ti"));
        cargo = cargoService.create(new Cargo(null, "backend developer", setor));
        Trabalhador trabalhadorEsperado = trabalhadorService.create(new Trabalhador(
                null,
                "198764189010",
                "Thiago",
                "M",
                true,
                cargo
        ));
        Trabalhador trabalhadorAtual = trabalhadorService.findById(trabalhadorEsperado.getId());
        assertEquals(trabalhadorEsperado, trabalhadorAtual);
        assertEquals(trabalhadorEsperado.getCpf(), trabalhadorEsperado.getCpf());
    }

    @Test
    public void test03UpdateAtivo(){
        setor = setorService.create(new Setor(null, "serviço gerais"));
        cargo = cargoService.create(new Cargo(null, "auxiliar de limpeza", setor));
        Trabalhador trabalhador = trabalhadorService.create(new Trabalhador(
                null,
                "44532144312",
                "Vinicius",
                "M",
                true,
                cargo
        ));
        trabalhadorService.updateAtivo(trabalhador.getId(), false);
        trabalhador = trabalhadorService.findById(trabalhador.getId());
        assertFalse(trabalhador.isAtivo());
    }

}
