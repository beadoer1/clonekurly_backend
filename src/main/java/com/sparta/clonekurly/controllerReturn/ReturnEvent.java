package com.sparta.clonekurly.controllerReturn;

import com.sparta.clonekurly.model.Event;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnEvent {
    private Boolean ok;
    private List<Event> results;
}
