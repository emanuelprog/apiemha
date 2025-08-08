package com.br.gov.ms.campogrande.apiemha.mapper;

import com.br.gov.ms.campogrande.apiemha.dto.DebtDTO;
import com.br.gov.ms.campogrande.apiemha.model.emha.Debt;
import com.br.gov.ms.campogrande.apiemha.util.DebtCalculatorUtil;
import com.br.gov.ms.campogrande.apiemha.util.DebtColorResolverUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Mapper(componentModel = "spring", imports = {DebtCalculatorUtil.class, DebtColorResolverUtil.class})
public interface DebtMapper {

    DebtMapper INSTANCE = Mappers.getMapper(DebtMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "contract", source = "contract")
    @Mapping(target = "person", source = "person")
    @Mapping(target = "taxTypeId", source = "taxTypeId")
    @Mapping(target = "installmentNumber", source = "installmentNumber")
    @Mapping(target = "dueDate", expression = "java(formatDate(debt.getDueDate()))")
    @Mapping(target = "originalValueFormatted", expression = "java(DebtCalculatorUtil.format(DebtCalculatorUtil.getValueWithoutDiscount(debt)))")
    @Mapping(target = "discountFormatted", expression = "java(DebtCalculatorUtil.format(debt.getAdditionalDiscount()))")
    @Mapping(target = "valueWithDiscount", expression = "java(DebtCalculatorUtil.format(DebtCalculatorUtil.getValueWithDiscount(debt)))")
    @Mapping(target = "interestFormatted", expression = "java(DebtCalculatorUtil.format(debt.getInterestAmount()))")
    @Mapping(target = "fineFormatted", expression = "java(DebtCalculatorUtil.format(debt.getFineAmount()))")
    @Mapping(target = "additionalFormatted", expression = "java(DebtCalculatorUtil.format(debt.getAdditionalValue()))")
    @Mapping(target = "totalFormatted", expression = "java(DebtCalculatorUtil.format(DebtCalculatorUtil.calculateTotalAmount(debt)))")
    @Mapping(target = "paymentValueFormatted", expression = "java(DebtCalculatorUtil.format(debt.getPaidAmount()))")
    @Mapping(target = "paymentDate", expression = "java(formatDate(debt.getPaymentDate()))")
    @Mapping(target = "color", expression = "java(DebtColorResolverUtil.resolve(debt))")
    @Mapping(target = "bonus", source = "bonus")
    @Mapping(target = "bonusYear", source = "bonusYear")
    DebtDTO toDTO(Debt debt);

    @Mapping(target = "coddeb", source = "id")
    @Mapping(target = "codctr", source = "contract.id")
    @Mapping(target = "numdeb", expression = "java(toInt(debt.getInstallmentNumber()))")
    @Mapping(target = "vendeb", expression = "java(toDate(debt.getDueDate()))")
    @Mapping(target = "vlodeb", source = "originalAmount")
    @Mapping(target = "vladeb", source = "adjustmentAmount")
    @Mapping(target = "jurdeb", source = "interestAmount")
    @Mapping(target = "muldeb", source = "fineAmount")
    @Mapping(target = "desdeb", source = "discountAmount")
    @Mapping(target = "deadeb", source = "additionalDiscount")
    @Mapping(target = "vlddeb", source = "additionalValue")
    @Mapping(target = "readeb", source = "percentageAdjustment")
    @Mapping(target = "rejdeb", source = "ipcaAdjustmentValue")
    @Mapping(target = "totdeb", source = "totalAmount")
    @Mapping(target = "vlpdeb", source = "paidAmount")
    @Mapping(target = "bnsdeb", source = "bonus")
    @Mapping(target = "abndeb", expression = "java(toInt(debt.getBonusYear()))")
    @Mapping(target = "checkBoxParcelas", constant = "true")
    @Mapping(target = "codtrb", source = "taxTypeId")
    @Mapping(target = "chkbox", constant = "true")
    DebtDTO.SecondCopy toSecondCopy(Debt debt);

    default String formatDate(java.time.LocalDate date) {
        return date != null ? date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : null;
    }

    default Date toDate(java.time.LocalDate date) {
        return date != null ? Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()) : null;
    }

    default Integer toInt(Long value) {
        return value != null ? value.intValue() : null;
    }
}