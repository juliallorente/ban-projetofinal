
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
public class BebidaModel {

    	public static int selectNewId(Connection con) throws SQLException {
		int newId = 1;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT max(codBebida) FROM bebida");
		while(rs.next()) {
			newId = rs.getInt(1) + 1;
		}
		return newId;
	}
    
    public static void insert(Bebida b, Connection con) throws SQLException {
    	PreparedStatement st = con.prepareStatement("INSERT INTO bebida (codBebida, nomeBebida, quantidade, codPedido) VALUES (?,?,?,?)");
    	st.setInt(1, b.getCodBebida());
    	st.setString(2, b.getNomeBebida());
    	st.setInt(3, b.getQuantidade());
        st.setInt(4, b.getCodPedido());
    	st.execute();
    	st.close();
    }

    public static List<Bebida> select(Connection con){
        List<Bebida> bebidas = new ArrayList<Bebida>();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT codBebida, nomeBebida, quantidade, codPedido FROM bebida");
            while(rs.next()){
                Bebida b = new Bebida(rs.getInt("codBebida"), rs.getString("nomeBebida"), rs.getInt("quantidade"), rs.getInt("codPedido"));
                bebidas.add(b);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return bebidas;
    }

    static HashSet listAllWithPedidos(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT codBebida, nomeBebida, quantidade, bebida.codPedido, codPedido, data FROM bebida Natural JOIN pedidos";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            Bebida mb = new Bebida(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4));
            Pedidos a = new Pedidos(result.getInt(5), result.getString(6));
            mb.setPedidos(a);
            list.add(mb);
        }
        return list;
    }
}
