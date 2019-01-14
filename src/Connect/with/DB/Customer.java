package Connect.with.DB;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Customers")
@Table(name = "Customers")
public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
        
	@Column(name = "FirstName")
	private String FirstName;
	
	@Column(name = "LastName")
	private String LastName;

	@Column(name = "Street")
	private String Street;

	@Column(name = "ZipCode")
	private String ZipCode;
        
        @Column(name = "Localization")
	private String Localization;
	
	@Column(name = "PhoneNumber")
	private String PhoneNumber;

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getZipCode() {
		return ZipCode;
	}

	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}

	public String getLocalization() {
		return Localization;
	}

	public void setLocalization(String localization) {
		Localization = localization;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
}
