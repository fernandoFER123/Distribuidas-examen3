package Cliente;
import java.util.Scanner;
import java.net.*;
import java.io.*;
import Cliente.Datos_Usuario;
import java.text.ParseException;

public class Cliente {

    
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese Apellido: ");
        String apellido = sc.nextLine();
        System.out.println("Ingrese año de nacimiento DD/MM/YYYY ");
        String fecha = sc.nextLine();
        
        
        Datos_Usuario persona1 = new Datos_Usuario(nombre, apellido, fecha);
        
        System.out.println( ""+persona1.MensajeCliente());
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Socket socket;
        
        byte[] mensaje_bytes = new byte[256];
        
        try {
            socket = new Socket("127.0.0.1",7000);
            
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            out.writeUTF(persona1.MensajeParaElServidor());
            

            out.close();
            socket.close();
         }catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
         }
        
    }
}
