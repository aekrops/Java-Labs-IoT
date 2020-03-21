package ua.lviv.iot.lawFirm.model;

public abstract class AbstractServices {

	protected int duration;

	private final Boolean draftingAClaim = true;
	private final Boolean signingAContract = true;
	private final Boolean representationInCourt = true;
	private Boolean advice;
	private Boolean collectingEvidence;

	public String getHeaders() {
		return "drafting a claim" + "," + "signing a contract" + ","
	+ "representationInCourt" + "," + "advice" + "," + "collecting evidence";
	}

	public String toCSV() {
		return getDraftingAClaim() + "," + getSigningAContract() + "," 
	+ getRepresentationInCourt() + "," + getAdvice() + "," + getCollectingEvidence();
	}

	public void numberOfServices() {

	}

	public void draftingAClaim() {

	}

	public void signingAContract() {

	}

	public void represetationInCourt() {

	}

	public void advice() {

	}

	protected void collectingEvidence() {

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
