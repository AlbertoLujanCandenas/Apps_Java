package util;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Descripcion: Un renderizador de celdas de un JTable que pone un jLabel en
 * cada una de las celdas para que se pueda poner un icono/imagen
 */

@SuppressWarnings("serial")
public class IconCellRenderer extends DefaultTableCellRenderer {
	/**
	 * Aqui redefinimos como se muestra, vemos que ahora lo forzamos a trabajar con
	 * JLabel, pero si no lo es, por ejemplo un String llamamos al super y lo escribe tambien
	 */
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		if (value instanceof JLabel) {
			JLabel label = (JLabel) value;
			label.setOpaque(true);
			fillColor(table, label, isSelected);
			return label;
		} else {
			return super.getTableCellRendererComponent(table, value,
					isSelected, hasFocus, row, column);
		}
	}

	/**
	 * Este metodo es para que pinte el fondo del JLabel cuando lo seleccionamos
	 * para que no quede en blanco, desentonando con el resto de las celdas que
	 * no son JLabel
	 */
	public void fillColor(JTable t, JLabel l, boolean isSelected) {
		if (isSelected) {
			l.setBackground(t.getSelectionBackground());
			l.setForeground(t.getSelectionForeground());
		} else {
			l.setBackground(t.getBackground());
			l.setForeground(t.getForeground());
		}
	}
}