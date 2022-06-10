package rminumbersorter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote {
  public String status = "idle";
  
  public int[] bubbleSort(int[] numbers) throws RemoteException;

  public void setStatus(String busy) throws RemoteException;
  
  public String getStatus() throws RemoteException;
}
