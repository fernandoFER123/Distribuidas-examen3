package Servidor;
import java.net.*; 
import java.io.*;


public class Servidor {
    public static void main(String argv[]) {
        
     ServerSocket socket;
     
     boolean fin = false;
     try {
         
        socket = new ServerSocket(7000);
        
        Socket socket_cli = socket.accept();

        DataInputStream in =new DataInputStream(socket_cli.getInputStream());

        String mensaje ="";
            
        mensaje = in.readUTF();

        System.out.println("Recibiendo mensaje: "+mensaje);

        socket.close();
     }

     catch (Exception e) {
        System.err.println(e.getMessage());
        System.exit(1);
     }
  }
}
