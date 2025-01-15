package LinkedList;

public class CLL {
    private Node head;
    private Node tail;

    public CLL() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int val) {
        Node node = new Node(val);
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    private class Node {
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public void delete(int val) {
        Node node = head;
        if(node == null){
            return;
        }
        if(head == tail){
            if(node.value == val){
                head = null;
                tail = null;
                return;
            } else {
                System.out.println("does not exist");
                return;
            }
        }
        if(node.value == val){
            head = node.next;
            tail.next = head;
            return;
        }

        do {
            Node n = node.next;
//            System.out.println("n: " + n.value + " node: "+ node.value);
            if(n.value == val){
                node.next = n.next;
                break;
            }
            node = node.next;
        } while(node != head);
    }

    public void display(){
        Node node = head;
        if(head != null){
            do {
                System.out.print(node.value + " -> ");
                if(node.next != null){
                    node = node.next;
                }
            } while (node != head);
        }
        System.out.println("HEAD");
    }

    public static void main(String[] args) {
        CLL list = new CLL();
        list.insert(2);
        list.delete(4);
        list.insert(5);
        list.insert(8);
        list.insert(9);
        list.display();
        list.delete(2);
        list.display();
    }
}
