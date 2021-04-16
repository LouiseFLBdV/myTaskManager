package exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> candles = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.print("Input size of candles: ");
        n = scanner.nextInt();

        for (int i = 0; i < n; i++){
            System.out.printf("Input candle [%d]: ", i);
            candles.add(scanner.nextInt());
        }

        System.out.println(birthdayCakeCandles(candles));
    }

    static int birthdayCakeCandles(List<Integer> candles){
        int repeats = 0;
        int max = candles.get(0);
        for (int candle:candles) {
            if (candle > max){
                repeats = 1;
                max = candle;
            }else if(candle == max){
                repeats++;
            }
        }

        return repeats;
    }
}
