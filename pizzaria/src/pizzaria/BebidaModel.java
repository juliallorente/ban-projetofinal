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
public class BebidaModel {

        static void create(BebidaBean b, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO bebida (cod_bebida, nomebebida, quantidade, cod_pedido) "
                    + "VALUES (?,?,?, ?)");
            st.setInt(1, b.getCod_bebida());
            st.setString(2, b.getNomebebida());
            st.setInt(3, b.getQuantidade());            
            st.setInt(4, b.getCod_pedido());

            st.execute();
            st.close();
    }
    
    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT cod_bebida, nomebebida, quantidade, cod_pedido FROM bebida";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new BebidaBean (result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4)));
            }
        return list;
    }    

    static HashSet listAllWithPedidos(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT cod_bebida, nomebebida, quantidade, bebida.cod_pedido, cod_pedido, data, hora FROM bebida natural JOIN pedidos";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            BebidaBean b = new BebidaBean(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4));
            PedidosBean a = new PedidosBean(result.getInt(4), result.getString(5), result.getString(6));
            b.setPedidos(a);
            list.add(b);
        }
        return list;
    }
}
