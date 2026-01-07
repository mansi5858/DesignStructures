package org.example.Designs;

import java.util.List;

public class RemoveNodeFromTheEnd {
    /**
     * Definition for singly-linked list.
     * */


        static public void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode ans = removeNthFromEnd(head, 2);

        System.out.println("Linked List after removing nth node from end: ");
        while(ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }

    }
      static public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


      static public ListNode removeNthFromEnd(ListNode head, int n) {

            int length = 0;
            ListNode curr = head;
            while(curr != null)
            {
                length++;
                curr = curr.next;
            }

            if(length == n)
                return head.next;

            int pos = length - 1 -n ;
            curr = head;
            while(pos >0)
            {
                pos--;
                curr = curr.next;
            }

            curr.next = curr.next.next;

            return head;
        }


}
