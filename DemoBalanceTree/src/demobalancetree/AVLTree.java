package demobalancetree;

import java.util.*;

public class AVLTree {

    Node root;

    public AVLTree() {
    }

    public AVLTree(Node root) {
        this.root = root;
    }

//xác định chiều cao của cây
    private int height(Node T) {
        if (T == null) {
            return -1;
        } else {
            return 1 + Math.max(height(T.left), height(T.right));
        }
    }

    public int height() {
        return height(root);
    }

// chạy theo phương pháp preorder
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

// xoay trái, phải
    public Node rostateleft(Node T) {
        if (T == null || T.right == null) {
            return T;
        }
        Node P = T.right;
        T.right = P.left;
        P.left = T;
        T.balance = height(T.left) - height(T.right);
        P.balance = height(P.left) - height(P.right);
        return P;
    }

    public Node rostateright(Node T) {
       if (T == null || T.left == null) {
            return T;
        }
        Node l = T.left;
        T.left = l.right;
        l.right = T;
        T.balance = height(T.left) - height(T.right);
        l.balance = height(l.left) - height(l.right);
        return l;
    }

// thêm vào phần tử 
    private Node insert(int x, Node T) {
        if (T == null) {
            return new Node(x);
        } else if (x < T.key) {
            T.left = insert(x, T.left);
        } else if (x > T.key) {
            T.right = insert(x, T.right);
        } else {
            return T; // Giá trị đã tồn tại, không cần thêm
        }

        // Cập nhật lại balance factor
        T.balance = height(T.left) - height(T.right);

        // Kiểm tra và cân bằng lại cây
        if (T.balance > 1) {
            if (x < T.left.key) {
                return rostateright(T);
            } else {
                T.left = rostateleft(T.left);
                return rostateright(T);
            }
        }
        if (T.balance < -1) {
            if (x > T.right.key) {
                return rostateleft(T);
            } else {
                T.right = rostateright(T.right);
                return rostateleft(T);
            }
        }

        return T;
    }

    public void insert(int x) {
        root = insert(x, root);
    }

// in ra cây 
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

// tìm giá trị lớn nhất
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

// xóa phần tử
    public void deletebyCopy(int x) {
        root = deletebyCopy(x, root);
    }

    private Node deletebyMerge(int x, Node T) {
        if (T == null) {
            return null;
        }

        if (x > T.key) {
            T.right = deletebyMerge(x, T.right);
        } else if (x < T.key) {
            T.left = deletebyMerge(x, T.left);
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

        if (T != null) { // Cập nhật lại balance factor
            T.balance = height(T.left) - height(T.right);

            // Kiểm tra và cân bằng lại cây
            if (T.balance > 1) {
                if (x < T.left.key) {
                    return rostateright(T);
                } else {
                    T.left = rostateleft(T.left);
                    return rostateright(T);
                }
            }
            if (T.balance < -1) {
                if (x > T.right.key) {
                    return rostateleft(T);
                } else {
                    T.right = rostateright(T.right);
                    return rostateleft(T);
                }
            }
        }
        return T;

    }

    public void deletebymerge(int x) {
        root = deletebyMerge(x, root);
    }

    private Node deletebyCopy(int x, Node T) {
        if (T == null) {
            return null;
        }
        if (x < T.key) {
            T.left = deletebyCopy(x, T.left);
        } else if (x > T.key) {
            T.right = deletebyCopy(x, T.right);
        } else { // T.key == x, tìm thấy nút cần xóa
            // Trường hợp nút có 0 hoặc 1 con
            if (T.left == null) {
                return T.right;
            } else if (T.right == null) {
                return T.left;
            } else {
                // Trường hợp nút có 2 con: tìm nút tiền thế (lớn nhất của cây con trái)
                Node N = max(T.left);
                T.key = N.key;  // sao chép key từ nút tiền thế
                T.left = deletebyCopy(N.key, T.left); // xóa nút tiền thế
            }
        }
        // Cập nhật lại balance factor
        T.balance = height(T.left) - height(T.right);

        // Kiểm tra và cân bằng lại cây
        if (T.balance > 1) {
            if (x < T.left.key) {
                return rostateright(T);
            } else {
                T.left = rostateleft(T.left);
                return rostateright(T);
            }
        }
        if (T.balance < -1) {
            if (x > T.right.key) {
                return rostateleft(T);
            } else {
                T.right = rostateright(T.right);
                return rostateleft(T);
            }
        }

        return T;
    }
}
