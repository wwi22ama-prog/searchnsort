package de.reinerh.courses.java;

import java.util.Collections;
import java.util.List;

/** Search ist eine Klasse, die mehrere statische Funktionen für die Suche
 *  nach Elementen in einer Liste enthält.
 */
public class Lists {

    /** binary führt eine binäre Suche nach einem Element in einer Liste durch.
     * 
     * @param list Die Liste, die durchsucht werden soll.
     * @param key Der Schlüssel, nach dem gesucht werden soll.
     * @return Die Position des ersten Vorkommens von key. 
     *         Oder -1, falls key nicht vorkommt.
     * 
     * Anmerkung: Diese Funktion kann nur für sortierte Listen ein sinnvolles Ergebnis liefern.
     */
    public static int binarySearch(List<Integer> list, int key) {
        if (list.isEmpty()) {
            return -1;
        }
        int midpos = list.size() / 2;

        if (key <= list.get(midpos)) {
            int result = binarySearch(list.subList(0, midpos), key);
            if (result != -1) {
                return result;
            }
            return list.get(midpos) == key ? midpos : -1;
        }
        int result = binarySearch(list.subList(midpos+1, list.size()), key);
        return result == -1 ? -1 : result + midpos + 1;
    }

    /**
     * 
     * * `partition` sortiert die Elemente einer Liste so um, dass zuerst alle Elemente
     * kommen, die kleiner als n sind und danach alle Elemente, die größer sind.
     * 
     * @param list Die umzusortierende Liste
     * @param n Der Wert, nach dem umsortiert werden soll.
     * @return Die Anzahl der Elemente, die <= n sind.
     */
    public static int partition(List<Integer> list, int n) {
        int left = 0;
        int right = list.size()-1;

        while (left <= right) {
            int leftValue = list.get(left);
            int rightValue = list.get(right);

            if (leftValue > n && rightValue <= n) {
                Collections.swap(list, left, right);
            }

            if (leftValue <= n) { left++; }
            if (rightValue > n) { right--; }
        }

        return left;
    }

    public static void qsort(List<Integer> list) {
        // Rekursionsanker: Listen der Länge <= 1 sind bereits sortiert.
        if (list.size() <= 1) {
            return;
        }
        
        // Liste nach pivot partitionieren und das Pivotelement in die Mitte tauschen.
        int pivot = list.get(0);
        int pivotpos = partition(list.subList(1, list.size()), pivot);
        Collections.swap(list,0,pivotpos);

        // Rekursiv sortieren.
        qsort(list.subList(0, pivotpos));
        qsort(list.subList(pivotpos+1, list.size()));
    }
}
