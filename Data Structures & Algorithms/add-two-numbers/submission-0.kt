/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        var head1 = l1
        var head2 = l2

        var result: ListNode? = null
        var prev: ListNode? = null

        var carry = 0

        while(head1!= null || head2 != null){

            var sum = (head1?.`val`?:0) + (head2?.`val`?:0) + carry
            carry = if(sum > 9) 1 else 0
            sum = sum%10


            val newNode = ListNode(sum)
            if(result == null){
                result = newNode
            }

            prev?.next = newNode
            prev = newNode

            head1 = head1?.next
            head2 = head2?.next

        }


        if(carry == 1){
            prev?.next = ListNode(carry)
        }

        return result

    }
}
