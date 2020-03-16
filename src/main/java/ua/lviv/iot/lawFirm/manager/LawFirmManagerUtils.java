package ua.lviv.iot.lawFirm.manager;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.lawFirm.model.AbstractServices;
import ua.lviv.iot.lawFirm.model.Lawyer;
import ua.lviv.iot.lawFirm.model.SortType;

public class LawFirmManagerUtils {

	private static final LawyersSorterByNumberOfServices LAWYER_BY_NUMBER_OF_SERVICES_SORTER = new LawyersSorterByNumberOfServices();

	// static inner class
	public static void sortLawyersByNumberOfService(List<Lawyer> lawyers, SortType sortType) {

		lawyers.sort(sortType == SortType.ASCENDING ? LAWYER_BY_NUMBER_OF_SERVICES_SORTER
				: LAWYER_BY_NUMBER_OF_SERVICES_SORTER.reversed());
	}

	// static inner class
	public static void sortLawyerByPricePerHourInUAH(List<Lawyer> lawyers, SortType sortType) {
		Comparator<Lawyer> comparator = Comparator.comparing(Lawyer::getPricePerHourInUAH);
		lawyers.sort(sortType == SortType.ASCENDING ? comparator : comparator.reversed());
	}

	// anonymous inner class
	public static void sortLawyersByLengthOfName(List<Lawyer> lawyers, SortType sortType) {
		Comparator<Lawyer> comparator = new Comparator<Lawyer>() {

			@Override
			public int compare(Lawyer firstLawyer, Lawyer secondLawyer) {

				int lengthOfNameComparisonResult = firstLawyer.getLengthOfName() - secondLawyer.getLengthOfName();

				if (lengthOfNameComparisonResult != 0) {
					return lengthOfNameComparisonResult;
				}

				return Integer.compare(firstLawyer.getLengthOfName(), secondLawyer.getLengthOfName());

			}
		};
		lawyers.sort(sortType == SortType.ASCENDING ? comparator : comparator.reversed());
	}

	// inner class
	class LawyersSorterByPricePerHourInUAH implements Comparator<Lawyer> {

		@Override
		public int compare(Lawyer firstLawyer, Lawyer secondLawyer) {
			return Double.compare(firstLawyer.getPricePerHourInUAH(), secondLawyer.getPricePerHourInUAH());
		}
	}

	static class LawyersSorterByNumberOfServices implements Comparator<Lawyer> {

		@Override
		public int compare(Lawyer firstLawyer, Lawyer secondLawyer) {
			return firstLawyer.getNumberOfServices() - secondLawyer.getNumberOfServices();
		}
	}
}
