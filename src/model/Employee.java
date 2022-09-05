package model;

public class Employee {
    String firstname;
    String lastname;
    String DOB;
    String email;
    String address;

    public Employee() {
    }

    public Employee(String firstname, String lastname, String DOB, String email, String address) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.DOB = DOB;
        this.email = email;
        this.address = address;
    }



    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
