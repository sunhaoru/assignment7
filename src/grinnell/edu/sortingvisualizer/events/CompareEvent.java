package grinnell.edu.sortingvisualizer.events;

import java.util.ArrayList;
import java.util.List;

public class CompareEvent<T> implements SortEvent<T> {

  T[] arr;

  @Override
  public List<Integer> getAffectedIndices() {
    List<Integer> val = new ArrayList<Integer>();

    return val;
  }

  @Override
  public boolean isEmphasized() {
    return false;
  }

  @Override
  public void apply(ArrayList<T> l) {
    // TODO Auto-generated method stub

  }

}
