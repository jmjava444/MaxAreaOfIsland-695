class Solution
{
    public int maxAreaOfIsland(int[][] grid)
    {
        int maxSize = 0;
        // i represents the rows to scan through
        for(int i = 0; i < grid.length; i++)
        {
            // j represents the columns to scan through
            for(int j = 0; j < grid[i].length; j++)
            {
                // 1 represents an island hit, 0 represents water
                if(grid[i][j] == 1)
                {
                    /* store the island size into tempSize, since the
                     * islandSize() method can only be run once per
                     * island.
                     */
                    int tempSize = islandSize(grid, i, j);
                    /* Keep comparing the current island with the one
                     * with the biggest size.
                     */
                    if(tempSize > maxSize)
                        maxSize = tempSize;
                }
            }                
        }
        return maxSize;
    }
    
    /* A recursive method: Once 1 piece of land is found, it initializes
     * the beginning size of 1, stores it in the size variable, then
     * turns that 1 into a zero so that that piece of island isn't
     * scanned again redundantly. Then, it looks left, right, up, and
     * down for island hits. It calls itself on those adjacent spaces
     * if there is land there. At the end it returns the size of the
     * island.
     */
    public int islandSize(int[][] tempGrid, int i, int j)
    {
        int size = 1;
        tempGrid[i][j] = 0;
        if(i + 1 < tempGrid.length)
        {
            if(tempGrid[i + 1][j] == 1)
                size += islandSize(tempGrid, i + 1, j);
        }
        if(i - 1 >= 0)
        {
            if(tempGrid[i - 1][j] == 1)
                size += islandSize(tempGrid, i - 1, j);
        }
        if(j + 1 < tempGrid[i].length)
        {
            if(tempGrid[i][j + 1] == 1)
                size += islandSize(tempGrid, i, j + 1);
        }
        if(j - 1 >= 0)
        {
            if(tempGrid[i][j - 1] == 1)
                size += islandSize(tempGrid, i, j - 1);
        }
        return size;
    }
}
