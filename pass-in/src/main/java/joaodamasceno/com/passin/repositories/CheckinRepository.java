package joaodamasceno.com.passin.repositories;

import joaodamasceno.com.passin.domain.checkin.Checkin;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CheckinRepository extends JpaRepository<Checkin, Integer> {

    Optional<Checkin> findByAttendeeId(String attendeeId);
}
