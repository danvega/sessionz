package dev.danvega.sessionz.event;

import dev.danvega.sessionz.session.Session;
import dev.danvega.sessionz.session.SessionRepository;
import org.springframework.data.domain.ScrollPosition;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Window;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.data.query.ScrollSubrange;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class EventController {

    private final EventRepository eventRepository;
    private final SessionRepository sessionRepository;

    public EventController(EventRepository eventRepository, SessionRepository sessionRepository) {
        this.eventRepository = eventRepository;
        this.sessionRepository = sessionRepository;
    }

    @QueryMapping
    List<Event> events() {
        return eventRepository.findAll();
    }

    @QueryMapping
    Optional<Event> event(@Argument Integer id) {
        return eventRepository.findById(id);
    }

    @SchemaMapping
    Window<Session> sessions(Event event, ScrollSubrange subrange) {
        return sessionRepository.findByEventId(event.getId(), subrange.position().orElse(ScrollPosition.offset()), Sort.by("title").ascending());
    }

}
