
package pizzariaban;

/**
 *
 * @author nicole
 */
public class Pizza {
    private int codPizza;
    private String sabores;
    private int codPedido;
    private Pedidos pedidos;
    
    
    public Pizza(int codPizza, String sabores, int codPedido) {
        this.codPizza = codPizza;
        this.sabores = sabores;
        this.codPedido = codPedido;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public int getCodPizza() {
        return codPizza;
    }

    public void setCodPizza(int codPizza) {
        this.codPizza = codPizza;
    }

    public String getSabores() {
        return sabores;
    }

    public void setSabores(String sabores) {
        this.sabores = sabores;
    }
    
    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("codigo pedido: "+codPedido+"\n" +"codigo pizza: "+codPizza+"\n" +"sabores: "+sabores+"\n");
        if(pedidos!= null)
            sb.append("data do pedido: "+pedidos.getData()+"\n"+"\n");
        return sb.toString();
    }   
    
    
}
