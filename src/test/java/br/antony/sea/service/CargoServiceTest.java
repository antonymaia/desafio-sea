package br.antony.sea.service;
import static org.junit.jupiter.api.Assertions.*;
import br.antony.sea.model.Cargo;
import br.antony.sea.model.Setor;
import br.antony.sea.repository.CargoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.Set;

@SpringBootTest
@AutoConfigureMockMvc
public class CargoServiceTest {

    @Autowired
    private CargoService cargoService;
    @Autowired
    private SetorService setorService;
    @Autowired
    private CargoRepository cargoRepository;

    @Test
    public void test01Create(){
        Setor setor = setorService.create(new Setor(null, "comercial"));
        Cargo cargo = cargoService.create(new Cargo(null, "vendedor", setor));
        assertNotNull(cargo.getId());
    }

    @Test
    public void test02FindById(){
        Setor setor = setorService.create(new Setor(null, "ti"));
        Cargo cargoEsperado = cargoService.create(new Cargo(null, "backend Developer", setor));
        Cargo cargoAtual = cargoService.findById(cargoEsperado.getId());
        assertEquals(cargoEsperado.getId(), cargoAtual.getId());
        assertEquals(cargoEsperado.getNome(), cargoAtual.getNome());
    }

    @Test
    public void test03Delete(){
        Setor setor = setorService.create(new Setor(null, "Serviço Geral"));
        Cargo cargo = cargoService.create(new Cargo(null, "Aux Limpeza", setor));
        cargoService.delete(cargo.getId());
        cargo = cargoService.findById(cargo.getId());
        Optional<Cargo> optionalCargo = cargoRepository.findById(cargo.getId());
        assertFalse(optionalCargo.isPresent());
    }
}
