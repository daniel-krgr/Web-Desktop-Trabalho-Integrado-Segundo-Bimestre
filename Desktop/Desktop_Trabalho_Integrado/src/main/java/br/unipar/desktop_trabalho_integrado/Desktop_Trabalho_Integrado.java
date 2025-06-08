/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.unipar.desktop_trabalho_integrado;

import javax.swing.JFrame;
import view.ViewPrincipal;

/**
 *
 * @author Daniel
 */
public class Desktop_Trabalho_Integrado {

    public static void main(String[] args) {

        ViewPrincipal view = new ViewPrincipal();
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        view.setVisible(true);
        
    }
}
