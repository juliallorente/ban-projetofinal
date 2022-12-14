/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzaria;

/**
 *
 * @author CLIENTE
 */
public class PizzaBean {

    private int cod_pizza;
    private String sabores;
    private int cod_pedido;
    private PedidosBean pedidos;


    public PizzaBean(int cod_pizza, String sabores, int cod_pedido) {
        this.cod_pizza = cod_pizza;
        this.sabores = sabores;
        this.cod_pedido = cod_pedido;


    }

    public int getCod_pizza() {
        return cod_pizza;
    }

    public void setCod_pizza(int cod_pizza) {
        this.cod_pizza = cod_pizza;
    }

    public int getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(int cod_pedido) {
        this.cod_pedido = cod_pedido;
    }
    
    public String getSabores() {
        return sabores;
    }

    public void setSabores(String sabores) {
        this.sabores = sabores;
    }

    public PedidosBean getPedidos() {
        return pedidos;
    }

    public void setPedidos(PedidosBean pedidos) {
        this.pedidos = pedidos;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("codigo pizza: "+cod_pizza+" codigo pedido: "+cod_pedido+" sabores: "+sabores);
        if(pedidos!= null)
            sb.append(" data: "+pedidos.getData()+" hora: "+pedidos.getHora());
        return sb.toString();
    }        
    
}
