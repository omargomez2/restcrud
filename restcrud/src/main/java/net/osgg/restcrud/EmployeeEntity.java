package net.osgg.restcrud;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Column;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.Basic;
import java.sql.Time;
import java.sql.Date;

import javax.persistence.Lob;
import java.util.Base64;

 
@Entity
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(updatable = false, nullable = false)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID id;
    
	
	private String firstName;
    private String lastName;
    private String email;
    
    @Type(type = "uuid-char")
    private UUID fk;
    
    @Basic
    @CreationTimestamp
    private Date date;
    
    @Basic
    @CreationTimestamp
    private Time time;  

    
	@Lob
    private byte[] file;
    
	public Date getDate() {
		return date;
	}

	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}	
	
    public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public byte[] getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = Base64.getDecoder().decode(file);
	}

	public void setFk(UUID fk) {
		this.fk = fk;
	}

	public UUID getFk() {
		return fk;
	}	
	

	@Override
    public String toString() {
        return "EmployeeEntity [id=" + id + ", firstName=" + firstName + 
                ", lastName=" + lastName + ", email=" + email + "]";
    }
}
