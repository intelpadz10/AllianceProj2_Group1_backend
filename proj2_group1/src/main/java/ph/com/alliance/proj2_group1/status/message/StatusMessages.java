package ph.com.alliance.proj2_group1.status.message;

import ph.com.alliance.proj2_group1.common.Messages;

public interface StatusMessages extends Messages {
	
	String STATUS_SUCCESSFULLY_LOADED = "Status was successfully loaded!";
	String STATUS_VALUE_INVALID ="Status Value Loaded was invalid";
	String STATUS_VALUES_EMPTY = "Error on Status values. Check DB is connected or loaded";
	
}
