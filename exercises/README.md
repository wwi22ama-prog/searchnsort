# Aufgaben zu Such- und Sortierverfahren

## Aufgaben zu Suchverfahren

1. In den Tests zu den Beispielen wird für die lineare Suche gefordert,
   dass bei mehreren Vorkommen eines Schlüssels als Ergebnis die Position des ersten Vorkommens geliefert wird.
   Für die binäre Suche wird dies jedoch nicht gefordert und die Beispielimplementierung leistet das auch nicht.

   **Aufgabe:**
   Ändern Sie die Implementierung der binären Suche so ab, dass auch sie bei mehreren Vorkommen eines Schlüssels
   den ersten dieser Schlüssel liefert.
   Hier im Übungs-Modul sind die Implementierungen der Suchen aus den Beispielen sowie
   entsprechend abgeänderte Tests wieder vorgegeben.

## Aufgaben zu Sortierverfahren

1. Schreiben Sie eine Funktion `partition`.
   Diese erwartet eine Liste `list` und eine Zahl `n`.
   Sie sortiert die Elemente der Liste so um, dass zuerst alle Elemente kommen,
   die kleiner als n sind und danach alle Elemente, die größer sind.

   *Hinweis:* Ein möglicher Ansatz ist der Vorbereitungsteil aus dem QuickSort-Beispiel.
   Idealerweise arbeitet `partition` aber in-place, also ohne Hilfsliste.

   Um `partition` in-place zu implementieren,
   können Sie zwei Positions-Marker verwenden, die vom linken und vom
   rechten Rand her aufeinander zu laufen. Immer, wenn der linke Marker auf einem Element
   steht, das größer ist als das Pivot-Element und der rechte auf einem Element steht,
   das kleiner ist, können diese beiden vertauscht werden.

1. Verbessern Sie die QuickSort-Funktion, indem Sie die obige Hilfsfunktion `partition`
   verwenden.

1. Erhöhen Sie die Codequalität, indem Sie auch die anderen Sortierverfahren "aufräumen".
   D.h. fügen Sie Hilfsfunktionen mit sprechenden Namen hinzu, die die inneren Schleifen
   oder andere Teile der Algorithmen ersetzen und besser erklären, was passiert.

1. Implementieren Sie eine Funktion `isSorted`, die eine Liste erwartet und mit
   `true` oder `false` zurückliefert, ob die Liste sortiert ist.

1. Implementieren Sie eine Funktion `sortReversed`, die eine Liste erwartet und sie
   in absteigender Reihenfolge sortiert.

## Allgemeine Aufgaben zur Definition eigener Datentypen und zum Umgang mit Listen davon

1. Implementieren Sie einen Datentyp für Einträge in einem Wörterbuch.
   Implementieren Sie auch eine Klasse für das Wörterbuch und geben Sie ihr folgende
   Methoden:

   * Hinzufügen von Elementen
   * Suche eines Elements
   * Sortieren der Elemente im Wörterbuch

   *Hinweis:* Zum Suchen und Sortieren der Elemente können Sie entweder die
   Funktionen aus den Beispielen hier im Repo anpassen oder Sie informieren sich,
   wie man mittels der Java-Standardbibliothek Listen mit eigenen Klassen als
   Elementtyp behandelt.
