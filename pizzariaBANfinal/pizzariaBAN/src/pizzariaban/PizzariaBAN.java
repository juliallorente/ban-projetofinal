
package pizzariaban;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;


/**
 *
 * @author nicole
 */
public class PizzariaBAN {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ParseException, SQLException{
    	PedidosController pedidosController = new PedidosController();
    	PizzaController pizzaController = new PizzaController();
        BebidaController bebidaController = new BebidaController();
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();
        menu();
        int op = Integer.parseInt(sc.nextLine());
        while(op != 0){
            switch(op){
                case 1:
                    pedidosController.createPedidos(con);
                break;
                case 2:
                    pizzaController.createPizza(con);
                break;
                case 3:
                    bebidaController.createBebida(con);
                break;
                case 4:
                    pedidosController.listPedidos(con);
                break;
                case 5:
                    pizzaController.listPizzas(con);
                break;
                case 6:
                    bebidaController.listBebidas(con);
                break;
                case 7:
                    pedidosController.listPizzas(con);
                break;
                case 8:
                    pedidosController.listBebidas(con);
                break ;   
                case 9: 
                    bebidaController.listarBebidasPedidos(con);
                break;                
                case 10: 
                    pizzaController.listarPizzasPedidos(con);
                break; 
                case 11:
                    pedidosController.subconsulta(con);
                break;                
                default:
                    System.out.println("opcao invalida");
                break;
            }
            menu();
            op = Integer.parseInt(sc.nextLine());
        }
        conexao.closeConnection();
    }

    public static void menu(){
        System.out.println("\n======================================================");
        System.out.println("01 - Adicionar pedido");
        System.out.println("02 - Adicionar pizza");
        System.out.println("03 - Adicionar bebida");
        System.out.println("04 - Listar todos os pedidos");
        System.out.println("05 - Listar todas as pizzas");
        System.out.println("06 - Listar todas as bebidas");
        System.out.println("07 - Listar pizza de um pedido em especifico");
        System.out.println("08 - Listar bebida de um pedido em especifico");
        System.out.println("09 - Listar todos os pedidos que contem bebidas");
        System.out.println("10 - Listar todos os pedidos que contem pizzas");
        System.out.println("11 - Listar o(s) pedido(os) com a data mais recente");
        System.out.println("(Digite 0 para encerrar)");
        System.out.println("\n======================================================");
    }
}
