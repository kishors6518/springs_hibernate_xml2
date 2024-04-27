package springs_hibernate_xml2.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Company {
	@Id
	private int id;
	private String name;
	private String location;
	@OneToMany(cascade = CascadeType.ALL)
	List<Employee> emp;

}
