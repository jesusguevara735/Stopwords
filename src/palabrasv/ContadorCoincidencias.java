package palabrasv;

import org.w3c.dom.ls.LSOutput;

import java.io.*;

public class ContadorCoincidencias {
    public ContadorCoincidencias()throws IOException {
        int contador = 0;
        StreamTokenizer st = new StreamTokenizer(new FileReader("divina_comedia.txt"));
        while(st.nextToken() != StreamTokenizer.TT_EOF){
            if(st.ttype== StreamTokenizer.TT_WORD){
                contador++;
            }
        }
        System.out.println("Numero de palabras en el archivo: " + contador);

    }

    static int totalCoincidencias = 0;

    public static void main(String[] args)throws IOException {
        new ContadorCoincidencias();


        File letraBuscar = new File("stopwords.txt");

        File archivo = new File("divina_comedia.txt");

        buscarCoincidenciaPalabra(String.valueOf(letraBuscar), archivo);
    }
    public static void buscarCoincidenciaPalabra(String letraBuscar, File archivo) {
        totalCoincidencias = 0;
        char caracter = letraBuscar.charAt(0);
        try {
            if(archivo.exists()) {
                BufferedReader archivoLeer = new BufferedReader(new FileReader(archivo));
                String lineaLeida;
                while((lineaLeida = archivoLeer.readLine()) != null) {
                    char[] arregloCaracteres = lineaLeida.toCharArray();
                    for(int i = 0 ; i < arregloCaracteres.length ; i++) {
                        if(arregloCaracteres[i] == caracter) {
                            totalCoincidencias = totalCoincidencias + 1;
                        }
                    }
                }
                archivoLeer.close();
            }
            System.out.println("\nEl numero de palabras StopWord es: " + totalCoincidencias );
            int contador = 121757;
            int total = contador - totalCoincidencias;
            System.out.println("\nEl total de palabras sin considerar las stopwords es: " + total);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }



}

