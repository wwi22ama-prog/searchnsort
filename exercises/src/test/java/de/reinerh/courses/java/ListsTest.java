package de.reinerh.courses.java;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Unit-Test für Suchalgorithmen.
 */
public class ListsTest 
{
    /**
     * Test für die binäre Suche.
     */
    @Test
    public void testBinarySearch()
    {
        // given a sorted list of ints 
        List<Integer> l1 = Arrays.asList(1,3,5,6,8,10,25,25,42,103);
        
        // when we search for elements that are in the list...
        int pos3 = Lists.binarySearch(l1, 3);
        int pos5 = Lists.binarySearch(l1, 5);
        int pos10 = Lists.binarySearch(l1, 10);
        int pos103 = Lists.binarySearch(l1, 103);

        // ... then we expect the search to return the correct positions.
        assertEquals( 1, pos3 );
        assertEquals( 2, pos5 );
        assertEquals( 5, pos10 );
        assertEquals( 9, pos103 );

        // when we search for an element that occurs twice in the list...
        int pos25 = Lists.binarySearch(l1, 25);

        // ... then we expect the search to return the first of the two positions.
        assertEquals( 6, pos25 );

        // when we search for an element that doesn't occur in the list...
        int pos38 = Lists.binarySearch(l1, 38);

        // ... then we expect the search to return -1.
        assertEquals( -1, pos38 );
    }

    /**
     * Test für die binäre Suche.
     */
    @Test
    public void testPartition()
    {
        // Gegeben eine Liste von Zahlen.
        List<Integer> l1 = Arrays.asList(42,15,77,23,12,14,85,15,103,42,38);
        
        // Wenn wir die Liste nach 45 partitionieren...
        int resultl1 = Lists.partition(l1,45);

        // .. sollte die Funktion 8 geliefert haben.
        assertEquals(8, resultl1);

        // .. sollten ab Stelle 8 nur noch Werte > 45 stehen und vorher nur kleinere.
        for (int i=0; i<8; i++) {
            assertTrue(l1.get(i) <= 45);
        }
        for (int i=8; i<l1.size(); i++) {
            assertTrue(l1.get(i) > 45);
        }
    }

    /**
     * Test für QuickSort.
     */
    @Test
    public void testQSort()
    {
        // Gegeben: Eine Liste von int und eine sortierte Form davon.
        List<Integer> l1 = Arrays.asList(1,5,6,10,3,25,8,42,25,103);
        List<Integer> l1sorted = l1.stream().sorted().toList();
        
        // Wenn wir die Liste sortieren ...
        Lists.qsort(l1);

        // ... soll sie anschließend eine sortierte Form ihrer selbst sein.
        assertEquals(l1sorted, l1);
    }
}
