package boj.`과거 문제들 정리`

data class Node(
    val data: String,
    var left: Node? = null,
    var right: Node? = null
)

class Tree {
    var root: Node? = null

    fun add(data: String, left: String, right: String) {
        if (root == null) {
            if (data != ".") root = Node(data)
            if (left != ".") root!!.left = Node(left)
            if (right != ".") root!!.right = Node(right)
        } else {
            position(root!!, data, left, right)
        }
    }

    private fun position(root: Node, data: String, left: String, right: String) {
        if (root.data == data) {
            if (left != ".") root.left = Node(left)
            if (right != ".") root.right = Node(right)
        } else {
            root.left?.let { position(root.left!!, data, left, right) }
            root.right?.let { position(root.right!!, data, left, right) }
        }
    }

    fun inOrder(root: Node) {
        root.left?.let { inOrder(root.left!!) }
        print(root.data)
        root.right?.let { inOrder(root.right!!) }
    }

    fun preOrder(root: Node) {
        print(root.data)
        root.left?.let { preOrder(root.left!!) }
        root.right?.let { preOrder(root.right!!) }
    }

    fun postOrder(root: Node) {
        root.left?.let { postOrder(root.left!!) }
        root.right?.let { postOrder(root.right!!) }
        print(root.data)
    }
}
fun main() {
    val size = readln().toInt()
    val tree = Tree()
    repeat(size) {
        val (node, left, right) = readLine()!!.split(' ')
        tree.add(node, left, right)
    }
    tree.preOrder(tree.root!!)
    println()
    tree.inOrder(tree.root!!)
    println()
    tree.postOrder(tree.root!!)
}