
package pizzariaban;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nicole
 */
public class BebidaController {

     public void createBebida(Connection con){
    	try {
            Scanner sc = new Scanner(System.in);
            int codBebida = BebidaModel.selectNewId(con);
            System.out.println("Nome da bebida:");
            String nomeBebida = sc.nextLine();
            System.out.println("Qual a quantidade?");
            int quantidade = sc.nextInt();
            System.out.println("Essa bebida vai ser adicionada em qual pedido?");
            int codPedido = sc.nextInt();
            BebidaModel.insert(new Bebida(codBebida, nomeBebida, quantidade, codPedido), con);           
            System.out.println("Codigo da bebida: " + codBebida);
    	}catch(SQLException e) {
    		System.out.print("Erro ao adicionar bebida"+"\n"+"(codigo do pedido inexistente)"+"\n"+"tente novamente!");
    	}
    }
    public void listBebidas(Connection con){
        List<Bebida> bebidas = BebidaModel.select(con);
        System.out.println();
        for(Bebida b : bebidas){
            System.out.println(b + "\n");
        }
    }    
    void listarBebidasPedidos(Connection con) throws SQLException {
        HashSet all = BebidaModel.listAllWithPedidos(con);
        Iterator<Bebida> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
