package TP2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server2 {
	public static void main (String[] args)
	   { 
		   try {
			   ServerSocket serverSocket = new ServerSocket(1234);
	           System.out.println("j'attend un client");
	           Socket socket = serverSocket.accept();
	           
	           System.out.println("Un client est connecté");
	           
	           InputStream is = socket.getInputStream();
	           OutputStream os = socket.getOutputStream();
	           int op1 , op2 , res = 0;
	           String operation;
	           InputStreamReader isr = new InputStreamReader(is);
	           BufferedReader br = new BufferedReader (isr);
		       
	           op1=Integer.parseInt(br.readLine());
	           op2=Integer.parseInt(br.readLine());
	           operation = br.readLine(); 
	          switch (operation)
	          { case "+" : res=op1+op2;
	          break;
	          case "-" : res=op1-op2;
	          break;
	          case "/" : res=op1/op2;
	          break;
	          case "*" : res=op1+op2;
	          break;
	          }
	          PrintWriter pw = new PrintWriter(os,true);
	          pw.println(res);	                   
	           socket.close();	           
	           serverSocket.close();
	            }catch(IOException e){
	            	e.printStackTrace();
	       }
		}

}
