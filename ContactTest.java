/*
    Author: Sachin Gurung
    Date: 01/22/25
    Class: CS-320 Software Test, Automation QA
 */

package com.contactservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
    @Test
    void testValidContact(){
        Contact contact = new Contact("12345", "Jane", "Doe", "1234567890", "111 Jane Doe Street");
        assertEquals("12345", contact.getContactId());
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("111 Jane Doe Street", contact.getAddress());
    }

    @Test
    void testContactIdCannotBeLongerThanTenCharacters(){
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "Jane", "Doe", "1234567890", "111 Jane Doe Street"));
    }

    @Test
    void testContactIdCannotBeNull(){
        assertThrows(IllegalArgumentException.class, ()->new Contact(null, "Jane", "Doe", "1234567890", "111 Jane Doe Street"));
    }

    @Test
    void testFirstNameCannotBeLongerThanTenCharacters(){
        assertThrows(IllegalArgumentException.class, ()->new Contact("12345", "abcdefghijk", "Doe", "1234567890", "111 Jane Doe Street"));
    }

    @Test
    void testFirstNameCannotBeNull(){
        assertThrows(IllegalArgumentException.class, ()-> new Contact("12345", null, "Doe", "1234567890", "111 Jane Doe Street"));
    }

    @Test
    void testLastNameCannotBeLongerThanTenCharacters(){
        assertDoesNotThrow(() -> new Contact("12345", "Jane", "DoeDoeDoeD", "1234567890", "111 Jane Doe Street"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Jane", "DoeDoeDoeDo", "1234567890", "111 Jane Doe Street"));
    }

    @Test
    void testLastNameCannotBeNull(){
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Jane", null, "1234567890", "111 Jane Doe Street"));
    }

    @Test
    void testPhoneNumberMustBeExactlyTenDigits(){
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Jane", "Doe", "123456789", "111 Jane Doe Street"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Jane", "Doe", "12345678901", "111 Jane Doe Street"));
    }

    @Test
    void testPhoneNumberCannotBeNull(){
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Jane", "Doe", null, "111 Jane Doe Street"));
    }

    @Test
    void testPhoneNumberMustContainAllDigits(){
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Jane", "Doe", "abcdef", "111 Jane Doe Street"));
    }

    @Test
    void testPhoneNumberContainsSpecialCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Jane", "Doe", "12345-6789", "111 Jane Doe Street"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Jane", "Doe", "12345 6789", "111 Jane Doe Street"));
    }

    @Test
    void testAddressCannotBeLongerThanThirtyCharacters(){
        assertDoesNotThrow(() -> new Contact("12345", "Jane", "Doe", "1234567890", "123456789012345678901234567890"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Jane", "Doe", "1234567890", "1234567890123456789012345678901"));
    }

    @Test
    void testAddressCannotBeNull(){
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Jane", "Doe", "1234567890", null));
    }

    @Test
    void testUpdatesThatAreValid(){
        Contact contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "111 Jane Doe Street");
        contact.setFirstName("John");
        contact.setLastName("Robinson");
        contact.setPhoneNumber("0987654321");
        contact.setAddress("111 John Robinson Street");

        assertEquals("John", contact.getFirstName());
        assertEquals("Robinson", contact.getLastName());
        assertEquals("0987654321", contact.getPhoneNumber());
        assertEquals("111 John Robinson Street", contact.getAddress());
    }

    @Test
    void testUpdatesThatAreInvalid(){
        Contact contact = new Contact("1234567890", "Jane", "Doe", "1234567890", "111 Jane Doe Street");

        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("JaneJaneJan"));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("DoeDoeDoeDo"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("12345678901"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber("abcdef"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhoneNumber(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress("111 Jane Doe Street 12345678901"));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }
}