package edu.grinnell.sortingvisualizer;

/**
 * A collection of indices into a Scale object. These indices are the subject of the various sorting
 * algorithms in the program.
 */
public class NoteIndices {

  Integer[] notes;
  Boolean[] highlights;

  /**
   * @param n the size of the scale object that these indices map into
   */
  public NoteIndices(int n) {
    this.notes = new Integer[n];
    this.highlights = new Boolean[n];
    for (@SuppressWarnings("unused")
    Boolean i : highlights) {
      i = false;
    } // for
  }// Constructor

  /**
   * Reinitializes this collection of indices to map into a new scale object of the given size. The
   * collection is also shuffled to provide an initial starting point for the sorting process.
   * 
   * @param n the size of the scale object that these indices map into
   */
  public void initializeAndShuffle(int n) {
    // TODO: fill me in
  }

  /** @return the indices of this NoteIndices object */
  public Integer[] getNotes() {
    return this.notes;
  }// getNotes()

  /**
   * Highlights the given index of the note array
   * 
   * @param index the index to highlight
   */
  public void highlightNote(int index) {
    highlights[index] = true;
  }// highlightNote()

  /** @return true if the given index is highlighted */
  public boolean isHighlighted(int index) {
    return highlights[index];
  }// isHighlighted()

  /** Clears all highlighted indices from this collection */
  public void clearAllHighlighted() {
    for (@SuppressWarnings("unused")
    Boolean i : highlights) {
      i = false;
    } // for
  }// clearAllHighlighted()
}
