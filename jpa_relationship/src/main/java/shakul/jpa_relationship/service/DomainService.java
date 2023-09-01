package shakul.jpa_relationship.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shakul.jpa_relationship.entity.EmployeeDomain;
import shakul.jpa_relationship.repository.DomainRepository;

@Service
public class DomainService {

	@Autowired
	private DomainRepository domainRepository;
	
	
	public List<EmployeeDomain> getDomain() {
		// TODO Auto-generated method stub
		return domainRepository.findAll() ;
	}

	public EmployeeDomain addDomain(EmployeeDomain empDomain) {
		// TODO Auto-generated method stub
		EmployeeDomain newempdom=new EmployeeDomain();
		newempdom.setId(empDomain.getId());
		newempdom.setDomain_name(empDomain.getDomain_name());
		newempdom.setEmployees(empDomain.getEmployees());
		domainRepository.save(newempdom);
		return newempdom;
	}

	public String delDomain(Integer domain_id) {
		// TODO Auto-generated method stub
		EmployeeDomain value_exist=domainRepository.findById(domain_id).orElse(null);
		if(value_exist != null)
		{
		     domainRepository.deleteById(domain_id);
			 return "Delete Successfully";
		}
		else 
		{
			return "Given Id is not existed";
		}
	}

}
