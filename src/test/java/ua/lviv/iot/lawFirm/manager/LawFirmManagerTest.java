package ua.lviv.iot.lawFirm.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.lawFirm.model.*;
import ua.lviv.iot.lawFirm.manager.*;

public class LawFirmManagerTest extends BaseLawFirmTest {

	@Test
	public void findLawyersByServices() {
		LawFirmManager manager = new LawFirmManager(lawyers);

		List<Lawyer> result = manager.findLawyersByServices(Services.ADVICE, lawyers);

		assertEquals(Services.ADVICE, lawyers.get(0).getServices());
		assertEquals(Services.COLLECTINGEVIDENCE, lawyers.get(1).getServices());
		assertEquals(Services.REPRESENTATIONINCOURT, lawyers.get(2).getServices());
		assertEquals(Services.SIGNINGACONTRACT, lawyers.get(3).getServices());
	}

}
