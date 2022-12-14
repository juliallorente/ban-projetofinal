/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pizzaria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author nicole
 */
public class Pizzaria {

    public static void main(String[] args) throws SQLException {
        Conexao c = new Conexao();
        Connection con = c.getConnection();
        int op = 0;
        do{
            op = menu();
            try {
                switch (op) {
                    case 1: new PedidosController().createPedidos(con);
                            break;
                    case 2: new PizzaController().createPizza(con);
                            break;
                    case 3: new BebidaController().createBebida(con);
                            break;
                    case 4: new PedidosController().listarPedidos(con);
                            break;
                    case 5: new PizzaController().listarPizza(con);
                            break;
                    case 6: new PizzaController().listarPizzasPedidos(con);
                            break;
                    case 7: new BebidaController().listarBebida(con);
                            break;
                    case 8: new BebidaController().listarBebidasPedidos(con);
                            break;
                            
                }
            }catch(SQLException ex) {
                //ex.printStackTrace();
                System.out.println(ex.getMessage());
                continue;
            }
        } while(op>0 && op<9);  
        con.close();
    }    
    
    private static int menu() {
        System.out.println("");
        System.out.println("Informe o numero da opcao que desejas executar: ");
        System.out.println("1 - Inserir um novo pedido");
        System.out.println("2 - Inserir uma nova pizza");
        System.out.println("3 - Inserir uma nova bebida");
        System.out.println("4 - Exibir todos os pedidos");
        System.out.println("5 - Exibir todos as pizzas");
        System.out.println("6 - Exibir todos os pedidos e suas respectivos pizzas");
        System.out.println("7 - Exibir todos as bebidas");
        System.out.println("8 - Exibir todos os pedidos e suas respectivos bebidas");        
        System.out.println("Digite qualquer outro valor para sair");
        System.out.print("sua opcao: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}

