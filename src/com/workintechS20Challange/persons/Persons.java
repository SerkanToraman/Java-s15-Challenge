package com.workintechS20Challange.persons;
import com.workintechS20Challange.persons.enums.PersonStatus;
import java.util.Objects;
import java.util.Scanner;

public class Persons implements personAccountChangable{
    String name;
    private PersonStatus personStatus;
    private int IDNo;
    private String PhoneNum;
    private boolean BorrowAllowed;
    private double accountMoney;

    public Persons(String name) {
        this.name = name;
    }

    public Persons(String name, int IDNo, String phoneNum, boolean borrowAllowed, double accountMoney) {
        this.name = name;
        this.IDNo = IDNo;
        PhoneNum = phoneNum;
        BorrowAllowed = borrowAllowed;
        this.personStatus = PersonStatus.BASICMEMBER;
        this.accountMoney=accountMoney;
    }

    public String getName() {
        return name;
    }

    public PersonStatus getPersonStatus() {
        return personStatus;
    }

    public int getIDNo() {
        return IDNo;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public boolean IsBorrowAllowed() {
        return BorrowAllowed;
    }

    public double getAccountMoney() {
        return accountMoney;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersonStatus(PersonStatus personStatus) {
        this.personStatus = personStatus;
    }

    public void setIDNo(int IDNo) {
        this.IDNo = IDNo;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

    public void setBorrowAllowed(boolean BorrowAllowed) {
        this.BorrowAllowed = BorrowAllowed;
    }

    public void setAccountMoney(Double accountMoney) {
        this.accountMoney = accountMoney;
    }

    public Persons becomeCharityMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password to become a Charity Member: ");
        String inputPassword = scanner.nextLine();
        if(inputPassword.equals("1234")){
            Persons charityEmployee = new CharityEmployee(
                    getName(),
                    getIDNo(),
                    getPhoneNum(),
                    IsBorrowAllowed(),
                    getAccountMoney()
            );
            this.setName(null);
            this.setPersonStatus(null);
            this.setIDNo(0);
            this.setPhoneNum(null);
            this.setBorrowAllowed(false);
            this.setAccountMoney(0.0);
            return charityEmployee;
        }else {
            System.out.println("Incorrect password. Citizen cannot assigned as a CharityMember.");
            return null;
        }
    }
    @Override
    public double addMoney(Persons person) {
    accountMoney = accountMoney + personAccountChangable.deposit;
    return accountMoney;
    }
    @Override
    public boolean checkAccount(Persons person) {
        if (person instanceof Author) {
            return accountMoney >= PersonStatus.AUTHOR.getFee()+personAccountChangable.deposit;
        } else if (person instanceof Member) {
            return accountMoney >= PersonStatus.BASICMEMBER.getFee()+personAccountChangable.deposit;
        } else if (person instanceof Donator) {
            return accountMoney >= PersonStatus.DONATOR.getFee()+personAccountChangable.deposit;
        }else if (person instanceof CharityEmployee) {
            return accountMoney >= PersonStatus.CHARITYEMPLOYEE.getFee()-personAccountChangable.deposit;
        }else{
            return false;
        }
    }

    @Override
    public double subtractMoney(Persons person) {
        if (person instanceof Author) {
            accountMoney = accountMoney - PersonStatus.AUTHOR.getFee()-personAccountChangable.deposit;
        } else if (person instanceof Member) {
            accountMoney = accountMoney - PersonStatus.BASICMEMBER.getFee()-personAccountChangable.deposit;
        } else if (person instanceof Donator) {
            accountMoney = accountMoney - PersonStatus.DONATOR.getFee()-personAccountChangable.deposit;
        }else if (person instanceof CharityEmployee) {
                accountMoney = accountMoney - PersonStatus.CHARITYEMPLOYEE.getFee()-personAccountChangable.deposit;
    }
        return accountMoney;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(getName(), author.getName());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
    @Override
    public String toString() {
        return "Persons{" +
                "name='" + name + '\'' +
                ", personStatus=" + personStatus +
                ", IDNo=" + IDNo +
                ", PhoneNum='" + PhoneNum + '\'' +
                ", IsAMember=" + BorrowAllowed +
                ", accountMoney=" + accountMoney +
                '}';
    }

}
