package rminumbersorter;

import java.rmi.RemoteException;
import java.rmi.Naming;
import java.util.Scanner;

public class Client {
  public static IServer server;
  public static ClientImp clientImp;
  public static int clientsQty = 0;

  public Client() throws RemoteException {
    new Client();
  }
  
  public static void main(String[] args) throws RemoteException {
    askForClients();
    
    server.sortNumbers();
  }
  
  public static void askForClients() {
    Scanner scanner= new Scanner(System.in);
    System.out.print("Quantidade de workers: ");  
    clientsQty = scanner.nextInt();
    
    connectClients();
  }
  
  public static void connectClients() {
    for (int i = 0; i < clientsQty; i++) {
      connect();
    }
  }
  
  public static void connect() {
    try {
      server = (IServer) Naming.lookup("rmi://localhost:8090/numbersorter");
      clientImp = new ClientImp();
      server.registerClient(clientImp);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
}
