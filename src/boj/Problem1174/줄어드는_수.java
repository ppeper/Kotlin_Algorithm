package boj.Problem1174;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 줄어드는_수 {
    private static List<Long> numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            makeNumbers(i);
        }
        numbers.sort(Comparator.comparingLong(o -> o));
        if (numbers.size() < n) {
            System.out.println(-1);
        } else {
            System.out.println(numbers.get(n - 1));
        }
    }

    private static void makeNumbers(long i) {
        numbers.add(i);
        long last = i % 10;
        if (last <= 0) return;
        for (long j = last - 1; 0 <= j; j--) {
            makeNumbers(i * 10 + j);
        }
    }
}
