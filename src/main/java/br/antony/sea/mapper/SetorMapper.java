package br.antony.sea.mapper;

import br.antony.sea.dto.SetorDTO;
import br.antony.sea.model.Setor;

import java.util.ArrayList;
import java.util.List;

public class SetorMapper {

    public static Setor toEntity(SetorDTO dto){
        return new Setor(dto.getId(), dto.getNome());
    }

    public static List<SetorDTO> toDTOList(List<Setor> entityList) {
        List<SetorDTO> dtoList = new ArrayList<>();
        entityList.forEach(entity ->{
            SetorDTO dto = new SetorDTO(entity.getId(), entity.getNome());
            dtoList.add(dto);
        });
        return dtoList;
    }
}
