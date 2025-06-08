/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.ItemVenda;
import model.Venda;

/**
 *
 * @author mateu
 */
public class VendaDAO {
   
    private Connection conn;

    public VendaDAO() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:pdv.db");
    }

    public int salvar(Venda venda) throws SQLException {
        String sql = "INSERT INTO venda (cliente_nome, observacao, total, data) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, venda.getCliente().getNome());
        stmt.setString(2, venda.getObservacao());
        stmt.setDouble(3, venda.getTotal());
        stmt.setString(4, java.time.LocalDate.now().toString());
        stmt.executeUpdate();

        ResultSet generatedKeys = stmt.getGeneratedKeys();
        int vendaId = 0;
        if (generatedKeys.next()) {
            vendaId = generatedKeys.getInt(1);
        }

        stmt.close();


        ItemVendaDAO itemDAO = new ItemVendaDAO();
        for (ItemVenda item : venda.getItens()) {
            itemDAO.salvar(item, vendaId);
        }

        return vendaId;
    }
}
