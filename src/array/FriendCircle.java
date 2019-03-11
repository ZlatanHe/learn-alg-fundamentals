package array;

/**
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。
 * 如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 * Created by Zlatan on 19/3/11.
 */
public class FriendCircle {

    public int findCircleNum(int[][] M) {
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            if (depthFirstSearch(M, i)) {
                res++;
            }
        }
        return res;
    }

    private boolean depthFirstSearch(int[][] M, int i) {
        if (M[i][i] == 2) {
            // 这个人的朋友圈被搜索过了
            return false;
        }
        M[i][i] = 2; // 标记下已经搜索过这个人的朋友圈
        for (int j = 0; j < M.length; j++) {
            if (j == i) {
                continue;
            }
            if (M[i][j] != 1) {
                // 朋友关系已经遍历过或者不是朋友
                continue;
            }
            M[i][j] = 2;
            M[j][i] = 2;
            depthFirstSearch(M, j);
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] M = new int[][] {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(new FriendCircle().findCircleNum(M));
    }
}
