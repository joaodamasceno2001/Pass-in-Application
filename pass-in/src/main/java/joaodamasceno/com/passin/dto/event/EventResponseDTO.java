package joaodamasceno.com.passin.dto.event;

import joaodamasceno.com.passin.domain.event.Event;
import lombok.Data;

@Data
public class EventResponseDTO {
    EventDetailDTO  event;

    public EventResponseDTO(Event event, Integer numberOfAttendees){
        this.event = new EventDetailDTO(
                event.getId(),
                event.getTittle(),
                event.getDetails(),
                event.getSlug(),
                event.getMaximumAttendees(),
                numberOfAttendees
        );
    }
}
