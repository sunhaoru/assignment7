package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class CompareEvent<T> implements SortEvent<T> {

  int i;
  int j;
  List<Integer> indices;

  public CompareEvent(int pos1, int pos2) {
    this.i = pos1;
    this.j = pos2;
  }// Constructor

  @Override
  public List<Integer> getAffectedIndices() {
    this.indices.add(this.i);
    this.indices.add(this.j);
    return this.indices;
  }// getAffectedIndices()

  @Override
  public boolean isEmphasized() {
    return false;
  }// isEmphasized()

  /**
   * apply does nothing to l
   * 
   * @param l ArrayList<T>
   */
  @Override
  public void apply(T[] arr) {}// apply()

}
