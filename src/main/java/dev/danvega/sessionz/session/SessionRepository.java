package dev.danvega.sessionz.session;

import org.springframework.data.domain.ScrollPosition;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Window;
import org.springframework.data.repository.ListCrudRepository;

public interface SessionRepository extends ListCrudRepository<Session,Integer> {

    Window<Session> findByEventId(Integer eventId, ScrollPosition position, Sort sort);

}
