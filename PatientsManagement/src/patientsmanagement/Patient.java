/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patientsmanagement;

/**
 *
 * @author Admin
 */
public class Patient {
    String id;
    String name;
    int age;

    public Patient(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Patient{" + "ID='" + id + "', Name='" + name + "', Age=" + age + '}';
    }  
}
