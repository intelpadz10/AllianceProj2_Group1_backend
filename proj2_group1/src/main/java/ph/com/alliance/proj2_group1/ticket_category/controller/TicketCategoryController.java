package ph.com.alliance.proj2_group1.ticket_category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ph.com.alliance.proj2_group1.common.models.ApiResponse;
import ph.com.alliance.proj2_group1.ticket_category.entity.Ticket_Category;
import ph.com.alliance.proj2_group1.ticket_category.message.TicketCategoryMessages;
import ph.com.alliance.proj2_group1.ticket_category.service.TicketCategoryService;

@RestController
@CrossOrigin
public class TicketCategoryController {

	@Autowired
	private TicketCategoryService ticketCategoryService;

	@GetMapping("/category/all")
	@ResponseBody
	public ApiResponse showTicketCategories() {

		List<Ticket_Category> categories = ticketCategoryService.getAllCategories();

		if (categories != null) {
			return ApiResponse.CreateSuccess(categories, TicketCategoryMessages.TICKET_CATEGORY_SUCCESSFULLY_LOADED);
		}

		return ApiResponse.CreateError(TicketCategoryMessages.GENERIC_UNSUCCESSFUL_SAVE);
	}
	
	@GetMapping("/category/{id}")
	@ResponseBody
	public ApiResponse showTicketCategory(@PathVariable final int id) {

		Ticket_Category category = ticketCategoryService.getCategorybyID(id);

		if (category != null) {
			return ApiResponse.CreateSuccess(category, TicketCategoryMessages.TICKET_CATEGORY_SUCCESSFULLY_LOADED);
		}

		return ApiResponse.CreateError(TicketCategoryMessages.GENERIC_UNSUCCESSFUL_SAVE);
	}

}
