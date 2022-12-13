package boj

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    data class Node(val node: Int, var left: Node? = null, var right: Node? = null)
    fun add(node: Int, tree: Node) {
        // 오른쪽
        if (tree.node < node) {
            if (tree.right == null) {
                tree.right = Node(node)
            } else {
                add(node, tree.right!!)
            }
        } else {
            // 왼쪽
            if (tree.left == null) {
                tree.left = Node(node)
            } else {
                add(node, tree.left!!)
            }
        }
    }

    fun postOrder(tree: Node) {
        tree.left?.let { postOrder(tree.left!!) }
        tree.right?.let { postOrder(tree.right!!) }
        println(tree.node)
    }

    val root = readLine().toInt()
    val tree = Node(root)
    while (true) {
        val node = readLine() ?: break
        add(node.toInt(), tree)
    }
    postOrder(tree)
}
