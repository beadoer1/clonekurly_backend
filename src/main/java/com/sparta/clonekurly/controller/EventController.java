package com.sparta.clonekurly.controller;

import com.sparta.clonekurly.controllerReturn.ReturnEvent;
import com.sparta.clonekurly.controllerReturn.ReturnProduct;
import com.sparta.clonekurly.model.Event;
import com.sparta.clonekurly.model.Product;
import com.sparta.clonekurly.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventRepository eventRepository;

    @GetMapping("/api/commercials")
    public ReturnEvent getCommercials(){
        ReturnEvent returnEvent = new ReturnEvent();
        List<Event> eventList = eventRepository.findAllBySubtitleNull();
        returnEvent.setOk(true);
        returnEvent.setResults(eventList);
        return returnEvent;
    }
}
