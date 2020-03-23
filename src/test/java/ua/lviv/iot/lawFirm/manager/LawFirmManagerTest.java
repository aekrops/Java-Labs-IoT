package ua.lviv.iot.lawFirm.manager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.lawFirm.model.Lawyer;
import ua.lviv.iot.lawFirm.model.Services;

public class LawFirmManagerTest extends BaseLawFirmTest {

    @Test
    public void testFindLawyersByServices() {
        LawFirmManager manager = new LawFirmManager(lawyers);

        List<Lawyer> result = manager.findLawyersByServices(Services.ADVICE, lawyers);
        assertEquals(2, result.size());

        // verify found buses Name
        assertEquals("Max", result.get(0).getName());
        assertEquals("Petro", result.get(1).getName());

    }

}
