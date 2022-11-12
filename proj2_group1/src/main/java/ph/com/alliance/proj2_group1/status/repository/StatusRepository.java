package ph.com.alliance.proj2_group1.status.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ph.com.alliance.proj2_group1.status.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

}
