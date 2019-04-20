package edu.grinnell.sortingvisualizer.rendering;

// Citation:
// https://stackoverflow.com/questions/29873878/creating-a-simple-bar-chart-in-java-reads-data-and-outputs-bar-graph

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import edu.grinnell.sortingvisualizer.audio.NoteIndices;

@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {

  private NoteIndices notes;

  /**
   * Constructs a new ArrayPanel that renders the given note indices to the screen.
   * 
   * @param notes the indices to render
   * @param width the width of the panel
   * @param height the height of the panel
   */
  public ArrayPanel(NoteIndices notes, int width, int height) {
    this.notes = notes;
    this.setPreferredSize(new Dimension(width, height));
  }// ArrayPanel()

  /**
   * Constructs a new bar graph for notes
   * 
   * @param g Graphics
   */
  @Override
  public void paintComponent(Graphics g) {
    Dimension di = this.getPreferredSize();
    g.setColor(Color.white);
    g.fillRect(0, 0, di.width, di.height);
    int len = this.notes.notes.length;
    int barWidth = di.width / len;// Calculate the width of the bar width
    // Find the maximum value of the notes
    int max = this.notes.notes[0];
    for (Integer i : this.notes.notes) {
      if (max < i) {
        max = i;
      } // if
    } // for
    for (int itemIndex = 0; itemIndex < len; itemIndex++) {
      g.setColor(new Color(100, 200, 255, 180));
      if (notes.isHighlighted(itemIndex)) {
        g.setColor(new Color(200, 50, 50, 200));
      } // if isHighlighted
      int barHight = this.notes.notes[itemIndex] * di.height / max;
      g.fillRect(itemIndex * barWidth, di.height - barHight, barWidth, barHight);
    } // for
    notes.clearAllHighlighted();
  }// paintComponent()
}

