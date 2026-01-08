/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demoheap;

/**
 *
 * @author Admin
 */
public class MinHeap {
   private int elems[];
    private int size;
    private static final int MAX = 50;

    public MinHeap() {
        size = 0;
        elems = new int[MAX];
    }

    // Thêm phần tử vào MinHeap
    public void add(int x) {
        if (size < MAX) {
            size++;
            elems[size - 1] = x;
            int i = size - 1;
            while (i > 0) {
                if (elems[i] < elems[(i - 1) / 2]) { // Nếu phần tử mới nhỏ hơn cha, hoán đổi
                    int temp = elems[i];
                    elems[i] = elems[(i - 1) / 2];
                    elems[(i - 1) / 2] = temp;
                } else {
                    break;
                }
                i = (i - 1) / 2;
            }
        }
    }

    // Xóa và trả về phần tử nhỏ nhất
    public int remove() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int minValue = elems[0]; // Lấy phần tử nhỏ nhất (gốc)
        elems[0] = elems[size - 1]; // Đưa phần tử cuối lên đầu
        size--;

        int i = 0;
        while (2 * i + 1 < size) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            int smallest = i;

            if (leftChild < size && elems[leftChild] < elems[smallest]) {
                smallest = leftChild;
            }
            if (rightChild < size && elems[rightChild] < elems[smallest]) {
                smallest = rightChild;
            }
            if (smallest == i) {
                break;
            }

            // Hoán đổi phần tử
            int temp = elems[i];
            elems[i] = elems[smallest];
            elems[smallest] = temp;

            i = smallest;
        }

        return minValue;
    }

    // Hiển thị heap dưới dạng mảng
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(elems[i] + " ");
        }
        System.out.println();
    } 
}
