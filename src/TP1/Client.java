package TP1;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
 public static void main (String[] args)
 { try{
	 System.out.println("Je suis un client");
  
	 InetAddress inetadress = InetAddress.getByName("10.27.15.178");
       InetSocketAddress inetSocketAdd=new InetSocketAddress(inetadress,1234);
       Socket S = new Socket();
       S.connect(inetSocketAdd);
	 //Socket socket= new Socket("localhost",1234);
	 System.out.println("Je suis connecté");
	 InputStream is = S.getInputStream();
     OutputStream os = S.getOutputStream();
     
     int nb;
     System.out.println("nb= ");
     Scanner scanner = new Scanner(System.in);
     nb = scanner.nextInt(); //awl haja sart bech client yab3th nb
     os.write(nb); //etape 2 client b3ath nb
     
     int resultat = is.read();
     System.out.println("la multiplication de " +nb+ "*5 = " + resultat);// etape 6 client esta9bl rep l serveur
     S.close();
     scanner.close();
 }
 catch(Exception e) {e.printStackTrace();
    }
  }
 }
