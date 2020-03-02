package ua.lviv.iot.lawFirm.manager;

import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.lawFirm.model.Lawyer;
import ua.lviv.iot.lawFirm.model.Services;

public class LawFirmManager {

	protected List<Lawyer> lawyers = new LinkedList<>();

	public LawFirmManager(List<Lawyer> lawyers) {
		this.lawyers = lawyers;
	}

	public LawFirmManager() {
	}

	public List<Lawyer> findLawyersByServices(Services serviceToSearch, List<Lawyer> lawyers) {

		List<Lawyer> foundLawyers = new LinkedList<Lawyer>();

		for (Lawyer lawyerToCheck : lawyers) {
			List<Services> services = lawyerToCheck.getServices();

			int count = 0;

			for (Services service : services) {
				if (serviceToSearch == service)
					count++;
			}
			if (count > 0) {
				foundLawyers.add(lawyerToCheck);
			}
		}

		return foundLawyers;
	}

	public List<Lawyer> getLawyers() {
		return lawyers;
	}

	public void addLawyers(Lawyer lawyer) {
		lawyers.add(lawyer);
	}

}
