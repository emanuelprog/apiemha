package com.br.gov.ms.campogrande.apiemha.util;

import com.br.gov.ms.campogrande.apiemha.model.emha.Debt;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

public class DebtColorResolverUtil {

    public static String resolve(Debt debt) {
        if (debt.getTaxTypeId() == null) return "";

        boolean isInactive = Optional.ofNullable(debt.getInactivatedByUser()).orElse(false);
        Boolean isClosed = debt.getClosedInstallment();
        LocalDate today = LocalDate.now();

        if (!isInactive) {
            if (debt.getTaxTypeId() == 2) {
                return color("#999999", isClosed, "black");
            }

            if (debt.getTaxTypeId() == 3) {
                return color("#20124d", isClosed, "#FFFFFF");
            }

            if (debt.getTaxTypeId() == 4) {
                return color("#783f04", isClosed, "#FFFFFF");
            }

            if (debt.getPaymentDate() != null && (debt.getBonus() == null || !debt.getBonus())) {
                return color("#098f7c", isClosed, "#FFFFFF");
            }

            if (debt.getPaymentDate() == null && debt.getDueDate() != null) {
                if (debt.getDueDate().isBefore(today)) {
                    LocalDate yesterday = today.minusDays(1);

                    boolean isWeekendYesterday = isWeekend(yesterday);
                    boolean isWeekendDue = isWeekend(debt.getDueDate());

                    if (isWeekendYesterday && isWeekendDue &&
                            (debt.getDueDate().equals(yesterday) || debt.getDueDate().equals(yesterday.minusDays(1)))) {
                        return color("#fefeb0", isClosed, "black");
                    }

                    return color("#ff3f3f", isClosed, "#FFFFFF"); // vencida
                }

                if (!debt.getDueDate().isBefore(today)) {
                    return color("#fefeb0", isClosed, "black"); // a vencer
                }
            }

            if (Boolean.TRUE.equals(debt.getBonus())) {
                return color("#87cefa", isClosed, "black"); // bônus
            }

        } else {
            return color("#FFA500", isClosed, "black"); // inativa
        }

        return "";
    }

    private static boolean isWeekend(LocalDate date) {
        return date != null && (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY);
    }

    private static String color(String bgColor, Boolean isClosed, String colorOpen) {
        String color = Boolean.TRUE.equals(isClosed) ? "Blue" : colorOpen;
        return String.format("background-color:%s; font-weight:bold;color:%s;font-size:10", bgColor, color);
    }
}
