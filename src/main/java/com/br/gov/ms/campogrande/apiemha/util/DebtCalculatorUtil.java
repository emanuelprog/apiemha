package com.br.gov.ms.campogrande.apiemha.util;

import com.br.gov.ms.campogrande.apiemha.model.emha.Debt;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DebtCalculatorUtil {

    private static final DecimalFormat formatter = new DecimalFormat("#,##0.00");

    public static BigDecimal getValueWithoutDiscount(Debt debt) {
        return safe(debt.getOriginalAmount())
                .add(safe(debt.getPercentageAdjustment()))
                .add(safe(debt.getIpcaAdjustmentValue()));
    }

    public static BigDecimal getValueWithDiscount(Debt debt) {
        return getValueWithoutDiscount(debt).subtract(safe(debt.getDiscountAmount()));
    }

    public static BigDecimal calculateTotalAmount(Debt debt) {
        return safe(debt.getOriginalAmount())
                .add(safe(debt.getPercentageAdjustment()))
                .add(safe(debt.getIpcaAdjustmentValue()))
                .add(safe(debt.getInterestAmount()))
                .add(safe(debt.getFineAmount()))
                .add(safe(debt.getAdditionalValue()))
                .subtract(safe(debt.getDiscountAmount()))
                .subtract(safe(debt.getAdditionalDiscount()));
    }

    public static String format(BigDecimal value) {
        return value != null ? formatter.format(value) : null;
    }

    private static BigDecimal safe(BigDecimal value) {
        return value != null ? value : BigDecimal.ZERO;
    }
}
