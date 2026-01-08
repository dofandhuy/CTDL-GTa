/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demorecursion;

/**
 *
 * @author Admin
 */
public class DemoRecursion {
    public static long factorial(int n){
        if(n==0) return 1;
        else return n*factorial(n-1);
    }
   
   
    public static void convertDecimalToBinary(int n){
        if(n==0){
            System.out.print("");
        }else{
            convertDecimalToBinary(n/2);
            System.out.print(n%2);
        }
    }
    
    public static String reverse(String st){
        if(st.equals("")) return "";
        else return reverse(st.substring(1))+st.charAt(0);
    }
     public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("5!= "+ factorial(5));
        convertDecimalToBinary(16);
        System.out.println(" ");
         System.out.println(reverse("abchdg"));
       
         
    }

    
}
