/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzaria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author CLIENTE
 */
public class PizzaController {
    
        public void createPizza(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para a criar uma nova Pizza: ");
        System.out.print("codigo pizza: ");
        int cod_pizza = input.nextInt();
        System.out.print("sabores: ");
        String sabores = input.next();
        System.out.print("codigo pedido: ");
        int cod_pedido = input.nextInt();

        
        PizzaBean mb = new PizzaBean(cod_pizza, sabores, cod_pedido);
        PizzaModel.create(mb, con);
        System.out.println("Pizza criado com sucesso!!");    
    }

    void listarPizza(Connection con) throws SQLException {
        HashSet all = PizzaModel.listAll(con);
        Iterator<PizzaBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    void listarPizzasPedidos(Connection con) throws SQLException {
        HashSet all = PizzaModel.listAllWithPedidos(con);
        Iterator<PizzaBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
