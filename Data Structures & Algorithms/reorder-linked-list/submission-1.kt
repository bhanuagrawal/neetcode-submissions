/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {

        var slow = head 
        var fast = head 

        while(fast?.next?.next!= null){
            slow = slow?.next
            fast = fast?.next?.next
        }

        var second = slow?.next
        slow?.next = null

        var prev: ListNode? = null

        while(second != null){
            val next = second.next
            second.next = prev
            prev = second
            second = next
        }

        second = prev
        var first = head 

        while(second!=null){ 
            
    
            val temp = first?.next
            val temp2 = second?.next 


            first?.next = second

            first = temp
            second?.next = temp
            second = temp2

        }




    }

// 2 4 6 
// 8 19 


}
