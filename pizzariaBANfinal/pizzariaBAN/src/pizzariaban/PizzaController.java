
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
public class PizzaController {
    
     public void createPizza(Connection con){
    	try {
            Scanner sc = new Scanner(System.in);
            int codPizza = PizzaModel.selectNewId(con);
            System.out.println("Sabores da pizza");
            String sabores = sc.nextLine();
            System.out.println("Essa pizza vai ser adicionada em qual pedido?");
            int codPedido = sc.nextInt();
            PizzaModel.insert(new Pizza(codPizza, sabores, codPedido), con);
            System.out.println("codigo da pizza: " + codPizza);    
    	}catch(SQLException e) {
    		System.out.print("Erro ao adicionar pizza"+"\n"+"(codigo do pedido inexistente)"+"\n"+"tente novamente!");
    	}

    }

    public void listPizzas(Connection con){
        List<Pizza> pizzas = PizzaModel.select(con);
        System.out.println();
        for(Pizza p : pizzas){
            System.out.println(p + "\n");
        }
    }

    void listarPizzasPedidos(Connection con) throws SQLException {
        HashSet all = PizzaModel.listAllWithPedidos(con);
        Iterator<Pizza> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
