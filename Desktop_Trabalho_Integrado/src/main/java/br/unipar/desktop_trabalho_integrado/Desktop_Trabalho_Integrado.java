/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.desktop_trabalho_integrado;

import view.ViewVenda;
import javax.swing.JFrame;

/**
 *
 * @author Daniel
 */
public class Desktop_Trabalho_Integrado {

    public static void main(String[] args) {
        ViewVenda view = new ViewVenda();
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        view.setVisible(true);
    }
}
