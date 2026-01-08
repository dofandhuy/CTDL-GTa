/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demostack;

import java.util.*;


/**
 *
 * @author Admin
 */
public class DemoStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int r;
        Stack<Integer> s = new Stack<>(); // Sử dụng Stack từ java.util
        while (n != 0) {
            r = n % 10;
            s.push(r); // Đẩy giá trị vào stack
            n = n / 10;
        }

        System.out.println("decimal :");
        while (!s.isEmpty()) {
            int x = s.pop(); // Lấy giá trị từ stack
            System.out.print(x); // In ra giá trị thực tế
        }
    }
    
}
/**
 * import java.util.Scanner;
import java.util.Stack;

public class NumberBaseConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Chọn chế độ:");
        System.out.println("1. Chuyển từ thập phân sang nhị phân");
        System.out.println("2. Chuyển từ thập phân sang thập lục phân");
        System.out.println("3. Chuyển từ nhị phân sang thập phân");
        System.out.println("4. Chuyển từ thập lục phân sang thập phân");
        int choice = sc.nextInt();
        
        switch (choice) {
            case 1:
                System.out.print("Nhập số thập phân: ");
                int decimal = sc.nextInt();
                System.out.println("Hệ nhị phân: " + convertDecimalToBinary(decimal));
                break;
            case 2:
                System.out.print("Nhập số thập phân: ");
                decimal = sc.nextInt();
                System.out.println("Hệ thập lục phân: " + convertDecimalToHex(decimal));
                break;
            case 3:
                System.out.print("Nhập số nhị phân: ");
                String binary = sc.next();
                System.out.println("Hệ thập phân: " + convertBinaryToDecimal(binary));
                break;
            case 4:
                System.out.print("Nhập số thập lục phân: ");
                String hex = sc.next();
                System.out.println("Hệ thập phân: " + convertHexToDecimal(hex));
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
        }
        
        sc.close();
    }

    // Chuyển từ thập phân sang nhị phân
    public static String convertDecimalToBinary(int decimal) {
        Stack<Integer> stack = new Stack<>();
        while (decimal > 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }

        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }

    // Chuyển từ thập phân sang thập lục phân
    public static String convertDecimalToHex(int decimal) {
        Stack<Character> stack = new Stack<>();
        char[] hexDigits = "0123456789ABCDEF".toCharArray();

        while (decimal > 0) {
            stack.push(hexDigits[decimal % 16]);
            decimal /= 16;
        }

        StringBuilder hex = new StringBuilder();
        while (!stack.isEmpty()) {
            hex.append(stack.pop());
        }

        return hex.toString();
    }

    // Chuyển từ nhị phân sang thập phân
    public static int convertBinaryToDecimal(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            decimal = decimal * 2 + (binary.charAt(i) - '0');
        }
        return decimal;
    }

    // Chuyển từ thập lục phân sang thập phân
    public static int convertHexToDecimal(String hex) {
        int decimal = 0;
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            int value;
            if (c >= '0' && c <= '9') {
                value = c - '0';
            } else {
                value = c - 'A' + 10;
            }
            decimal = decimal * 16 + value;
        }
        return decimal;
    }
}

 */