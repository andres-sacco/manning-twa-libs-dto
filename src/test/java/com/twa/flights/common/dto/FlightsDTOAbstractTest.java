package com.twa.flights.common.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import org.junit.jupiter.api.Test;

public abstract class FlightsDTOAbstractTest<T> {

    @Test
    public void settersAndGettersOk() {
        T objectToCheck = buildObjectWithSetters();
        assertAttributes(objectToCheck);
    }

    @Test
    public void equalsOk() {
        T anObject = buildObjectWithSetters();
        T anotherObject = buildObjectWithSetters();

        assertNotSame(anObject, anotherObject);
        assertEquals(anObject, anotherObject);
    }

    @Test
    public void notEqualsOk() {
        T anObject = buildObjectWithSetters();
        T notEqualsObject = buildNotEqualsObject();

        assertNotEquals(anObject, notEqualsObject);
    }

    @Test
    public void hashCodeOk() {
        T anObject = buildObjectWithSetters();
        T anotherObject = buildObjectWithSetters();

        assertEquals(anObject.hashCode(), anotherObject.hashCode());
    }

    @Test
    public void toStringOk() {
        assertEquals(expectedToString(), buildObjectWithSetters().toString());
    }

    public abstract T buildObjectWithSetters();

    public abstract T buildNotEqualsObject();

    public abstract void assertAttributes(T objectToCheck);

    public abstract String expectedToString();
}
