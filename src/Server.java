import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
   public static void main (String[] args)
   { 
	   try {
		   ServerSocket serverSocket = new ServerSocket(1234);
           System.out.println("j'attend un client");
           Socket socket = serverSocket.accept();
           
           System.out.println("Un client est connecté");
           
           InputStream is = socket.getInputStream();
           OutputStream os = socket.getOutputStream();
	       
           int nb = is.read(); // etape 3 l serveur esta9bl req mn client
           int resultat = nb*5;//etape 4 l serveur y7athr f calcul
           os.write(resultat);//etape 5 l serveur b3ath l resultat 
           
           socket.close();
           
           serverSocket.close();
           
            }catch(IOException e){
            	e.printStackTrace();
       }
	}
   }
