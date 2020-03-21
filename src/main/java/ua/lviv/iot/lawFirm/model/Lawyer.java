package ua.lviv.iot.lawFirm.model;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import ua.lviv.iot.lawFirm.manager.LawFirmManager;

public class Lawyer extends AbstractServices {

	private static AtomicInteger numbersOfLawyers = new AtomicInteger(0);
	
	private AtomicInteger id = new AtomicInteger(0);

	private String name;

	private double pricePerHourInUAH;

	protected List<Services> services = new LinkedList<>();

	private int age;
	private int numberOfServices = 3;
	private int lengthOfName;

	LawFirmManager manager = new LawFirmManager();

	public Lawyer(String name, double pricePerHourInUAH, int age, boolean CollectingEvidence, boolean Advice) {

		this.name = name;
		this.lengthOfName = name.length();
		this.pricePerHourInUAH = pricePerHourInUAH;
		this.age = age;
		numbersOfLawyers.incrementAndGet();
		id = numbersOfLawyers;

		if (CollectingEvidence == true) {
			services.add(Services.COLLECTINGEVIDENCE);
			super.setCollectingEvidence(true);
		} else {
			super.setCollectingEvidence(false);
		}
		if (Advice == true) {
			services.add(Services.ADVICE);
			super.setAdvice(true);
		} else {
			super.setAdvice(false);
		}

		if (Advice == true) {
			numberOfServices++;
		}
		if (CollectingEvidence == true) {
			numberOfServices++;
		}
		manager.addLawyers(this);
	}

	public int getLengthOfName() {
		return lengthOfName;
	}

	public void setLengthOfName(int lengthOfName) {
		this.lengthOfName = lengthOfName;
	}

	public Lawyer(String name, double pricePerHourInUAH) {
		this(name, pricePerHourInUAH, 0, false, false);
	}

	public Lawyer(String name) {
		this(name, 0.0, 0, false, false);
	}

	public Lawyer() {
	}

	public String getHeaders() {
		return "name" + "," + "price per hour in hryvna" + "," 
				+ "age" + "," + super.getHeaders();
	}

	public String toCSV() {
		return getName() + "," + getPricePerHourInUAH() + ","
				+ getAge() + "," + super.toCSV();
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

	public AtomicInteger getId() {
		return id;
	}

	public void setId(AtomicInteger id) {
		this.id = id;
	}

	public int getNumberOfServices() {
		return numberOfServices;
	}
}
