package ph.com.alliance.proj2_group1.ticket_category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ph.com.alliance.proj2_group1.common.models.ApiResponse;
import ph.com.alliance.proj2_group1.ticket_category.entity.TicketCategory;
import ph.com.alliance.proj2_group1.ticket_category.message.TicketCategoryMessages;
import ph.com.alliance.proj2_group1.ticket_category.service.TicketCategoryService;

@RestController
public class TicketCategoryController {

	@Autowired
	private TicketCategoryService ticketCategoryService;

	@GetMapping("/ticket/all")
	@ResponseBody
	public ApiResponse getAll() {

		List<TicketCategory> categories = ticketCategoryService.getAllCategories();

		if (categories != null) {
			return ApiResponse.CreateSuccess(categories, TicketCategoryMessages.TICKET_CATEGORY_SUCCESSFULLY_LOADED);
		}

		return ApiResponse.CreateError(TicketCategoryMessages.GENERIC_UNSUCCESSFUL_SAVE);
	}

}
