package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class CompareEvent<T> implements SortEvent<T> {

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+
  int i;
  int j;
  List<Integer> indices = new ArrayList<Integer>();

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+
  public CompareEvent(int pos1, int pos2) {
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
   * @return false
   */
  @Override
  public boolean isEmphasized() {
    return false;
  }// isEmphasized()

  /**
   * apply does nothing
   * 
   * @param arr
   */
  @Override
  public void apply(T[] arr) {}// apply()

}
