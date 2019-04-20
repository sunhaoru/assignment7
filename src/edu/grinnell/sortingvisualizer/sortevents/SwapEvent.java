package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class SwapEvent<T> implements SortEvent<T> {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  int i;
  int j;
  List<Integer> indices = new ArrayList<Integer>();

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  public SwapEvent(int pos1, int pos2) {
    this.i = pos1;
    this.j = pos2;
  }// Constructor

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * getAffectedIndices
   * 
   * @return indices that are affected
   */
  @Override
  public List<Integer> getAffectedIndices() {
    this.indices.add(this.i);
    this.indices.add(this.j);
    return this.indices;
  }// getAffectedIndices()

  /**
   * @return true
   */
  @Override
  public boolean isEmphasized() {
    return true;
  }// isEmphasized()

  /**
   * apply swaps the values at i and j positions in l
   * 
   * @param arr
   */
  public void apply(T[] arr) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }// apply()

}
