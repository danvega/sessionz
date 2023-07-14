package dev.danvega.sessionz.data;

import dev.danvega.sessionz.event.Event;
import dev.danvega.sessionz.event.EventRepository;
import dev.danvega.sessionz.session.*;
import dev.danvega.sessionz.speaker.Gender;
import dev.danvega.sessionz.speaker.Speaker;
import dev.danvega.sessionz.speaker.SpeakerRepository;
import net.datafaker.Faker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final EventRepository eventRepository;
    private final SpeakerRepository speakerRepository;
    private final SessionRepository sessionRepository;
    private final TagRepository tagRepository;
    private final Faker faker;

    public DataLoader(EventRepository eventRepository, SpeakerRepository speakerRepository, SessionRepository sessionRepository, TagRepository tagRepository) {
        this.eventRepository = eventRepository;
        this.speakerRepository = speakerRepository;
        this.sessionRepository = sessionRepository;
        this.tagRepository = tagRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {

        if(tagRepository.count() == 0) {
            Tag springBootTag = new Tag("Spring Boot");
            Tag springFrameworkTag = new Tag("Spring Framework");
            tagRepository.saveAll(List.of(springBootTag,springFrameworkTag));
        }
        
        if(eventRepository.count() == 0) {

            var event = new Event(1,
                    "SpringOne at VMware Explore",
                    "Join us at the biggest gathering of Spring enthusiasts, beginners and practitioners who build the apps that make the world run. This year, we are excited to have the developer-focused SpringOne event unite with the incredible VMware Explore 2023 in Las Vegas. Learn how Spring can take you from code to production at speed with its support for modern application architectures that run seamlessly on any cloud.",
                    LocalDate.of(2023,8,21),
                    LocalDate.of(2023,8,24),
                    LocalDate.now().minusDays(180),
                    LocalDate.now().minusDays(90),
                    "Las Vegas, NV",
                    "https://springone.io/");

            eventRepository.save(event);

            List<Speaker> speakers = new ArrayList<>();
            for (int i = 1; i <= 20; i++) {
                speakers.add(new Speaker(i,
                        faker.name().fullName(),
                        faker.name().title(),
                        faker.company().name(),
                        Gender.values()[faker.number().numberBetween(0,Gender.values().length)],
                        faker.address().country(),
                        faker.internet().emailAddress(),
                        faker.phoneNumber().phoneNumber(),
                        faker.twitter().userName()));

            }
            speakerRepository.saveAll(speakers);

            List<Session> sessions = new ArrayList<>();
            for (int i = 1; i <= 100; i++) {
                sessions.add(new Session(i,
                        faker.book().title(),
                        faker.lorem().paragraph(),
                        Level.values()[faker.number().numberBetween(0, Level.values().length)],
                        Set.of(tagRepository.findAll().toArray(new Tag[0])),
                        event));
            }
            sessionRepository.saveAll(sessions);

        }

    }

    private Speaker randomSpeaker(List<Speaker> speakers) {
        return speakers.get(faker.number().numberBetween(0, speakers.size() - 1));
    }

}