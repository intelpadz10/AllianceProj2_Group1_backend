package ph.com.alliance.proj2_group1.role.service;

import java.util.List;

import ph.com.alliance.proj2_group1.role.entity.Role;


public interface IRoleService {
	public List<Role> getAllRoles();
	public Role getRolebyID(Integer id);
	public Role updateRole ( Role role);
	
}
