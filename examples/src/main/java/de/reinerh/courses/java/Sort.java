package de.reinerh.courses.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Sort ist eine Klasse, die mehrere statische Funktionen
 *  für das Sortieren von Listen enthält.
 */
public class Sort {

    /** Implementierung des Sortierverfahrens InsertionSort. */
    public static void insertion(List<Integer> list) {
        for (int i=1; i < list.size(); i++) {
            for (int j = i; j>0 && list.get(j) < list.get(j-1); j--) {
                Collections.swap(list, j, j-1);
            }
        }

    }

    /** Implementierung des Sortierverfahrens SelectionSort. */
    public static void selection(List<Integer> list) {
        for (int i=0; i<list.size()-1; i++) {
            int smallestPos = -1;
            for (int j=i; j<list.size(); j++) {
                if (smallestPos < 0 || list.get(j) < list.get(smallestPos)) {
                    smallestPos = j;
                }
            }
            Collections.swap(list, i, smallestPos);
        }
    }

    /** Implementierung des Sortierverfahrens BubbleSort. */
    public static void bubble(List<Integer> list) {
        for (int i=0; i<list.size(); i++) {
            for (int j=0; j<i; j++) {
                if (list.get(j) > list.get(j+1)) {
                    Collections.swap(list, j, j+1);
                }
            }
        }
    }

    /** Implementierung des Sortierverfahrens QuickSort. */
    public static void quick(List<Integer> list) {
        // Rekursionsanker: Listen der Länge <= 1 sind bereits sortiert.
        if (list.size() <= 1) {
            return;
        }

        // Vorbereitung: Erzeugen von zwei Teillisten,
        // die kleinere bzw. größere Elemente als das erste enthalten.
        int pivot = list.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (var el : list.subList(1, list.size())) {
            if (el < pivot) {
                left.add(el);
            } else {
                right.add(el);
            }
        }

        // Rekursiv sortieren.
        quick(left);
        quick(right);

        // Die sortierten Teillisten wieder zusammensetzen.
        int i = 0;
        for (var el : left) {
            list.set(i++, el);
        } 
        list.set(i++, pivot);
        for (var el : right) {
            list.set(i++, el);
        } 
    }

    /** Implementierung des Sortierverfahrens MergeSort. */
    public static void merge(List<Integer> list) {
        // Rekursionsanker: Listen der Länge <= 1 sind bereits sortiert.
        if (list.size() <= 1) {
            return;
        }

        // Liste in zwei Hälften zerlegen.
        int midpos = list.size() / 2;
        var left = list.subList(0, midpos);
        var right = list.subList(midpos, list.size());

        // Die beiden Hälften rekursiv sortieren.
        merge(left);
        merge(right);

        // Die sortierten Teillisten zusammenmischen.
        List<Integer> sortedList = new ArrayList<>();
        int leftpos = 0;
        int rightpos = 0;
        while (leftpos < left.size() && rightpos < right.size()) {
            var leftElement = left.get(leftpos);
            var rightElement = right.get(rightpos);
            if (leftElement < rightElement) {
                sortedList.add(leftElement);
                leftpos++;
            } else {
                sortedList.add(rightElement);
                rightpos++;
            }
        }
        for (int i=leftpos; i<left.size(); i++) {
            sortedList.add(left.get(i));
        }
        for (int i=rightpos; i<right.size(); i++) {
            sortedList.add(right.get(i));
        }

        // Für's Zusammenmischen haben wir eine Hilfsliste verwendet,
        // weil wir left und right mit List.subList() erzeugt hatten und dies keine
        // echten Kopien sind. Hätten wir direkt List verwendet worden, hätte das die
        // Teillisten mit verändert.
        // Diese Hilfsliste kopieren wir nun zurück in die Haupt-Liste.
        Collections.copy(list, sortedList);
    }
}
