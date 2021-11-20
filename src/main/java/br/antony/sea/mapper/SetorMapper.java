package br.antony.sea.mapper;

import br.antony.sea.dto.CargoDTO;
import br.antony.sea.dto.NovoSetorDTO;
import br.antony.sea.dto.SetorDTO;
import br.antony.sea.model.Setor;

import java.util.ArrayList;
import java.util.List;

public class SetorMapper {

    public static Setor toEntity(NovoSetorDTO dto){
        return new Setor((dto.getId()!=null? dto.getId() : 0), dto.getNome());
    }

    public static List<NovoSetorDTO> toDTOList(List<Setor> entityList) {
        List<NovoSetorDTO> dtoList = new ArrayList<>();
        entityList.forEach(entity ->{
            NovoSetorDTO dto = new NovoSetorDTO(entity.getId(), entity.getNome());
            dtoList.add(dto);
        });
        return dtoList;
    }

    public static SetorDTO toDTO(Setor entity) {
        List<CargoDTO> cargoDTOList = new ArrayList<>();
        entity.getCargos().forEach(cargoEntity->{
            CargoDTO cargoDTO = new CargoDTO(cargoEntity.getId(), cargoEntity.getNome(), cargoEntity.getSetor().getId());
            cargoDTOList.add(cargoDTO);
        });
        SetorDTO dto = new SetorDTO(entity.getId(), entity.getNome());
        dto.setCargos(cargoDTOList);
        return dto;
    }
}
