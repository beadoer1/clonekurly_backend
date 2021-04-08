package com.sparta.clonekurly.repository;

import com.sparta.clonekurly.model.Event;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
    List<Event> findAllBySubtitleNotNull();
}
