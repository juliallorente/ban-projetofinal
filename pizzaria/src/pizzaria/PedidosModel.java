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
public class PedidosModel {
    
    public static void create(PedidosBean a, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO pedidos (cod_pedido, data, hora) VALUES (?,?,?)");
            st.setInt(1, a.getCod_pedido());
            st.setString(2, a.getData());
            st.setString(3, a.getHora());
            st.execute();
            st.close();  
    }

    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT cod_pedido, data, hora FROM pedidos";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new PedidosBean(result.getInt(1), result.getString(2), result.getString(3)));
            }
        return list;
    }
}
