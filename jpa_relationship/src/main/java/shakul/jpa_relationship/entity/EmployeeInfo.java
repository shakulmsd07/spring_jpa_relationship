package shakul.jpa_relationship.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="EmployeeInfo")
public class EmployeeInfo {
	
		
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private int id;
			private int emp_id_no;
			private String name;
			private int contact;
			
			@ManyToOne
			@JoinColumn(name="domain_fid")
			@JsonIgnoreProperties("employees")
			private EmployeeDomain domain;

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public int getEmp_id_no() {
				return emp_id_no;
			}

			public void setEmp_id_no(int emp_id_no) {
				this.emp_id_no = emp_id_no;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public int getContact() {
				return contact;
			}

			public void setContact(int contact) {
				this.contact = contact;
			}

			public EmployeeDomain getDomain() {
				return domain;
			}

			public void setDomain(EmployeeDomain domain) {
				this.domain = domain;
			}
			
}
