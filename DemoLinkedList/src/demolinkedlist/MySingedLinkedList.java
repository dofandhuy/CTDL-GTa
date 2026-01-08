
package demolinkedlist;

public class MySingedLinkedList {

    Node head, tail;

    public MySingedLinkedList() {
        head = null;
        tail = null;
    }

    public void travel() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info.name + "," + p.info.age);
            p = p.next;
        }
    }

    public boolean isEmpty() {
        return (head == null && tail == null);

    }

    public void insertFirst(Employee x) {
        Node N = new Node(x, null);
        if (tail == null) {
            tail = N;
        }
        N.next = head;
        head = N;
    }

    public int size() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    public void insertLast(Employee x) {
        Node N = new Node(x, null);
        N.next = null;
        tail.next = N;
        tail = N;
    }

    public void insertAfter(Node p, Employee x) {
        Node N = new Node(x, null);
        Node q = p.next;
        p.next = N;
        N.next = q;
    }

    public void insertBefore(Node p, Employee x) {
        Node n = new Node(x, null);
        if (p == null || isEmpty()) {
            return;
        }
        if (p == head) {
            insertFirst(x);
            return;
        }
        Node q = head;
        Node m = null;
        while (q != null && q != p) {
            m = q;
            q = q.next;
        }
        if (q == p) {
            n = m.next;
            n.next = p;
        }
    }

    public void insertAt(int k, Employee x) {
        if ((head == null) && (tail == null)) {
            Node N = new Node(x, null);
            head = N;
            tail = N;
        } else {
            if (k <= 1) {
                insertFirst(x);
            } else if (k > size()) {
                insertLast(x);
            } else {
                Node p = head;
                int i = 1;
                while (i < k - 1) {
                    p = p.next;
                    i++;
                }
                insertAfter(p, x);
            }
        }
    }

    public Employee removeFirst() {
        if (!isEmpty()) {
            Employee x = head.info;
            if (size() == 1) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }
            return x;
        } else {
            return null;
        }
    }

    public Employee removeLast() {
        if (!isEmpty()) {

        }
        Node q = head;
        int i = 1;
        while (i < size() - 1) {
            q = q.next;
            i++;
        }
        return removeAfter(q);
    }

    public Employee removeAfter(Node p) {
        if (p != null && p.next != null) {
            Node q;
            q = p.next;
            Employee x = q.info;
            p.next = q.next;
            if (q == tail) {
                p.next = tail;
            }
            return x;

        }
        return null;
    }

    public Employee removeAt(int k) {
        if (k == 1) {
            return removeFirst();
        } else if (k == size()) {
            return removeLast();
        }

        Node p = head;
        int i = 1;
        while (i < k - 1) {
            p = p.next;
            i++;
        }
        return removeAfter(p);
    }
}
// câu 1: danh sách liên kết đơn
// câu 2: 