package edu.grinnell.sortingvisualizer.audio;

import java.util.*;

// Citation: https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array

/**
 * A collection of indices into a Scale object. These indices are the subject of the various sorting
 * algorithms in the program.
 */
public class NoteIndices {

  public Integer[] notes;
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
    // Reinitialize with give size n
    this.notes = new Integer[n];
    this.highlights = new Boolean[n];
    for (int i = 0; i < n; i++) {
      highlights[i] = false;
    } // for
    // Map the values
    for (int i = 0; i < n; i++) {
      this.notes[i] = i;
    } // for
    // Shuffle
    shuffleArray(this.notes);
  }// initializeAndShuffle

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

  /**
   * shuffleArray
   * 
   * @author Dan Bray
   * @param notes2
   */
  private static void shuffleArray(Integer[] notes) {
    int index, temp;
    Random random = new Random();
    for (int i = notes.length - 1; i > 0; i--) {
      index = random.nextInt(i + 1);
      temp = notes[index];
      notes[index] = notes[i];
      notes[i] = temp;
    } // for
  }// shuffleArray
}
