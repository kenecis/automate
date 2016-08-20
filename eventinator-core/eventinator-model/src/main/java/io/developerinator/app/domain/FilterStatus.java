package io.developerinator.app.domain;


public enum FilterStatus {

    ACTIVE("Active"),
    INACTIVE("Inactive");

    private String label;

    FilterStatus(String label){
        this.label = label;
    }
}
