/*
    Author: Sachin Gurung
    Date: 01/22/25
    Class: CS-320 Software Test, Automation QA
 */

package com.contactservice;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact
    public void addContact(Contact contact){
        if(contacts.containsKey(contact.getContactId())){
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Update First Name
    public void updateFirstName(String contactId, String firstName){
        if(!contacts.containsKey(contactId)){
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.get(contactId).setFirstName(firstName);
    }

    // Update Last Name
    public void updateLastName(String contactId, String lastName){
        if(!contacts.containsKey(contactId)){
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.get(contactId).setLastName(lastName);
    }

    // Update Phone Number
    public void updatePhoneNumber(String contactId, String phoneNumber){
        if(!contacts.containsKey(contactId)){
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.get(contactId).setPhoneNumber(phoneNumber);
    }

    // Update Address
    public void updateAddress(String contactId, String address){
        if(!contacts.containsKey(contactId)){
            throw new IllegalArgumentException("Contact ID not found.");
        }
        contacts.get(contactId).setAddress(address);
    }

    // Delete contact
    public void deleteContact(String contactId){
        if(!contacts.containsKey(contactId)){
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.remove(contactId);
    }
}
