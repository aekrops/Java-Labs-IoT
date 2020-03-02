package ua.lviv.iot.lawFirm.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.lawFirm.model.*;

public class LawFirmManagerTest extends BaseLawFirmTest {

	@Test
	public void findLawyersByServices() {
		LawFirmManager manager = new LawFirmManager(super.lawyers);

		List<Lawyer> result = manager.findLawyersByServices(Services.ADVICE, super.lawyers);

		assertEquals("Max", result.get(0).getName());
		assertEquals("Petro", result.get(1).getName());
		
	}

}
