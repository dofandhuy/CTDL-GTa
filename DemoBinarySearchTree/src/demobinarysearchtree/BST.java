/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demobinarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Admin
 */
public class BST {

    Node root;

    public BST() {
        root = null;
    }

    private Node insert(int x, Node T) {
        Node N = new Node(x);
        if (T == null) {
            T = N;
        }
        if (x < T.key) {
            T.left = insert(x, T.left);
        } else if (x > T.key) {
            T.right = insert(x, T.right);
        }
        return T;
    }

    public void insert(int x) {
        root = insert(x, root);
    }

    public void BFS() {
        Queue<Node> Q = new LinkedList();
        if (root != null) {
            Q.add(root);
            while (!Q.isEmpty()) {
                Node N = Q.remove();
                System.out.print(N.key + " ");
                if (N.left != null) {
                    Q.add(N.left);
                }
                if (N.right != null) {
                    Q.add(N.right);
                }
            }
        }
    }

    private void preorder(Node T) {
        if (T != null) {
            System.out.print(T.key + " ");
            preorder(T.left);
            preorder(T.right);
        }
    }

    public void preorder() {
        preorder(root);
    }

    private void inorder(Node T) {
        if (T != null) {
            inorder(T.left);
            System.out.print(T.key + " ");
            inorder(T.right);
        }
    }

    public void inorder() {
        inorder(root);
    }

    private void postorder(Node T) {
        if (T != null) {
            inorder(T.left);
            inorder(T.right);
            System.out.print(T.key + " ");
        }
    }

    public void postorder() {
        postorder(root);
    }

    private int count(Node T) {
        if (T == null) {
            return 0;
        } else {
            return 1 + count(T.left) + count(T.right);
        }
    }

    public int count() {
        return count(root);
    }

    private int height(Node T) {
        if (T == null) {
            return 0;
        }
        return 1 + Math.max(height(T.left), height(T.right));
    }

    public int height() {
        return height(root);
    }

    private int countLeaf(Node T) {
        if (T == null) {
            return 0;
        }
        if (T.left == null && T.right == null) {
            return 1;
        }
        return countLeaf(T.left) + countLeaf(T.right);
    }

    public int countLeaf() {
        return countLeaf(root);
    }

    private int countInNode(Node T) {
        if (T == null) {
            return 0;
        }
        // Nếu T là nút lá thì không tính
        if (T.left == null && T.right == null) {
            return 0;
        }
        return 1 + countInNode(T.left) + countInNode(T.right);
    }

    public int countInNode() {
        return countInNode(root);
    }

    public Node parent(Node c) {
        if (c == null || root == null || root == c) {
            return null;
        }
        return parent(root, c);
    }

    private Node parent(Node T, Node c) {
        if (T == null) {
            return null;
        }
        // Nếu T là cha của c
        if ((T.left != null && T.left.key == c.key) || (T.right != null && T.right.key == c.key)) {
            return T;
        }
        if (c.key < T.key) {
            return parent(T.left, c);
        } else {
            return parent(T.right, c);
        }
    }

    public Node search(int x) {
        return search(root, x);
    }

    private Node search(Node T, int x) {
        if (T == null || T.key == x) {
            return T;
        }
        if (x < T.key) {
            return search(T.left, x);
        } else {
            return search(T.right, x);
        }
    }

    private Node max(Node T) {
        Node V = T;
        if (V == null) {
            return null;
        } else {
            while (V.right != null) {
                V = V.right;
            }
        }
        return V;
    }

    public Node max() {
        return max(root);
    }

    private Node min(Node T) {
        Node V = T;
        if (V == null) {
            return null;
        } else {
            while (V.left != null) {
                V = V.left;
            }
            return V;
        }
    }

    public Node min() {
        return min(root);
    }

    public void deletebyCopy(int x) {
        root = deletebyCopy(root, x);
    }
    

        // Xóa nút theo phương pháp sao chép (delete by copy)    
    private Node deletebyCopy(Node T, int x) {
        if (T == null) return null;
        if (x < T.key) {
            T.left = deletebyCopy(T.left, x);
        } else if (x > T.key) {
            T.right = deletebyCopy(T.right, x);
        } else { // T.key == x, tìm thấy nút cần xóa
            // Trường hợp nút có 0 hoặc 1 con
            if (T.left == null) return T.right;
            else if (T.right == null) return T.left;
            else {
                // Trường hợp nút có 2 con: tìm nút tiền thế (lớn nhất của cây con trái)
                Node N = max(T.left);
                T.key = N.key;  // sao chép key từ nút tiền thế
                T.left = deletebyCopy(T.left, N.key); // xóa nút tiền thế
            }
        }
        return T;
    }


    public void deletebymerge(int x) {
        root = deletebyMerge(root, x);
    }

    private Node deletebyMerge(Node T, int x) {
        if (T != null) {
            if (x > T.key) {
                T.right = deletebyMerge(T.right, x);
            } else if (x < T.key) {
                T.left = deletebyMerge(T.left, x);
            } else {
//                } else if (T.left != null) {
                //nối con phải sang cực phải con trái
                if (T.right == null) {
                    return T.left;
                }
                if (T.left == null) {
                    return T.right;
                }
                Node N = max(T.left);
                N.right = T.right;
                T = T.left;
           
            }
            return T;
        }
        return null;
    }
}
