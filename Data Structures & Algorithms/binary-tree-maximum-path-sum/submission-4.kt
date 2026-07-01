/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    var max = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        postOrder(root)
        return max
    }

    fun postOrder(root: TreeNode?): Int{

        if(root == null) return 0

        val left = maxOf(0, postOrder(root?.left))
        val right= maxOf(0, postOrder(root?.right))


        val a = root.`val` + maxOf(left, right, 0)

        max = maxOf(max, left + right + root.`val`)
        return a


    }
}
