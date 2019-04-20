package edu.grinnell.sortingvisualizer.sorts;

import java.util.ArrayList;
import java.util.List;
import edu.grinnell.sortingvisualizer.sortevents.CompareEvent;
import edu.grinnell.sortingvisualizer.sortevents.CopyEvent;
import edu.grinnell.sortingvisualizer.sortevents.SortEvent;
import edu.grinnell.sortingvisualizer.sortevents.SwapEvent;

public class Sorts {

  // +-----------+---------------------------------------------------------
  // | eventSort |
  // +-----------+
  /**
   * sortEvent
   * 
   * @param l
   * @param events
   */
  @SuppressWarnings("unchecked")
  public static <T> void eventSort(T[] arr, List<SortEvent<T>> events) {
    for (@SuppressWarnings("rawtypes")
    SortEvent event : events) {
      event.apply(arr);
    } // for()
  }// sortEvent()

  // +------------+---------------------------------------------------------
  // | bubbleSort |
  // +------------+
  /**
   * bubbleSort
   * 
   * @param arr
   * @return events
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static <T extends Comparable<T>> List<SortEvent<T>> bubbleSort(T[] arr) {
    if (arr == null) {
      throw new IllegalStateException();
    } // if

    List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
    for (int i = arr.length - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        events.add(new CompareEvent(j, j + 1));
        if (arr[j].compareTo(arr[j + 1]) > 0) {
          events.add(new SwapEvent(j, j + 1));
          swap(arr, j + 1, j);
        }
      } // for (j)
    } // for (i)
    return events;
  }// bubbleSort()

  // +---------------+-------------------------------------------------------
  // | insertionSort |
  // +---------------+
  /**
   * insertionSort
   * 
   * @param arr
   * @return
   */
  @SuppressWarnings({"rawtypes", "unchecked"})
  public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(T[] arr) {
    if (arr == null) {
      throw new IllegalStateException();
    } // if
    List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
    for (int i = 1; i < arr.length; i++) {
      T temp = arr[i];
      int min_pos = i;
      for (int j = i - 1; j >= 0; j--) {
        if (arr[i].compareTo(arr[j]) < 0) {
          events.add(new CompareEvent(j, i));
          min_pos = j;
        } // if
      } // for
      for (int k = i; k > min_pos; k--) {
        arr[k] = arr[k - 1];
        T value = arr[k - 1];
        events.add(new CopyEvent(value, k));
      } // for
      arr[min_pos] = temp;
      events.add(new CopyEvent(temp, min_pos));
    } // for
    return events;
  }// insertionSort();

  // +---------------+-------------------------------------------------------
  // | selectionSort |
  // +---------------+
  /**
   * selectionSort
   * 
   * @param arr
   * @return events
   */
  @SuppressWarnings({"rawtypes", "unchecked"})
  public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(T[] arr) {
    if (arr == null) {
      throw new IllegalStateException();
    } // if

    List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
    for (int i = 0; i < arr.length; i++) {
      int j = i + 1;
      int index = i;
      while (j < arr.length) {
        if (arr[j].compareTo(arr[index]) <= 0) {
          events.add(new CompareEvent(j, index));
          index = j;
        } // if
        j++;
      } // while
      swap(arr, i, index);
      events.add(new SwapEvent(index, i));
    } // for
    return events;
  }// selectionSort();

  // +-----------+-----------------------------------------------------------
  // | quickSort |
  // +-----------+
  /**
   * quickSort
   * 
   * @param values
   * @return events
   */
  public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] values) {
    List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
    quickSortHelper(values, 0, values.length, events);
    return events;
  } // quickSort()

  /**
   * Sort the subarray of values between lb (inclusive) and ub (exclusive) using Quicksort w/DNF
   */
  @SuppressWarnings({"rawtypes", "unchecked"})
  private static <T extends Comparable<T>> void quickSortHelper(T[] values, int lb, int ub,
      List<SortEvent<T>> events) {
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
        events.add(new CompareEvent(w, mid));
        swap(values, w, b - 1);
        events.add(new SwapEvent(w, b - 1));
        b--;
      } // if
      else if (values[w].compareTo(pivot) == 0) {
        events.add(new CompareEvent(w, mid));
        w++;
      } // else if
      else {
        events.add(new SwapEvent(r, w));
        swap(values, r++, w++);
      } // else

    } // while

    // Recurse
    quickSortHelper(values, lb, r, events);
    quickSortHelper(values, b, ub, events);
  } // quickSortHelper()

  // +-----------+-----------------------------------------------------------
  // | mergeSort |
  // +-----------+
  /**
   * mergeSort
   * 
   * @param values
   * @return events
   */
  public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(T[] values) {
    List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
    mergeSortHelper(values, 0, values.length, events);
    return events;
  } // mergeSort(T[] values)

  public static <T extends Comparable<T>> void mergeSortHelper(T[] values, int lb, int ub,
      List<SortEvent<T>> events) {
    if (ub - lb <= 1) {
      return;
    }
    int mid = lb + (ub - lb) / 2;
    mergeSortHelper(values, lb, mid, events);
    mergeSortHelper(values, mid, ub, events);
    merge(values, lb, mid, ub, events);
  } // mergeSortHelper()

  @SuppressWarnings({"rawtypes", "unchecked"})
  public static <T extends Comparable<T>> List<SortEvent<T>> merge(T[] values, int lb, int mid,
      int ub, List<SortEvent<T>> events) {
    T[] spare = values.clone();
    int i = lb;
    int j = mid;
    int k = lb;
    while ((i < mid) && (j < ub)) {
      if (values[i].compareTo(values[j]) <= 0) {
        events.add(new CompareEvent(i, j));
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
      values[k] = (T) spare[k];
      events.add(new CopyEvent(spare[k], k));
    } // for
    return events;
  } // merge



  // +--------+-----------------------------------------------------------
  // | helper |
  // +--------+
  /**
   * swap
   * 
   * @param arr
   * @param i
   * @param j
   */
  public static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }// swap();
}
