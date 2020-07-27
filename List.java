package linked_list;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data  = data;
        this.next = null;
    }
}
public class List {
    Node head = null;
    void append(int data){
        Node node = new Node(data);
        if (head == null){
            head = node;
        }
        else{
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }
    void insertBefore(int cur,int data){
        Node node= new Node(data);
        if(head == null){
            head = node;
        }
        else{
            if(cur == head.data){
                Node temp = head;
                node.next = temp;
                head = node;
            }
            else{
                Node temp = head,prev=null;
                while(cur != temp.data){
                    prev = temp;
                    temp = temp.next;
                }
                node.next = prev.next;
                prev.next = node;
            }
        }
    }
}
