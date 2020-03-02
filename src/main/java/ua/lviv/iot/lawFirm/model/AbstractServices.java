package ua.lviv.iot.lawFirm.model;

public abstract class AbstractServices {

	protected int duration;

	private final Boolean draftingAClaim = true;
	private final Boolean signingAContract = true;
	private final Boolean representationInCourt = true;
	private Boolean advice;
	private Boolean collectingEvidence;

	public void draftingAClaim() {
		System.out.println("You are enrolled for the service, wait...");
	}

	public void signingAContract() {
		System.out.println("You are enrolled for the service, wait...");
	}

	public void represetationInCourt() {
		System.out.println("You are enrolled for the service, wait...");
	}

	public void advice() {
		if (advice == true) {
			System.out.println("You are enrolled for the service, wait...");
		} else
			System.out.println("Sorry, but the lawyer does not provide this service.");
	}

	protected void collectingEvidence() {
		
		if (collectingEvidence == true) {
			System.out.println("You are enrolled for the service, wait...");
		} else
			System.out.println("Sorry, but the lawyer does not provide this service.");
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Boolean getDraftingAClaim() {
		return draftingAClaim;
	}

	public Boolean getSigningAContract() {
		return signingAContract;
	}

	public Boolean getRepresentationInCourt() {
		return representationInCourt;
	}

	public Boolean getAdvice() {
		return advice;
	}

	public void setAdvice(Boolean advice) {
		this.advice = advice;
	}

	public Boolean getCollectingEvidence() {
		return collectingEvidence;
	}

	public void setCollectingEvidence(Boolean collectingEvidence) {
		this.collectingEvidence = collectingEvidence;
	}

}
