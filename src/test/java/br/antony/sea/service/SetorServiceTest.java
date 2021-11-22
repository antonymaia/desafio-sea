package br.antony.sea.service;
import static org.junit.jupiter.api.Assertions.*;
import br.antony.sea.model.Setor;

import br.antony.sea.repository.SetorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
public class SetorServiceTest {

    @Autowired
    private SetorService setorService;
    @Autowired
    private SetorRepository setorRepository;

    @Test
    public void createTest(){
        Setor setor = setorService.create(new Setor(null, "COMERCIAL"));
        assertNotNull(setor.getId());
    }

    @Test
    public void findByIdTest(){
        Setor setorEsperado = setorService.create(new Setor(null, "TI"));
        Setor setorAtual = setorService.findById(1);
        assertEquals(setorEsperado, setorAtual);
        assertEquals(setorEsperado.getNome(), setorAtual.getNome());
    }

    @Test
    public void deleteTest(){
        setorService.delete(1);
        Optional<Setor> optionalSetor = setorRepository.findById(1);
        assertFalse(optionalSetor.isPresent());
    }

}
