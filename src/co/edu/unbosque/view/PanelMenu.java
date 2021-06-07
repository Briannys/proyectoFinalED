package co.edu.unbosque.view;

import sun.swing.CachedPainter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

public class PanelMenu extends JPanel {

    private JLabel fondo;
    private JLabel[] labels;
    private JButton[] buttons;

    public PanelMenu() {
        setLayout(null);
        setVisible(false);
        setBackground(Color.green);
        inicializarComponentes();
    }

    private void inicializarComponentes() {

        buttons = new JButton[13];//Botones de la clase
        inicializarBotones(buttons, "CARGAR_DATASET", 0, "Cargar Dataset", 80, 70, 450, 60,
                new Color(24, 34, 51), Color.WHITE, Color.WHITE, 25, true, true);
        inicializarBotones(buttons, "AGREGAR_FILM", 1, "Agregar Ejemplar Film", 80, 150, 450, 60,
                new Color(24, 34, 51), Color.WHITE, Color.WHITE, 25, true, false);
        inicializarBotones(buttons, "EDITAR_FILM", 2, "Editar Informacion Film", 80, 230, 450, 60,
                new Color(24, 34, 51), Color.WHITE, Color.WHITE, 25, true, false);
        inicializarBotones(buttons, "VER_FLIMS", 3, "Ver films", 80, 310, 450, 60,
                new Color(24, 34, 51), Color.WHITE, Color.WHITE, 25, true, false);
        inicializarBotones(buttons, "BUSCAR_DEBUT", 4, "Buscar debut anual", 80, 390, 450, 60,
                new Color(24, 34, 51), Color.WHITE, Color.WHITE, 25, true, false);
        inicializarBotones(buttons, "BUSCAR_GENEROS", 5, "Buscar segun generos", 80, 470, 450, 60,
                new Color(24, 34, 51), Color.WHITE, Color.WHITE, 25, true, false);
        inicializarBotones(buttons, "MAS_OPCIONES", 6, "Mas opciones", 320, 580, 200, 60,
                Color.WHITE, new Color(24, 34, 51), new Color(24, 34, 51), 25, true, true);
        //primeras opciones
        //_____________________________________________________________________________________________________________________-
        //segundas opciones
        inicializarBotones(buttons, "BUSCAR_TITULO", 7, "Buscar a partir de titulo", 80, 70, 450, 60,
                new Color(24, 34, 51), Color.WHITE, Color.WHITE, 25, false, false);
        inicializarBotones(buttons, "ELIMINAR_FILM", 8, "Eliminar Film", 80, 150, 450, 60,
                new Color(24, 34, 51), Color.WHITE, Color.WHITE, 25, false, false);
        inicializarBotones(buttons, "MAS_COSTO", 9, "Ejemplares mas costosos", 80, 230, 450, 60,
                new Color(24, 34, 51), Color.WHITE, Color.WHITE, 25, false, false);
        inicializarBotones(buttons, "BUSCAR_CLASIFICACIONES", 10, "Buscar film por clasificaciones", 80, 310, 450, 60,
                new Color(24, 34, 51), Color.WHITE, Color.WHITE, 25, false, false);
        inicializarBotones(buttons, "BUSCAR_VERSIONES", 11, "Buscar film por versiones", 80, 390, 450, 60,
                new Color(24, 34, 51), Color.WHITE, Color.WHITE, 25, false, false);

        inicializarBotones(buttons, "VOLVER", 12, "Volver", 60, 550, 200, 60,
                Color.WHITE, new Color(24, 34, 51), new Color(24, 34, 51), 25, false, false);

        //gif de flechitas
        labels = new JLabel[7];
        devolverImagenLabel(labels, "flecha", "gif", 50, 50, 0, 15, 70, 50, 50);
        devolverImagenLabel(labels, "flecha", "gif", 50, 50, 1, 15, 150, 50, 50);
        devolverImagenLabel(labels, "flecha", "gif", 50, 50, 2, 15, 230, 50, 50);
        devolverImagenLabel(labels, "flecha", "gif", 50, 50, 3, 15, 310, 50, 50);
        devolverImagenLabel(labels, "flecha", "gif", 50, 50, 4, 15, 390, 50, 50);
        devolverImagenLabel(labels, "flecha", "gif", 50, 50, 5, 15, 470, 50, 50);


        fondo = new JLabel();
        devolverImagenLabel("menu", "png", 900, 700, fondo);
        fondo.setBounds(0, 0, 900, 700);
        add(fondo);
    }

    public JLabel devolverLabel(int pos) {
        return labels[pos];
    }


    public void devolverImagenLabel(String src, String tipo, int escalax, int escalay, JLabel b) {
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/images/" + src + "." + tipo));
        ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
        b.setIcon(icon);
    }

    public void devolverImagenLabel(JLabel[] lab, String src, String tipo, int escalax, int escalay, int b, int x,
                                    int y, int xB, int yB) {
        lab[b] = new JLabel();
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/images/" + src + "." + tipo));
        ImageIcon icon = new ImageIcon(imagen1.getImage().getScaledInstance(escalax, escalay, Image.SCALE_DEFAULT));
        lab[b].setIcon(icon);
        lab[b].setBounds(x, y, xB, yB);
        add(lab[b]);
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

    public void moreOptions() {
        for (int i = 0; i < buttons.length; i++) {
            if (i < 7) {
                buttons[i].setVisible(false);
            } else {
                buttons[i].setVisible(true);
            }
        }
        devolverLabel(5).setVisible(false);
        repaint();
    }

    public void volver() {
        for (int i = 0; i < buttons.length; i++) {
            if (i < 7) {
                buttons[i].setVisible(true);
            } else {
                buttons[i].setVisible(false);
            }
        }
        devolverLabel(5).setVisible(true);
        repaint();
    }

    public void activarBotonesMenu() {
        for (int i = 0; i < buttons.length; i++) {
            if (i > 0) {
                buttons[i].setEnabled(true);
            } else {
                buttons[0].setEnabled(false);
            }
        }
        repaint();
    }


}
