package br.antony.sea.mapper;

import br.antony.sea.dto.NovoTrabalhoDTO;
import br.antony.sea.model.Cargo;
import br.antony.sea.model.Trabalhador;

public class TrabalhadorMapper {

    public static Trabalhador newDtoToEntity(NovoTrabalhoDTO dto) {
        Trabalhador entity = new Trabalhador(
                dto.getId(),
                dto.getCpf(),
                dto.getNome(),
                dto.getSexo(),
                true,
                new Cargo(dto.getIdCargo(), null, null));
        return entity;
    }
}
