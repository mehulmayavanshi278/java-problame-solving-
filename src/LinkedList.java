import javax.management.modelmbean.ModelMBean;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }


}

public class LinkedList {


    public static Node createSingleLinkedList(int[] a) {
        if (a.length == 0) {
            return null;
        }
        Node head = new Node(a[0]);
        Node curr = head;
        for (int i = 1; i < a.length; i++) {
            Node temp = new Node(a[i]);
            curr.next = temp;
            curr = curr.next;
        }
        return head;
    }

    public static Node createDoublyLinkedList(int[] a){
        if(a.length==0){
            return null;
        }
        Node head = new Node(a[0]);
        Node curr=head;


        for(int i=1;i<a.length;i++){
          Node temp = new Node(a[i]);
          temp.prev=curr;
          curr.next=temp;
          curr=curr.next;
        }
        return head;
    }


    public static void PrintDoublyLinkedList(Node head){
        while (head.next!=null){
            System.out.print(head.data + " ");
            head=head.next;
        }
        System.out.print(head.data);
        System.out.println("");
        while (head!=null){
            System.out.print(head.data + " ");
            head=head.prev;
        }
    }

    public static void PrintSinglyLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head=head.next;
        }

    }





    Node insertAtEnd(Node head , int k){
        Node curr = head;
        while (curr.next!=null){
            curr=curr.next;
        }
        Node temp = new Node(k);
        curr.next=temp;
        return head;
    }


    Node addNodeToDoublyLinkedList(Node head, int index , int data){
        Node curr = head;
        int count=0;

        while (curr!=null){
           if(count==index){
               break;
           }
           count++;
           curr=curr.next;
        }
        Node temp = new Node(data);
        temp.next=curr.next;
        temp.prev=curr;
        curr.next=temp;
        return head;
    }



    Node deleteNode(Node head , int pos){
        int count=1;
        if(pos==1){
            head=head.next;
            head.prev=null;
            return head;
        }
        Node curr = head;
        while (curr!=null){
            if(count==pos){
                break;
            }
            count++;
            curr=curr.next;
        }
        Node prv=curr.prev;
        prv.next=curr.next;
        //   System.out.println(curr.data);
        return head;
    }


    Node reverseDLL(Node head){
        Node temp = null;
        Node current = head;

        // Swap next and prev pointers for each node
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        // Adjust head pointer
        if (temp != null) {
            head = temp.prev;
        }
        return head;
    }

    Node oddEvenList(Node head){
        if(head==null || head.next==null || head.next.next==null){
            return head;
        }
        Node curr=head;
        Node curr2=head.next;
        Node start=curr2;
        while (curr!=null && curr.next!=null && curr2!=null && curr2.next!=null){
            curr.next=curr.next.next;
            curr2.next=curr2.next.next;
            curr=curr.next;
            curr2=curr2.next;
        }
        curr.next=start;
        return head;
    }

    Node deleteMiddle(Node head){
        Node curr=head;
        Node slow=curr;
        Node fast=curr;
        Node prev=slow;
        while (slow!=null && fast!=null && fast.next!=null){
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        if(prev==slow){
            return null;
        }else{
            prev.next=slow.next;
        }
        return head;
    }

    public Node findMid(Node head){
        Node slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public Node mergeTwoLists(Node a, Node b) {
        if(a==null)return b;
        if(b==null)return a;
        Node head=null,tail=null;
        if(a.data<=b.data){
            head=tail=a;
            a=a.next;
        }
        else{
            head=tail=b;
            b=b.next;
        }
        while(a!=null && b!=null){
            if(a.data<=b.data){
                tail.next=a;
                tail=a;
                a=a.next;
            }
            else{
                tail.next=b;
                tail=b;
                b=b.next;
            }
        }
        if(a==null){
            tail.next=b;
        }
        else{
            tail.next=a;
        }
        return head;
    }
    Node sortList(Node head){
        if(head==null || head.next==null)return head;

        Node mid=findMid(head);
        Node left=head;
        Node right=mid.next;
        mid.next=null;

        left=sortList(left);
        right=sortList(right);

        Node res=mergeTwoLists(left,right);
        return res;
    }

    Node deleteAllOccurOfX(Node head , int k){    // 2,2,10,8,4,2,5,2

        while (head!=null && head.data==k){
           head=head.next;
        }
        head.prev=null;
        Node prev=head;
        Node curr=head.next;

        while (curr!=null){
         Node temp=curr;
         if(curr.data==k){
             while (curr!=null && curr.data==k){
                 curr=curr.next;
             }
             if(curr!=null){
                 curr.prev=prev;
             }
             prev.next=curr;
         }
         prev=curr;
         if(curr!=null){
             curr=curr.next;
         }
        }

        return head;
    }

    Node removeDuplicates(Node head){
        Node curr=head;
        Node prev=head;
        curr=curr.next;
        while (curr!=null){
            if(prev.data==curr.data){
                while (curr!=null && prev.data==curr.data){
                    curr=curr.next;
                }
                if(curr!=null){
                    curr.prev=prev;
                }
                prev.next=curr;
            }
            prev=curr;
            if(curr!=null){
                curr=curr.next;
            }

        }
        return head;
    }

    Node rotateList(Node head , int k){
        if(k==0 || head==null || head.next==null){
            return head;
        }
        Node curr=head;
        Node slow=curr;
        int index=0;
        for(int i=0;i<k&&slow!=null;i++){
            slow=slow.next;
            index++;
        }
        if(k>index){
            k=k%index;
            if(k==0){
                return head;
            }
        }

        System.out.println("k:"+k);
        if(k==index && slow==null){
            return head;
        }
        slow=head;
        for(int i=0;i<k;i++){
            slow=slow.next;
        }
        curr=head;
        Node prev1=curr;
        Node prev2=slow;

        while (slow!=null){
            prev2=slow;
            slow=slow.next;
            prev1=curr;
            curr=curr.next;
        }
//       System.out.println(curr.data);
//       System.out.println(prev1.data);

        prev1.next=null;
        prev2.next=head;


        return curr;
    }
    public static void main(String[] args){

        LinkedList l1 = new LinkedList();
//        Linked List Insertion At End


//          int[] a = {1,2,3,4,5};
//          int k=6;
//          Node head = createSingleLinkedList(a);
//          head =  l1.insertAtEnd(head ,k);
//          PrintSinglyLinkedList(head);



//        Introduction to Doubly Linked Lis
//           int[] a = {1,2,3,4,5,6};
//           Node head = createDoublyLinkedList(a);
//           PrintDoublyLinkedList(head);


//        Doubly linked list Insertion at given position
//          int[] a = {2,4,5};
//          Node head = createDoublyLinkedList(a);
//          int p=2,x=6;
//          head = l1.addNodeToDoublyLinkedList(head , p,x);
//          PrintDoublyLinkedList(head);


//        Delete node in Doubly Linked List

//          int[] a = {1,5,2,9};
//          Node head = createDoublyLinkedList(a);
//          int pos=3;
//          head = l1.deleteNode(head,pos);
//          PrintDoublyLinkedList(head);


//        Reverse a Doubly Linked Lis
//           int[] a = {3,4,5};
//           Node head = createDoublyLinkedList(a);
//           head = l1.reverseDLL(head);
//           PrintSinglyLinkedList(head);

//        328. Odd Even Linked List
//              int[] a = {2,1,3,5,6,4};
//              Node head = createSingleLinkedList(a);
//               head= l1.oddEvenList(head);
//              PrintSinglyLinkedList(head);

//        2095. Delete the Middle Node of a Linked List
//                int[] a= {1,3,4,7,1,2,6};
//                Node head = createSingleLinkedList(a);
//                head= l1.deleteMiddle(head);
//                PrintSinglyLinkedList(head);


//        148. Sort List
//           int[] a= {4,2,1,3};
//           Node head=createSingleLinkedList(a);
//           head=l1.sortList(head);
//           PrintSinglyLinkedList(head);


//        Sort a linked list of 0s, 1s and

//        Delete all occurrences of a given key in a doubly linked list
//           int[] a = {2,2,10,8,4,2,5,2};
//           Node head = createDoublyLinkedList(a);
//           int k=2;
//           head = l1.deleteAllOccurOfX(head,k);
//           PrintDoublyLinkedList(head);


//        Remove duplicates from a sorted doubly linked list
//           int[] a = {1,2,2,3,3,4,4};
//           Node head = createDoublyLinkedList(a);
//           head = l1.removeDuplicates(head);
//           PrintDoublyLinkedList(head);

//        61. Rotate List
              int[] a = {1,2,3,4,5};
//              int[] a = {0,1,2};
              int k=2;
              Node head = createSingleLinkedList(a);
              head = l1.rotateList(head , k);
              PrintSinglyLinkedList(head);





    }


}
