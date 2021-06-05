public class MinPathSum {
    public int calculateMinimumHP(int[][] dungeon) {

        int rows = dungeon.length;
        int columns = dungeon[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boolean fromLeft = false;
                boolean fromTop = false;
                if (i - 1 >= 0) {
                    fromLeft = true;
                }
                if (j - 1 >= 0) {
                    fromTop = true;
                }

                if (fromLeft && fromTop) {
                    dungeon[i][j] = Math.min(dungeon[i - 1][j], dungeon[i][j - 1]) + dungeon[i][j];
                } else if (fromLeft) {
                    dungeon[i][j] = dungeon[i - 1][j] + dungeon[i][j];
                } else if (fromTop) {
                    dungeon[i][j] = dungeon[i][j - 1] + dungeon[i][j];
                }
            }
        }
        return dungeon[rows -1][columns -1];
    }
}
