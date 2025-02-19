/*
    Author: Sachin Gurung
    Date: 01/22/25
    Class: CS-320 Software Test, Automation QA
 */

package com.contactservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    void setUp(){
        service = new ContactService();
    }
    @Test
    void testAddContact(){
        Contact contact = new Contact("12345", "Jane", "Doe", "1234567890", "111 Jane Doe Street");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
    void testDeleteContact(){
        Contact contact = new Contact("12345", "Jane", "Doe", "1234567890", "111 Jane Doe Street");
        service.addContact(contact);
        service.deleteContact("12345");
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("12345"));
    }

    @Test
    void testDeleteNonExistentContact(){
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("99999"));
    }

    @Test
    void testUpdateFirstName(){
        Contact contact = new Contact("12345", "Jane", "Doe", "1234567890", "111 Jane Doe Street");
        service.addContact(contact);
        service.updateFirstName("12345", "John");
        assertEquals("John", contact.getFirstName());
    }

    @Test
    void testUpdateLastName(){
        Contact contact = new Contact("12345", "Jane", "Doe", "1234567890", "111 Jane Doe Street");
        service.addContact(contact);
        service.updateLastName("12345", "Robinson");
        assertEquals("Robinson", contact.getLastName());
    }

    @Test
    void testUpdatePhoneNumber(){
        Contact contact = new Contact("12345", "Jane", "Doe", "1234567890", "111 Jane Doe Street");
        service.addContact(contact);
        service.updatePhoneNumber("12345", "1111111111");
        assertEquals("1111111111", contact.getPhoneNumber());
    }

    @Test
    void testUpdateInvalidPhoneNumber(){
        Contact contact = new Contact("12345", "Jane", "Doe", "1234567890", "111 Jane Doe Street");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber("12345", "123456789"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber("12345", "12345678901"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber("12345", "123 567 90"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber("12345", "abcdefghij"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber("00000", "123456789"));
    }

    @Test
    void testUpdateAddress(){
        Contact contact = new Contact("12345", "Jane", "Doe", "1234567890", "111 Jane Doe Street");
        service.addContact(contact);
        service.updateAddress("12345", "111 New Address Street");
        assertEquals("111 New Address Street", contact.getAddress());
    }

    @Test
    void testUpdateForNonExistentContact(){
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("00000", "123 New Address"));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("00000", "Robinson"));
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("00000", "John"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber("00000", "9876543210"));
    }
}