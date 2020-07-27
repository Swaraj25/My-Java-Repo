package linked_list;
import java.util.Scanner;
public class Main {
    static boolean isPresent(Node node,List l){
        Node t1 = node, t2 = l.head;
        while(t2 != null){
            if (t1.data == t2.data)
                return true;
            t2 = t2.next;
        }
        return false;
    }
    static void printList(List l){
        Node t = l.head;
        while(t != null){
            System.out.print(t.data+" ");
            t = t.next;
        }
        System.out.println();
    }
    static List intersection(List l1, List l2){
        List li = new List();
        Node t1 = l1.head;
        while(t1 != null){
            if (isPresent(t1,l2))
                li.append(t1.data);
            t1 = t1.next;
        }
        return li;
    }
    static List union(List l1,List l2, List in){
        List un = new List();
        Node t = l2.head;
        //Print List2
        while (t != null){
            if (!isPresent(t,in))
                un.append(t.data);
            t = t.next;
        }
        // print List 1
        t = l1.head;
        while (t != null){
            if (!isPresent(t,in))
                un.append(t.data);
            t = t.next;
        }
        return un;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        List l1 = new List();
        int n1 = sc.nextInt();
        for (int i=0; i < n1; i++){
            int d = sc.nextInt();
            l1.append(d);
        }
//        displayList(l1);
        List l2 = new List();
        System.out.println("Elements in 2nd list : ");
        int n2 = sc.nextInt();
        for (int i=0; i < n2; i++){
            int d = sc.nextInt();
            l2.append(d);
        }
        List in = intersection(l1,l2);
        printList(in);
        List un = union(l1,l2,in);
        printList(un);
    }
}
/*
5
1
3
2
4
5
5
3
4
5
6
7
* */