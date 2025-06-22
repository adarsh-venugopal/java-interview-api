package com.talentreef.interviewquestions.takehome.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder(toBuilder=true)
public class Widget {

  @Column(nullable = false, unique = true)
  @NotBlank(message = "Name is required")
  @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
  private String name;

  @Column(nullable = false)
  @NotBlank(message = "Description is required")
  @Size(min = 5, max = 1000, message = "Description must be between 5 and 1000 characters")
  private String description;

  @Column(nullable = false, precision = 10, scale = 2)
  @DecimalMin(value = "1.00", inclusive = true, message = "Price must be at least 1.00")
  @DecimalMax(value = "20000.00", inclusive = true, message = "Price must not exceed 20000.00")
  private BigDecimal price;

}
