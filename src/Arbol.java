public class Arbol<E extends Comparable<E>> {
    private NodoArbol<E> raiz;

    public Arbol() {
        raiz = null;
    }

    public void insertar(E dato) {
        raiz = insertarRec(raiz, dato);
    }

    private NodoArbol<E> insertarRec(NodoArbol<E> nodo, E dato) {
        if (nodo == null) return new NodoArbol<>(dato);
        int cmp = dato.compareTo(nodo.dato);
        if (cmp < 0) nodo.izquierdo = insertarRec(nodo.izquierdo, dato);
        else if (cmp > 0) nodo.derecho = insertarRec(nodo.derecho, dato);
        return nodo;
    }

    public E buscar(E dato) {
        return buscarRec(raiz, dato);
    }

    private E buscarRec(NodoArbol<E> nodo, E dato) {
        if (nodo == null) return null;
        int cmp = dato.compareTo(nodo.dato);
        if (cmp == 0) return nodo.dato;
        if (cmp < 0) return buscarRec(nodo.izquierdo, dato);
        return buscarRec(nodo.derecho, dato);
    }

    public void enOrden(java.util.List<E> resultado) {
        enOrdenRec(raiz, resultado);
    }

    private void enOrdenRec(NodoArbol<E> nodo, java.util.List<E> resultado) {
        if (nodo == null) return;
        enOrdenRec(nodo.izquierdo, resultado);
        resultado.add(nodo.dato);
        enOrdenRec(nodo.derecho, resultado);
    }
}