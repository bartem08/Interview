package com.interview.model.entity;

import org.junit.Before;
import org.junit.Test;
import javax.validation.*;

import static org.junit.Assert.*;

public class UserTest {

    private User user;

    private Validator validator;

    @Before
    public void setUp() throws Exception {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

        user = User.builder()
                .firstName("FirstName")
                .lastName("LastName")
                .email("email@email.com")
                .phone("0931110011")
                .password("Password")
                .build();
    }

    @Test
    public void testUserEntity() {

        user.setFirstName("newFirstName");
        assertSame(user.getFirstName(), "newFirstName");

        user.setLastName("newLastName");
        assertSame(user.getLastName(), "newLastName");

        user.setEmail("newEmail@email.com");
        assertSame(user.getEmail(), "newEmail@email.com");

        user.setPhone("0000000000");
        assertSame(user.getUsername(), "0000000000");
    }

    @Test
    public void testUserValidation() {

        assertTrue(validator.validate(user).isEmpty());
    }

    @Test
    public void testEmailValidation() {
        user.setEmail("incorrect");

        assertTrue(validator.validate(user).stream().anyMatch(constraintViolation ->
                constraintViolation.getMessage().equals("not a well-formed email address")));
    }

    @Test
    public void testPhoneValidation() {
        user.setPhone("1234567890");

        assertTrue(validator.validate(user).stream().anyMatch(constraintViolation ->
                constraintViolation.getMessage().equals("must match \"^[0][1-9][0-9]{8}\"")));
    }

    @Test
    public void testUserEqualsAndHashCode() {

        User same = User.builder()
                .phone("0931110011")
                .build();

        assertEquals(user, same);
        assertTrue(user.hashCode() == same.hashCode());

        same.setPhone("0967771110");

        assertNotEquals(user, same);
        assertFalse(user.hashCode() == same.hashCode());
    }
}