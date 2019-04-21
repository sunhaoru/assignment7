package edu.grinnell.sortingvisualizer.sorts;

// Citation: Sam's makeup exam01, problem 2.

import org.junit.Test;
import edu.grinnell.sortingvisualizer.sortevents.SortEvent;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


/**
 * Some quick experiments with our sorting methods.
 *
 * @author Samuel A. Rebelsky
 * @author Haorui Sun
 */
public class SortsTest {
  // +-----------+---------------------------------------------------
  // | Utilities |
  // +-----------+

  /**
   * Test all types of sort algorithms, given an expected result and an input array.
   */
  void checkQuicksort(Integer expected[], Integer[] values) {
    String[] sortName = new String[] {"bubble", "insertion", "merge", "quick", "selection"};
    for (int i = 0; i < sortName.length; i++) {
      switch (sortName[i]) {
        case "bubble":
          Integer[] bubble_copy = values.clone();
          List<SortEvent<Integer>> b_events = Sorts.bubbleSort(values);
          Sorts.eventSort(bubble_copy, b_events);
          assertArrayEquals(expected, values);
          assertArrayEquals(expected, bubble_copy);
          break;
        case "insertion":
          Integer[] insertion_copy = values.clone();
          List<SortEvent<Integer>> i_events = Sorts.insertionSort(values);
          Sorts.eventSort(insertion_copy, i_events);
          assertArrayEquals(expected, values);
          assertArrayEquals(expected, insertion_copy);
          break;
        case "merge":
          Integer[] merge_copy = values.clone();
          List<SortEvent<Integer>> m_events = Sorts.mergeSort(values);
          Sorts.eventSort(merge_copy, m_events);
          assertArrayEquals(expected, values);
          assertArrayEquals(expected, merge_copy);
          break;
        case "quick":
          Integer[] quick_copy = values.clone();
          List<SortEvent<Integer>> q_events = Sorts.quickSort(values);
          Sorts.eventSort(quick_copy, q_events);
          assertArrayEquals(expected, values);
          assertArrayEquals(expected, quick_copy);
          break;
        case "selection":
          Integer[] selection_copy = values.clone();
          List<SortEvent<Integer>> s_events = Sorts.selectionSort(values);
          Sorts.eventSort(selection_copy, s_events);
          assertArrayEquals(expected, values);
          assertArrayEquals(expected, selection_copy);
          break;
        default:
      }// switch case
    } // for
  } // checkQuicksort

  /**
   * Permute an already sorted array,
   */
  void checkQuicksort(Integer[] sorted) {
    Integer[] copy = sorted.clone();
    TestUtils.randomlyPermute(copy);
    checkQuicksort(sorted, copy);
  } // checkQuicksort

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+


  @Test
  public void testEmpty() {
    Integer[] values = new Integer[0];
    checkQuicksort(values);
  } // testEmpty

  @Test
  public void testOrdered() {
    for (int size = 1; size < 20; size++) {
      Integer[] sorted = new Integer[size];
      for (int i = 0; i < size; i++) {
        sorted[i] = i;
      } // for checkQuicksort(sorted,
      sorted.clone();
    } // for
  } // testOrdered


  @Test
  public void testBackwards() {
    for (int size = 1; size < 20; size++) {
      Integer[] sorted = new Integer[size];
      Integer[] backwards = new Integer[size];
      for (int i = 0; i < size; i++) {
        backwards[i] = size - i;
        sorted[i] = i + 1;
      } // for checkQuicksort(sorted, backwards);
    } // for
  } // testBackwards

  @Test
  public void testRandom() {
    for (int trials = 0; trials < 5; trials++) {
      // Some comparatively small ones
      for (int size = 1; size < 20; size++) {
        checkQuicksort(TestUtils.randomInts(size));
      } // for size
      // Some larger ones
      for (int size = 30; size < 1000; size = size * 2 + 1) {
        checkQuicksort(TestUtils.randomInts(size));
      } // for size
    } // for trials
  } // testRandom()
}

