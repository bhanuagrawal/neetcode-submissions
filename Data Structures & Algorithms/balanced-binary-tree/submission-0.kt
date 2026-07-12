/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    var balance = true 
    fun isBalanced(root: TreeNode?): Boolean {
        height(root)
        return balance
    }

    fun height(root: TreeNode?): Int {

        if(root == null) return 0

        val lh = height(root?.left)
        if(!balance) return 0

        val rh = height(root?.right)
        if(!balance) return 0

        balance = Math.abs(lh-rh) < 2

        return maxOf(lh, rh) + 1
    }
}
