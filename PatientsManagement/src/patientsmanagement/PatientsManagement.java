/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package patientsmanagement;
import java.util.*;
/**
 *
 * @author Admin
 */
public class PatientsManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Patient> priorityQueue = new PriorityQueue<>((p1, p2) -> {
            // Ưu tiên bệnh nhân < 2 tuổi trước, sau đó đến bệnh nhân >= 70 tuổi
            if (p1.age < 2 && p2.age >= 2) return -1;
            if (p1.age >= 2 && p2.age < 2) return 1;
            if (p1.age >= 70 && p2.age < 70) return -1;
            if (p1.age < 70 && p2.age >= 70) return 1;
            return 0;
        });

        System.out.print("Nhập số lượng bệnh nhân: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin bệnh nhân " + (i + 1) + ":");
            System.out.print("CMND/CCCD: ");
            String id = sc.nextLine();
            System.out.print("Họ tên: ");
            String name = sc.nextLine();
            System.out.print("Tuổi: ");
            int age = sc.nextInt();
            sc.nextLine();

            priorityQueue.add(new Patient(id, name, age));   
        }

        System.out.println("\nDanh sách khám bệnh theo thứ tự:");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

    }
    
}
