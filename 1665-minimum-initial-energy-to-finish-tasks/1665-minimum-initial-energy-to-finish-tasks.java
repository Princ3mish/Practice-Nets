class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        
        int currentEnergy = 0;
        int initialEnergy = 0;
        
        for (int[] task : tasks) {
            if (currentEnergy < task[1]) {
                initialEnergy += (task[1] - currentEnergy);
                currentEnergy = task[1];
            }
            currentEnergy -= task[0];
        }
        
        return initialEnergy;
    }
}