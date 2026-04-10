public class NodoArbol<E extends Comparable<E>> {
    E dato;
    NodoArbol<E> izquierdo, derecho;

    public NodoArbol(E dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}

