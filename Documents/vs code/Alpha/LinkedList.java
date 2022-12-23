class LinkedList{

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    // Add data before (In First)
    public void addFirst(int data){
        Node newNode = new Node(data);  //creating new node
        size++;
        if(head==null){   
            head = tail = newNode;
            return;
        }
        newNode.next = head; //giving refrence of head 

        head = newNode; //now newnode become head
    }


    // Add data after (in Last)
    public void addLast(int data){
        Node newNode  =  new Node(data);
         size++;
        if(head==null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;

        tail = newNode;
    }

    //add in middle
    public void add(int idx,int data){
        if(idx==0){
            addFirst(data);
            return;
        }
         size++;
        Node newNode = new Node(data);
        Node temp = head;
        int i=0;
        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        //i = idx-1, temp->prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    //remove first node
    public int removeFirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
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
    //remove last node
    public int removeLast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for(int i=0;i<size-2;i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        size--;
        prev.next = null;
        tail = prev;
        return val;
    }
    //printing
    public void print(){
        if(head==null){
            System.out.print("LL is null");
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int itretive(int key){
        Node temp = head;
        int i =0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }
    
    //recursive search
    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx = helper(head.next,key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key){
        return helper(head,key);
    }

    //reverse a linkedlist
    public void reverse(){
        Node prev = null;
        Node curr = tail= head;
        Node next;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //delete node 
    public void deleteNthfromEnd(int n){
        int sz = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            sz++;
        }

        if(n==sz){
            head = head.next;
            return;
        }

        //sz-n
        int i = 1;
        int iToFind= sz-n;
        Node prev = head;
        while(i<iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
        
    }

    //find middle 
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public static void main(String[] args){
       LinkedList ll = new LinkedList();
       ll.print();
       ll.addFirst(2);
       ll.print();
       ll.addFirst(1);
       ll.print();
       ll.addLast(3);
       ll.print();
       ll.addLast(4);
       ll.print();
       ll.add(2,5);
       ll.print();
    //    System.out.println("Size is "+ll.size);
    //    System.out.println("Removed Node is "+ll.removeFirst());
    //    ll.print();
    //    System.out.println("Size is "+ll.size);
    //    System.out.println("Removed Node is "+ll.removeLast());
    //    ll.print();
    //    System.out.println("Size is "+ll.size);

       System.out.println(ll.itretive(3));  //itretive search
       System.out.println(ll.recSearch(3));  //recursive search
       
    //    ll.reverse();
       ll.deleteNthfromEnd(3);
       ll.print();
    }
}