package com.talentreef.interviewquestions.takehome.controllers;

import com.talentreef.interviewquestions.takehome.dto.WidgetDTO;
import com.talentreef.interviewquestions.takehome.services.WidgetService;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin
@Validated
@RequestMapping(value = "/v1/widgets", produces = MediaType.APPLICATION_JSON_VALUE)
public class WidgetController {

  private final WidgetService widgetService;

  public WidgetController(WidgetService widgetService) {
    Assert.notNull(widgetService, "widgetService must not be null");
    this.widgetService = widgetService;
  }

  @GetMapping
  public ResponseEntity<List<WidgetDTO>> getAllWidgets() {
    return ResponseEntity.ok(widgetService.getAllWidgets());
  }

  @DeleteMapping("/{name}")
  public ResponseEntity<List<WidgetDTO>> deleteById(@PathVariable String name) {
    return ResponseEntity.ok(widgetService.deleteById(name));
  }

  @GetMapping("/{name}")
  public ResponseEntity<WidgetDTO> findById(@PathVariable String name) {
    return ResponseEntity.ok(widgetService.findById(name));
  }

  @PostMapping
  public ResponseEntity<WidgetDTO> createWidget(@Valid @RequestBody WidgetDTO widgetDto) {
    return ResponseEntity.ok(widgetService.createOrUpdateWidget(widgetDto));
  }

  @PutMapping("/{name}")
  public ResponseEntity<WidgetDTO> updateWidget(
      @PathVariable String name,
      @Valid @RequestBody WidgetDTO widgetDto) {
    return ResponseEntity.ok(widgetService.createOrUpdateWidget(widgetDto));
  }

}