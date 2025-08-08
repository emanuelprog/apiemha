package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.PersonOnlineDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.PersonOnline;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = { ChartMapper.class, DeficiencyMapper.class, ProfessionMapper.class, AddressMapper.class, DependentMapper.class })
public interface PersonOnlineMapper {

    @Mapping(target = "cpf", ignore = true)
    PersonOnlineDTO toDTO(PersonOnline model);

    PersonOnline toModel(PersonOnlineDTO dto);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "cpf", target = "formattedCpf", qualifiedByName = "formatCpf")
    @Mapping(source = "isElderly", target = "isElderly", qualifiedByName = "boolToSimNao")
    @Mapping(source = "hasPhysicalDisability", target = "hasDisability", qualifiedByName = "boolToSimNao")
    @Mapping(target = "referenceYear", expression = "java(getYearOrNull(dto))")
    @Mapping(target = "status", expression = "java(getUpdateStatus(dto))")
    @Mapping(source = "id", target = "id")
    PersonOnlineDTO.Summary toSummary(PersonOnlineDTO dto);

    @AfterMapping
    default void maskCpf(@MappingTarget PersonOnlineDTO dto, PersonOnline model) {
        String rawCpf = model.getCpf();
        if (rawCpf != null && rawCpf.length() == 11) {
            String formatted = rawCpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
            dto.setCpf(formatted);
        } else {
            dto.setCpf(rawCpf);
        }
    }

    default Long getYearOrNull(PersonOnlineDTO dto) {
        if (dto.getUpdatedAt() != null) {
            return (long) dto.getUpdatedAt().getYear();
        }
        if (dto.getCreatedAt() != null) {
            return (long) dto.getCreatedAt().getYear();
        }
        return null;
    }

    default String getUpdateStatus(PersonOnlineDTO dto) {
        Long year = getYearOrNull(dto);
        if (year == null) return "CAD DESATUALIZADO";
        int currentYear = java.time.Year.now().getValue();
        return (year == currentYear) ? "CAD ATUALIZADO" : "CAD DESATUALIZADO";
    }

    @Named("boolToSimNao")
    default String boolToSimNao(Boolean value) {
        return (value != null && value) ? "Sim" : "Não";
    }

    @Named("formatCpf")
    default String formatCpf(String cpf) {
        if (cpf != null) {
            String cleanCpf = cpf.replaceAll("[.\\-]", "");
            if (cleanCpf.length() == 11) {
                return "***.***." + cleanCpf.substring(6, 9) + "-" + cleanCpf.substring(9);
            }
        }
        return cpf;
    }
}