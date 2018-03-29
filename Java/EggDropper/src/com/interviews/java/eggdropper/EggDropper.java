package com.interviews.java.eggdropper;

/**
 * EggDropper junit class
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
         * We need a try for each floor if we have only one egg.
         */
        for (int i = 0; i <= floors; i++) {
            T[1][i] = i;
        }

        /**
         * Iterate eggs
         */
        for (int e = 2; e <= eggs; e++) {
            /**
             * Iterate floors for every eggss -1
             */
            for (int f = 1; f <= floors; f++) {
                /**
                 * Get all drops from first floor to last floor
                 */
                T[e][f] = Integer.MAX_VALUE;
                for (int k = 1; k <= f; k++) {
                    /**
                     * Return the minimum of these values + 1.
                     */
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

        if (args.length == 2) {
            eggs = Integer.parseInt(args[0]);
            floors = Integer.parseInt(args[1]);
        }

        EggDropper dropper = new EggDropper();
        int r = dropper.minEggDropperX(eggs, floors);

        // String result = String.format("You need %d drops for %d eggs and %d floors.", r, eggs, floors);
        // System.out.println(result);
        System.out.println(r);
    }
}
