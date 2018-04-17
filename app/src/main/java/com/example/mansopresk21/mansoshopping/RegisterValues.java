package com.example.mansopresk21.mansoshopping;

/**
 * Created by Mansopresk13 on 9/18/2017.
 */

public class RegisterValues
{
    String firstname;
    String lastname;
    String email;
    String mobile;
    String password;
    String cnfrmpasword;


    public RegisterValues()
    {

    }

    public RegisterValues(String firstname, String lastname, String email, String mobile, String password, String cnfrmpasword) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.cnfrmpasword = cnfrmpasword;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCnfrmpasword() {
        return cnfrmpasword;
    }

    public void setCnfrmpasword(String cnfrmpasword) {
        this.cnfrmpasword = cnfrmpasword;
    }
}
