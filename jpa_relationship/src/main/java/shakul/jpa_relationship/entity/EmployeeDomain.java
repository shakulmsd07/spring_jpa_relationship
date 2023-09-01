package shakul.jpa_relationship.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="EmployeeeDomain")
public class EmployeeDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int id;
	private String domain_name;
	
	@OneToMany(mappedBy = "domain",cascade = CascadeType.ALL)
	@JsonBackReference  
	private List<EmployeeInfo> employees;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDomain_name() {
		return domain_name;
	}

	public void setDomain_name(String domain_name) {
		this.domain_name = domain_name;
	}

	public List<EmployeeInfo> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeInfo> employees) {
		this.employees = employees;
	}
	

}
