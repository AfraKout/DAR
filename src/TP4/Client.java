package TP4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
	private static final int PORT = 1234;
	private static byte[] buffer = new byte[1024];

	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket();
		Scanner scan = new Scanner(System.in);
		String username = scan.nextLine();
		DatagramPacket dataToSend = new DatagramPacket(username.getBytes(), username.length(),
				InetAddress.getByName("localhost"), PORT);
		socket.send(dataToSend);
		DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);
		socket.receive(receivedPacket);
		System.out.println("Serveur : " + new String(receivedPacket.getData(),0, receivedPacket.getLength()));
	}
}