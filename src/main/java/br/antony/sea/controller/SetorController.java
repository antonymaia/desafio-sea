package br.antony.sea.controller;


import br.antony.sea.dto.SetorDTO;
import br.antony.sea.mapper.SetorMapper;
import br.antony.sea.model.Setor;
import br.antony.sea.service.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/setor")
public class SetorController {

    @Autowired
    private SetorService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@Valid @RequestBody SetorDTO dto){
        Setor setor = service.create(SetorMapper.toEntity(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(setor.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Setor> findById(@PathVariable Integer id){
        Setor setor = service.findById(id);
        return ResponseEntity.ok().body(setor);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SetorDTO>> findAll(){
        List<SetorDTO> setorList = SetorMapper.toDTOList(service.findAll());
        return ResponseEntity.ok().body(setorList);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody SetorDTO dto){
        Setor setor = service.update(SetorMapper.toEntity(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(setor.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
