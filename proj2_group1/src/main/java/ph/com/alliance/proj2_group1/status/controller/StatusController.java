package ph.com.alliance.proj2_group1.status.controller;


import java.util.List;

//import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ph.com.alliance.proj2_group1.common.models.ApiResponse;
import ph.com.alliance.proj2_group1.status.entity.Status;
import ph.com.alliance.proj2_group1.status.message.StatusMessages;
import ph.com.alliance.proj2_group1.status.service.StatusService;

@RestController
public class StatusController {

	@Autowired
	private StatusService statusService;

	@GetMapping("/status/all")
	@ResponseBody
	public ApiResponse getAll() {

		List<Status> statuses = statusService.loadValues();

		if (statuses != null) {
			return ApiResponse.CreateSuccess(statuses, StatusMessages.STATUS_SUCCESSFULLY_LOADED);
		}

		return ApiResponse.CreateError(StatusMessages.STATUS_VALUES_EMPTY);

	}

	@GetMapping ("/status/{id}")
	@ResponseBody
	public ApiResponse getViaID(@PathVariable final Integer id) {

		Status loadedStatus = statusService.loadValue(id);

		if (loadedStatus != null) {
			return ApiResponse.CreateSuccess(loadedStatus, StatusMessages.STATUS_SUCCESSFULLY_LOADED);
		}

		return ApiResponse.CreateError(StatusMessages.STATUS_VALUE_INVALID);
	}

}
