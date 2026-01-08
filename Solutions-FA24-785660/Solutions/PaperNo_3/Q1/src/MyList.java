/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xOwner, int xHorn, int xColor) {
        //You should write here appropriate statements to complete this function.
        if (xOwner.charAt(0) == 'A') {
            return;
        }
        Node newNode = new Node(new Cala(xOwner, xHorn, xColor));
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Cala x, y, z;
        x = new Cala("X", 1, 2);
        y = new Cala("Y", 2, 3);
        z = new Cala("Z", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node xNode = new Node(x);
        Node yNode = new Node(y);
        Node zNode = new Node(z);

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        xNode.next = head.next;
        head.next = xNode;

        Node temp = head;
        for (int i = 0; i < 3 && temp.next != null; i++) {
            temp = temp.next;
        }
        yNode.next = temp.next;
        temp.next = yNode;

        temp = head;
        for (int i = 0; i < 5 && temp.next != null; i++) {
            temp = temp.next;
        }
        zNode.next = temp.next;
        temp.next = zNode;
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        if (isEmpty() || head == tail) {
            return;
        }

        Node maxNode = head;
        Node current = head;
        while (current != null) {
            if (current.info.color > maxNode.info.color) {
                maxNode = current;
            }
            current = current.next;
        }

        if (maxNode != tail) {
            Cala temp = maxNode.info;
            maxNode.info = tail.info;
            tail.info = temp;
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node p = head;
    while (p != null && !p.info.owner.equals("D")) {
        p = p.next;
    }
    if (p == null) return; // No node with owner "D"

    // Collect the info of the next 6 nodes after "D" node
    Cala[] infos = new Cala[6];
    Node current = p.next;
    int count = 0;
    while (count < 6 && current != null) {
        infos[count] = current.info;
        current = current.next;
        count++;
    }

    // Sort the array of Cala objects by color in ascending order
    for (int i = 0; i < count - 1; i++) {
        for (int j = i + 1; j < count; j++) {
            if (infos[i].color > infos[j].color) {
                Cala temp = infos[i];
                infos[i] = infos[j];
                infos[j] = temp;
            }
        }
    }

    // Reassign the sorted info objects back to the nodes
    current = p.next;
    for (int i = 0; i < count; i++) {
        current.info = infos[i];
        current = current.next;
    }

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
