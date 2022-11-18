package ph.com.alliance.proj2_group1.ticket.message;

import  ph.com.alliance.proj2_group1.common.Messages;

public interface TicketMessages extends Messages{
	String TICKET_SUCCESSFULLY_SAVED = "Ticket was successfully saved!"; 
	String TICKET_SUCCESSFULLY_RETRIEVED = "Ticket was sucessfully retrieved!";
	String TICKET_SUCCESSFULLY_UPDATED = "Ticket was succesfully updated!";
	
	String TICKET_FAILED_UPDATE = "Ticket Failed to update.";
	String TICKET_FAILED_SAVE = "Ticket Failed to save.";
	String TICKET_FAILED_RETRIEVED = "Ticket was sucessfully retrieved!";
	
	String TICKET_ID_MISMATCH = "ID selected and in Json Body is not match";

}
