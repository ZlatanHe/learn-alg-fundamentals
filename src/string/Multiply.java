package string;

import java.util.Stack;

/**
 * Created by Zlatan on 19/3/10.
 */
class Multiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int num1Len = num1.length();
        int num2Len = num2.length();
        boolean num1Shorter = num1Len < num2Len;
        final String shorterNum, longerNum;
        final int shorterLen, longerLen;
        if(num1Shorter) {
            shorterNum = num1;
            longerNum = num2;
            shorterLen = num1Len;
            longerLen = num2Len;
        } else {
            shorterNum = num2;
            longerNum = num1;
            shorterLen = num2Len;
            longerLen = num1Len;
        }

        byte[] longerNumBytes = new byte[longerLen];
        for (int i = 0; i < longerLen; i++) {
            longerNumBytes[i] = Byte.parseByte(String.valueOf(longerNum.charAt(longerLen - 1 - i)));
        }

        byte[][] nums = new byte[shorterLen][220];
        char[] shorterNumChars = shorterNum.toCharArray();
        for (int i = 0; i < shorterLen; i++) {
            nums[i] = multiply(longerNumBytes, Byte.parseByte(String.valueOf(shorterNumChars[shorterLen - 1 - i])), i);
        }

        int carry = 0;
        Stack<Byte> bits = new Stack<>();
        for (int i = 0; i < shorterLen + longerLen; i++) {
            for (int j = 0; j < shorterLen; j++) {
                carry += nums[j][i];
            }
            byte bit = (byte) (carry % 10);
            bits.add(bit);
            carry /= 10;
        }
        if (carry > 0) {
            bits.add((byte) carry);
        }

        StringBuilder sb = new StringBuilder();
        boolean zeroHead = true;
        while (!bits.isEmpty()) {
            int bit = bits.pop();
            if (zeroHead) {
                zeroHead = bit == 0;
            }
            if (!zeroHead) {
                sb.append(bit);
            }
        }
        return sb.toString();
    }

    private byte[] multiply(byte[] num1, byte num2, int weight) {
        byte[] res = new byte[220];
        int carry = 0;
        int i = 0;
        for (;i < num1.length; i++) {
            int product = num1[i] * num2 + carry;
            carry = product / 10;
            res[i + weight] = (byte) (product % 10);
        }
        res[i + weight] = (byte) carry;
        return res;
    }
}
