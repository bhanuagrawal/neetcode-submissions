/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

            if(root == null) return null 

            val isRoot = root?.`val` == p?.`val` || root?.`val` == q?.`val`

            val left = lowestCommonAncestor(root?.left, p, q)
            val right = lowestCommonAncestor(root?.right, p, q)


            return if(isRoot || (left!= null && right != null)){
                root
            }else{
                left?: right
            }
    }
}
