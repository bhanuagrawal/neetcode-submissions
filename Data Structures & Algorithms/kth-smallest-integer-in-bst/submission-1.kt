/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val count = IntArray(1){0}
        return inorder(root, k, count)?:0
    }

    fun inorder(root: TreeNode?, k: Int, count: IntArray): Int? {

        if(root == null) return null 

        val a = inorder(root.left, k, count)
        if(a!= null){
            return a
        }
        count[0]++
        if(count[0] == k){
            return root.`val`
        }
        val b = inorder(root.right, k, count)

        return b
    }

}
