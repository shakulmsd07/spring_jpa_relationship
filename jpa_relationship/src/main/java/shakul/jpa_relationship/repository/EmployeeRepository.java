package shakul.jpa_relationship.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import shakul.jpa_relationship.entity.EmployeeInfo;

public interface EmployeeRepository extends JpaRepository<EmployeeInfo,Integer> {

	List<EmployeeInfo> findByDomainId(int domain_fid);
}
