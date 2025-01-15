package LinkedList;

public class DLL {
    private Node head;
    private Node tail;

    public Node find(int index){
        Node p = head;
        for (int i = 1; i < index; i++) {
            p = p.next;
        }
        return p;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;
    }

    public void insert(int val, int index) {
        Node p = find(index);
        if (p == null) {
            System.out.println("does not exist");
            return;
        }
        Node temp = new Node(val);
        temp.next = p.next;
        p.next = temp;
        temp.prev = p;
        if (temp.next != null) {
            temp.next.prev = temp;
        }
    }

    public void display(){
        Node node = head;
        while(node != null){
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.println("END");
    }

    private class Node {
        private Node next;
        private Node prev;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertFirst(2);
        list.insertFirst(4);
        list.insert(5, 3);
        list.display();
    }
}
