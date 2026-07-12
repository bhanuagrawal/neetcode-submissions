/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        val (d, h) = dh(root)
        return d
    }

    fun dh(root: TreeNode?): Pair<Int, Int>{

        if(root == null) return 0 to 0

        val (ld, lh) = dh(root?.left)
        val (rd, rh) = dh(root?.right)

        return maxOf(ld, rd, lh+rh) to 1+maxOf(lh, rh)

    }
}
