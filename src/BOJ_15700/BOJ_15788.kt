package BOJ_15700

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { readln().split(" ").map { it.toLong() }.toLongArray() }

    // 빈 칸(0)의 위치 찾기
    var emptyX = -1
    var emptyY = -1
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (arr[i][j] == 0L) {
                emptyX = i
                emptyY = j
            }
        }
    }

    // 목표 합 구하기: 빈 칸이 없는 행에서 찾기
    val targetSum = if (emptyX != 1) {
        arr[1].sum()  // 1번 행의 합
    } else {
        arr[0].sum()  // 0번 행의 합
    }

    // 빈 칸이 있는 행의 현재 합
    val currentSum = arr[emptyX].sum()

    // 빈 칸에 들어갈 값 계산
    val m = targetSum - currentSum

    // M은 자연수여야 함 (1 이상)
    if (m < 1) {
        println(-1)
        return
    }

    // 빈 칸에 값 채우기
    arr[emptyX][emptyY] = m

    // 검증: 모든 행과 열의 합이 targetSum과 같은지 확인
    for (i in 0 until n) {
        if (arr[i].sum() != targetSum) {
            println(-1)
            return
        }

        var colSum = 0L
        for (j in 0 until n) {
            colSum += arr[j][i]
        }
        if (colSum != targetSum) {
            println(-1)
            return
        }
    }

    // 검증: 주 대각선과 부 대각선의 합 확인
    var diag1 = 0L  // 주 대각선 (↘)
    var diag2 = 0L  // 부 대각선 (↙)
    for (i in 0 until n) {
        diag1 += arr[i][i]
        diag2 += arr[i][n - 1 - i]
    }

    val result = if (diag1 == targetSum && diag2 == targetSum) m else -1
    println(result)
}