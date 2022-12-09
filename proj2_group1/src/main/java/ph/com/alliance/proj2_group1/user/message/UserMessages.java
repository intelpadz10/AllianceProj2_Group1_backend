package ph.com.alliance.proj2_group1.user.message;

import ph.com.alliance.proj2_group1.common.Messages;

public interface UserMessages extends Messages {
	
	String USER_SUCCESSFULLY_SAVED = "User was successfully saved!"; 
	String USER_SUCCESSFULLY_RETRIEVED = "User retrieval is successful";
	String USER_DOESNOT_EXIST = "User does not exist";
	
	String UPDATEPASS_SUCCESS = "Password has been changed";
	String UPDATEPASS_FAIL = "Try again";
	
	String USER_SUCCESSFULLY_DELETED = "Successfully deleted";
	String USER_DELET_FAILED = "user not deleted";
		
}
