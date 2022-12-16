
package pizzariaban;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicole
 */
public class PedidosModel {
    
	public static int selectNewId(Connection con) throws SQLException {
		int newId = 1;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT max(codPedido) FROM pedidos");
		while(rs.next()) {
			newId = rs.getInt(1) + 1;
		}
		return newId;
	}
    
    public static void insert(Pedidos p, Connection con) throws SQLException{
    	PreparedStatement st = con.prepareStatement("INSERT INTO pedidos (codPedido, data) VALUES (?,?::date)");
    	st.setInt(1, p.getCodPedido());
    	st.setString(2, p.getData());
    	st.execute();
    	st.close();
    }
    
    public static List<Pedidos> select(Connection con){
        List<Pedidos> pedidos = new ArrayList<Pedidos>();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT codPedido, data FROM pedidos");
            while(rs.next()){
                Pedidos p = new Pedidos(rs.getInt("codPedido"), rs.getString("data"));
                pedidos.add(p);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return pedidos;
    }

    public static List<Pizza> listPizzas(int codPedido, Connection con){
        List<Pizza> pizzas = new ArrayList<Pizza>();
        try{
            PreparedStatement st = con.prepareStatement("SELECT codPizza, sabores, codPedido FROM pizza NATURAL JOIN pedidos where pedidos.codPedido=?");
            st.setInt(1, codPedido);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                pizzas.add(new Pizza(rs.getInt("codPizza"), rs.getString("sabores"), rs.getInt("codPedido")));
            }
        }catch(SQLException e){
            System.out.print("Nao existe pedido com esse codigo"+"\n"+"tente novamente!");
        }
        return pizzas;
    }
    
    public static List<Bebida> listBebidas(int codPedido, Connection con){
        List<Bebida> bebidas = new ArrayList<Bebida>();
        try{
            PreparedStatement st = con.prepareStatement("SELECT codBebida, nomeBebida, quantidade, codPedido FROM bebida NATURAL JOIN pedidos where pedidos.codPedido=?");
            st.setInt(1, codPedido);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                bebidas.add(new Bebida(rs.getInt("codBebida"), rs.getString("nomeBebida"), rs.getInt("quantidade"), rs.getInt("codPedido")));
            }
        }catch(Exception e){
            System.out.print("Nao existe pedido com esse codigo"+"\n"+"tente novamente!");
        }
        return bebidas;
    }    
    
    public static List<Pedidos> subconsulta(Connection con){
       List<Pedidos> pedidos = new ArrayList<Pedidos>();
        try{
            PreparedStatement st = con.prepareStatement("select codPedido, data from pedidos where data in (select MAX(data) from pedidos)");
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                pedidos.add(new Pedidos(rs.getInt("codPedido"), rs.getString("data")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return pedidos;
    }
    
}
