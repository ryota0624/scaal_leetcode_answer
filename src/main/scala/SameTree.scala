object SameTree {

  import utils._

  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    if (p == null && q == null) return true
    if (p == null && q != null) return false
    if (p != null && q == null) return false
    p.value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
  }
}
