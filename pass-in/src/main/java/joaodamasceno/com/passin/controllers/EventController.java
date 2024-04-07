package joaodamasceno.com.passin.controllers;

import joaodamasceno.com.passin.domain.attendee.Attendee;
import joaodamasceno.com.passin.dto.attendee.AttendeeIdDTO;
import joaodamasceno.com.passin.dto.attendee.AttendeeRequestDTO;
import joaodamasceno.com.passin.dto.attendee.AttendeesListResponseDTO;
import joaodamasceno.com.passin.dto.event.EventIdDTO;
import joaodamasceno.com.passin.dto.event.EventRequestDTO;
import joaodamasceno.com.passin.dto.event.EventResponseDTO;
import joaodamasceno.com.passin.sevices.AttendeeService;
import joaodamasceno.com.passin.sevices.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final AttendeeService attendeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getEvent(@PathVariable String id){
       EventResponseDTO event =  this.eventService.getEventDetail(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    public ResponseEntity<EventIdDTO> createEvent(@RequestBody EventRequestDTO eventRequestDTO, UriComponentsBuilder uriComponentsBuilder){
        EventIdDTO eventIdDTO = this.eventService.createEvent(eventRequestDTO);

        var uri = uriComponentsBuilder.path("events/{id}").buildAndExpand(eventIdDTO.eventId()).toUri();
        return ResponseEntity.created(uri).body(eventIdDTO);
    }

    @PostMapping("/{eventId}/attendees")
    public ResponseEntity<AttendeeIdDTO> registerParticipant(@PathVariable String eventId, @RequestBody AttendeeRequestDTO body, UriComponentsBuilder uriComponentsBuilder){
        AttendeeIdDTO  attendeeIdDTO = this.eventService.registerAttendeeOnEvent(eventId, body);

        var uri = uriComponentsBuilder.path("/attendees/{attendId}/badge").buildAndExpand(attendeeIdDTO.attendeeId()).toUri();

        return ResponseEntity.created(uri).body(attendeeIdDTO);
    }

    @GetMapping("/attendees/{id}")
    public ResponseEntity<AttendeesListResponseDTO> getEventAttendees(@PathVariable String id){
        AttendeesListResponseDTO attendeesListResponseDTO =  this.attendeeService.getEventsAttendee(id);
        return ResponseEntity.ok(attendeesListResponseDTO);
    }
}
