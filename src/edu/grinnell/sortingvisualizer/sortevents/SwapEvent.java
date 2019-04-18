package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class SwapEvent<T> implements SortEvent<T> {

  int i;
  int j;
  List<Integer> indices;

  public SwapEvent(int pos1, int pos2) {
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
    return true;
  }// isEmphasized()

  /**
   * apply swaps the values at i and j positions in l
   * 
   * @param l ArrayList
   */
  public void apply(T[] arr) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }// apply()

}
