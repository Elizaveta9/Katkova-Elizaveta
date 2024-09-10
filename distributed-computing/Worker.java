package MasterWorker;

import java.io.*;
import java.net.*;

public class Worker {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            Trapezoid trapezoid = (Trapezoid) in.readObject();
            double area = (trapezoid.a + trapezoid.b) / 2 * trapezoid.h;
            out.writeDouble(area);
            out.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


