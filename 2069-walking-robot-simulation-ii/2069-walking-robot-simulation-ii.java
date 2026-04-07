class Robot {

    int width, height;
    int x, y;
    int dir;

    int[][] dirs = {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };

    int perimeter;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.perimeter = 2 * (width + height) - 4;
    }

    public void step(int num) {
        if (perimeter == 0) return;

        int steps = num % perimeter;

        if (steps == 0 && num > 0) {
            steps = perimeter;
        }

        while (steps > 0) {
            int nx = x + dirs[dir][0];
            int ny = y + dirs[dir][1];

            if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
                dir = (dir + 1) % 4;
                continue;
            }

            x = nx;
            y = ny;
            steps--;
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        if (dir == 0) return "East";
        if (dir == 1) return "North";
        if (dir == 2) return "West";
        return "South";
    }
}