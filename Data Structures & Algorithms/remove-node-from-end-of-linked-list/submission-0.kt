/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var first = head 
        var second = head

        for(i in 0 until n){
            second = second?.next
        }

        var dummy = ListNode(0)
        dummy.next = head 

        var prev: ListNode? = dummy

        while(second != null){
            prev = first
            first = first?.next
            second = second?.next
        }

   

        prev?.next = first?.next
        first = null 

        return dummy?.next


    }
}
