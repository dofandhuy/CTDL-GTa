/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package waterjugproblem;
import java.util.*;
/**
 *
 * @author Admin
 */
public class WaterJugProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int jug1= sc.nextInt();
        int jug2=sc.nextInt();
        int target= sc.nextInt();
        MeasureWater measure= new MeasureWater();
        System.out.println("Can measure " + target + "L: " + measure.canMeasureWater(jug1, jug2, target));
    }
    
}
