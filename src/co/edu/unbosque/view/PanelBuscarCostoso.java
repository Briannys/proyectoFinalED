package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

public class PanelBuscarCostoso extends JPanel {

    private JLabel[] labels;
    private JTextField[] textFields;
    private JButton[] buttons;
    private JTable table;
    private JScrollPane sp;

    public PanelBuscarCostoso() {
        setLayout(null);
        setVisible(false);
        setBackground(new Color(157, 205, 90));
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        labels = new JLabel[2];
        iniciarLabelTexto(0, "Buscar ejemplar mas costoso:", 5, 10, 30, 600, 25, Color.white);
        iniciarLabelTexto(1, "Ingrese genero para el filtro: ", 95, 90, 23, 400, 17, Color.black);


        textFields = new JTextField[1];
        iniciarTextArea(0, 340, 90, 23, 200);


        buttons = new JButton[2];
        inicializarBotones(buttons, "BUSQUEDA_COST", 0, "Buscar", 610, 80, 150, 40,
                Color.WHITE, new Color(24, 34, 51), new Color(24, 34, 51), 17, true, true);
        inicializarBotones(buttons, "VOlVER_AÑO", 1, "Volver", 360, 600, 150, 40,
                Color.WHITE, new Color(24, 34, 51), new Color(24, 34, 51), 17, true, true);

        table = new JTable();
        table.setBounds(10, 170, 860, 420);
        sp = new JScrollPane(table);
        sp.setBounds(10, 170, 860, 420);
        sp.setVisible(false);
        add(sp);

    }

    public void iniciarLabelTexto(int pos, String texto, int x, int y, int alto, int ancho, int tamañoLetra, Color colorLetra) {
        labels[pos] = new JLabel(texto);
        labels[pos].setBounds(x, y, ancho, alto);
        labels[pos].setFont(new Font("Century Gothic", Font.PLAIN, tamañoLetra));
        labels[pos].setForeground(colorLetra);
        add(labels[pos]);
    }


    public JButton devolverBoton(int pos) {
        return buttons[pos];
    }

    public void inicializarBotones(JButton[] bot, String command, int pos, String name, int x, int y, int xB,
                                   int yB, Color color, Color color2, Color letra, int tamaño, boolean visible, boolean enable) {
        bot[pos] = new JButton(name);
        bot[pos].setBackground(color);
        bot[pos].setActionCommand(command);
        bot[pos].setEnabled(enable);
        bot[pos].setVisible(visible);
        bot[pos].setBorder(null);
        bot[pos].setCursor(new Cursor(Cursor.HAND_CURSOR));
        bot[pos].setBounds(x, y, xB, yB);
        bot[pos].setForeground(letra);
        bot[pos].setFont(new Font("Century Gothic", Font.PLAIN, tamaño));
        MouseListener ml = new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setBackground(color2);
                c.setForeground(color);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                Component c = evt.getComponent();
                c.setBackground(color);
                c.setForeground(color2);
            }
        };
        bot[pos].addMouseListener(ml);
        add(bot[pos]);
    }

    public void iniciarTextArea(int pos, int x, int y, int alto, int ancho) {
        textFields[pos] = new JTextField();
        textFields[pos].setBounds(x, y, ancho, alto);
        add(textFields[pos]);
    }

    public void verTabla(String[][] matriz, String[] headder) {
        DefaultTableModel model = new DefaultTableModel(matriz, headder);
        table.setModel(model);
        sp.setVisible(true);
        devolverBoton(1).setVisible(true);
    }

    public boolean verficarDatos() {
        if (!textFields[0].getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public String capturarGenero() {
        return textFields[0].getText();
    }

    public JTable getTable() {
        return table;
    }

    public JScrollPane getSp() {
        return sp;
    }

    private boolean esNumero(String m) {
        try {
            Integer.parseInt(m);
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("Entrada invalida.");
            return false;
        }
    }

}
