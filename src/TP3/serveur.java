package TP3;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import cnx.operation;
public class serveur extends Thread {
    private static int nbclient;

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
                   
         // Définir l'adresse IP et le port du serveur
            InputStream input = s.getInputStream();
            ObjectInputStream oi = new ObjectInputStream(input);
            // Lire l'objet reçu (Opération)
            operation op = (operation) oi.readObject();
            // Extraire les données nécessaires de l'objet de l'opération
            int op1 = op.getOp1();
            int op2 = op.getOp2();
            char ops = op.getOp();
            int result = 0;
            // Effectuer l'opération demandée
            switch (ops) {
                case '+': result = op1 + op2; break;
                case '-': result = op1 - op2; break;
                case '*': result = op1 * op2; break;
                case '/': result = op1 / op2; break;
            }
            // Stocker le résultat dans l'objet Operation
            op.setRes(result);
            // Configuration du flux de sortie pour l'envoi de l'objet Operation modifié
            OutputStream output = s.getOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(output);
            // Renvoyer l'objet Operation modifié au client
            oo.writeObject(op);
        } catch (IOException | ClassNotFoundException e) {
        	e.printStackTrace();
        }
      }
    }
  }