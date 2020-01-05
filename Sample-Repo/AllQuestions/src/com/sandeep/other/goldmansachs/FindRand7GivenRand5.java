package com.sandeep.other.goldmansachs;

import java.util.Random;

public class FindRand7GivenRand5 {

    private static Random rand = new Random();

    public static void main(String[] args) {
        System.out.println(rand7());
    }

    // generates random numbers uniformly from 1 to 7
    private static int rand7() {
        int result;

        while (true) {
            result = rand0_24();
            if (result <= 20) {
                break;
            }
        }

        result = 1 + (result % 7);
        return result;
    }

    // generates random numbers uniformly from 1 to 5
    private static int rand5() {
        return rand.nextInt(5) + 1;
    }

    private static int rand0_24() {
        return ((rand5() - 1) + 5 * (rand5() - 1));
    }
}
