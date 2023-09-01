package shakul.jpa_relationship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shakul.jpa_relationship.entity.EmployeeInfo;
import shakul.jpa_relationship.service.EmployeeService;

@RestController
@RequestMapping("api/Empolyee/v1")
public class EmployeeController {
		
		@Autowired
		private EmployeeService employeeService;

	    @GetMapping("/employees")
	    public List<EmployeeInfo> getAllEmployees() {
	        return employeeService.getAllEmployees();
	    }
	    
	    @PostMapping("/addEmployee")
	    public EmployeeInfo addEmployees(@RequestBody EmployeeInfo addemp)
	    {
			return employeeService.addEmployee(addemp);
	    	
	    }
	    
	    @GetMapping("/getEmployeeById/{domain_fid}")
	    public List<EmployeeInfo> getEmployeesByDomain(@PathVariable int domain_fid) {
	        return employeeService.getEmployeesByDomain(domain_fid);
	    }
	    
	    @PutMapping("/updateEmployee/modifyDomain/{id}")
	    public EmployeeInfo updateEmployee(@RequestBody EmployeeInfo userInput,@PathVariable int id)
	    {
			return employeeService.updEmployee(userInput,id);
	    	
	    }
	   
	    
		@DeleteMapping("/deleteEmployee/{emp_id}")
		public String deleteDomain(@PathVariable Integer emp_id) {
			return employeeService.delEmp(emp_id);
			
		}
}
