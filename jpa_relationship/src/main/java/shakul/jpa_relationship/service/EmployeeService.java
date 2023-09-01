package shakul.jpa_relationship.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shakul.jpa_relationship.entity.EmployeeDomain;
import shakul.jpa_relationship.entity.EmployeeInfo;
import shakul.jpa_relationship.repository.DomainRepository;
import shakul.jpa_relationship.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository emprepos;
	
	@Autowired
	private DomainRepository domainrepository;
	
	public List<EmployeeInfo> getAllEmployees() {
		// TODO Auto-generated method stub
		
		return emprepos.findAll();
		
		
	}
	public EmployeeInfo addEmployee(EmployeeInfo addemp) {
		// TODO Auto-generated method stub
		
		EmployeeDomain domain=domainrepository.findById(addemp.getDomain().getId()).orElse(null);
				
		if(domain!=null)
		{
			// Exception handling
		}
		EmployeeInfo empnew=new EmployeeInfo();
		empnew.setId(addemp.getId());
		empnew.setEmp_id_no(addemp.getEmp_id_no());
		empnew.setName(addemp.getName());
		empnew.setContact(addemp.getContact());
		empnew.setDomain(domain);
		
		emprepos.save(empnew);
		return empnew;
		
		
	}
	public List<EmployeeInfo> getEmployeesByDomain(int domain_fid) {
		// TODO Auto-generated method stub
		return emprepos.findByDomainId(domain_fid);
	}
	public String delEmp(Integer emp_id) {
		// TODO Auto-generated method stub
		EmployeeInfo value_exist=emprepos.findById(emp_id).orElse(null);
		if(value_exist != null)
		{
			emprepos.deleteById(emp_id);
			 return "Delete Successfully";
		}
		else 
		{
			return "Given Id is not existed";
		}
	}
	public EmployeeInfo updEmployee(EmployeeInfo userInput,int id) {
		// TODO Auto-generated method stub
		EmployeeInfo findEmp=emprepos.findById(id).orElse(null);
		if(findEmp!=null) 
		{
		EmployeeDomain updateEmpl_dom=domainrepository.findById(userInput.getDomain().getId()).orElse(null);
		
		if(updateEmpl_dom!=null)
		{
//		EmployeeInfo updateEmpl=new EmployeeInfo();
		findEmp.setId(userInput.getId());
		findEmp.setEmp_id_no(userInput.getEmp_id_no());
		findEmp.setName(userInput.getName());
		findEmp.setContact(userInput.getContact());
		findEmp.setDomain(updateEmpl_dom);
		emprepos.save(findEmp);
		return findEmp;
		}
		else
			return null;
		}
		else
			return null;
	}
    
	
	//get update reference  solution from chatgpt
	
//	public EmployeeInfo updEmployee(EmployeeInfo userInput, int id) {
//	    // Find the existing employee by ID
//	    EmployeeInfo findEmp = emprepos.findById(id).orElse(null);
//
//	    if (findEmp != null) {
//	        // Load the new domain entity from the database based on userInput's domain ID
//	        EmployeeDomain newDomain = domainrepository.findById(userInput.getDomain().getId()).orElse(null);
//
//	        if (newDomain != null) {
//	            // Update the employee's attributes
//	            findEmp.setEmp_id_no(userInput.getEmp_id_no());
//	            findEmp.setName(userInput.getName());
//	            findEmp.setContact(userInput.getContact());
//	            
//	            // Set the new domain
//	            findEmp.setDomain(newDomain);
//	            
//	            // Save the updated employee
//	            emprepos.save(findEmp);
//	            
//	            return findEmp;
//	        } else {
//	            // Handle the case where the new domain ID doesn't exist
//	            // You can throw an exception or return an error message as needed.
//	            return null; // For example, return null to indicate failure.
//	        }
//	    } else {
//	        // Handle the case where the employee with the given ID doesn't exist
//	        // You can throw an exception or return an error message as needed.
//	        return null; // For example, return null to indicate failure.
//	    }
//	}


}
