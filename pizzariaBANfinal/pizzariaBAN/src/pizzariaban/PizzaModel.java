
package pizzariaban;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author nicole
 */
public class PizzaModel {
    	public static int selectNewId(Connection con) throws SQLException {
		int newId = 1;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT max(codPizza) FROM pizza");
		while(rs.next()) {
			newId = rs.getInt(1) + 1;
		}
		return newId;
	}
    
    public static void insert(Pizza p, Connection con) throws SQLException {
        
    	PreparedStatement st = con.prepareStatement("INSERT INTO pizza (codPizza, sabores, codPedido) VALUES (?,?,?)");
    	st.setInt(1, p.getCodPizza());
    	st.setString(2, p.getSabores());
    	st.setInt(3, p.getCodPedido());
    	st.execute();
    	st.close();
    }


    public static List<Pizza> select(Connection con){
        List<Pizza> pizzas = new ArrayList<Pizza>();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT codPizza, sabores, codPedido FROM pizza");
            while(rs.next()){
                Pizza p = new Pizza(rs.getInt("codPizza"), rs.getString("sabores"), rs.getInt("codPedido"));
                pizzas.add(p);
            }
        }catch(SQLException e){
            System.out.print("erro com banco de dados");
        }
        return pizzas;
    }

    static HashSet listAllWithPedidos(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT codPizza, sabores, pizza.codPedido, codPedido, pedidos.data FROM pizza Natural JOIN pedidos";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            Pizza pizza = new Pizza(result.getInt(1), result.getString(2), result.getInt(3));
            Pedidos pedidos = new Pedidos(result.getInt(4), result.getString(5));
            pizza.setPedidos(pedidos);
            list.add(pizza);
        }
        return list;
    }    
}
