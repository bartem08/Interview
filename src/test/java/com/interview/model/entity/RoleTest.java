package com.interview.model.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoleTest {

    private Role role;

    @Before
    public void setUp() throws Exception {
        role = new Role("ROLE_ROLE");
    }

    @Test
    public void testRoleEntity() {

        role.setAuthority("ROLE_ANOTHER");
        assertSame(role.getAuthority(), "ROLE_ANOTHER");
    }

    @Test
    public void testEqualsAndHashCode() {

        Role same = new Role("ROLE_ROLE");
        assertEquals(role, same);
        assertTrue(role.hashCode() == same.hashCode());

        same.setAuthority("ROLE_ANOTHER");
        assertNotEquals(role, same);
        assertFalse(role.hashCode() == same.hashCode());
    }
}