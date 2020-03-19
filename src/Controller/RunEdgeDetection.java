package Controller;

import UI.Form;

public class RunEdgeDetection {
    //metoda main - initiere interfata si inregistrare timp de procesare
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.nanoTime();
        new Form().setVisible(true);
        long endTime = System.nanoTime();
        double totalTime = (double)(endTime - startTime);
        System.out.println("Timp de executie - Main: " + totalTime / 1.0E9D + " secunde");
    }
}
