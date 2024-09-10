package distributedComputing;

import java.io.*;
import java.net.*;

public class Worker {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000); // Cокет служит соединением с сервером
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            Trapezoid trapezoid = (Trapezoid) in.readObject(); // Создание трапеции из данных, присланных от сервера
            double area = (trapezoid.getA() + trapezoid.getB()) / 2 * trapezoid.getH(); // Подсчёт площади трапеции
            out.writeDouble(area); // Записать значение площади в поток
            out.flush(); // Смыть всё серверу
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


