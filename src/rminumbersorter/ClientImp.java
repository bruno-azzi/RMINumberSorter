package rminumbersorter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

public class ClientImp extends UnicastRemoteObject implements IClient {
  public String status = "idle";

  ClientImp() throws RemoteException  {
    super();
  }
  
  @Override
  public int[] bubbleSort(int[] numbers) throws RemoteException {
    setStatus("busy");
    System.out.println("Ordenando -> " + this + " " + Arrays.toString(numbers));
    
    for (int i = 0; i < numbers.length; ++i) {
      for (int j = i; j < numbers.length; ++j) {
        if (numbers[i] > numbers[j]) {
          int aux = numbers[i];
          numbers[i] = numbers[j];
          numbers[j] = aux;
        }
      }
    }
    
    System.out.println("Ordenação finalizada -> " + this + " " + Arrays.toString(numbers));
    setStatus("idle");
    
    return numbers;
  }

  @Override
  public String getStatus() {
    return status;
  }

  @Override
  public void setStatus(String status) {
    this.status = status;
  }
  
}
