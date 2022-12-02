package ph.com.alliance.proj2_group1.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ph.com.alliance.proj2_group1.role.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
