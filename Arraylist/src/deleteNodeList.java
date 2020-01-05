/**
 * Created by Sharath Nagendra on 7/27/2017.
 */
public class deleteNodeList {
    static ListNode head;

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //function which displays the node at the nth position from the rear
    public static void deleteNode(int index) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
            length++;
        }
        if (length < index)
            return;
        // System.out.println(length);
        temp = head;
        //for nth element from first replace the condition in for loop: froklm i<length-index+1 to i<index
        for (int i = 1; i <  length -index+1 ; i++) {


            temp = temp.next;
        }


        System.out.println(index + "nd element from the last is " + temp.val);
    }

    public static void push(int data) {
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;

    }

    //function to delete nth node from the rear
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    public static ListNode partition(ListNode node,int x){

        ListNode beforeStart=null;
        ListNode beforeEnd=null;
        ListNode afterStart=null;
        ListNode afterEnd=null;


        while(node!=null){
            ListNode nextNode = node.next;
            node.next=null;

            if(node.val<x){
                if(beforeStart==null){
                    beforeStart = node;
                    beforeEnd=beforeStart;
                }
                else
                {
                    beforeEnd.next=node;
                    beforeEnd=node;
                }
            }

            else
            {
                if(afterStart==null)
                {
                    afterStart=node;
                    afterEnd=afterStart;
                }
                else
                {
                    afterEnd.next=node;
                    afterEnd=node;
                }
            }
            node=nextNode;
        }
        if(beforeStart==null)
            return afterStart;

        beforeEnd.next=afterStart;
        return beforeStart;


    }

//3 5 8 5 10 2 1
    public static ListNode anotherPartition(ListNode node,int x){

        ListNode head=node;
        ListNode tail=node;
        while(node!=null){
            ListNode nextNode = node.next;
            if(node.val<x){
                node.next=head;
                head=node;
            }
            else
            {
                tail.next=node;
                tail=node;
            }
            node=nextNode;
        }
        tail.next=null;
        return head;
    }

    public static void main(String[] args) {
//        deleteNodeList obj = new deleteNodeList();
//
//        obj.push(20);//last element
//        obj.push(4);
//        obj.push(15);
//        obj.push(35);//first element

//        ListNode x = new ListNode(1);
//        x.next = new ListNode(2);
//        x.next.next = new ListNode(3);
//        x.next.next.next = new ListNode(4);
//        x.next.next.next.next = new ListNode(5);

        int index = 5;
     //   System.out.println(removeNthFromEnd(x, index));
      //  deleteNode(index);

        push(1);
        push(2);
        push(10);
        push(5);
        push(8);
        push(5);
        push(3);

        ListNode ptr = head;    System.out.println("The elemenets before partition in list");
        while(ptr!=null)
        {

            System.out.println(ptr.val);
            ptr=ptr.next;
        }
        ListNode res =anotherPartition(head,5);
        ListNode cur=res;
        System.out.println("elements after partition");
        while(cur!=null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
        }


}
