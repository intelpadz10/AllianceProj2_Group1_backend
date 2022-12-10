package ph.com.alliance.proj2_group1.role.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ph.com.alliance.proj2_group1.role.entity.Role;
import ph.com.alliance.proj2_group1.role.repository.RoleRepository;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleRepository roleJpaRepository;
	
	
	public List<Role> getAllRoles() {
		return roleJpaRepository.findAll();
	}

	
	public Role getRolebyID(Integer id) {
		return roleJpaRepository .findById(id).get();
	}


	public Role updateRole(Integer id, Role role) {
		Role getRole =  roleJpaRepository .findById(id).get();
		return roleJpaRepository.saveAndFlush(getRole.update(role)) ;
	}

	public Role createRole (Role role) {
		return roleJpaRepository.saveAndFlush(role);
		
	}
	
	public String deleteRole(Role role) {
		try {
			roleJpaRepository.delete(role);
			return "Success Delete";
		} catch (Exception e) {
			System.out.print(e);
			return "System Error:" + e;
		}
	}
}
