package com.br.gov.ms.campogrande.apiemha.repository.emha;

import com.br.gov.ms.campogrande.apiemha.model.emha.Chart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChartRepository extends JpaRepository<Chart, Long> {

    List<Chart> findAllByChartType(String chartType);
}
