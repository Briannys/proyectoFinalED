package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

public class PanelEliminarFilm extends JPanel {

    private JLabel[] labels;
    private JTextField[] textFields;
    private JButton[] buttons;

    public PanelEliminarFilm() {
        setLayout(null);
        setVisible(false);
        setBackground(new Color(157, 205, 90));
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        labels = new JLabel[2];
        iniciarLabelTexto(0, "Eliminar film por id:", 5, 10, 30, 400, 25, Color.white);
        iniciarLabelTexto(1, "Ingrese id para eliminar el film: ", 95, 90, 23, 400, 17, Color.black);


        textFields = new JTextField[1];
        iniciarTextArea(0, 360, 90, 23, 200);


        buttons = new JButton[2];
        inicializarBotones(buttons, "ELIMINAR", 0, "Eliminar", 610, 80, 150, 40,
                Color.WHITE, new Color(24, 34, 51), new Color(24, 34, 51), 17, true, true);
        inicializarBotones(buttons, "VOlVER_AÑO", 1, "Volver", 360, 600, 150, 40,
                Color.WHITE, new Color(24, 34, 51), new Color(24, 34, 51), 17, true, true);


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


    public boolean verficarDatos() {
        if (!textFields[0].getText().isEmpty() && esNumero(textFields[0].getText())) {
            return true;
        } else {
            return false;
        }
    }

    public int capturarId() {
        return Integer.parseInt(textFields[0].getText());
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
