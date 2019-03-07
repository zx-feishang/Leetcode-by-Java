package leetcode;


import java.util.*;

// 输入第一行为测试数目，<=10
// 每个测试给出8*8初始局面，'.'表示未占满，’‘*’表示黑棋，‘o’表示白棋
// 接下来是整数N操作数
// 接下来N行表示N个操作，每行三个数，x,y,t(1<=x,y<=8，t=0表明是黑棋走，t=0表明是白棋走

//测试用例
// 输入
// 1
//........
//........
//........
//...o*...
//...*o...
//........
//........
//........
//2
//4 3 0
//3 3 1
// 输出
//3 3

public class Netease2019_BlackWhiteChess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            char[][] chs = new char[8][8];
            for (int j = 0; j < 8; j++) {
                chs[j] = sc.next().toCharArray();
            }

            int steps = sc.nextInt();
            int[] x = new int[steps];
            int[] y = new int[steps];
            int[] t = new int[steps];
            for (int k = 0; k < steps; k++) {
                x[k] = sc.nextInt();
                y[k] = sc.nextInt();
                t[k] = sc.nextInt();
            }
            process(chs, steps, x, y, t);
            int cntBlack = 0;
            int cntWhite = 0;
            for (int r = 0; r < 8; r++) {
                for (int c = 0; c < 8; c++) {
                    // 遍历计数
                    if (chs[r][c] == '*') {
                        cntBlack++;
                    }
                    if (chs[r][c] == 'o') {
                        cntWhite++;
                    }
                }
            }
            System.out.println(cntBlack + " " + cntWhite);

        }

    }

    private static void process(char[][] chs, int steps, int[] x, int[] y, int[] t) {
        for (int i = 0; i < steps; i++) {
            int row = x[i] - 1;
            int col = y[i] - 1;
            if (t[i] == 0) {
                fun(chs, row, col, '*');
            } else {
                fun(chs, row, col, 'o');
            }
        }
    }


    private static void fun(char[][] map, int row, int col, char c) {
        // DFS 遍历找到八个方向的最远点，然后沿着路径返回进行修改，注意边界条件
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int i = 0; i < direction.length; i++) {
            int x = row + direction[i][0];
            int y = col + direction[i][1];
            while (x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] != c && map[x][y] != '.') {
                // DFS沿着某个方向走到棋是自己的
                x += direction[i][0];
                y += direction[i][1];
            }
            if (x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] == c) {
                // 如果最终位置没有越界，表明可以翻转路径上对方的棋
                while ((x != row || y != col) && map[x -= direction[i][0]][y -= direction[i][1]] != c)
                    // 沿着路径回溯，翻转对方的棋
                    map[x][y] = c;
            }
        }
    }
}