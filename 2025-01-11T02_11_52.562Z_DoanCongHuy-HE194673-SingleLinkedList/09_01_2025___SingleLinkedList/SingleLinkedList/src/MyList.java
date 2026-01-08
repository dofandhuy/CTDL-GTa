public class MyList
 {
    Node head, tail;
    MyList() {head=tail=null;}
   boolean isEmpty() {return(head==null);}
   void clear() {head=tail=null;}

   // (1) 
   void addLast(Person x)
     {Node q = new Node(x);
       if(isEmpty()) {head=tail=q;return;}
       tail.next = q;
       tail = q;
     }

    void visit(Node p) {if(p!=null) System.out.print(p.info);}
    void traverse()
     {Node p=head;
       while(p!=null)
         {visit(p);
           p=p.next;
         }
      System.out.println();
     }
   void addMany(String [] a, int [] b){
         for(int i=0;i<a.length;i++){
         Person person= new Person(a[i],b[i]);
         addLast(person);
     }
     }

   // (2)
   Node searchByName(String xName)
     {
        Node current=head;
        while(current!= null){
            if(current.info.name.equals(xName)){
                return current;
            }
            current=current.next;
        }
        return null;
     }

   // (3)
   void addFirst(Person x)
     {
         Node newNode= new Node(x);
         if(isEmpty()){
             head=tail=newNode;
         }else{
             newNode.next=head;
             head=newNode;
         }
     }

   // (4)
   void insertAfter(Node q, Person x)
     {
        if(q==null) return;
        Node newNode=new Node(x);
        newNode.next=q.next;
        q.next=newNode;
        if(q==tail){
            tail=newNode;
        }
     }

   // (5)
   void insertBefore(Node q, Person x)
     {
       if(q==null || isEmpty()) return;
       if(q==head){
           addFirst(x);
           return;
       }
       Node current= head;
       Node prev= null;
       while(current!= null&& current !=q){
           prev=current;
           current=current.next;
       }
       if(current==q){
           Node newNode= new Node(x);
           prev.next=newNode;
           newNode.next=q;
       }
     }

   // (6)
   void remove(Node q)
     {
         if(q==null || isEmpty())return;
         if(q==head){
             head=head.next;
             if(head==null) tail=null;
             return;
         }
         Node current= head;
         Node prev=null;
         while(current!=null&& current!=q){
             prev=current;
             current=current.next;
         }
         if(current==q){
             prev.next=current.next;
             if(current==tail){
                 tail=prev;
             }
         }
     }

   // (7)
   void remove(String xName)
     {
         Node current= head;
         Node prev= null;
         while(current!= null){
             if(current.info.name.equals(xName)){
                 if(current==head){
                     head=head.next;
                     if(head==null)tail=null;
                 }else{
                     prev.next=current.next;
                     if(current==tail) tail=prev;
                 }
                 return;
             }
             prev=current;
             current=current.next;
         }
     }

   // (8)
   void remove(int xAge)
     {
        Node current= head;
        Node prev=null;
        while(current!=null){
            if(current.info.age==xAge){
                if(current==head){
                    head=head.next;
                    if(head==null)tail=null;
                }else{
                    prev.next=current.next;
                    if(current==tail) tail=prev;
                }
                return;
            }
            prev=current;
            current=current.next;
        }
     }

   // (9)
   void removeAll(int xAge)
     {
          Node current=head;
         Node prev=null;
         while(current!=null){
             if(current.info.age==xAge){
                 if(current==head){
                     head=head.next;
                     if(head==null)tail=null;
                 }else{
                     prev.next=current.next;
                     if(current==tail) tail= prev;
                 }
                 current=(prev!=null)? prev.next:head;
             }else{
                 prev=current;
                 current=current.next;
             }
         }
     }

   // (10)
Node pos(int k)
     {
         if(k<0)return null;
         Node current=head;
         int count=0;
         while(current!=null){
             if(count==k) return current;
             count++;
             current=current.next;
         }
         return(null);
     }

   // (11)
void removePos(int k)
     {
         if(k<0|| isEmpty())return;
         if(k==0){
             head=head.next;
             if(head==null)tail=null;
             return;
         }
         Node current= head;
         Node prev=null;
         int count=0;
         
         while(current!=null&& count<k){
             prev=current;
             current=current.next;
             count++;
         }
         if(current!=null){
             prev.next=current.next;
             if(current==tail){
                 tail=prev;
             }
         }
     }

   // (12)
void sortByName()
     {
      if(isEmpty())return;
      Node i=head;
      while(i!=null){
          Node j= i.next;
          while(j!=null){
              if(i.info.name.compareTo(j.info.name)>0){
                  Person temp= i.info;
                  i.info=j.info;
                  j.info=temp;
              }
              j=j.next;
          }
          i=i.next;
      }
     }

   // (13)
void sortByAge()
     {
         if(isEmpty())return;
         Node i=head;
         while(i!=null){
             Node j=i.next;
             while(j!=null){
                 if(i.info.age>j.info.age){
                     Person temp= i.info;
                     i.info=j.info;
                     j.info=temp;
                 }
                 j=j.next;
             }
             i=i.next;
         }
     }


   // (14)
int size()
     {
         int count=0;
         Node current=head;
         while(current!=null){
             count++;
             current=current.next;
         }
         return count;
     }

   // (15)
Person [] toArray()
     {
         int n=size();
         Person[] arr= new Person[n];
         Node current=head;
         int i=0;
         while(current!=null){
             arr[i++]=current.info;
             current=current.next;
         }
         return arr;
     }

   // (16)
void reverse()
     {
         Node prev=null;
         Node current= head;
         Node next;
         while(current!=null){
             next=current.next;
             current.next=prev;
             prev=current;
             current=next;
         }
         tail=head;
         head=prev;
     }

  // (17) 
Node findMaxAge()
     {
         if(isEmpty()) return null;
         Node maxNode=head;
         Node current=head;
         while(current!=null){
             if(current.info.age>maxNode.info.age){
                 maxNode=current;
             }
             current=current.next;
         }
         return maxNode;
     }

  // (18) 
Node findMinAge()
     {
         if(isEmpty()) return null;
         Node minNode=head;
         Node current= head;
         
         while(current!= null){
             if(current.info.age<minNode.info.age){
                 minNode=current;
             }
             current=current.next;
         }
         
         return minNode;
     }

  // (19) 
void setData(Node p, Person x)
     {
         if(p!=null){
             p.info=x;
         }
     }

  // (20) 
void sortByAge(int  k, int h) // Sort from position k to position h (the position of the first element is 0)
     {
      if(isEmpty()||k>h||k<0) return;
      Node start=pos(k);
      Node end= pos(h);
      if(start==null|| end== null) return;
      Node i=start;
      while(i!=end.next){
          Node j=i.next;
          while(j!= end.next){
              if(i.info.age>j.info.age){
                  Person temp=i.info;
                  i.info=j.info;
                  j.info=temp;
              }
              j=j.next;
          }
          i=i.next;
      }
     }

  // (21) 
void reverse(int k, int h) // reverse from position k to position h (the position of the first element is 0) 
     {
//      MyList newlist=new MyList();
//      Node p=head;
//      Node pre=null;
//      int count =0;
//      while (p!=null){
//          count++;
//          if (count<=k) newlist.addLast(p.info);
//          if (count==k-1) pre=newlist.tail;
//          if ((count>k)&&(count<=h)) newlist.insertAfter(pre, p.info);
//          if (count>h) newlist.addLast(p.info);
//          p=p.next;
//          
//      }
//      head=newlist.head;
//      tail=newlist.tail;
       if (isEmpty() || k > h || k < 0) return;

    Node start = pos(k);
    Node end = pos(h);
    if (start == null || end == null) return;

    Node prev = null, next = null, current = start;
    Node prevStart = (k > 0) ? pos(k - 1) : null;

    while (current != end.next) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }

    if (prevStart != null) {
        prevStart.next = prev;
    } else {
        head = prev;
    }
    start.next = next;
    if (next == null) {
        tail = start;
    }
     }
  // (22)
void addBefore(Node p, Person x){ //- add a node with value x before the node p.
    if (p == null) return;
    if (p == head) {
        addFirst(x);
        return;
    }
    Node current = head;
    while (current != null && current.next != p) {
        current = current.next;
    }
    if (current != null) {
        Node newNode = new Node(x);
        newNode.next = p;
        current.next = newNode;
    }
}
  // (23)
void concateLists(MyList lst){   // Attach a singly linked list to the end of another singly linked list.
    if (lst.isEmpty()) return;
    if (isEmpty()) {
        head = lst.head;
        tail = lst.tail;
        return;
    }
    tail.next = lst.head;
    tail = lst.tail;
}
  // (24)
Person maxAge(){ //- find and return student having maximum age in the list.
    Node maxNode = findMaxAge();
    return (maxNode != null) ? maxNode.info : null;
}
  // (25)
Person minAge(){   //- find and return student having minimum age in the list.
    Node minNode = findMinAge();
    return (minNode != null) ? minNode.info : null;
} 
  // (26)
int sumAge(){//- find and return student having minimum age in the list.
    int sum = 0;
    Node current = head;
    while (current != null) {
        sum += current.info.age;
        current = current.next;
    }
    return sum;
}   
  // (27)
double avg(){ //- return the average of all ages in the list.
    int total = sumAge();
    int count = size();
    return (count > 0) ? (double) total / count : 0;
}
  // (28)
boolean sorted(){ //- check and return true if the list is sorted by name ascending, return false if the list is not sorted.
    if (isEmpty()) return true;

    Node current = head;
    while (current.next != null) {
        if (current.info.name.compareTo(current.next.info.name) > 0) {
            return false;
        }
        current = current.next;
    }
    return true;
}
  // (29)
void insert(Person x){ //- insert node with value x into sorted list so that the new list is sorted.
    Node newNode = new Node(x);
    if (isEmpty() || head.info.name.compareTo(x.name) > 0) {
        addFirst(x);
        return;
    }
    Node current = head;
    while (current.next != null && current.next.info.name.compareTo(x.name) < 0) {
        current = current.next;
    }
    newNode.next = current.next;
    current.next = newNode;
    if (newNode.next == null) tail = newNode;
}
  // (30)
void reverseList(){ //: reverse a linked list using only one pass through the list.
    Node prev = null, current = head, next;
    while (current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    tail = head;
    head = prev;
}
  // (31)
boolean check(MyList lst){ //: Check whether two singly linked list have the same contents.
    Node p1 = this.head;
    Node p2 = lst.head;
    while (p1 != null && p2 != null) {
        if (!p1.info.name.equals(p2.info.name) || p1.info.age != p2.info.age) {
            return false;
        }
        p1 = p1.next;
        p2 = p2.next;
    }
    return (p1 == null && p2 == null);
}
 }
