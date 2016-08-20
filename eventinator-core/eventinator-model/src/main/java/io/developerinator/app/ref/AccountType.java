package io.developerinator.app.ref;


public enum AccountType {

    PERSONAL("Personal"),
    ORGANIZATION("Organization"),
    COMMUNITY("Community");

    private String label;

    AccountType(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
