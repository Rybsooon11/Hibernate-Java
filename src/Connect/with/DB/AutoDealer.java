package Connect.with.DB;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "AutoDealers")
@Table(name = "AutoDealers")
public class AutoDealer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;

	@Column(name = "Name")
	private String Name;

	@Column(name = "Street")
	private String Street;

	@Column(name = "ZipCode")
	private String ZipCode;

	@Column(name = "Localization")
	private String Localization;

	@Column(name = "PhoneNumber")
	private String PhoneNumber;
	
	@OneToMany(mappedBy = "autodealer")
	private List<Car> cars;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
}
