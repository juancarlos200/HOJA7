import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArbolBinarioTest {

    @Test
    public void testInsertarYBuscarEncontrado() {
        Arbol<Asociacion<String, String>> arbol = new Arbol<>();
        arbol.insertar(new Asociacion<>("maison", "casa"));
        arbol.insertar(new Asociacion<>("chien", "perro"));

        Asociacion<String, String> resultado = arbol.buscar(new Asociacion<>("chien", null));
        assertNotNull(resultado);
        assertEquals("perro", resultado.getValor());
    }

    @Test
    public void testBuscarNoEncontrado() {
        Arbol<Asociacion<String, String>> arbol = new Arbol<>();
        arbol.insertar(new Asociacion<>("oui", "si"));

        Asociacion<String, String> resultado = arbol.buscar(new Asociacion<>("non", null));
        assertNull(resultado);
    }

    @Test
    public void testInsertarMantieneOrdenBST() {
        Arbol<Asociacion<String, String>> arbol = new Arbol<>();
        arbol.insertar(new Asociacion<>("oui", "si"));
        arbol.insertar(new Asociacion<>("maison", "casa"));
        arbol.insertar(new Asociacion<>("ville", "pueblo"));

        java.util.List<Asociacion<String, String>> lista = new java.util.ArrayList<>();
        arbol.enOrden(lista);

        assertEquals("maison", lista.get(0).getLlave());
        assertEquals("oui", lista.get(1).getLlave());
        assertEquals("ville", lista.get(2).getLlave());
    }
}
