package br.antony.sea.controller;

import br.antony.sea.dto.NovoTrabalhoDTO;
import br.antony.sea.mapper.TrabalhadorMapper;
import br.antony.sea.model.Trabalhador;
import br.antony.sea.service.TrabalhadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/trabalhador")
public class TrabalhadorController {

    @Autowired
    private TrabalhadorService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@Valid @RequestBody NovoTrabalhoDTO novoTrabalhoDTO){
        Trabalhador trabalhador = service.create(TrabalhadorMapper.newDtoToEntity(novoTrabalhoDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(trabalhador.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Trabalhador> findById(@PathVariable Integer id){
        Trabalhador trabalhador = service.findById(id);
        return  ResponseEntity.ok().body(trabalhador);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Trabalhador>> findAll(){
        List<Trabalhador> trabalhadorList = service.findAll();
        return ResponseEntity.ok().body(trabalhadorList);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody NovoTrabalhoDTO novoTrabalhoDTO){
        Trabalhador trabalhador = service.update(TrabalhadorMapper.newDtoToEntity(novoTrabalhoDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(trabalhador.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateAtivo(@PathVariable Integer id, @RequestParam boolean ativo){
        service.updateAtivo(id, ativo);
        return ResponseEntity.ok().build();
    }
}
