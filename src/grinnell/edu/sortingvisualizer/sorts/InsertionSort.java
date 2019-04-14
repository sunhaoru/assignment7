package grinnell.edu.sortingvisualizer.sorts;

public class InsertionSort {

  public static <T extends Comparable<T>> void sort(T[] arr) {
    if (arr == null) {
      throw new IllegalStateException();
    } // if

    int pos = 1;
    T temp;
    while (pos < arr.length) {
      temp = arr[pos];
      int index = 0;

      while (index < pos && arr[index].compareTo(arr[pos]) <= 0) {
        index++;
      } // for
      for (int i = pos; i > index; i--) {
        arr[i] = arr[i - 1];
      } // for
      arr[index] = temp;
      pos++;
    } // while
  }// sort();
}// InsertionSort
