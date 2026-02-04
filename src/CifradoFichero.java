import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class CifradoFichero {
    public static void main(String[] args) {

//inicializamos el lectopr para leer el archivo
        try(BufferedReader lector = new BufferedReader(new FileReader("archivo.txt"))){

//creamos una lista para guardar el codigo y un String para guardar la linea leida. inicializamos un array de char para guardar el codigo
            String linea;
            int i=0;
            char [] codigo = new char[10];

//mientras la linea no lea un cambio de linea o el contador llegue a 10 se ejecutara el codigo
            while ((linea = lector.readLine()) != "\n" && i<10){

//si le un null, es decir, ya no has mas documentos, se sale del bucle
                if(linea == null){
                    break;
                }

//si lee ese caracter significa que no hya linea, por lo que, en ese caso, no hará nada, sino se llama al metodo y se añade al array codigo
                if(!linea.equals("")){
                    codigo [i] = ultimoCaracter(linea);
                    i++;
                }
            }

//si el contador no es 10, se añade mas veces el ultimo caracter para que pueda llegar a un codigo de 10 caracteres
            while(i<10){
                codigo [i] = codigo [i-1];
                i++;
            }

//muestra en consola el codigo
            for (int j = 0; j < 10; j++){
                System.out.print(codigo[j]);

            }

        }catch(Exception e){
            System.out.print(e);
        }
    }

//se manda una lista de caracteres y la linea y envia el ultimo caracter
    public static char ultimoCaracter(String ultima){
        List<Character> caracteres = new ArrayList<>();
        char c;
        for(int i = 0; i < ultima.length(); i++){
            caracteres.add(ultima.charAt(i));
        }
        c = caracteres.getLast();
        return c;
    }
}