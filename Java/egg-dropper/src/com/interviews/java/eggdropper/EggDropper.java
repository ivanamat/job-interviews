package com.interviews.java.eggdropper;

/**
 * EggDropper class
 */
public class EggDropper {

    public int minEggDropperX(int eggs, int floors) {

        /**
         * If there are no eggs or floors, there are no tries.
         */
        if (eggs == 0 || floors == 0) {
            return 0;
        }

        /**
         * T = temporary table of tries (eggs/floors)
         */
        int T[][] = new int[eggs + 1][floors + 1];

        int res = 0;

        /**
         * We need one trial for each floor if we have only one egg.
         */
        for (int i = 0; i <= floors; i++) {
            T[1][i] = i;
        }

        /**
         * Rest of trials
         * All drops from 1st floor to last floor
         */
        for (int e = 2; e <= eggs; e++) {
            for (int f = 1; f <= floors; f++) {
                T[e][f] = Integer.MAX_VALUE;
                for (int k = 1; k <= f; k++) {
                    // return the minimum of these values plus 1
                    res = 1 + Math.max(T[e - 1][k - 1], T[e][f - k]);
                    if (res < T[e][f]) {
                        T[e][f] = res;
                    }
                }
            }
        }

        return T[eggs][floors];
    }

    public static void main(String args[]) {
        int eggs = 0;
        int floors = 0;

        /**
         * Eggs and floors arguments are passed
         */
        if (args.length == 2) {
            eggs = Integer.parseInt(args[0]);
            floors = Integer.parseInt(args[1]);
        }

        EggDropper dropper = new EggDropper();
        int r = dropper.minEggDropperX(eggs, floors);

        System.out.println(r);
    }
}