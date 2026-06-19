class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] visitedAtStep = new int[n];
        int[] fromNode = new int[n];
        int longestCycleLen = -1;
        int globalStep = 1;

        for (int i = 0; i < n; i++) {
            if (visitedAtStep[i] > 0) {
                continue;
            }

            int currentNode = i;
            int startNode = i;
            int localStep = globalStep;

            while (currentNode != -1) {
                if (visitedAtStep[currentNode] > 0) {
                    if (fromNode[currentNode] == startNode) {
                        int cycleLen = globalStep - visitedAtStep[currentNode];
                        longestCycleLen = Math.max(longestCycleLen, cycleLen);
                    }
                    break;
                }
                visitedAtStep[currentNode] = globalStep;
                fromNode[currentNode] = startNode;
                globalStep++;
                currentNode = edges[currentNode];
            }
        }
        return longestCycleLen;
    }
}