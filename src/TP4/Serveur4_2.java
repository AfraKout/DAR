package TP4;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Serveur4_2 {
    private static final int PORT = 1234;
    private static byte[] buffer = new byte[1234];
    private static String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYY MM DD HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            System.out.println("Démarrage du serveur");
            while (true) {              
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String time = getCurrentTime();
                DatagramPacket msgToSend = new DatagramPacket(time.getBytes(), time.length(), packet.getAddress(), packet.getPort());
                socket.send(msgToSend);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}


