/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxPathSum(root: TreeNode?): Int {
        val (a, b) = postOrder(root)
        return maxOf(a, b)
    }

    fun postOrder(root: TreeNode?): Pair<Int, Int>{

        if(root == null) return -19990 to -10000

        val left = postOrder(root?.left)
        val right= postOrder(root?.right)


        val a = maxOf(left.first + root.`val`, right.first + root.`val`, root.`val`)

        val b = maxOf(left.second, right.second, root.`val`, left.first + root.`val` + right.first)

        return a to b 


    }
}
