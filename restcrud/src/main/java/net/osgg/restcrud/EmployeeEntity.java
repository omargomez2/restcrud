package net.osgg.restcrud;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


 
@Entity
public class EmployeeEntity {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name="id", updatable = false, nullable = false)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    
    @Type(type = "uuid-char")
    private UUID fk;
    
    @CreationTimestamp
    private LocalDateTime dateTimeStamp;

	@Lob
    private byte[] file;
    
    
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
	

	public LocalDateTime getDateTimeStamp() {
		return dateTimeStamp;
	}

	public void setDateTimeStamp(LocalDateTime dateTimeStamp) {
		this.dateTimeStamp = dateTimeStamp;
	}

	
	@Override
    public String toString() {
        return "EmployeeEntity [id=" + id + ", firstName=" + firstName + 
                ", lastName=" + lastName + ", email=" + email   + "]";
    }
}
