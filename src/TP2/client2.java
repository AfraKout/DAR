package TP2;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
public class client2 {
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
         PrintWriter pw = new PrintWriter(os, true);
	     Scanner scanner = new Scanner(System.in);
	     int op1 , op2;
	     String operation;
	     System.out.println("Donner le premier operateur = ");
	     op1 = scanner.nextInt();
	     System.out.println("Donner  operateur = ");
	     op2 = scanner.nextInt(); 
	    do { System.out.println("Donner  l'operation (+,-,/,*)");
	    operation = scanner.nextLine();
	    }while(!operation.equals("+")&& !operation.equals("-") && !operation.equals("*") && !operation.equals("/"));
	    InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader (isr);	     
	     System.out.println(op1+" "+operation+" " +op2+"  = " +br.readLine());
	     S.close();
	     scanner.close();
	 }
	 catch(Exception e) {e.printStackTrace();
	    }
    }
}
