package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class CopyEvent<T> implements SortEvent<T> {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  int pos;
  T val;
  List<Integer> indices = new ArrayList<Integer>();

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  public CopyEvent(T value, int index) {
    this.pos = index;
    this.val = value;
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
    this.indices.add(this.pos);
    return this.indices;
  }// getAffectedIndices

  /**
   * @return true
   */
  @Override
  public boolean isEmphasized() {
    return true;
  }// isEmphasized

  /**
   * apply performs the copy of the recorded value into the list.
   * 
   * @param arr
   */
  public void apply(T[] arr) {
    arr[this.pos] = this.val;
  }// apply

}
