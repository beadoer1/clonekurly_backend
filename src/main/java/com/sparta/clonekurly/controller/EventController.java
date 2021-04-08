package com.sparta.clonekurly.controller;

import com.sparta.clonekurly.controllerReturn.ReturnEvent;
import com.sparta.clonekurly.model.Event;
import com.sparta.clonekurly.repository.EventRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventRepository eventRepository;

    @GetMapping("/api/events")
    public ReturnEvent getEvent(){
        ReturnEvent returnEvent = new ReturnEvent();
        List<Event> eventList = eventRepository.findAllBySubtitleNotNull();
        returnEvent.setOk(true);
        returnEvent.setResults(eventList);
        return returnEvent;
    }

}
