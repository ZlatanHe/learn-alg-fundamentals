import java.util.Random;

/**
 * Created by Zlatan on 19/3/7.
 */
public class Main {

    public static int swapBit(int input) {
        System.out.println("input: " + input);
        if (input < 10) {
            System.out.println("output: " + input);
            return input;
        }

        int val = input;
        int weight = 0; // 位数
        int[] rawNumber = new int[10]; // int32最大10位
        while (val > 0) {
            rawNumber[weight] = val % 10;
            val /= 10;
            weight++;
        }

        boolean exchange = false;
        for (int i = 1; i < weight; i++) {
            if (rawNumber[i] < rawNumber[i-1]) {
                int tmp = rawNumber[i];
                rawNumber[i] = rawNumber[i-1];
                rawNumber[i-1] = tmp;
                exchange = true;
                break;
            }
        }

        int result;
        if (!exchange) {
            System.out.println("不存在可交换");
            result = input;
        } else {
            result = 0;
            for (int i = 0; i < weight; i++) {
                result += rawNumber[i] * Math.pow(10, i);
            }
        }

        System.out.println("output: " + result);
        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        swapBit(random.nextInt(Integer.MAX_VALUE));
        swapBit(random.nextInt(Integer.MAX_VALUE));
        swapBit(random.nextInt(Integer.MAX_VALUE));
        swapBit(random.nextInt(Integer.MAX_VALUE));
        swapBit(random.nextInt(Integer.MAX_VALUE));
    }
}
