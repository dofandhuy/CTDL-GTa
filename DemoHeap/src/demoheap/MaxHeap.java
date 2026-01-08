/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demoheap;

/**
 *
 * @author Admin
 */
public class MaxHeap {
    private int elems[];
    private int size;
    private static final int MAX=50;
    public MaxHeap(){
        size=0;
        elems= new int[MAX];
    }
    public void add(int x){
        if(size<MAX){
            size++;
            elems[size-1]=x;
            int i= size-1;
            while(i>0){
                if(elems[i]>elems[(i-1)/2]){
                    int temp;
                    temp=elems[i];
                    elems[i]=elems[(i-1)/2];
                    elems[(i-1)/2]=temp;
                }
                i=(i-1)/2;
            }
        }
    }
    public void display(){
        for(int i=0;i<size;i++){
            System.out.print(elems[i]+" ");
        }
        
    }
}
