// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
// == You can insert setters and/or getters only if you need them ==== 
class Node {
  Pen info;
  Node next;
  Node() {
   }
  Node(Pen x, Node p) {
    info=x;next=p;
   }
  Node(Pen x) {
    this(x,null);
   }
 }

