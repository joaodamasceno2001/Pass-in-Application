package joaodamasceno.com.passin.sevices;

import joaodamasceno.com.passin.domain.attendee.Attendee;
import joaodamasceno.com.passin.domain.checkin.Checkin;
import joaodamasceno.com.passin.domain.checkin.exceptions.CheckInAlreadyExistsException;
import joaodamasceno.com.passin.repositories.CheckinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckInService {

    private final CheckinRepository checkinRepository;

    public void registerCheckIn(Attendee attendee){
        this.verifyCheckInExists(attendee.getId());
        Checkin newCheckIn = new Checkin();
        newCheckIn.setAttendee(attendee);
        newCheckIn.setCreatedAt(LocalDateTime.now());
        this.checkinRepository.save(newCheckIn);
    }

    private void verifyCheckInExists(String attendeeId){
        Optional<Checkin> isCheckedIn = this.getCheckIn(attendeeId);
        if(isCheckedIn.isPresent()) throw new CheckInAlreadyExistsException("Attendee already checked in");
    }

    public Optional<Checkin> getCheckIn(String attendeeId){
        return this.checkinRepository.findByAttendeeId(attendeeId);

    }
}
