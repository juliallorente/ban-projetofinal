/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzaria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

/**
 *
 * @author CLIENTE
 */
public class PizzaModel {

        static void create(PizzaBean m, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO pizza (cod_pizza, sabores, cod_pedido) "
                    + "VALUES (?,?,?)");
            st.setInt(1, m.getCod_pizza());
            st.setString(2, m.getSabores());
            st.setInt(3, m.getCod_pedido());

            st.execute();
            st.close();
    }
    
    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT cod_pizza, sabores, cod_pedido FROM pizza";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new PizzaBean(result.getInt(1), result.getString(2), result.getInt(3)));
            }
        return list;
    }    

    static HashSet listAllWithPedidos(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT cod_pizza, sabores, pizza.cod_pedido, cod_pedido, data, hora FROM pizza Natural JOIN pedidos";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            PizzaBean mb = new PizzaBean(result.getInt(1), result.getString(2), result.getInt(3));
            PedidosBean a = new PedidosBean(result.getInt(3), result.getString(4), result.getString(5));
            mb.setPedidos(a);
            list.add(mb);
        }
        return list;
    }
}
