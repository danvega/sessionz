package dev.danvega.sessionz.speaker;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SpeakerController {

    private final SpeakerRepository speakerRepository;

    public SpeakerController(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    @QueryMapping
    List<Speaker> speakers() {
        return speakerRepository.findAll();
    }

    @QueryMapping
    Speaker speaker(@Argument Integer id) {
        return speakerRepository.findById(id).orElseThrow();
    }

}
