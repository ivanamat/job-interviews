# Egg dropper

## Description
Suppose that you had *n* eggs in a *n* floor skyscraper, and you wanted to conduct an experiment to find out the highest floor (​criticalFloor​) from which you could drop an egg without breaking it... but you’re also really hungry so you don’t want to waste any eggs.

## Approach of resolution

* An egg that survives a fall can be used again.
* A broken egg must be discarded.
* The eggs are all incredibly similar – the effect of a fall from a particular floor is
* the same for all eggs.
* If an egg survives a fall from floor ​n​, then it would also survive a fall from the
* floors below it: floor ​n-1​, floor ​n-2​, etc.
* If an egg does not survive a fall from floor ​n​, then it would also not survive a
* fall from the floors above it: floor ​n+1​, floor ​n+2​, etc.
* You should not presume that an egg would survive a fall from the first floornor should you presume that it would not survive a fall from the 100th floor!

if only one egg is available and we need obtaining the right result, we must drop the egg from the first floor, if it survives, drop it from the second floor. We must continue upward until it breaks. In the worst case, this method may require the same tries as floors we have.

If there are two eggs available, we drop the egg from the window of the tenth floor. The egg may break or not. If it does not break, we upward to the twentieth floor and drop the egg, if the egg breaks, we drop the egg from the eleventh floor, if it does not break, we drop it from the twelfth floor and so on until it breaks, in In this case, we would drop the egg eleven times.

If more eggs are available, we can upward more floors beetwen drops, instead of ten floors we can upward twenty, twenty five, fivety floors, but we need the minimmun number of drops for *n* eggs and *n* floors to find critical floor.

```java  
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
```
