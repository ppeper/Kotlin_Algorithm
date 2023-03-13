package boj.완전탐색

import java.util.*

private var answer = 0
private lateinit var visited: Array<BooleanArray>
data class Rock(val a: Int, val b: Int, val c: Int)
fun main() = with(System.`in`.bufferedReader()) {
    val (a, b, c) = readLine().split(" ").map { it.toInt() }
    visited = Array(1501) { BooleanArray(1501) }
    val sum = a + b + c
    if (sum % 3 != 0) {
        println(0)
    } else {
        search(Rock(a, b, c))
        println(answer)
    }
}

private fun search(rock: Rock) {
    val queue = LinkedList<Rock>()
    queue.offer(rock)
    visited[rock.a][rock.b] = true
    while (queue.isNotEmpty()) {
        val rock = queue.poll()
        if (rock.a == rock.b && rock.b == rock.c) {
            answer = 1
            break
        }
        for (i in 1..3) {
            val moveRock = moveRock(rock, i)
            if (i == 1 && !visited[moveRock.a][moveRock.b]) {
                visited[moveRock.a][moveRock.b] = true
                queue.offer(moveRock)
            } else if (i == 2 && !visited[moveRock.a][moveRock.c]) {
                visited[moveRock.a][moveRock.c] = true
                queue.offer(moveRock)
            } else if (i == 3 && !visited[moveRock.b][moveRock.c]) {
                visited[moveRock.b][moveRock.c] = true
                queue.offer(moveRock)
            }
        }
    }
}

private fun moveRock(rock: Rock, i: Int): Rock {
    when (i) {
        1 -> {
            return if (rock.a < rock.b) {
                Rock(rock.a * 2, rock.b - rock.a, rock.c)
            } else {
                Rock(rock.a - rock.b, rock.b * 2, rock.c)
            }
        }

        2 -> {
            return if (rock.a < rock.c) {
                Rock(rock.a * 2, rock.b, rock.c - rock.a)
            } else {
                Rock(rock.a - rock.c, rock.b, rock.c * 2)
            }
        }

        3 -> {
            return if (rock.b < rock.c) {
                Rock(rock.a, rock.b * 2, rock.c - rock.b)
            } else {
                Rock(rock.a, rock.b - rock.c, rock.c * 2)
            }
        }
        else -> return rock
    }
}