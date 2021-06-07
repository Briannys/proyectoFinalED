package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

public class PanelBuscarDebut extends JPanel {

    private JLabel[] labels;
    private JTextField[] textFields;
    private JButton[] buttons;
    private JTable table;
    private JScrollPane sp;

    public PanelBuscarDebut() {
        setLayout(null);
        setVisible(false);
        setBackground(new Color(157, 205, 90));
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        labels = new JLabel[3];
        iniciarLabelTexto(0, "Buscar film por año:", 5, 10, 30, 300, 25, Color.white);
        iniciarLabelTexto(1, "Ingrese año inicio del filtro: ", 15, 90, 23, 400, 17, Color.black);
        iniciarLabelTexto(2, "Ingrese año final del filtro : ", 440, 90, 23, 400, 17, Color.black);

        textFields = new JTextField[2];
        iniciarTextArea(0, 240, 90, 23, 150);
        iniciarTextArea(1, 662, 90, 23, 150);

        buttons = new JButton[2];
        inicializarBotones(buttons, "BUSQUEDA_AÑO", 0, "Buscar", 360, 140, 150, 40,
                Color.WHITE, new Color(24, 34, 51), new Color(24, 34, 51), 17, true, true);
        inicializarBotones(buttons, "VOlVER_AÑO", 1, "Volver", 360, 600, 150, 40,
                Color.WHITE, new Color(24, 34, 51), new Color(24, 34, 51), 17, false, true);

        table = new JTable();
        table.setBounds(10, 190, 800, 400);
        sp = new JScrollPane(table);
        sp.setBounds(10, 190, 860, 400);
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

    public void verTabla() {
        sp.setVisible(true);
    }

    public boolean verficarDatos() {
        if (!textFields[0].getText().isEmpty() && !textFields[1].getText().isEmpty() &&
                esNumero(textFields[0].getText()) && esNumero(textFields[1].getText())) {
            return true;
        } else {
            return false;
        }
    }

    public Integer[] capturarAños() {
        Integer[] temp = {Integer.parseInt(textFields[0].getText()), Integer.parseInt(textFields[1].getText())};
        return temp;
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
