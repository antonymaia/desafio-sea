package br.antony.sea.mapper;

import br.antony.sea.dto.CargoDTO;
import br.antony.sea.dto.NovoCargoDTO;
import br.antony.sea.model.Cargo;
import br.antony.sea.model.Setor;

import java.util.ArrayList;
import java.util.List;

public class CargoMapper {

    public static Cargo toEntity(NovoCargoDTO dto){
        Setor setor = new Setor(dto.getIdSetor(), null);
        Cargo entity = new Cargo(dto.getId(), dto.getNome(), setor);
        return entity;
    }

    public static CargoDTO toDTO(Cargo entity) {
        CargoDTO dto = new CargoDTO(entity.getId(), entity.getNome());
        return dto;
    }

    public static List<CargoDTO> toDTOList(List<Cargo> entityList) {
        List<CargoDTO> dtoList = new ArrayList<>();
        entityList.forEach(entity->{
            CargoDTO dto = new CargoDTO(entity.getId(), entity.getNome());
            dtoList.add(dto);
        });
        return dtoList;
    }
}
