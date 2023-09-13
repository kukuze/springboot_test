package com.example.sprintboot_test.八皇后;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.variables.IntVar;

import static com.example.sprintboot_test.八皇后.EightQueens.solveQueens;

public class EightQueensChoco {
    public static int ans = 0;

    public static void main(String[] args) {
        long startTime = System.nanoTime();  // 记录开始时间
        extracted();
        System.out.println(EightQueens.ans);
        long endTime = System.nanoTime();  // 记录结束时间
        long timeElapsed = endTime - startTime;  // 计算消耗时间
        System.out.println("chatgpt程序执行消耗时间：" + timeElapsed + " 纳秒");

        startTime = System.nanoTime();  // 记录开始时间
        extracted1();
        System.out.println(EightQueens.ans);
        endTime = System.nanoTime();  // 记录结束时间
        timeElapsed = endTime - startTime;  // 计算消耗时间
        System.out.println("官网程序执行消耗时间：" + timeElapsed + " 纳秒");

        startTime = System.nanoTime();  // 记录开始时间
        extracted2();
        System.out.println(EightQueens.ans);
        endTime = System.nanoTime();  // 记录结束时间
        timeElapsed = endTime - startTime;  // 计算消耗时间
        System.out.println("回溯程序执行消耗时间：" + timeElapsed + " 纳秒");

    }

    private static void extracted2() {
        int[] queens = new int[8];
        solveQueens(queens, 0);
    }

    private static void extracted1() {
        int n = 8;
        Model model = new Model(n + "-queens problem");
        IntVar[] vars = new IntVar[n];
        for (int q = 0; q < n; q++) {
            vars[q] = model.intVar("Q_" + q, 1, n);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                model.arithm(vars[i], "!=", vars[j]).post();
                model.arithm(vars[i], "!=", vars[j], "-", j - i).post();
                model.arithm(vars[i], "!=", vars[j], "+", j - i).post();
            }
        }
        Solver solver = model.getSolver();
        solver.setSearch(Search.inputOrderLBSearch(vars));

        while (solver.solve()) {
//            System.out.println(++flag);
//            for (int i = 0; i < queens.length; i++) {
//                System.out.print("Q");
//                System.out.print(queens[i].getValue());
//            }
//            System.out.println();
            ans++;
        }
    }

    private static void extracted() {
        Model model = new Model("Eight Queens");

        // Define variables
        IntVar[] queens = model.intVarArray("queens", 8, 1, 8);

        // Define constraints
        model.allDifferent(queens).post();
        for (int i = 0; i < queens.length; i++) {
            for (int j = i + 1; j < queens.length; j++) {
                IntVar q1 = queens[i];
                IntVar q2 = queens[j];
                q1.ne(q2).post();
                q1.add(i).ne(q2.add(j)).post();
                q1.sub(i).ne(q2.sub(j)).post();
            }
        }

        // Find all solutions
        Solver solver = model.getSolver();
        solver.setSearch(Search.inputOrderLBSearch(queens));

        while (solver.solve()) {
//            System.out.println(++flag);
//            for (int i = 0; i < queens.length; i++) {
//                System.out.print("Q");
//                System.out.print(queens[i].getValue());
//            }
//            System.out.println();
            ans++;
        }
    }


}