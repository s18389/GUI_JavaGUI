package z06threat;

public class Main {

    public static void main(String[] args) throws InterruptedException {
     Letters letters = new Letters("ABCD"); 
      for (Thread t : letters) 
          System.out.println(t.getName() + " starting"); 
      letters.start();
      try {  Thread.sleep(5000); }
      catch(InterruptedException ignore) { } 
      letters.stop();
      System.out.println("\nProgram completed.");
    }

}