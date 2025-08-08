package com.br.gov.ms.campogrande.apiemha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebtDTO {

    private Long id;
    private ContractDTO contract;
    private PersonDTO person;
    private Long taxTypeId;
    private Long installmentNumber;
    private String dueDate;
    private String originalValueFormatted;
    private String discountFormatted;
    private String valueWithDiscount;
    private String interestFormatted;
    private String fineFormatted;
    private String additionalFormatted;
    private String totalFormatted;
    private String paymentValueFormatted;
    private String paymentDate;
    private String color;
    private Boolean bonus;
    private Long bonusYear;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SecondCopy {
        private Long coddeb;
        private Long codctr;
        private Integer numdeb;
        private Date vendeb;
        private BigDecimal vlodeb;
        private BigDecimal vladeb;
        private BigDecimal jurdeb;
        private BigDecimal muldeb;
        private BigDecimal desdeb;
        private BigDecimal deadeb;
        private BigDecimal totdeb;
        private BigDecimal vlpdeb;
        private Boolean bnsdeb;
        private Integer abndeb;
        private Boolean checkBoxParcelas;
        private BigDecimal readeb;
        private BigDecimal rejdeb;
        private BigDecimal vlddeb;
        private Long codtrb;
        private Boolean chkbox;
    }
}
