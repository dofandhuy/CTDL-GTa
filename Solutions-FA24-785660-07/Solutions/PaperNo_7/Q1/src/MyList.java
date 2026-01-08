
/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.File;
import java.io.RandomAccessFile;

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
    if (p != null)
      f.writeBytes(p.info + " ");
  }

  void ftraverse(RandomAccessFile f) throws Exception {
    Node p = head;
    while (p != null) {
      fvisit(p, f); // You will use this statement to write information of the node p to the file
      p = p.next;
    }
    f.writeBytes("\r\n");
  }

  void loadData(int k) { // do not edit this function
    String[] a = Lib.readLineToStrArray("data.txt", k);
    int[] b = Lib.readLineToIntArray("data.txt", k + 1);
    int[] c = Lib.readLineToIntArray("data.txt", k + 2);
    int n = a.length;
    for (int i = 0; i < n; i++)
      addLast(a[i], b[i], c[i]);
  }

  // ===========================================================================
  // (2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
  // ===========================================================================
  /*
   * Khong su dung tieng Viet co dau de viet ghi chu.
   * Neu dung khi chay truc tiep se bao loi va nhan 0 diem
   */
  void addLast(String xOwner, int xHorn, int xColor) {
    // Check if owner starts with 'A'
    if (xOwner != null && xOwner.charAt(0) == 'A') {
      return;
    }

    // Create new node
    Node node = new Node(new Cala(xOwner, xHorn, xColor));

    // If list is empty
    if (isEmpty()) {
      head = tail = node;
      return;
    }

    // Add to end of list
    tail.next = node;
    tail = node;
  }

  // You do not need to edit this function. Your task is to complete the addLast
  // function above only.
  void f1() throws Exception {
    clear();
    loadData(1);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if (g123.exists())
      g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    ftraverse(f);
    f.close();
  }

  // ==================================================================
  void f2() throws Exception {
    clear();
    loadData(5);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if (g123.exists())
      g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    ftraverse(f);
    Cala x, y, z;
    x = new Cala("X", 1, 2);
    y = new Cala("Y", 2, 3);
    z = new Cala("Z", 3, 4);
    // ------------------------------------------------------------------------------------
    /*
     * You must keep statements pre-given in this function.
     * Your task is to insert statements here, just after this comment,
     * to complete the question in the exam paper.
     */

    // Find nodes at positions 1, 4, and 6
    Node p = head;
    Node prev = null;
    int i = 0;

    // Insert x after position 1
    while (p != null && i < 1) {
      prev = p;
      p = p.next;
      i++;
    }
    if (prev != null) {
      Node temp = prev.next;
      prev.next = new Node(x);
      prev.next.next = temp;
    }

    // Reset to find position 4
    p = head;
    prev = null;
    i = 0;
    while (p != null && i < 4) {
      prev = p;
      p = p.next;
      i++;
    }
    if (prev != null) {
      Node temp = prev.next;
      prev.next = new Node(y);
      prev.next.next = temp;
    }

    // Reset to find position 6
    p = head;
    prev = null;
    i = 0;
    while (p != null && i < 6) {
      prev = p;
      p = p.next;
      i++;
    }
    if (prev != null) {
      Node temp = prev.next;
      prev.next = new Node(z);
      prev.next.next = temp;
    }

    // ------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }

  // ==================================================================
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if (g123.exists())
      g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    ftraverse(f);
    // ------------------------------------------------------------------------------------
    /*
     * You must keep statements pre-given in this function.
     * Your task is to insert statements here, just after this comment,
     * to complete the question in the exam paper.
     */

    // Find node with maximum color
    Node p = head;
    Node maxNode = head;
    while (p != null) {
      if (p.info.color > maxNode.info.color) {
        maxNode = p;
      }
      p = p.next;
    }

    // Swap maxNode with tail if maxNode is not tail
    if (maxNode != tail) {
      Cala temp = maxNode.info;
      maxNode.info = tail.info;
      tail.info = temp;
    }

    // ------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }

  // ==================================================================
  void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if (g123.exists())
      g123.delete();
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    ftraverse(f);
    // ------------------------------------------------------------------------------------
    /*
     * You must keep statements pre-given in this function.
     * Your task is to insert statements here, just after this comment,
     * to complete the question in the exam paper.
     */

    // ------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }

}
