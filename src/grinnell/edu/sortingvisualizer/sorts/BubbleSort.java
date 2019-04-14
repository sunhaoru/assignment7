package grinnell.edu.sortingvisualizer.sorts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import grinnell.edu.sortingvisualizer.events.SortEvent;

public class BubbleSort<T> {
  public static <T extends Comparable<T>> void sort(T[] arr) {
    if (arr == null) {
      throw new IllegalStateException();
    } // if

    for (int i = arr.length - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (arr[j].compareTo(arr[j + 1]) < 0) {
          swap(arr, j, j + 1);
        }
      } // for (j)
    } // for (i)
  }// sort();

  public static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }// swap();

  public void sortEvent(ArrayList<T> l, List<SortEvent<T>> events) {
    @SuppressWarnings("unchecked")
    Iterator<T> il = (Iterator<T>) events.iterator();
    while (il.hasNext()) {
      ((SortEvent<T>) il.next()).apply(l);
    }
  }
}
