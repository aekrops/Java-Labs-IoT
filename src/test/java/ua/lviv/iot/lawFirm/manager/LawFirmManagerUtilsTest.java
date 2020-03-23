package ua.lviv.iot.lawFirm.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.lawFirm.model.SortType;

class LawFirmManagerUtilsTest extends BaseLawFirmTest {

    @Test
    public void testLawyersSorterByPricePerHourInUAH() {
        LawFirmManagerUtils.sortLawyerByPricePerHourInUAH(lawyers, SortType.DESCENDING);
        /*
         * 300 350 450 500
         */
        assertEquals(500.0, lawyers.get(0).getPricePerHourInUAH());
        assertEquals(450.0, lawyers.get(1).getPricePerHourInUAH());
        assertEquals(350.0, lawyers.get(2).getPricePerHourInUAH());
        assertEquals(300.0, lawyers.get(3).getPricePerHourInUAH());
    }

    @Test
    public void TestLawyersSorterByNumberOfService() {
        LawFirmManagerUtils.sortLawyersByNumberOfService(lawyers, SortType.ASCENDING);
        /*
         * 5,4,4,3
         */
        assertEquals(3, lawyers.get(0).getNumberOfServices());
        assertEquals(4, lawyers.get(1).getNumberOfServices());
        assertEquals(4, lawyers.get(2).getNumberOfServices());
        assertEquals(5, lawyers.get(3).getNumberOfServices());
    }

    @Test
    public void TestLawyersSorterByLengthOfName() {
        LawFirmManagerUtils.sortLawyersByLengthOfName(lawyers, SortType.ASCENDING);
        /*
         * 3, 5, 5, 9
         */
        assertEquals(3, lawyers.get(0).getLengthOfName());
        assertEquals(5, lawyers.get(1).getLengthOfName());
        assertEquals(5, lawyers.get(2).getLengthOfName());
        assertEquals(9, lawyers.get(3).getLengthOfName());
    }
}
