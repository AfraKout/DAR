package rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Implementation de l'interface IConversion
public class ConversionImpl extends UnicastRemoteObject implements IConversion {

    // Constructeur pour ConversionImpl, qui jete RemoteException
    public ConversionImpl() throws RemoteException {
        // Appel au constructeur de la superclasse (UnicastRemoteObject)
        super();
    }

    // Implémentation de la méthode de conversion depuis l'interface
    @Override
    public double convertirMontant(double mt) throws RemoteException {
        return mt * 3.3;
    }
}