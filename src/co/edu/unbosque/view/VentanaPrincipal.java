package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {


    public VentanaPrincipal() {
        setTitle("Casa de Apuestas");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout(10, 10));
        inicializarComponentes();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void inicializarComponentes() {
    }


}
