/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 결과는 list1의 길이 + list2의 길이
        ListNode result = new ListNode();
        ListNode cur = result;

        // 둘다 null이 아닐때동안 순회
        while (list1 != null && list2 != null) {
            // 만약 list1의 값이 list2의 값보다 크다면 list1의 값을 연결해준뒤 next
            // else list2의 값을 연결해준뒤 next
            if (list1.val <= list2.val) {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            cur = cur.next;
        }

        // list1이 null이 아니라면
        // list1 link

        if (list1 != null) {
            cur.next = list1;
        } else {
            cur.next = list2;
        }
        return result.next;
    }
}