package main.events.eventYear.projection;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "onlyYear", types = {main.events.eventYear.model.EventYear.class})
public interface OnlyYear{
    Long getLongEventYear_id();
    String getShortYear();
}