package TP3;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class serveur extends Thread {
    private int nbclient;

    // Méthode principale
    public static void main(String[] args) {
        // Crée une instance de la classe serveur et démarre le serveur
        new serveur().start();
    }
    @Override
    public void run() {
        try {
            // Crée un serveur socket écoutant sur le port 600
            ServerSocket ss = new ServerSocket(600);
            System.out.println("Démarrage du serveur");

            // Boucle d'écoute de clients en continu
            while (true) {
                // Accepte la connexion d'un client
                Socket s = ss.accept();

                // Crée un nouveau thread pour gérer le client et incrémente le compteur de clients
                new ClientProcess(s, ++nbclient).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Classe interne pour gérer chaque client connecté
    public class ClientProcess extends Thread {
        private int numclient;
        private Socket s;

        // Constructeur de la classe ClientProcess
        public ClientProcess(Socket s, int numclient) {
            this.s = s;
            this.numclient = numclient;
        }

        @Override
        public void run() {
            // Affiche un message indiquant le numéro du client et son adresse IP
            System.out.println("Le client numéro : " + numclient + " de l'adresse IP " + s.getRemoteSocketAddress());

            try {
                // Envoie un message de bienvenue au client
                new PrintWriter(s.getOutputStream(), true).println("Bienvenue, vous êtes le client numéro " + numclient);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
