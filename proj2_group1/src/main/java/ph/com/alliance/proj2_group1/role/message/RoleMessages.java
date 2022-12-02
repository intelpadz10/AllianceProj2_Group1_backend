package ph.com.alliance.proj2_group1.role.message;

import ph.com.alliance.proj2_group1.common.Messages;

public interface RoleMessages extends Messages{
	String ROLE_SUCCESSFULLY_SAVED = "Role was successfully created";
	String ROLE_SUCCESSFULLY_LOADED = "Role was successfully loaded!";
	String ROLE_FAILED_LOADED = "Role failed to load";
	String ROLE_VALUE_INVALID ="Role Value Loaded was invalid";
	String ROLE_VALUES_EMPTY = "Error on Role values. Check DB is connected or loaded";
	String ROLE_SUCCESSFULLY_UPDATED = "Role was successfully updated!";
	String ROLE_FAILED_UPDATED = "Role failed to Update";
	String ROLE_ID_MISMATCH= "Role ID does not exist";

}
