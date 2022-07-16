class Solution
{
    public int maxAreaOfIsland(int[][] grid)
    {
        int maxSize = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
                if(grid[i][j] == 1)
                {
                    int temp = potentialIsland(grid, i, j);
                    if(temp > maxSize)
                        maxSize = temp;
                }
            }                
        }
        return maxSize;
    }
    
    public int potentialIsland(int[][] tempGrid, int i, int j)
    {
        int size = 1;
        tempGrid[i][j] = 0;
        if(i + 1 < tempGrid.length)
        {
            if(tempGrid[i + 1][j] == 1)
                size += potentialIsland(tempGrid, i + 1, j);
        }
        if(i - 1 >= 0)
        {
            if(tempGrid[i - 1][j] == 1)
                size += potentialIsland(tempGrid, i - 1, j);
        }
        if(j + 1 < tempGrid[i].length)
        {
            if(tempGrid[i][j + 1] == 1)
                size += potentialIsland(tempGrid, i, j + 1);
        }
        if(j - 1 >= 0)
        {
            if(tempGrid[i][j - 1] == 1)
                size += potentialIsland(tempGrid, i, j - 1);
        }
        return size;
    }
}