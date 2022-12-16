
package pizzariaban;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author nicole
 */
public class PedidosController {

    public void createPedidos(Connection con) throws ParseException{
    	try {
    		Scanner sc = new Scanner(System.in);
    		
			int codPedido = PedidosModel.selectNewId(con);
                        System.out.println("Codigo do pedido: " + codPedido);
			System.out.println("Data do pedido: ");
			String data = sc.next();
                        SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-mm-dd");
                        try{
                        Date date = formatarData.parse(data);
                        }catch (Exception e){
                            System.out.print("data inserida no formato invalido.");
                        }
			PedidosModel.insert(new Pedidos(codPedido, data), con);
		}catch(SQLException e) {
			System.out.print("Erro ao adicionar pedido"+"\n"+"tente novamente!");
		}
    }

    public void listPedidos(Connection con){
        List<Pedidos> pedidos = PedidosModel.select(con);
        System.out.println();
        for(Pedidos p : pedidos){
            System.out.println(p + "\n");
        }
    }

    public void listPizzas(Connection con){
	Scanner sc = new Scanner(System.in);
        System.out.println("Codigo do pedido: ");
        int codPedido = Integer.parseInt(sc.nextLine());

        List<Pizza> pizzas  = PedidosModel.listPizzas(codPedido, con);
        System.out.println();
        for(Pizza p : pizzas){
            System.out.println(p + "\n");
        }
    }

    public void listBebidas(Connection con){
        Scanner sc = new Scanner(System.in);
        System.out.println("Codigo do pedido: ");
        int codPedido = Integer.parseInt(sc.nextLine());

        List<Bebida> bebidas  = PedidosModel.listBebidas(codPedido, con);
        System.out.println();
        for(Bebida b : bebidas){
            System.out.println(b + "\n");
        }
    }    
    
    public void subconsulta(Connection con){
	Scanner sc = new Scanner(System.in);
        List<Pedidos> pedidos  = PedidosModel.subconsulta(con);
        System.out.println();
        for(Pedidos p : pedidos){
            System.out.println(p + "\n");
        }
    }
}
