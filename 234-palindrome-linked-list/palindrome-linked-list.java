/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         int count = 0;
        while(head!=null){
            head = head.next;
            count++;
        }
        int []arr = new int[count];
        int i = 0;
        while(head!=null){
            arr[i] = head.val;
            System.out.println(arr[i]);
            head = head.next;
            i++;
        }
        System.out.println(count);
        for(int k=0; k<arr.length; k++){
            //System.out.println(arr[k]);
        }
        for(int j = 0; j<count; j++){
            if(arr[j]==arr[count-j-1]){
                return true;
            }
        }
        return false;
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
    
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        
        slow = reverse(slow);
        fast = head;
        
        while(slow!=null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;   
        }

        return true;
        
    }
            public ListNode reverse(ListNode head){
            ListNode prev = null;
            while (head != null){
                ListNode temp = head.next;
                head.next = prev;
                prev = head;
                head = temp;
            }
            return prev;
        }
}