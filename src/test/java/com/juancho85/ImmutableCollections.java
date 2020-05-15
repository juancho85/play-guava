package com.juancho85;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ImmutableCollections {

    @Test
    public void of()
    {
        List<String> myImmutableList = ImmutableList.of("a", "b", "c");
        assertEquals(3, myImmutableList.size());
        assertThrows(UnsupportedOperationException.class, () -> myImmutableList.add("d"));
    }

    @Test
    public void copyOf()
    {
        List<String> myMutableList = new ArrayList<>();
        myMutableList.add("a");
        myMutableList.add("b");
        List<String> myImmutableList = ImmutableList.copyOf(myMutableList);
        assertThrows(UnsupportedOperationException.class, () -> myImmutableList.add("c"));
    }

    @Test
    public void builder()
    {
        ImmutableSet<String> myImmutableSet = ImmutableSet
                .<String>builder()
                .add("Hola,")
                .add("¿Qué")
                .add("tal?")
                .build();
        assertEquals(3, myImmutableSet.size());
        assertTrue(myImmutableSet.contains("Hola,"));
        assertTrue(myImmutableSet.contains("¿Qué"));
        assertTrue(myImmutableSet.contains("tal?"));
    }
}
