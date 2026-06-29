/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {

        reorderListUtil(head)

    }



    fun reorderListUtil(head: ListNode?): ListNode? {


        var second_last = head 

        while(second_last?.next?.next != null){
            second_last = second_last?.next
        }

        if(second_last == head) return head

        val last = second_last!!.next
        second_last.next = null
        last!!.next = reorderListUtil(head!!.next)
        head.next = last

        return head
    }
}
