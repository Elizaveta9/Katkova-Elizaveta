package distributedComputing;

import java.io.*;
import java.net.*;
import java.util.*;

public class Master {
    public static void main(String[] args) {
        // Список трапеций
        List<Trapezoid> trapezoids = Arrays.asList(
                new Trapezoid(3, 4, 5),
                new Trapezoid(5, 6, 7),
                new Trapezoid(7, 8, 9)
        );

        try (ServerSocket serverSocket = new ServerSocket(5000)) { // ServerSocket собирает сокеты от клиентов
            System.out.println("Master is waiting for Workers...");

            for (Trapezoid trapezoid : trapezoids) {
                try (Socket workerSocket = serverSocket.accept(); // Ловля сокетов от работников (создание соединения)

                     // Потоки для работы с объектами. Превращают объект в байты, для этого объект должен быть Serializable
                     ObjectOutputStream out = new ObjectOutputStream(workerSocket.getOutputStream());
                     ObjectInputStream in = new ObjectInputStream(workerSocket.getInputStream())) {

                    out.writeObject(trapezoid); // Отправить данные трапеции
                    double area = in.readDouble(); // Получить посчитанную площадь трапеции от работника
                    System.out.println("Trapezoid's area: " + area);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
