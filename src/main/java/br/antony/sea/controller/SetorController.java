package br.antony.sea.controller;


import br.antony.sea.dto.NovoSetorDTO;
import br.antony.sea.dto.SetorDTO;
import br.antony.sea.mapper.SetorMapper;
import br.antony.sea.model.Setor;
import br.antony.sea.service.SetorService;
import br.antony.sea.service.exception.ObjectNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/setor")
@Api(value = "Endpoints Setor")
@CrossOrigin(origins = "*")
public class SetorController {

    @Autowired
    private SetorService service;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Cadastrar Setor")
    public ResponseEntity<Void> create(@Valid @RequestBody NovoSetorDTO setorDTO){
        Setor setor = service.create(SetorMapper.toEntity(setorDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(setor.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<SetorDTO> findById(@PathVariable Integer id){
        Setor setorEntity = service.findById(id);
        if(setorEntity == null){
            return ResponseEntity.notFound().build();
        }
        SetorDTO setorDTO = SetorMapper.toDTO(setorEntity);
        return ResponseEntity.ok().body(setorDTO);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SetorDTO>> findAll(){
        List<SetorDTO> setorList = SetorMapper.toDTOList(service.findAll());
        return ResponseEntity.ok().body(setorList);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody NovoSetorDTO dto){
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
