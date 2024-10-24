import java.util.HashMap;
import java.util.Map;

public class SubsistemaInventario {
    private Map<String, Integer> inventario;

    public SubsistemaInventario() {
        inventario = new HashMap<>();
        inventario.put("ProductoX", 10);
        inventario.put("ProductoY", 5);
    }

    public boolean verificarDisponibilidad(String producto, int cantidad) {
        return inventario.containsKey(producto) && inventario.get(producto) >= cantidad;
    }

    public void reducirInventario(String producto, int cantidad) {
        if (verificarDisponibilidad(producto, cantidad)) {
            inventario.put(producto, inventario.get(producto) - cantidad);
        }
    }
}
