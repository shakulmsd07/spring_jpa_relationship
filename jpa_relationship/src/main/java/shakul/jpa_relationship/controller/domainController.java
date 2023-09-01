package shakul.jpa_relationship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shakul.jpa_relationship.entity.EmployeeDomain;
import shakul.jpa_relationship.service.DomainService;

@RestController
@RequestMapping("api/Domain/v1")
public class domainController {

	@Autowired
	private DomainService domainserv;
	
	@GetMapping("/getDomains")
	public List<EmployeeDomain> getAllDomain(){
		return domainserv.getDomain();
		
	}
	
	@PostMapping("/addDomain")
	public EmployeeDomain addDomain(@RequestBody EmployeeDomain empDomain) {
		return domainserv.addDomain(empDomain);
		
	}
	
	@DeleteMapping("deletDomain/{domain_id}")
	public String deleteDomain(@PathVariable Integer domain_id) {
		return domainserv.delDomain(domain_id);
		
	}
} 
