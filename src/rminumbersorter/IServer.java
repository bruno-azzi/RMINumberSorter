package rminumbersorter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {
  
  public void registerClient(IClient client) throws RemoteException;
  
  public void sortNumbers()  throws RemoteException;
  
  public void printNumbers(int[] numbers) throws RemoteException;
  
}
