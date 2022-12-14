/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzaria;

/**
 *
 * @author CLIENTE
 */
public class BebidaBean {
    
    private int cod_bebida;
    private String nomebebida;
    private int quantidade;
    private int cod_pedido;
    private PedidosBean pedidos;

    public BebidaBean(int cod_bebida, String nomebebida, int quantidade, int cod_pedido) {
        this.cod_bebida = cod_bebida;
        this.nomebebida = nomebebida;
        this.quantidade = quantidade;
        this.cod_pedido = cod_pedido;
        this.pedidos = pedidos;
    }

    public int getCod_bebida() {
        return cod_bebida;
    }

    public void setCod_bebida(int cod_bebida) {
        this.cod_bebida = cod_bebida;
    }

    public String getNomebebida() {
        return nomebebida;
    }

    public void setNomebebida(String nomebebida) {
        this.nomebebida = nomebebida;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(int cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    public PedidosBean getPedidos() {
        return pedidos;
    }

    public void setPedidos(PedidosBean pedidos) {
        this.pedidos = pedidos;
    }
    

    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("codigo bebida: "+cod_bebida+" bebida: "+nomebebida+" quantidade: "+quantidade+" codigo pedido: "+cod_pedido);
        if(pedidos!= null)
            sb.append(" data: "+pedidos.getData()+" hora: "+pedidos.getHora());
        return sb.toString();
    }        
}
