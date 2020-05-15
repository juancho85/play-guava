package com.juancho85;


import com.google.common.base.MoreObjects;
import org.junit.jupiter.api.Test;

import com.google.common.base.Optional;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

//https://github.com/google/guava/wiki/UsingAndAvoidingNullExplained#optional
public class Optionals
{
    @Test
    public void optionalOf()
    {
        // Make an optional containing the given non-null
        java.util.Optional<Integer> possible = java.util.Optional.of(5);
        assertTrue(possible.isPresent());
        assertEquals(5, possible.get());
        // Or fail fast on null
        Exception exception = assertThrows(NullPointerException.class, () -> Optional.of(null));
        assertEquals(null, exception.getMessage());
    }

    @Test
    public void absent()
    {
        // Make an optional containing the given non-null
        Optional<Integer> absentValue = Optional.absent();
        assertFalse(absentValue.isPresent());
        Exception exception = assertThrows(IllegalStateException.class, () -> absentValue.get());
        assertEquals("Optional.get() cannot be called on an absent value", exception.getMessage());
    }

    @Test
    public void nullable()
    {
        // Make an optional containing the given non-null
        Optional<Integer> nullable = Optional.fromNullable(null);
        assertFalse(nullable.isPresent());
        Exception exception = assertThrows(IllegalStateException.class, () -> nullable.get());
        assertEquals("Optional.get() cannot be called on an absent value", exception.getMessage());
    }

    @Test
    public void or()
    {
        // Make an optional containing the given non-null
        Optional<Integer> nullable = Optional.fromNullable(null);
        assertEquals(5, nullable.or(5));
        Optional<Integer> six = Optional.of(6);
        assertEquals(6, six.or(5));
    }

    @Test
    public void orNull()
    {
        // Make an optional containing the given non-null
        Optional<Integer> nullable = Optional.fromNullable(null);
        assertNull(nullable.orNull(), "I really want this to be null");
    }

    @Test
    public void asSet()
    {
        // Make an optional containing the given non-null
        Optional<Integer> nullable = Optional.fromNullable(null);
        Set<Integer> emptySet = nullable.asSet();
        assertEquals(0, emptySet.size());
        Set<Integer> nonEmptySet = Optional.of(5).asSet();
        assertEquals(1, nonEmptySet.size());
        assertTrue(nonEmptySet.contains(5));
    }

    @Test
    public void moreObjects()
    {
        // Make an optional containing the given non-null
        String primaryChoice = null;
        String secondaryChoice = "second";
        assertEquals("second", MoreObjects.firstNonNull(primaryChoice, secondaryChoice));
        assertEquals("second", Optional.fromNullable(primaryChoice).or(secondaryChoice));
    }
}
