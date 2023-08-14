package chapter7.item47;
import java.util.Arrays;
import java.util.Scanner;

public class GameStartTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("사람 수 N을 입력하세요: ");
        int N = scanner.nextInt();

        int[] aTimes = new int[N];
        int[] bTimes = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.print("사람 " + (i + 1) + "의 a 시간을 입력하세요: ");
            aTimes[i] = scanner.nextInt();
            System.out.print("사람 " + (i + 1) + "의 b 시간을 입력하세요: ");
            bTimes[i] = scanner.nextInt();
        }

        System.out.print("동시에 게임을 할 사람 수 K를 입력하세요: ");
        int K = scanner.nextInt();

        // K명이 동시에 게임을 할 수 있는 최대 시간을 찾습니다.
        int startTime = findMax(Arrays.copyOfRange(aTimes, 0, K));

        if (startTime <= findMin(Arrays.copyOfRange(bTimes, 0, K))) {
            System.out.println("가장 빠르게 시작할 수 있는 시간: " + startTime);
        } else {
            System.out.println("NO");
        }
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}