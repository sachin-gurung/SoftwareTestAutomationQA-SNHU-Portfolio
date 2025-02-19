/*
    Author: Sachin Gurung
    Date: 01/22/25
    Class: CS-320 Software Test, Automation QA
 */

package com.contactservice;
public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    // Constructor
    public Contact(String contactId, String firstName, String lastName, String phoneNumber, String address){
        if(contactId == null || contactId.length() > 10){
            throw new IllegalArgumentException("Invalid contact ID.");
        }

        if(firstName == null || firstName.length() > 10){
            throw new IllegalArgumentException("Invalid First Name.");
        }

        if(lastName == null || lastName.length() > 10){
            throw new IllegalArgumentException("Invalid Last Name.");
        }

        // Checks if phone number is exactly 10 characters and includes only digits with regex
        if(phoneNumber == null || phoneNumber.length() != 10 || !phoneNumber.matches("\\d+")){
            throw new IllegalArgumentException("Invalid Phone Number.");
        }

        if(address == null || address.length()>30){
            throw new IllegalArgumentException("Invalid Address.");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Getters
    public String getContactId(){
        return contactId;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getAddress(){
        return address;
    }

    // Setters
    public void setFirstName(String firstName){
        if(firstName == null || firstName.length()>10){
            throw new IllegalArgumentException("Invalid First Name.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        if(lastName == null || lastName.length()>10){
            throw new IllegalArgumentException("Invalid Last Name.");
        }
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber){
        if(phoneNumber == null || phoneNumber.length()!=10 || !phoneNumber.matches("\\d+")){
            throw new IllegalArgumentException("Invalid Phone Number.");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address){
        if(address == null || address.length()>30){
            throw new IllegalArgumentException("Invalid Address.");
        }
        this.address = address;
    }
}
