import java.util.ArrayList;
import java.util.List;

public class Diccionario {
    private Arbol<Asociacion<String, String>> arbol;

    public Diccionario() {
        arbol = new Arbol<>();
    }

    public void agregar(String frances, String espanol) {
        arbol.insertar(new Asociacion<>(frances.toLowerCase(), espanol.toLowerCase()));
    }

    public String traducir(String frances) {
        Asociacion<String, String> llave = new Asociacion<>(frances.toLowerCase(), null);
        Asociacion<String, String> resultado = arbol.buscar(llave);
        return (resultado != null) ? resultado.getValor() : null;
    }

    public void imprimirEnOrden() {
        List<Asociacion<String, String>> lista = new ArrayList<>();
        arbol.enOrden(lista);
        for (Asociacion<String, String> a : lista) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}