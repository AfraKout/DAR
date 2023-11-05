package TP4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

public class Serveur {
	private static final int PORT = 1234;
	private static byte[] buffer = new byte[1024];

	public static void main(String[] args) throws Exception {

		DatagramSocket socket = new DatagramSocket(PORT);
		System.out.println("Démarrage du Serveur");
		while (true) {
			DatagramPacket usernamePacket = new DatagramPacket(buffer, buffer.length);
			socket.receive(usernamePacket);
			String username = new String(usernamePacket.getData(), 0, usernamePacket.getLength());
			System.out.println(usernamePacket.getAddress() + " : " + username);

			username = "Bienvenue " + username;
			DatagramPacket msgToSend = new DatagramPacket(username.getBytes(), username.length(),
					usernamePacket.getAddress(), usernamePacket.getPort());
			socket.send(msgToSend);

		}
	} 
	
}
