package sbrest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "forms")
public class Form {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    private Integer id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(
			  name = "form_fields", 
			  joinColumns = @JoinColumn(name = "form_id"), 
			  inverseJoinColumns = @JoinColumn(name = "field_id"))
    private List<Field> fields = new ArrayList<>();
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	
}
