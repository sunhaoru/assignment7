package grinnell.edu.sortingvisualizer.sorts;

public class MergeSort {
 static Object[] spare;
  
  public static <T extends Comparable<T>> void sort(T[] values) {
    spare = new Object[values.length];
    mergeSortHelper(values, 0, values.length);
  } // sort(T[] values)
 
  public static <T extends Comparable<T>> void mergeSortHelper(T[] values, int lb, int ub) {
    if (ub - lb <= 1) {
      return;
    }
    int mid = lb + (ub - lb)/2;
    mergeSortHelper(values, lb, mid);
    mergeSortHelper(values, mid, ub);
    merge(values, lb, mid, ub);
  } // mergeSortHelper()
 
  @SuppressWarnings("unchecked")
  public static <T extends Comparable<T>> void merge(T[] values, int lb, int mid, int ub) {
    int i = lb;
    int j = mid;
    int k = lb;
    while ((i < mid) && (j < ub)) {
      if (values[i].compareTo(values[j]) <= 0) {
        spare[k++] = values[i];
        i++;
      }
      else {
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
      values[k] = (T) spare[k];
    } // for
  } // merge
}
