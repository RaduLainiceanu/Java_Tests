/**
 * @author Lainiceanu Radu
 * 25.10.2019
 * Continuare a testului de Java Networking
 *   functioneaza impreuna cu NetworkTesting
 *   Infografie: Java Programming Masterclass for Software Developers, Tim Buchalka, www.udemy.com
 */

package ro.lrctech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //Aici este necesar si numele gazdei
        try(Socket socket = new Socket("localhost", 5000)){
            //crearea IO dupa modelul serverului definit in NetworkTesting
            BufferedReader echoes = new BufferedReader(  new InputStreamReader(socket.getInputStream())  );
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            do{
                System.out.println("Introduceti 'string' pentru afisaj: ");
                echoString = scanner.nextLine();

                stringToEcho.println(echoString);
                if(!echoString.equals("exit")){
                    response = echoes.readLine();
                    System.out.println("exit");
                }
            }while(!echoString.equals("exit"));

        }catch(IOException ioex){
            System.out.println("Eroare client: "+ioex.getMessage());
        }
    }
}
