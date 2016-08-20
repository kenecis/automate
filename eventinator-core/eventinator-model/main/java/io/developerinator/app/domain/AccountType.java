package io.developerinator.app.domain;


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
