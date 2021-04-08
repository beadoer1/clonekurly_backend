package com.sparta.clonekurly.repository;

import com.sparta.clonekurly.model.Event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllBySubtitleNull();
    List<Event> findAllBySubtitleNotNull();
}
