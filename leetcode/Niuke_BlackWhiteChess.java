package leetcode;


//黑白棋，又叫翻转棋（Reversi）、苹果棋或奥赛罗棋（Othello）。棋盘共有8行8列共64格。
// 开局时，棋盘正中央的4格先置放黑白相隔的4枚棋子。双方轮流落子，只要落子和棋盘上任一枚己方的棋子在一条线上
//（横、直、斜线皆可）夹着对方棋子，就能将对方的这些棋子转变为我己方（翻面即可）。
// 如果在任一位置落子都不能夹住对手的任一颗棋子，就要让对手下子。当双方皆不能下子时，游戏就结束，子多的一方胜。
// 现在给你一个8x8的棋局，以及下一步玩家的落子位置。请输出翻转好的新棋局。
//输入有多组数据，每组数据有两部分。
// 第一部分有8行，为8x8的棋局，其中“*”为黑子、“+”为白子、“.”为空位置。
// 第二个部分有一行，包含要落子的行号r（1≤r≤8）、列号c（1≤c≤8）、棋子e（“*”或“+”）。
//对应每组输入，根据黑白棋的规则，请输出落子后翻转的结果。
// 每组数据之后输出一个空行作为间隔。


import java.util.*;

public class Niuke_BlackWhiteChess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Character[][] map = new Character[8][8];
            for (int i = 0; i < 8; i++) {
                String s = sc.next();
                for (int j = 0; j < 8; j++)
                    map[i][j] = s.charAt(j);
            }
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            Character c = sc.next().charAt(0);
            map[row][col] = c;
            fun(map, row, col, c);
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (j == map[0].length - 1) System.out.println(map[i][j]);
                    else System.out.print(map[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void fun(Character[][] map, int row, int col, Character c) {
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int i = 0; i < direction.length; i++) {
            int x = row + direction[i][0];
            int y = col + direction[i][1];
            while (x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] != c && map[x][y] != '.') {
                x += direction[i][0];
                y += direction[i][1];
            }
            if (x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] == c) {
                while ((x != row || y != col) && map[x -= direction[i][0]][y -= direction[i][1]] != c)
                    map[x][y] = c;
            }
        }
    }
}



