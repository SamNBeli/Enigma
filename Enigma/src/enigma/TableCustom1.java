package enigma;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class TableCustom1 extends JLabel implements TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public TableCustom1() {
	
	setForeground(Color.blue);
	setHorizontalAlignment(JLabel.CENTER);
	}

	
	  public Component getTableCellRendererComponent(JTable table, Object value, 
		      boolean isSelected, boolean hasFocus, int row, int column) {
		  setText(value.toString());
		  return this;
	}

}
