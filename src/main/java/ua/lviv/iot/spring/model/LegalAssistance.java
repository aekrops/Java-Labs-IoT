package ua.lviv.iot.lawFirm.spring.model;

public class LegalAssistance extends AbstractServices {

    protected String kindOfLegalAssistance;

    public String getKindOfLegalAssistance() {
        return kindOfLegalAssistance;
    }

    public void setKindOfLegalAssistance(String kindOfLegalAssistance) {
        this.kindOfLegalAssistance = kindOfLegalAssistance;
    }
}
