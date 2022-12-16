
package pizzariaban;

/**
 *
 * @author nicole
 */
public class Bebida {
        
    private int codBebida;
    private String nomeBebida;
    private int quantidade;
    private int codPedido;
    private Pedidos pedidos;

    public Bebida(int codBebida, String nomeBebida, int quantidade, int codPedido) {
        this.codBebida = codBebida;
        this.nomeBebida = nomeBebida;
        this.quantidade = quantidade;
        this.codPedido = codPedido;
    }

    public int getCodBebida() {
        return codBebida;
    }

    public void setCodBebida(int codBebida) {
        this.codBebida = codBebida;
    }

    public String getNomeBebida() {
        return nomeBebida;
    }

    public void setNomeBebida(String nomeBebida) {
        this.nomeBebida = nomeBebida;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCod_pedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }
    
    public String toString(){
        StringBuffer str = new StringBuffer();
        str.append("codigo pedido: "+codPedido+"\n"+"codigo bebida: "+codBebida+"\n" +"nome da bebida: "+nomeBebida+"\n"+"quantidade: "+quantidade+"\n");
        if(pedidos!= null)
            str.append("data do pedido: "+pedidos.getData()+"\n"+"\n");
        return str.toString();
    } 
}
