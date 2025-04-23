package therapist_desktopJavaApp.model.dto.in;

public class EventDTOIN {
    private String eventId;
    private String eventTitle;
    private String eventDescription;
    private String startDateTime;
    private String endDateTime;
    private String createdAt;
	
    public EventDTOIN(
    		String eventId, 
    		String eventTitle, 
    		String eventDescription, 
    		String startDateTime,
			String endDateTime, 
			String createdAt) {
		this.eventId = eventId;
		this.eventTitle = eventTitle;
		this.eventDescription = eventDescription;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.createdAt = createdAt;
	}
	
	public String getEventId() {
		return eventId;
	}
	
	public void setEventId(String eventId) {
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
	
	public String getStartDateTime() {
		return startDateTime;
	}
	
	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}
	
	public String getEndDateTime() {
		return endDateTime;
	}
	
	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
    
}
