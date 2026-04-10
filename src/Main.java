import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        diccionario Diccionario = new Diccionario();

        // Leer diccionario.txt
        BufferedReader lectorDic = new BufferedReader(new FileReader("diccionario.txt"));
        String linea;
        while ((linea = lectorDic.readLine()) != null) {
            linea = linea.trim().replace("(", "").replace(")", "");
            String[] partes = linea.split(",");
            if (partes.length == 2) {
                Diccionario.agregar(partes[0].trim(), partes[1].trim());
            }
        }
        lectorDic.close();

        // Imprimir en orden
        System.out.print("En orden: ");
        Diccionario.imprimirEnOrden();

        // Leer texto.txt y traducir
        BufferedReader lectorTexto = new BufferedReader(new FileReader("texto.txt"));
        StringBuilder salida = new StringBuilder();
        while ((linea = lectorTexto.readLine()) != null) {
            String[] palabras = linea.split(" ");
            for (int i = 0; i < palabras.length; i++) {
                String palabra = palabras[i];
                String puntuacion = "";
                if (palabra.length() > 0 && !Character.isLetter(palabra.charAt(palabra.length() - 1))) {
                    puntuacion = String.valueOf(palabra.charAt(palabra.length() - 1));
                    palabra = palabra.substring(0, palabra.length() - 1);
                }
                String traduccion = Diccionario.traducir(palabra);
                if (traduccion != null) {
                    salida.append(traduccion);
                } else {
                    salida.append("*").append(palabra).append("*");
                }
                salida.append(puntuacion);
                if (i < palabras.length - 1) salida.append(" ");
            }
            salida.append("\n");
        }
        lectorTexto.close();

        System.out.println("Traduccion:");
        System.out.print(salida);
    }
}
