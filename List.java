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
}
