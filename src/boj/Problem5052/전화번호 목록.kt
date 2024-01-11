package boj.Problem5052

class Trie {
    inner class TrieNode {
        val children: HashMap<Char, TrieNode> = hashMapOf()
        var isTerminate: Boolean = false
    }

    private val root = TrieNode()

    fun insert(word: String) {
        var currentNode = root
        word.forEach { ch ->
            currentNode.children.putIfAbsent(ch, TrieNode())
            currentNode = currentNode.children[ch]!!
        }
        currentNode.isTerminate = true
    }

    fun searchPrefix(prefix: String): Boolean {
        var currentNode = root
        prefix.forEach { ch ->
            if (!currentNode.children.containsKey(ch)) {
                return false
            }
            currentNode = currentNode.children[ch]!!
        }
        return currentNode.children.isNotEmpty()
    }
}

private var sb = StringBuilder()
private lateinit var words: MutableList<String>
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    repeat(n) {
        var check = false
        val m = readLine().toInt()
        val trie = Trie()
        words = mutableListOf()
        repeat(m) {
            val number = readLine()
            words.add(number)
            trie.insert(number)
        }
        words.sort()

        for (word in words) {
            if (trie.searchPrefix(word)) {
                sb.append("NO\n")
                check = true
                break
            }
        }
        if (!check) sb.append("YES\n")
    }
    println(sb.toString())
}