package com.talentreef.interviewquestions.takehome.dto;

import java.math.BigDecimal;


public record WidgetDTO(
    String name,
    String description,
    BigDecimal price
    ) {}