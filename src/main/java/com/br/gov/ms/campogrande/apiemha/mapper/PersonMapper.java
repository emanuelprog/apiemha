package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.PersonDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonDTO toDTO(Person model);

    Person toModel(PersonDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "cpf", target = "formattedCpf", qualifiedByName = "maskCpf")
    @Mapping(target = "isBenefited", constant = "Sim")
    @Mapping(target = "status", expression = "java(getStatus(model))")
    PersonDTO.Summary toSummary(Person model);

    @Named("maskCpf")
    default String maskCpf(String cpf) {
        if (cpf != null && cpf.length() == 11) {
            return "***.***." + cpf.substring(6, 9) + "-" + cpf.substring(9);
        }
        return cpf;
    }

    default String getStatus(Person model) {
        if (model.getUpdatedAt() == null) return "CAD DESATUALIZADO";

        int year = model.getUpdatedAt().getYear();
        int current = LocalDate.now().getYear();
        return year == current ? "CAD ATUALIZADO" : "CAD DESATUALIZADO";
    }
}