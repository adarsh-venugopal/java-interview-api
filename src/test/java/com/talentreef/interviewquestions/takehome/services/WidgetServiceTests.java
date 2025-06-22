package com.talentreef.interviewquestions.takehome.services;

import com.talentreef.interviewquestions.takehome.dto.WidgetDTO;
import com.talentreef.interviewquestions.takehome.models.Widget;
import com.talentreef.interviewquestions.takehome.respositories.WidgetRepository;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class WidgetServiceTests {

  @Mock
  private WidgetRepository widgetRepository;

  @InjectMocks
  private WidgetService widgetService;

  @Test
  public void when_getAllWidgets_expect_findAllResult() throws Exception {
    Widget widget = Widget.builder().name("Widgette Nielson").build();
    WidgetDTO widgetDTO = new WidgetDTO(
        widget.getName(),
        widget.getDescription(),
        widget.getPrice()
    );
    List<Widget> response = List.of(widget);
    when(widgetRepository.findAll()).thenReturn(response);

    List<WidgetDTO> result = widgetService.getAllWidgets();

    assertThat(result).isEqualTo(List.of(widgetDTO));
  }

}
