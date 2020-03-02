package ua.lviv.iot.lawFirm.manager;

import org.junit.jupiter.api.BeforeEach;
import ua.lviv.iot.lawFirm.model.*;

import java.util.LinkedList;
import java.util.List;

public class BaseLawFirmTest {

	protected List<Lawyer> lawyers;

	@BeforeEach
	public void createLawyers() {
		this.lawyers = new LinkedList<Lawyer>();
		this.lawyers.add(new Lawyer("Max", 500.0, 27, true, true));
		this.lawyers.add(new Lawyer("Roman", 450.0, 25, true, false));
		this.lawyers.add(new Lawyer("Petro", 350.0, 23, false, true));
		this.lawyers.add(new Lawyer("Sebastian", 300.0, 24, false, false));
	
	}
	
}
