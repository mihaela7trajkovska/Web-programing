package mk.finki.ukim.mk.labb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventBooking {
    private String eventName;
    private String attendeeName;
    private String attendeeAddress;
    private Long numberOfTickets;

    public EventBooking(String eventName, String attendeeName, String attendeeAddress, Long numberOfTickets) {
        this.eventName = eventName;
        this.attendeeName = attendeeName;
        this.attendeeAddress = attendeeAddress;
        this.numberOfTickets = numberOfTickets;
    }

    public String getEventName() {
        return eventName;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public String getAttendeeAddress() {
        return attendeeAddress;
    }

    public Long getNumberOfTickets() {
        return numberOfTickets;
    }
}
