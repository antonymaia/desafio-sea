package br.antony.sea.controller;

import br.antony.sea.dto.CargoDTO;
import br.antony.sea.dto.NovoCargoDTO;
import br.antony.sea.mapper.CargoMapper;
import br.antony.sea.model.Cargo;
import br.antony.sea.service.CargoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cargo")
public class CargoController {

    @Autowired
    private CargoService service;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Cadastrar Cargo")
    public ResponseEntity<Void> create(@Valid @RequestBody NovoCargoDTO dto){
        Cargo cargo = service.create(CargoMapper.toEntity(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cargo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Busca Cargo pelo Id")
    public ResponseEntity<Cargo> findById(@PathVariable Integer id){
        Cargo cargo = service.findById(id);
        if(cargo == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(cargo);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Busca todos os Cargos")
    public ResponseEntity<List<Cargo>> findAll(){
        List<Cargo> cargoDTOList = service.findAll();
        return ResponseEntity.ok().body(cargoDTOList);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "Atualiza Cargo")
    public ResponseEntity<Void> update(@Valid @RequestBody NovoCargoDTO dto){
        Cargo cargo = service.update(CargoMapper.toEntity(dto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cargo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deleta Cargo pelo Id")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
