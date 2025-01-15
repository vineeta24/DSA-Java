package LinkedList;

public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public void display() {
        Node temp = head;
        while (temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insert(int val, int index){
        if(index == 0){
            insertFirst(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size++;
    }

    public void insertLast(int val) {
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public Node find(int val) {
        Node node = head;
        while(node != null){
            if(node.value == val){
                System.out.println("Found");
                return node;
            }
            node = node.next;
        }
        System.out.println("Not Found");
        return null;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void deleteFirst() {
        head = get(1);   // similar head.next
        if(head == null){
            tail = null;
        }
        size--;
    }

    public void deleteLast(){
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
    }

    public void delete(int index){
        if(index == 0){
            deleteFirst();
        }
        if(index == size - 1){
            deleteLast();
        }
//        Node node = head;
//        for (int i = 1; i < index; i++) {
//            node = node.next;
//        }
//        node.next = node.next.next;
        Node prev = get(index-1);
        prev.next = prev.next.next;
        size--;
    }

    public static void mergeTwoList(LL list1, LL list2){
        Node f = list1.head;
        Node s = list2.head;

        LL ans = new LL();
        while (f != null && s != null) {
            if(f.value < s.value){
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }
        while (f != null){
            ans.insertLast(f.value);
            f = f.next;
        }
        while (s != null){
            ans.insertLast(s.value);
            s = s.next;
        }
        System.out.print("Merged: ");
        ans.display();
    }


    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LL list = new LL();
        // basic
//        list.insertFirst(1);
//        list.insert(2, 1);
//        list.insert(3, 2);
//        list.insert(4, 3);
//        list.insert(5, 4);
//        list.display();
//        list.delete(2);
//        list.display();

        LL list1 = new LL();
        LL list2 = new LL();

        list1.insert(1, 0);
        list1.insert(2, 1);
        list1.insert(5, 2);

        list2.insert(1, 0);
        list2.insert(3, 1);
        list2.insert(4, 2);

        System.out.print("List1: ");
        list1.display();
        System.out.print("List2: ");
        list2.display();

        LL.mergeTwoList(list1, list2);

    }

}
