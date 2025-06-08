/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.ItemVenda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class ItemVendaDAO extends GenericDAO<ItemVenda> {
    @Override
    protected ItemVenda construirObjeto(ResultSet rs) {
        ItemVenda itemVenda = new ItemVenda();

        try {
            // Assuming the ItemVenda class has a constructor that takes these parameters
            itemVenda = new ItemVenda();
            itemVenda.setId(rs.getInt("id"));
            itemVenda.setVendaId(rs.getLong("venda_id"));
            itemVenda.setProdutoId(rs.getLong("produto_id"));
            itemVenda.setQuantidade(rs.getInt("quantidade"));
            itemVenda.setValorUnitario(rs.getDouble("valor_unitario"));
            itemVenda.setValorTotal(rs.getDouble("quantidade") * rs.getDouble("valor_unitario"));

        } catch (SQLException ex) {
            Logger.getLogger(ItemVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemVenda;

    }

    @Override
    public boolean salvar(ItemVenda itemVenda) {
        String sql = "INSERT INTO public.item_venda (venda_id, produto_id, quantidade, valor_unitario) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setLong(1, itemVenda.getVendaId());
            ps.setLong(2, itemVenda.getProdutoId());
            ps.setInt(3, itemVenda.getQuantidade());
            ps.setDouble(4, itemVenda.getValorUnitario());
            ps.executeUpdate();
            ps.close();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ItemVendaDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    @Override
    public boolean atualizar(ItemVenda itemVenda) {

        String sql = "UPDATE public.item_venda SET venda_id = ?, produto_id = ?, quantidade = ?, valor_unitario = ? WHERE id = ?";

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setLong(1, itemVenda.getVendaId());
            ps.setLong(2, itemVenda.getProdutoId());
            ps.setInt(3, itemVenda.getQuantidade());
            ps.setDouble(4, itemVenda.getValorUnitario());
            ps.setLong(5, itemVenda.getId());
            ps.executeUpdate();
            ps.close();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ItemVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}