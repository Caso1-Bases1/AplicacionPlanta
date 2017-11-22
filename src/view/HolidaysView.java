package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.HolidayModel;

public class HolidaysView extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = -2168743995844931403L;
    private JTable table;

    /**
     * Create the panel.
     */
    public HolidaysView() {
        this.setLayout(null);
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setFillsViewportHeight(true);
        table.setOpaque(false);

        defaultTableModel.addColumn("Fecha");
        defaultTableModel.addColumn("Es feriado pagado");

        HolidayModel holidayModel = new HolidayModel();
        holidayModel.getAllHolidays(defaultTableModel);

        add(new JScrollPane(table)).setBounds(0, 0, 450, 300);
        repaint();
        updateUI();
    }
}
