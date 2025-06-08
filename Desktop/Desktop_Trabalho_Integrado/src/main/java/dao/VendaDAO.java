/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.ItemVenda;
import model.Venda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class VendaDAO extends GenericDAO<Venda>{


    @Override
    protected Venda construirObjeto(ResultSet rs) {
        Venda venda = null;
        try {
            venda = new Venda();
            venda.setId(rs.getInt("id"));
            venda.setObservacoes(rs.getString("observacoes"));
            venda.setValorTotal(rs.getDouble("valor_total"));
            venda.setClienteId(rs.getLong("cliente_id"));
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return venda;
    }


    @Override
    public boolean salvar(Venda venda) {
        String sql = "INSERT INTO public.venda (observacoes, valor_total, cliente_id) VALUES (?, ?, ?)";

        try (var ps = conn.prepareStatement(sql)) {
            ps.setString(1, venda.getObservacoes());
            ps.setDouble(2, venda.getValorTotal());
            ps.setLong(3, venda.getClienteId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }



    @Override
    public boolean atualizar(Venda obj) {
        return false;
    }
}
