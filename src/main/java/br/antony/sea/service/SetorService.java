package br.antony.sea.service;

import br.antony.sea.model.Setor;
import br.antony.sea.repository.SetorRepository;
import br.antony.sea.service.exception.DuplicidadeDadosException;
import br.antony.sea.service.exception.NullDataException;
import br.antony.sea.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetorService {

    @Autowired
    private SetorRepository repository;

    public Setor create(Setor setor) {
        if(findByNome(setor.getNome().toUpperCase()) != null){
            throw new DuplicidadeDadosException("Setor "+setor.getNome()+" já cadastrado");
        }
        setor = repository.save(setor);
        return setor;
    }

    public Setor findByNome(String nome){
        Setor setor = repository.findByNome(nome);
        return setor;
    }

    public Setor findById(Integer id) {
        Optional<Setor> setor = repository.findById(id);
        return setor.orElseThrow(()-> new ObjectNotFoundException("Setor não encontrado: Id: "+id));
    }

    public List<Setor> findAll() {
        return repository.findAll();
    }

    public Setor update(Setor setor) {
        if(setor.getId() == null){
            throw new NullDataException("Informe o id do setor");
        }
        if(findByNome(setor.getNome().toUpperCase()) != null){
            throw new DuplicidadeDadosException("Setor "+setor.getNome()+" já cadastrado");
        }
        findById(setor.getId());
        return repository.save(setor);
    }

    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }
}
