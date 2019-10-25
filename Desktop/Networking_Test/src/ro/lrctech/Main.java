/**
*   Proba Buffered Reader Java
 *  25.10.2019
*   @author Lainiceanu Radu-Constantin
 *   functioneaza impreuna cu EchoClient
*   Infografie: Java Programming Masterclass for Software Developers, Tim Buchalka @ Udemy
 */

package ro.lrctech;

// Importarea pachetelor
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//O singura clasa este necesara pentru acest test
public class Main {
    //Metoda principala
    public static void main(String[] args){

        //Ca orice operatie IO, socket-urile cer ,,Exception Handling''
        //Pe randul 23 avem ,try' in care declaram un ServerSocket si un numar de port 5000
        try(ServerSocket serverSocket = new ServerSocket(5000)){

            //socket primeste valoare din serverSocket
            Socket socket = serverSocket.accept();

            //mesaj consola
            System.out.println("Client connected");

            //BufferedReader, pentru intrarea datelor din socket
            BufferedReader input = new BufferedReader(  new InputStreamReader(socket.getInputStream())   );

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            //bucla pentru 5 teste
            int T = 0;
            while (T++ < 5){
                String echoString = input.readLine();

                //iesire din bucla daca primim 'exit'
                if(echoString.equals("exit")){
                    break;
                }
                output.println("Echo from server: "+echoString);
            }

        }catch(IOException ioe){
            //Afisare erori
            System.out.println("Eroare server. Exception: "+ioe.getMessage());
            ioe.printStackTrace();
        }
    }
}
