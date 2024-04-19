package Client_Server;

//import DAOs.GamesDaoInterface;
//import DAOs.MySqlGamesDao;
//import DTOs.Game;
//import Exceptions.DaoException;
//import JSON.JsonConverter;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class ClientMain {
    public static void main(String[] args) {
        ClientMain client = new ClientMain();
        client.start(8889); // start client to connect to the port number that the server uses
    }

    public void start(int portNumber) {

        try (
                Socket socket = new Socket("localhost", 8889);
                OutputStream outputStream = socket.getOutputStream();
        ) {

            PrintWriter out = new PrintWriter(outputStream, true);
            System.out.println("The client is running and has connected to the server.");

            //Ben
            System.out.println("[1] Press 1 to Display Entity by Id");
            System.out.println("[2] Press 2 to end");

            Scanner menu = new Scanner(System.in);
            int answer = menu.nextInt();

            if(answer==1) {
                System.out.println("Enter ID: ");

                Scanner options = new Scanner(System.in);
                int newID = options.nextInt();

                out.println(newID);

                Integer.toString(newID);

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String response = in.readLine();    // wait, and receive a return message from the server
                System.out.println("In client: The server response was : " + response);
            }
            if(answer==2) {
                System.out.println("Do you want to end?: ");

                Scanner options = new Scanner(System.in);
                String exit = options.nextLine();
                out.println(exit);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String response = in.readLine();
                System.out.println("In client: The server response was : " + response);
            }

            System.out.println("Finished! - client is exiting.");

        } catch (UnknownHostException e) {
            System.out.println(e);  // print out the exception
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
