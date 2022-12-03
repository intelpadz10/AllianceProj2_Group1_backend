package ph.com.alliance.proj2_group1.fileUplaod.message;

import ph.com.alliance.proj2_group1.common.Messages;

public interface  FileUploadMessages extends Messages {
	String FILE_SUCCESSFULLY_SAVED = "File was successfully created";
	String FILE_SUCCESSFULLY_LOADED = "File was successfully loaded!";
	String FILE_FAILED_LOADED = "File failed to load";
	String FILE_VALUE_INVALID ="File Value Loaded was invalid";
	String FILE_VALUES_EMPTY = "Error on File values. Check DB is connected or loaded";
	String FILE_SUCCESSFULLY_UPDATED = "File was successfully updated!";
	String FILE_FAILED_UPDATED = "File failed to Update";
	String FILE_ID_MISMATCH= "File ID does not exist";
}
