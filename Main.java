package linked_list;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    static List reverseBlocks(Node head, int blocks[]){
        Node temp = head,cur = head;
        List ans = new List();
        int i = 0;
        while(temp != null && i < blocks.length){
            while (blocks[i] > 0 && temp != null){
                ans.insertBefore(cur.data,temp.data);
                cur = temp;
                temp = temp.next;
                blocks[i]--;
            }
            if(temp != null) {
                ans.append(temp.data);
                cur = temp;
                temp = temp.next;
            }
            i++;
            if(i < blocks.length)
                blocks[i]--;
        }
        while(temp != null){
            ans.append(temp.data);
            temp = temp.next;
        }
        return ans;
    }
    public static void main(String args[]){
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List l = new List();
        int blocks[] = new int[0];
        try {
            String inp[] = br.readLine().split(" ");
            for(String s : inp){
                int d = Integer.parseInt(s);
                if(d != -1){
                    l.append(d);
                }
            }
            int k = Integer.parseInt(br.readLine());
            inp = br.readLine().split(" ");
            blocks = new int[k];
            for(int i = 0; i < k; i++){
                blocks[i] = Integer.parseInt(inp[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List ans = reverseBlocks(l.head,blocks);
        printList(ans);
//        for(int i=0;i<5;i++){
//            try {
//                l.append(Integer.parseInt(br.readLine()));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        printList(l);
//        l.insertBefore(1,6);
//        printList(l);
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
/*
1 2 3 4 5 6 7 8 9 10 11 -1
3
2 3 4
* */