package com.talentreef.interviewquestions.takehome.services;

import com.talentreef.interviewquestions.takehome.dto.WidgetDTO;
import com.talentreef.interviewquestions.takehome.models.Widget;
import com.talentreef.interviewquestions.takehome.respositories.WidgetRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Slf4j
@Service
public class WidgetService {

  private final WidgetRepository widgetRepository;

  @Autowired
  private WidgetService(WidgetRepository widgetRepository) {
    Assert.notNull(widgetRepository, "widgetRepository must not be null");
    this.widgetRepository = widgetRepository;
  }

  public List<WidgetDTO> deleteById(String name) {
    return widgetRepository
        .deleteById(name)
        .stream()
        .map(widget -> new WidgetDTO(
            widget.getName(),
            widget.getDescription(),
            widget.getPrice()))
        .toList();
  }

  public List<WidgetDTO> getAllWidgets() {
    return widgetRepository
        .findAll()
        .stream()
        .map(widget -> new WidgetDTO(
            widget.getName(),
            widget.getDescription(),
            widget.getPrice()))
        .toList();
  }

  public WidgetDTO findById(String name) {
    Optional<Widget> widgetResult = widgetRepository.findById(name);
    return widgetResult.map(widget -> new WidgetDTO(
            widget.getName(),
            widget.getDescription(),
            widget.getPrice()))
        .orElse(null);
  }

  public WidgetDTO createOrUpdateWidget(WidgetDTO widgetDto) {
    Widget widget = Widget.builder()
        .name(widgetDto.name())
        .description(widgetDto.description())
        .price(widgetDto.price())
        .build();
    Widget newWidget = widgetRepository.save(widget);
    return new WidgetDTO(
        newWidget.getName(),
        newWidget.getDescription(),
        newWidget.getPrice());
  }

}
