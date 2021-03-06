package co.edu.unbosque.model.persistence;

import java.io.*;

public class OperacionArchivo {

    public ArbolBinario[] leerCsv(){
        int n = 0;
        int contadorEntrada = 0;
        int contadorArreglo = 0;
        int contadorCochino= 0;
        ArbolBinario arbol = new ArbolBinario();
        ArbolBinario[] arboles = new ArbolBinario[355];
        BufferedReader lectura = null;
        try {
            lectura = new BufferedReader(new FileReader("./Data/DVD.csv"));
            String linea = lectura.readLine();

            linea = lectura.readLine();
            while(linea!=null){
                String temp[] = linea.split(";");
                temp[4] = temp[4].substring(0,temp[4].length()-3);
                if(!comprobarNumero(temp[4])){
                   temp[4] = "0";
                }
                 if(!comprobarNumero(temp[9])){
                    temp[9] = "0";
                }
                System.out.println(n);
                Pelicula pelicula = new Pelicula(temp[0],temp[1],temp[2],temp[3],Integer.parseInt(temp[4]),
                        temp[5],temp[6],temp[7],temp[8],Integer.parseInt(temp[9]),n);
                arbol.insertar(pelicula);
                 if(contadorCochino==800&&n<284000){
                     arboles[contadorArreglo] = arbol;
                     contadorArreglo++;
                     arbol = null;
                     arbol = new ArbolBinario();
                     contadorCochino = 0;
                     contadorEntrada++;
                 }
                linea = lectura.readLine();
                n++;
                contadorCochino++;
            }

            arboles[contadorArreglo] = arbol;
           // System.out.println("El contador es "+contadorArreglo);
            return arboles;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    public ArbolBinario[] obtener() throws ClassNotFoundException {
        try {
            ObjectInputStream recuperar = new ObjectInputStream(new FileInputStream("./Data/arbol.dat"));
            ArbolBinario[] aux;
            aux = (ArbolBinario[]) recuperar.readObject();
            recuperar.close();
            return aux;
        } catch (EOFException e) {
            //e.printStackTrace();
            return null;
        }catch(IOException e) {
            //e.printStackTrace();
            return null;
        }
    }



    public void escribir(ArbolBinario[] arbol) {
        try {
            ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream("./Data/arbol.dat"));
            escribir.writeObject(arbol);
            escribir.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean comprobarNumero(String n){
        try {
            Integer.parseInt(n);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
