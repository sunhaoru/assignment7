package grinnell.edu.sortingvisualizer.sorts;

// Citation
// Haorui's makeup 01 problem 2

public class QuickSort {
  /**
   * Sort an array of integers in place, using Quicksort w/DNF.
   */
  public static <T extends Comparable<T>> void sort(T[] values) {
    sort(values, 0, values.length);
  } // sort()

  /**
   * Sort the subarray of values between lb (inclusive) and ub (exclusive) using Quicksort w/DNF
   */
  private static <T extends Comparable<T>> void sort(T[] values, int lb, int ub) {
    // Special case: 0 or 1 elements
    if (ub - lb <= 1) {
      return;
    } // if zero or one elements

    // Prepare bounds for DNF
    int mid = lb + (ub - lb) / 2; // The mid of the array
    int r = lb; // The end of the red/small section
    int w = lb; // The end of the white/equal section
    int b = ub; // The start of the blue/greater section
    T pivot = values[mid];// The pivot of the array

    // Rearrange the values
    while ((w < b)) {
      if (values[w].compareTo(pivot) > 0) {
        swap(values, w, b - 1);
        b--;
      } // if
      else if (values[w].compareTo(pivot) == 0) {
        w++;
      } // else if
      else {
        swap(values, r++, w++);
      } // else

    } // while

    // Recurse
    sort(values, lb, r);
    sort(values, b, ub);
  } // sort()

  /**
   * Swap the elements at positions i and j.
   */
  private static <T extends Comparable<T>> void swap(T[] values, int i, int j) {
    T tmp = values[i];
    values[i] = values[j];
    values[j] = tmp;
  } // swap()
}// QuickSort
