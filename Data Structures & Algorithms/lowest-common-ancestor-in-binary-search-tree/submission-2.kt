/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        return lca(root, p!!, q!!)
    }

    fun lca(root: TreeNode?, p: TreeNode, q: TreeNode): TreeNode? {
        if(root == null) return null

        if(root!!.`val` == p.`val` || root!!.`val` == q.`val`){
            return root 
        }

        val lr = lca(root?.left, p, q)
        val rr = lca(root?.right, p, q)

        return if(lr != null && rr != null){
            root
        }else{
            lr?:rr
        }
    }
}
