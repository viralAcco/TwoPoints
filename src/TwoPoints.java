import java.util.Scanner;
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}
class CircularLinkedList {
    Node head = null;

    CircularLinkedList(){
        Node n = new Node(1);
        head = n;
        n.next = null;
        Node prev = n;
        for(int i = 2; i <= 12; i++){
            Node n2 = new Node(i);
            prev.next = n2;
            n2.next = null;
            prev = n2;
        }
        prev.next = head;
    }
    public Node getNode(int d){
        Node t = head;
        int ite = 12;
        while(ite > 0) {
            if (d == t.data) {
                return t;
            }
            //System.out.println(t.data);
            ite--;
            t = t.next;
        }
        return null;
    }
}



public class TwoPoints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter X: ");
        int x = sc.nextInt();
        System.out.print("Enter Y: ");
        int y = sc.nextInt();
        int result = computePointOfInterception(x, y);
        System.out.println("Both X and Y will meet at point --> "+result);
    }
    public static int computePointOfInterception(int x, int y) {
        //TODO Add your implementation here
        CircularLinkedList c = new CircularLinkedList();
        Node X = c.getNode(x);
        Node Y = c.getNode(y);

        while(X != Y){
            X = X.next.next;
            Y = Y.next;
           // System.out.println(X.data + " " + Y.data);
        }

        return X.data;
    }
}