package com.bk;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Day_1_ReportRepair {

    public void part1() throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource("input.txt").toURI());
        List<String> lines = Files.readAllLines(path);
        int[] report = lines.stream().mapToInt(Integer::valueOf).toArray();

        Arrays.sort(report);    // worst-case sort => O(n log n)

        int a = 0;
        int b = report.length - 1;
        int sum, val1, val2;

        while (a < b) {
            val1 = report[a];
            val2 = report[b];
            sum = val1 + val2;
            if (sum == 2020) {
                System.out.printf("input = %s, val1 = %d, val2 = %d, product = %d", Arrays.toString(report), val1, val2, val1 * val2);
                return;
            } else if (sum < 2020) {
                // sum too low - move 1st pointer to next highest
                a++;
            } else {
                // only possibility here is sum > 2020, so sum is too high - move 2nd pointer to next lowest
                b--;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Day_1_ReportRepair inst = new Day_1_ReportRepair();
        inst.part1();
    }
}
