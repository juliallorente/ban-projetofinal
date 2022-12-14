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
public class BebidaController {
   
        public void createBebida(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para adicionar uma nova bebida: ");
        System.out.print("codigo bebida: ");
        int cod_bebida = input.nextInt();
        System.out.print("nome bebida: ");
        String nomebebida = input.next();
        System.out.print("quantidade: ");
        int quantidade = input.nextInt();
        System.out.print("codigo pedido: ");
        int cod_pedido = input.nextInt();

        
        BebidaBean b = new BebidaBean(cod_bebida, nomebebida, quantidade, cod_pedido);
        BebidaModel.create(b, con);
        System.out.println("Bebida criado com sucesso!!");    
    }

    void listarBebida(Connection con) throws SQLException {
        HashSet all = BebidaModel.listAll(con);
        Iterator<BebidaBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    void listarBebidasPedidos(Connection con) throws SQLException {
        HashSet all = BebidaModel.listAllWithPedidos(con);
        Iterator<BebidaModel> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
