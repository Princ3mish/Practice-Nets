class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        
        long dp0 = 0;
        long dpA = energyDrinkA[0];
        long dpB = energyDrinkB[0];

        for (int i = 1; i < n; i++) {
            long ndp0 = Math.max(dp0, Math.max(dpA, dpB));
            long ndpA = energyDrinkA[i] + Math.max(dpA, dp0);
            long ndpB = energyDrinkB[i] + Math.max(dpB, dp0);
            dp0 = ndp0;
            dpA = ndpA;
            dpB = ndpB;
        }

        return Math.max(dp0, Math.max(dpA, dpB));
    }
}
