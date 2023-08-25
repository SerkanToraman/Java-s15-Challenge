package com.workintechS20Challange.persons;

import com.workintechS20Challange.persons.enums.PersonStatus;

public interface personAccountChangable {
    int deposit=25;

    public double addMoney(Persons person);
    public double subtractMoney(Persons person);
    public boolean checkAccount(Persons person);

}
