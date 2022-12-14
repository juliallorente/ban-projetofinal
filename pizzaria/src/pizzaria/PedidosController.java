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
 * @author nicole
 */
public class PedidosController {
    
       public void createPedidos(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar um novo Pedido: ");
        System.out.print("codigo do pedido: ");
        int cod_pedido = input.nextInt();
        System.out.print("data do pedido: ");
        String data = input.next();
        System.out.print("hora do pedido: ");
        String hora = input.next();
        PedidosBean ab = new PedidosBean(cod_pedido, data, hora);
        PedidosModel.create(ab, con);
        System.out.println("Pedido criado com sucesso!!");
    }

    void listarPedidos(Connection con) throws SQLException {
        HashSet all = PedidosModel.listAll(con);
        Iterator<PedidosBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    
}
