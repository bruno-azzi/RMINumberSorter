package rminumbersorter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerImp extends UnicastRemoteObject implements IServer {

  List<IClient> clients = new ArrayList<IClient>();
  List<int[]> numbers = new ArrayList<int[]>();
  List<int[]> sortedNumbers = new ArrayList<int[]>();
  int lastSortedArrayIndex = 0;

  public ServerImp() throws RemoteException {
    super();
  }

  @Override
  public void printNumbers(int[] numbers) {
    for (int number : numbers) {
      System.out.print(number + ", ");
    }

    System.out.println("\n");
  }

  @Override
  public void registerClient(IClient client) throws RemoteException {
    clients.add(client);
    System.out.println("Cliente Registrado -> " + client);
  }

  @Override
  public void sortNumbers() throws RemoteException {
    while (numbers.size() > 0) {
      for (IClient client : clients) {
        if (client.getStatus().equals("idle")) {
          client.setStatus("busy");
          
          int[] currentNumbers = numbers.get(0);
          numbers.remove(0);


          Thread t = new Thread(new Runnable() {
              public void run() { 
                try {
                  int[] sortedArray = client.bubbleSort(currentNumbers);
                  sortedNumbers.add(sortedArray);
                  client.setStatus("idle");
                } catch (Exception ex) {
                  ex.printStackTrace();
                }
              }
            }
          );

          t.start();

          break;
        }
      }
    }

//    for (int i = 0; i < sortedNumbers.size(); i++) {
//      printNumbers(sortedNumbers.get(i));
//    }
    
    System.out.println("Todos os números foram ordenados!");
  }

}
