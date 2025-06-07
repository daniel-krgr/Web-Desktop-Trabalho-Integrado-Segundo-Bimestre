/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.ItemVenda;

/**
 *
 * @author mateu
 */
public class ItemVendaDAO {
 
     private Connection conn;

    public ItemVendaDAO() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:pdv.db");
    }

    public void salvar(ItemVenda item, int vendaId) throws SQLException {
        String sql = "INSERT INTO item_venda (venda_id, produto_nome, quantidade, subtotal) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, vendaId);
        stmt.setString(2, item.getProduto().getNome());
        stmt.setInt(3, item.getQuantidade());
        stmt.setDouble(4, item.getSubtotal());
        stmt.executeUpdate();
        stmt.close();
    }
}
