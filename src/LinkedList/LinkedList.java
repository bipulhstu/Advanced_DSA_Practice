package LinkedList;

public class LinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size = 0;

    //Add an element in Linked List
    //Add First
    // Step 1: Create a new Node
    // Step 2: new Node's next = head
    // Step 3: head = new Node
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;

        //if linked list is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }


    // Add Last
    // Step 1: Create a new Node
    // Step 2: tail.next = newNode
    // Step 3:tail = newNode
    public void addLast(int data){
        Node newNode = new Node(data);
        size++;

        // if linked list is empty
        if (head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void printLinkedList(){
        if (head == null){
            System.out.println("Linked List is empty");
            return;
        }
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int index, int data){
        if(index == 0){
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;
        while (i < index - 1){ //finding previous node
            temp = temp.next;
            i++;
        }

        //temp (previous)
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("Linked List is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) { // only one value
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;

        return val;
    }

    //remove last
    // Step 1: Find previous node and set prev.next = null
    // Step 2: set tail = prev
    public int removeLast(){
        if(size == 0){
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        //prev: i = size - 2 (last: size - 1 & prev: size - 2)
        Node temp = head;
        for(int i = 0; i < size - 2; i++){
            temp = temp.next;
        }

        //temp (prev)
        int val = temp.next.data; // tail.data
        temp.next = null;
        tail = temp;
        size--;

        return val;
    }

    // Search for a key in a Linked List. Return the position whre it is found.
    // If not found, return -1.
    public int iterativeSearch(int key){
        Node temp = head;
        int i = 0;

        while (temp != null){
            if(temp.data == key) { //key found
                return i;
            }
            temp = temp.next;
            i++;
        }

        //key not found
        return -1;
    }

    public int recursiveSearch(int key){
        return helper(head, key);
    }

    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }

        if(head.data == key){ //key found
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }

        return idx+1; //increase index on backtracking
    }

    public void deleteNthfromEnd(int n){
        //calculate size
        int sz = 0;
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            sz++;
        }

        if(n == sz){
            head = head.next; //remove first
            size = 0;
            return;
        }

        //calculate index from start
        int i = 1;
        int indexToFind = sz - n;
        Node prev = head;
        while ( i < indexToFind){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        size--;
        return;
    }

    //slow-fast approach
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }

        return slow; //slow is my midNode
    }

    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //Step 1: Find the mid
        Node midNode = findMid(head);

        //Step 2: Reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; //right half head
        Node left = head; //left half head

        //Step 3: Check left half & right half
        while (right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.printLinkedList();
        ll.addFirst(1);
        ll.printLinkedList();
        ll.addLast(2);
        ll.printLinkedList();
        ll.addLast(4);
        ll.addLast(4);
        ll.add(2, 9);

        ll.printLinkedList();

        System.out.println("Size of the Linked List: "+ size);

        System.out.println();
        ll.removeFirst();
        ll.printLinkedList();
        System.out.println("Size of the Linked List: "+ size);


        System.out.println();
        ll.removeLast();
        ll.printLinkedList();
        System.out.println("Size of the Linked List: "+ size);

        System.out.println(ll.iterativeSearch(9));
        System.out.println(ll.iterativeSearch(10));

        System.out.println(ll.recursiveSearch(3));
        System.out.println(ll.recursiveSearch(10));


        System.out.println();
        ll.deleteNthfromEnd(1);
        ll.printLinkedList();
        System.out.println("Size of the Linked List: "+ size);

        System.out.println();
        ll.add(3, 2);
        ll.removeLast();
        ll.printLinkedList();
        //ll.addLast(2);
        System.out.println(ll.checkPalindrome());
    }
}
