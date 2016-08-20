package io.developerinator.app.ref;


public enum FilterStatus {

    ACTIVE("Active"),
    INACTIVE("Inactive");

    private String label;

    FilterStatus(String label){
        this.label = label;
    }
}
