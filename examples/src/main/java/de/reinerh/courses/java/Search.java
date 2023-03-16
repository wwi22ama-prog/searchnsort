package de.reinerh.courses.java;

import java.util.List;

/** Search ist eine Klasse, die mehrere statische Funktionen für die Suche
 *  nach Elementen in einer Liste enthält.
 */
public class Search {

    /** linear führt eine lineare Suche nach einem Element in einer Liste durch.
     * 
     * @param list Die Liste, die durchsucht werden soll.
     * @param key Der Schlüssel, nach dem gesucht werden soll.
     * @return Die Position des ersten Vorkommens von key. 
     *         Oder -1, falls key nicht vorkommt.
     */
    public static int linear(List<Integer> list, int key) {
        for (int i = 0; i<list.size(); i++) {
            if (list.get(i) == key) {
                return i;
            }
        }
        return -1;
    }

    /** binary führt eine binäre Suche nach einem Element in einer Liste durch.
     * 
     * @param list Die Liste, die durchsucht werden soll.
     * @param key Der Schlüssel, nach dem gesucht werden soll.
     * @return Die Position des ersten Vorkommens von key. 
     *         Oder -1, falls key nicht vorkommt.
     * 
     * Anmerkung: Diese Funktion kann nur für sortierte Listen ein sinnvolles Ergebnis liefern.
     */
    public static int binary(List<Integer> list, int key) {
        if (list.isEmpty()) {
            return -1;
        }
        int midpos = list.size() / 2;

        if (list.get(midpos) == key) {
            return midpos;
        }
        if (key <= list.get(midpos)) {
            return binary(list.subList(0, midpos), key);
        }
        int result = binary(list.subList(midpos+1, list.size()), key);
        return result == -1 ? -1 : result + midpos + 1;
    }
}
