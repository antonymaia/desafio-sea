package br.antony.sea.service;

import br.antony.sea.model.Trabalhador;
import br.antony.sea.repository.TrabalhadorRepository;
import br.antony.sea.service.exception.DuplicidadeDadosException;
import br.antony.sea.service.exception.NullDataException;
import br.antony.sea.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabalhadorService {

    @Autowired
    private TrabalhadorRepository repository;
    @Autowired
    private CargoService cargoService;

    public Trabalhador create(Trabalhador trabalhador) {
        trabalhador.setAtivo(true);
        if(trabalhador.getCargo() == null){
            throw new NullDataException("Informe o Cargo do Trabalhador");
        }
        cargoService.findById(trabalhador.getCargo().getId());
        if(repository.findByCpf(trabalhador.getCpf()).isPresent()){
            throw new DuplicidadeDadosException("CPF já cadastrado");
        }
        return repository.save(trabalhador);
    }

    public Trabalhador findById(Integer id) {
        Optional<Trabalhador> trabalhador = repository.findById(id);
        return trabalhador.orElseThrow(()-> new ObjectNotFoundException("Trabalhador não encontrado: Id: "+id));
    }

    public List<Trabalhador> findAll() {
        return repository.findAll();
    }

    public Trabalhador update(Trabalhador trabalhadorAtualizado ){
        Trabalhador trabalhadorCadastrado = findById(trabalhadorAtualizado.getId());
        if(!trabalhadorCadastrado.getCpf().equals(trabalhadorAtualizado.getCpf())){
            if(repository.findByCpf(trabalhadorAtualizado.getCpf()).isPresent()){
                throw new DuplicidadeDadosException("CPF já cadastrado");
            }
        }
        cargoService.findById(trabalhadorAtualizado.getCargo().getId());
        return repository.save(trabalhadorAtualizado);
    }

    public void updateAtivo(Integer id, boolean ativo) {
        findById(id);
        repository.updateAtivo(id, ativo);
    }
}
