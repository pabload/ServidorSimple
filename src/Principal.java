import java.net.*;
import java.io.*;

public class Principal  {

    public static void main(String[] args) throws Exception {
        IniciarServidor(args);
       
       
    }
    public static void IniciarServidor(String[] args) throws IOException {
        try {
               int puerto = Integer.valueOf(args[0]);
            try {
                ServerSocket socketServidor = new ServerSocket(puerto);
                while (true) {
                    String Entrada;
                    Socket socket = socketServidor.accept();
                    BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    while ((Entrada = lector.readLine()) != null) {
                        System.out.println("me dijeron " + Entrada);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error al recibir informacion" + e.toString());
            }
                
        } catch (Exception e) {
            System.out.println("Error al crear socket servidor " + e.toString());
        }
    }

}
