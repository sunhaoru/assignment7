package grinnell.edu.sortingvisualizer.sorts;

import java.util.Arrays;

public class SamNotes {
  static int[] spare;

  public static void mergeSort(int[] values) {
    spare = new int[values.length];
    mergeSortHelper(values, 0, values.length);
  } // mergeSort(int[])

  public static void mergeSortHelper(int[] values, int lb, int ub) {
    if (ub - lb <= 1) {
      return;
    }
    int mid = lb + (ub - lb) / 2;
    mergeSortHelper(values, lb, mid);
    mergeSortHelper(values, mid, ub);
    merge(values, lb, mid, ub);
  } // mergeSort(int[], int, int)

  public static void merge(int[] values, int lb, int mid, int ub) {
    int i = lb;
    int j = mid;
    int k = lb;
    while ((i < mid) && (j < ub)) {
      if (values[i] < values[j]) {
        spare[k++] = values[i];
        i++;
      } else {
        spare[k++] = values[j];
        ++j;
      }
    } // while
    while (i < mid) {
      spare[k++] = values[i];
      i++;
    } // while i
    while (j < ub) {
      spare[k++] = values[j];
      j++;
    } // while j

    for (k = lb; k < ub; k++) {
      values[k] = spare[k];
    } // for
  } // merge

  public static void main(String[] args) {
    int[] values = {3, 1, 8, 4, 5, 2, 6, 7};
    mergeSort(values);
    System.out.println(Arrays.toString(values));
  } // main
}
