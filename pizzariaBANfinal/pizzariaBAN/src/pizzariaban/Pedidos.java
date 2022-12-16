
package pizzariaban;

/**
 *
 * @author nicole
 */
public class Pedidos {
    private int codPedido;
    private String data;

    public Pedidos(int codPedido, String data) {
        this.codPedido = codPedido;
        this.data = data;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String toString(){
        String str = "Codigo do pedido: " + this.codPedido;
        str += "\nData: " + this.data;
        return str;
    }
}
