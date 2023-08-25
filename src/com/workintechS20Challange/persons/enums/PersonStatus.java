package com.workintechS20Challange.persons.enums;

public enum PersonStatus {
    AUTHOR("Author",10),
    CHARITYEMPLOYEE("CHARITYEMPLOYEE",10),
    BASICMEMBER("BASICMEMBER",45),
    DONATOR("DONATOR",8);

    private String status;
    private int fee;

    PersonStatus(String status, int fee) {
        this.status = status;
        this.fee = fee;
    }

    public String getStatus() {
        return status;
    }

    public int getFee() {
        return fee;
    }
}
