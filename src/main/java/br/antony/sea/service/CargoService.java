package br.antony.sea.service;

import br.antony.sea.model.Cargo;
import br.antony.sea.repository.CargoRepository;
import br.antony.sea.service.exception.DuplicidadeDadosException;
import br.antony.sea.service.exception.NullDataException;
import br.antony.sea.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    @Autowired
    private CargoRepository repository;
    @Autowired
    private SetorService setorService;

    public Cargo create(Cargo cargo) {
        setorService.findById(cargo.getSetor().getId());
        if(findByNome(cargo.getNome()) != null){
            throw new DuplicidadeDadosException("Cargo "+cargo.getNome()+" já cadastrado");
        }
        return  repository.save(cargo);
    }

    public Cargo findByNome(String nome){
        return repository.findByNome(nome);
    }

    public Cargo findById(Integer id) {
        if(id == null || id == 0){
            throw new NullDataException("Id do Cargo invalido, Id: "+ id);
        }
        Optional<Cargo> cargo = repository.findById(id);
        return cargo.orElseThrow(()-> new ObjectNotFoundException("Cargo não encontrado id: "+id));
    }

    public List<Cargo> findAll() {
        return repository.findAll();
    }

    public Cargo update(Cargo cargo) {
        if(findByNome(cargo.getNome()) != null){
            throw new DuplicidadeDadosException("Cargo "+cargo.getNome()+" já cadastrado");
        }
        setorService.findById(cargo.getSetor().getId());
        findById(cargo.getId());
        return repository.save(cargo);
    }

    public void deleteCargoTrabalhador(Integer id){
        findById(id);
        repository.deleteCargoTrabalhador(id);
    }

    public void delete(Integer id) {
        Cargo cargo = findById(id);
        deleteCargoTrabalhador(id);
        repository.delete(cargo);
    }
}
