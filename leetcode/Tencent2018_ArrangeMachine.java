package leetcode;

/*        小 Q 的公司最近接到 m 个任务, 第 i 个任务需要 xi 的时间去完成, 难度等级为 yi。
        小 Q 拥有 n 台机器, 每台机器最长工作时间 zi, 机器等级 wi。
        对于一个任务,它只能交由一台机器来完成, 如果安排给它的机器的最长工作时间小于任务需要的时间,
        则不能完成,如果完成这个任务将获得 200 * xi + 3 * yi 收益。
        对于一台机器,它一天只能完成一个任务, 如果它的机器等级小于安排给它的任务难度等级, 则不能完成。
        小 Q 想在今天尽可能的去完成任务, 即完成的任务数量最大。如果有多种安排方案,小 Q 还想找到收益最大
        的那个方案。小 Q 需要你来帮助他计算一下。
        输入描述：
        输入包括 N + M + 1 行,
        输入的第一行为两个正整数 n 和 m(1 <= n, m <= 100000), 表示机器的数量和任务的数量。
        接下来 n 行,每行两个整数 zi 和 wi(0 < zi < 1000, 0 <= wi <= 100), 表示每台机器的最大工作时间和
        机器等级。
        接下来的 m 行,每行两个整数 xi 和 yi(0 < xi < 1000, 0 <= yi<= 100), 表示每个任务需要的完成时间和
        任务的难度等级。
        输出描述：
        输出两个整数, 分别表示最大能完成的任务数量和获取的收益。
        输入示例：
        1 2
        100 3
        100 2
        100 1
        输出
        1 20006
        */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Tencent2018_ArrangeMachine {

    static class Pair {
        int time;
        int diff;

        public Pair(int time, int diff) {
            this.time = time;
            this.diff = diff;
        }
    }

    public static void main(String[] args) {
        // 输入：一：机器数和任务数 二：每个机器的最大工作时间和机器等级 三：每个任务的工作时间和等级
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int machineNum = sc.nextInt();
            int taskNum = sc.nextInt();
            Pair[] machines = new Pair[machineNum];
            Pair[] tasks = new Pair[taskNum];
            for (int i = 0; i < machineNum; i++) {
                machines[i] = new Pair(sc.nextInt(), sc.nextInt());
            }
            for (int i = 0; i < taskNum; i++) {
                tasks[i] = new Pair(sc.nextInt(), sc.nextInt());
            }

            // 重新定义比较器，时间优先
            Comparator<Pair> cmp = new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    if (p1.time == p2.time) {
                        return p2.diff - p1.diff;
                    } else {
                        return p2.time - p1.time;
                    }
                }

            };
            Arrays.sort(machines, cmp);
            Arrays.sort(tasks, cmp);
            long sum = 0; //注意此处要用long，否则只能通过90%
            int count = 0; // 记录完成任务数
            int j = 0;
            int[] countTasksAMachineCanComplete = new int[101];//记录
            for (int i = 0; i < taskNum; i++) {
                // 遍历任务，对于时长大于当前任务的机器，在其对应的difficulty位置上记录能完成的任务数+1
                while (j < machineNum && machines[j].time >= tasks[i].time) {
                    countTasksAMachineCanComplete[machines[j].diff]++;
                    j++;
                }
                for (int k = tasks[i].diff; k < 101; k++) {
                    if (countTasksAMachineCanComplete[k] != 0) {
                        // 若当前任务的难度对应的机器可完成任务数不为0，表明当前任务可以被完成
                        // 任务时间长的收益更大，因此依次遍历，贪心算法可获得最大收益
                        countTasksAMachineCanComplete[k]--;
                        sum += 200 * tasks[i].time + 3 * tasks[i].diff;
                        count++;
                        break;
                    }
                }
            }
            System.out.println(count + " " + sum);
        }
        sc.close();

    }

}




