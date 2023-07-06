package dev.danvega.sessionz.session;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class SessionController {

    private final SessionRepository sessionRepository;

    public SessionController(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @QueryMapping
    List<Session> sessions() {
        return sessionRepository.findAll();
    }

    @QueryMapping
    Optional<Session> session(@Argument Integer id) {
        return sessionRepository.findById(id);
    }

}
