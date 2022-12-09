package ph.com.alliance.proj2_group1.role.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ph.com.alliance.proj2_group1.common.models.ApiResponse;
import ph.com.alliance.proj2_group1.role.entity.Role;
import ph.com.alliance.proj2_group1.role.message.RoleMessages;
import ph.com.alliance.proj2_group1.role.service.RoleService;
import ph.com.alliance.proj2_group1.ticket.entity.Ticket;
import ph.com.alliance.proj2_group1.ticket.message.TicketMessages;

@RestController
public class RolesController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/role/create")
	@ResponseBody
	public ApiResponse saveRole(Role role) {

		Role savedRole = roleService.createRole(role);

		if (savedRole != null) {
			return ApiResponse.CreateSuccess(savedRole, RoleMessages.ROLE_SUCCESSFULLY_SAVED);
		}

		return ApiResponse.CreateError(RoleMessages.GENERIC_UNSUCCESSFUL_SAVE);
	}
	
	@GetMapping("/role/all")
	@ResponseBody
	public ApiResponse showRoles() {

		List<Role> rolestickets = roleService.getAllRoles();

		if (rolestickets != null) {
			return ApiResponse.CreateSuccess(rolestickets, RoleMessages.ROLE_SUCCESSFULLY_LOADED);
		}

		return ApiResponse.CreateError(
				RoleMessages.GENERIC_UNSUCCESSFUL_SAVE + "CAUSE:" + RoleMessages.ROLE_FAILED_LOADED);

	}
	
	@GetMapping("/role/{id}")
	@ResponseBody
	public ApiResponse showRole(@PathVariable final int id) {
		
			Role savedRole = roleService.getRolebyID(id);
			if (savedRole != null) {
				return ApiResponse.CreateSuccess(savedRole, RoleMessages.ROLE_SUCCESSFULLY_LOADED);
			} else {
				return ApiResponse.CreateError(
						RoleMessages.GENERIC_UNSUCCESSFUL_SAVE + "CAUSE:" + RoleMessages.ROLE_ID_MISMATCH);
			}
			
	}
	
	@DeleteMapping (path = "/role/{id}")
	@ResponseBody
	public ApiResponse deleteRole (@PathVariable Integer  id, Role role) {
		String status;
		try {
			if (id == role.getId()) {
			 status = roleService.deleteRole(role);
			} else  status = "Role Mismatch";
			if (status == "Success Delete") 
				return ApiResponse.CreateSuccess("Role "+role.getId()+" has been successfully deleted!");
			else 
				return ApiResponse.CreateError(status);
		}catch (Exception e) {
			return ApiResponse.CreateError("Error in e: "+ e);
		}
	}
	
	@PostMapping(path = "/role/{id}/update")
	@ResponseBody
	public ApiResponse updateRole(@PathVariable Integer  id, Role  	newRole) {


		try {
			Role savedRole = roleService.updateRole(id,newRole);
			if (savedRole != null)
				return ApiResponse.CreateSuccess(savedRole, RoleMessages.ROLE_SUCCESSFULLY_UPDATED);
			else
				return ApiResponse.CreateError(RoleMessages.ROLE_FAILED_UPDATED);
		} catch (Exception e) {
			return ApiResponse.CreateError(RoleMessages.ROLE_FAILED_UPDATED + e.getMessage());
		}

	}
	
	
}
