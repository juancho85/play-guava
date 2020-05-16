package com.juancho85;


import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//https://github.com/google/guava/wiki/NewCollectionTypesExplained#multiset
public class Multisets
{
    @Test
    public void multiset()
    {
        Multiset<String> bookStore = HashMultiset.create();
        bookStore.add("Potter");
        bookStore.add("Potter");
        bookStore.add("Potter");
        bookStore.add("1984");
        bookStore.add("1984");

        assertTrue(bookStore.contains("Potter"));
        assertEquals(3, bookStore.count("Potter"));
        assertTrue(bookStore.contains("1984"));
        assertEquals(2, bookStore.count("1984"));
        assertEquals(5, bookStore.size());

        bookStore.remove("1984", 1);
        final Set<Multiset.Entry<String>> entries = bookStore.entrySet();
        for(Multiset.Entry entry: entries) {
            if(entry.getElement().equals("Potter")) {
                assertEquals(3, entry.getCount());
            }
            if(entry.getElement().equals("1984")) {
                assertEquals(1, entry.getCount());
            }
        }

        bookStore.setCount("1984", 5);
        assertEquals(5, bookStore.count("1984"));


    }

}
