package grinnell.edu.sortingvisualizer.sorts;

public class SelectionSort {
  public static <T extends Comparable<T>> void sort(T[] arr) {
    if (arr == null) {
      throw new IllegalStateException();
    } // if

    for (int i = 0; i < arr.length; i++) {
      int j = i;
      int index = i;
      while (j < arr.length) {
        if (arr[j].compareTo(arr[index]) <= 0) {
          index = j;
        } // if
        j++;
      } // while
      swap(arr, i, index);
    } // for
  }// sort();

  public static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }// swap();

}// SelectionSort
