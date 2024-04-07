package joaodamasceno.com.passin.repositories;

import joaodamasceno.com.passin.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {
}
