package rminumbersorter;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Random;

public class Server {
  public static ServerImp serverImp;
  public static int MAX_ARRAY_SIZE = 10000;  
  public static int MAX_ARRAY_QTY = 10;

  public static void main(String[] args) throws RemoteException {
    startRegistry();
    createNumberMatrix();
  }
  
  public static void startRegistry() {
    try {
      serverImp = new ServerImp();
      LocateRegistry.createRegistry(8090);
      String uri = "rmi://localhost:8090/numbersorter";
      Naming.rebind(uri, serverImp);
      
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
  public static int[] generateRandomNumbers() {
    Random rand = new Random();
    int numbers[] = new int[MAX_ARRAY_SIZE];

    for (int i =0; i < numbers.length; ++i) {
      numbers[i] = rand.nextInt(MAX_ARRAY_SIZE);
    }
    
    return numbers;
  }
  
  public static void createNumberMatrix() {
    for (int i = 0; i < MAX_ARRAY_QTY; i++) {
      int[] numbers = generateRandomNumbers();
      serverImp.numbers.add(numbers);
      serverImp.printNumbers(numbers);
    }
    
    System.out.println("\nFinalizada a geração da matriz");
  }
  
}
