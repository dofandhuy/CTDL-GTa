
package librarymanagementsystem;
import java.util.*;
import java.util.function.Consumer;
public class LinkedList<T> {

    Node<T> head;

    void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    void addToBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    void traverse(Consumer<T> action) {
        Node<T> current = head;
        while (current != null) {
            action.accept(current.data);
            current = current.next;
        }
    }

    T find(String id, java.util.function.Function<T, String> getId) {
        Node<T> current = head;
        while (current != null) {
            if (getId.apply(current.data).equals(id)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    void delete(String id, java.util.function.Function<T, String> getId) {
        if (head == null) {
            return;
        }

        if (getId.apply(head.data).equals(id)) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        while (current.next != null && !getId.apply(current.next.data).equals(id)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }
}
