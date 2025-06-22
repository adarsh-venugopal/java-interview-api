package com.talentreef.interviewquestions.takehome.respositories;

import com.talentreef.interviewquestions.takehome.models.Widget;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class WidgetRepository {

  private List<Widget> table = new ArrayList<>();

  public WidgetRepository() {
    table.add(Widget.builder()
        .name("Smart Widget")
        .description("An intelligent widget for your smart home.")
        .price(new BigDecimal("199.99"))
        .build());

    table.add(Widget.builder()
        .name("Eco Widget")
        .description("Eco-friendly widget made from recycled materials.")
        .price(new BigDecimal("89.49"))
        .build());

    table.add(Widget.builder()
        .name("Mini Widget")
        .description("Compact widget for travel purposes.")
        .price(new BigDecimal("49.95"))
        .build());
  }

  public List<Widget> deleteById(String name) {
    this.table = table.stream()
                      .filter((Widget widget) -> !name.equals(widget.getName()))
                      .collect(Collectors.toCollection(ArrayList::new));
    return table;
  }

  public List<Widget> findAll() {
    return table;
  }

  public Optional<Widget> findById(String name) {
    return table.stream()
        .filter(widget -> name.equalsIgnoreCase(widget.getName()))
        .findAny();
  }

  public Widget save(Widget widget) {
    deleteById(widget.getName());
    table.add(widget);
    return widget;
  }

}
