/**
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []
*/

/**
 
Definition for singly-linked list.
public class ListNode {
int val;
ListNode next;
ListNode() {}
ListNode(int val) { this.val = val; }
ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int leng = lists.length;
        if (leng == 0) {
            return null;
        } else if (leng == 1) {
            return lists[0];
        }
        ListNode merged = new ListNode();
        ListNode live = merged;


        int num = 0;
        boolean end = true;
        boolean first = true;
        while (true) {
            num = 0;
            end = true;
            for (int i = 0; i < leng; i++) {
                if (lists[i] == null) {
                    if (end == true) num++;
                } else if (lists[num].val > lists[i].val) {
                    num = i;
                    end = false;
                } else {
                    end = false;
                }
            }
            if (end) break;

            live.next = new ListNode();
            live = live.next;
            live.val = lists[num].val;
            lists[num] = lists[num].next;
            
        }

        return merged.next;
    }
}
