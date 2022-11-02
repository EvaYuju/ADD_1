/**
 * Author: Eva López Márquez
 * Asignatura: Acceso a Datos
 * 1) Crea una aplicación que pida por teclado un número de números
 aleatorios enteros positivos y la ruta de un fichero binario. Este fichero
 contendrá la cantidad de números aleatorios enteros positivos que se ha
 pedido por teclado. El rango de los números aleatorios estará entre 0 y
 100, incluyendo el 100.
 Cada vez que ejecutemos la aplicación añadiremos números al fichero sin
 borrar los anteriores, es decir, si cuando creo el fichero añado 10 números
 y después añado otros 10 al mismo, en el fichero habrá 20 números que
 serán mostrados por pantalla.

 *Ruta usada para el fichero del ejercicio en: Ubicación proyecto + \Eva_Lopez_Binarios1\carpeta\Fichero1
*/


import java.io.*;
import javax.swing.JOptionPane;

public class Binario1 {

        public static void main(String[] args) {

            String ruta=JOptionPane.showInputDialog("Indique la ruta del fichero");
            String numeros=JOptionPane.showInputDialog("Indique el nº de números aleatorios");
            int numNumerosAleatorios=Integer.parseInt(numeros);

            //Abrimos el fichero desde el final
            try(DataOutputStream dos=new DataOutputStream (new FileOutputStream (ruta, true));
                DataInputStream dis=new DataInputStream(new FileInputStream (ruta))){

                escribeFichero(dos, numNumerosAleatorios);
                leeFichero(dis);

            }catch(EOFException e){
                System.out.println("Fin del fichero");
            }catch(IOException e){
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        public static void escribeFichero (DataOutputStream dos, int numNumerosAleatorios) throws IOException{

            //Escribimos los números

            for (int i=0;i<numNumerosAleatorios;i++){
                int numero=generaNumerosAleatorios();
                dos.writeInt(numero);
            }
            //Guardamos los cambios
            dos.flush();
        }
        public static void leeFichero (DataInputStream dis) throws IOException{
            //Leemos los números hasta el final del fichero
            while(true){
                System.out.println(dis.readInt());
            }
        }
        public static int generaNumerosAleatorios(){
            return (int)Math.floor(Math.random()*101);
        }
    }

