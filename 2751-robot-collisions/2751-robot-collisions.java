import java.util.*;

class Solution {

    static class Robot {
        int pos;
        int health;
        char dir;
        int index;

        Robot(int p, int h, char d, int i) {
            pos = p;
            health = h;
            dir = d;
            index = i;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

        int n = positions.length;

        Robot[] robots = new Robot[n];
        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }

        Arrays.sort(robots, (a, b) -> a.pos - b.pos);

        Stack<Robot> stack = new Stack<>();

        List<Robot> survivors = new ArrayList<>();


        for (Robot curr : robots) {

            if (curr.dir == 'R') {
                stack.push(curr);
            } else {

                while (!stack.isEmpty() && curr.health > 0) {

                    Robot top = stack.peek(); 

                    if (top.health > curr.health) {
                        top.health--;
                        curr.health = 0; 
                        break;

                    } else if (top.health < curr.health) {
                        curr.health--;
                        stack.pop(); 
                    } else {
                        stack.pop();
                        curr.health = 0;
                        break;
                    }
                }

                if (curr.health > 0) {
                    survivors.add(curr);
                }
            }
        }

        while (!stack.isEmpty()) {
            survivors.add(stack.pop());
        }

        Collections.sort(survivors, (a, b) -> a.index - b.index);

        List<Integer> result = new ArrayList<>();
        for (Robot r : survivors) {
            result.add(r.health);
        }

        return result;
    }
}