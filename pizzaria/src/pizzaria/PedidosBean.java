/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pizzaria;

/**
 *
 * @author CLIENTE
 */
public class PedidosBean {
    private int cod_pedido;
    private String data;
    private String hora;

    public PedidosBean(int cod_pedido, String data, String hora) {
        this.cod_pedido = cod_pedido;
        this.data = data;
        this.hora = hora;
    }

    public int getCod_pedido() {
        return cod_pedido;
    }

    public void setCod_pedido(int cod_pedido) {
        this.cod_pedido = cod_pedido;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    @Override
        public String toString(){
        return "codigo do pedido: "+cod_pedido+" data pedido: "+data+" hora pedido: "+hora;
    }
    
}
