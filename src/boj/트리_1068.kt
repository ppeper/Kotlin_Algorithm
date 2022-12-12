package boj

import java.util.LinkedList
import java.util.Scanner

private var leafs = 0
private var root = 0
fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val tree = Array(N) { LinkedList<Int>() }
    for (node in 0 until N) {
        val parent = nextInt()
        if (parent == -1) {
            root = node
            continue
        }
        tree[parent].add(node)
    }
    val deleteNode = nextInt()
    if (deleteNode == root) println(0)
    else {
        for (i in tree.indices) {
            val child = tree[i]
            if (i == deleteNode) child.clear()
            if (child.contains(deleteNode)) child.remove(deleteNode)
        }
        checkLeaf(tree, root)
        println(leafs)
    }
}

private fun checkLeaf(tree: Array<LinkedList<Int>>, root: Int) {
    if (tree[root].isEmpty()) {
        leafs++
        return
    }
    for (child in tree[root]) {
        checkLeaf(tree, child)
    }
}
