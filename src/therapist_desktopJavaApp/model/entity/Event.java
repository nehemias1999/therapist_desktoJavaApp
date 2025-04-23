package therapist_desktopJavaApp.model.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Event {
    private UUID eventId;
    private String eventTitle;
    private String eventDescription;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private LocalDateTime createdAt;
	
    public Event(
    		UUID eventId, 
    		String eventTitle, 
    		String eventDescription, 
    		LocalDateTime startDateTime, 
    		LocalDateTime endDateTime, 
    		LocalDateTime createdAt) {
		this.eventId = eventId;
		this.eventTitle = eventTitle;
		this.eventDescription = eventDescription;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.createdAt = createdAt;
	}
	
	public UUID getEventId() {
		return eventId;
	}
	
	public void setEventId(UUID eventId) {
		this.eventId = eventId;
	}
	
	public String getEventTitle() {
		return eventTitle;
	}
	
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	
	public String getEventDescription() {
		return eventDescription;
	}
	
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	
	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}
	
	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}
	
	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}
	
	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
    
}
