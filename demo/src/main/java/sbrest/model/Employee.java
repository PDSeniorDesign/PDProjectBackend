package sbrest.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    private Integer employeeNum;
    
    private String fName;

    private String lName;
    
    private Character mi;
    
    private Integer hostedId;
    
    private String registrationType;
    
    private Integer deptNum;
    
    
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
	public int getEmployeeNum() {
		return employeeNum;
	}

	public void setEmployeeNum(int employeeNum) {
		this.employeeNum = employeeNum;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Character getMi() {
		return mi;
	}

	public void setMi(Character mi) {
		this.mi = mi;
	}

	public Integer getHostedId() {
		return hostedId;
	}

	public void setHostedId(Integer hostedId) {
		this.hostedId = hostedId;
	}

	public String getRegistrationType() {
		return registrationType;
	}

	public void setRegistrationType(String registrationType) {
		this.registrationType = registrationType;
	}

	public Integer getDeptNum() {
		return deptNum;
	}

	public void setDeptNum(Integer deptNum) {
		this.deptNum = deptNum;
	}

    

}