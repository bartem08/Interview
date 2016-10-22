package com.interview.model.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoleTest {

    private Role role;

    public static final String ROLE_USER = "ROLE_USER";

    public static final String ROLE_ADMIN = "ROLE_ADMIN";

    @Before
    public void setUp() {
        role = new Role(ROLE_USER);
    }

    @Test
    public void testRoleEntity() {

        role.setAuthority(ROLE_ADMIN);
        assertSame(role.getAuthority(), ROLE_ADMIN);
    }

    @Test
    public void testEqualsAndHashCode() {

        Role same = new Role(ROLE_USER);
        assertEquals(role, same);
        assertTrue(role.hashCode() == same.hashCode());

        same.setAuthority(ROLE_ADMIN);
        assertNotEquals(role, same);
        assertFalse(role.hashCode() == same.hashCode());
    }
}