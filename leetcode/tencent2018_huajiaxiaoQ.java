package leetcode;
/*画家小Q又开始他的艺术创作。小Q拿出了一块有NxM像素格的画板, 画板初始状态是空白的,用'X'表示。
        小Q有他独特的绘画技巧,每次小Q会选择一条斜线, 如果斜线的方向形如'/',即斜率为1,小Q会选择这条斜线中的一段格子,都涂画为蓝色,用'B'表示;如果对角线的方向形如'\',即斜率为-1,小Q会选择这条斜线中的一段格子,都涂画为黄色,用'Y'表示。
        如果一个格子既被蓝色涂画过又被黄色涂画过,那么这个格子就会变成绿色,用'G'表示。
        小Q已经有想画出的作品的样子, 请你帮他计算一下他最少需要多少次操作完成这幅画。

        每个输入包含一个测试用例。
        每个测试用例的第一行包含两个正整数N和M(1 <= N, M <= 50), 表示画板的长宽。
        接下来的N行包含N个长度为M的字符串, 其中包含字符'B','Y','G','X',分别表示蓝色,黄色,绿色,空白。整个表示小Q要完成的作品

        4 4
        YXXB
        XYGX
        XBYY
        BXXY

      output:3*/

import java.util.Scanner;

public class tencent2018_huajiaxiaoQ {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'Y') {
                    dfsY(map, n, m, i, j);
                    count++;
                } else if (map[i][j] == 'B') {
                    dfsB(map, n, m, i, j);
                    count++;
                } else if (map[i][j] == 'G') {
                    dfsY(map, n, m, i, j);
                    map[i][j] = 'B';
                    dfsB(map, n, m, i, j);
                    count += 2;
                }
            }
        }

        System.out.println(count);
    }


    private static void dfsY(char[][] map, int n, int m, int i, int j) {
        if (i >= 0 && i < n && j >= 0 && j < m && (map[i][j] == 'Y' || map[i][j] == 'G')) {
            if (map[i][j] == 'G') {
                map[i][j] = 'B';
            } else {
                map[i][j] = 'X';
            }
            dfsY(map, n, m, i - 1, j - 1);
            dfsY(map, n, m, i + 1, j + 1);
        }
    }

    private static void dfsB(char[][] map, int n, int m, int i, int j) {

        if (i >= 0 && i < n && j >= 0 && j < m && (map[i][j] == 'B' || map[i][j] == 'G')) {
            if (map[i][j] == 'G') {
                map[i][j] = 'Y';
            } else {
                map[i][j] = 'X';
            }
            dfsB(map, n, m, i + 1, j - 1);
            dfsB(map, n, m, i - 1, j + 1);
        }
    }

}


