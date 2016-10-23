package com.interview.model;

import com.interview.model.entity.Direction;

import java.util.Set;

public interface ITitle {

    String getFirstName();

    String getLastName();

    Set<Direction> getDirections();
}
