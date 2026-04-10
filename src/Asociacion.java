public class Asociacion<K extends Comparable<K>, V> implements Comparable<Asociacion<K, V>> {
    private K llave;
    private V valor;

    public Asociacion(K llave, V valor) {
        this.llave = llave;
        this.valor = valor;
    }

    public K getLlave() { return llave; }
    public V getValor() { return valor; }

    @Override
    public int compareTo(Asociacion<K, V> otra) {
        return this.llave.compareTo(otra.llave);
    }

    @Override
    public String toString() {
        return "(" + llave + ", " + valor + ")";
    }
}