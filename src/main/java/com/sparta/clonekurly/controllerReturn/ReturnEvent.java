package com.sparta.clonekurly.controllerReturn;

import com.sparta.clonekurly.model.Event;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ReturnEvent {
    private Boolean ok;
    private List<Event> results = new ArrayList<>();
}
