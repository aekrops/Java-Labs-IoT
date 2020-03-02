package ua.lviv.iot.lawFirm.model;

import java.util.List;

import ua.lviv.iot.lawFirm.manager.LawFirmManager;

public class Lawyer extends AbstractServices {

	private static int numbersOfLawyers;
	private int id;

	private String name;

	private double pricePerHourInUAH;

	protected List<Services> services;

	private int age;

	LawFirmManager manager = new LawFirmManager();

	public Lawyer(String name, double pricePerHourInUAH, int age, Boolean CollectingEvidence, Boolean Advice) {

		this.name = name;
		this.pricePerHourInUAH = pricePerHourInUAH;
		this.age = age;
		numbersOfLawyers++;
		id = numbersOfLawyers;

		if (CollectingEvidence == true) {
			services.add(Services.COLLECTINGEVIDENCE);
		} else {
		}
		if (Advice == true) {
			services.add(Services.ADVICE);
		} else {
		}
		manager.addLawyers(this);
	}

	public Lawyer(String name, double pricePerHourInUAH) {
		this(name, pricePerHourInUAH, 0, false, false);
	}

	public Lawyer(String name) {
		this(name, 0.0, 0, false, false);
	}

	public Lawyer() {
		this(null, 0.0, 0, false, false);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPricePerHourInUAH() {
		return pricePerHourInUAH;
	}

	public void setPricePerHourInUAH(double pricePerHourInUAH) {
		this.pricePerHourInUAH = pricePerHourInUAH;
	}

	public List<Services> getServices() {
		return services;
	}

	public void setServices(List<Services> services) {
		this.services = services;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
