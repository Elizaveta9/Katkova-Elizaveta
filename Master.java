package MasterWorker;

import java.io.*;
import java.net.*;
import java.util.*;

public class Master {
    public static void main(String[] args) {
        List<Trapezoid> trapezoids = Arrays.asList(
                new Trapezoid(3, 4, 5),
                new Trapezoid(5, 6, 7),
                new Trapezoid(7, 8, 9)
        );

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Master is waiting for Workers...");

            for (Trapezoid trapezoid : trapezoids) {
                try (Socket workerSocket = serverSocket.accept();
                     ObjectOutputStream out = new ObjectOutputStream(workerSocket.getOutputStream());
                     ObjectInputStream in = new ObjectInputStream(workerSocket.getInputStream())) {

                    out.writeObject(trapezoid);
                    double area = in.readDouble();
                    System.out.println("Trapezoid's square: " + area);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



