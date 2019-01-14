package Connect.with.DB.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cars")
public class Car {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "Mark")
	private String Mark;

	@Column(name = "Model")
	private String Model;

	@Column(name = "Colour")
	private String Colour;

	@Column(name = "Engine")
	private String Engine;

	@Column(name = "Year")
	private int Year;

	@Column(name = "Price")
	private double Price;

	@ManyToOne
	@JoinColumn(name = "AutoDealerId")
	private AutoDealer autodealer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMark() {
		return Mark;
	}

	public void setMark(String mark) {
		Mark = mark;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public String getColour() {
		return Colour;
	}

	public void setColour(String colour) {
		Colour = colour;
	}

	public String getEngine() {
		return Engine;
	}

	public void setEngine(String engine) {
		Engine = engine;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public AutoDealer getAutodealer() {
		return autodealer;
	}

	public void setAutodealer(AutoDealer autodealer) {
		this.autodealer = autodealer;
	}

}
