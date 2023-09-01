package shakul.jpa_relationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shakul.jpa_relationship.entity.EmployeeDomain;

public interface DomainRepository extends JpaRepository<EmployeeDomain, Integer>{

	
}
