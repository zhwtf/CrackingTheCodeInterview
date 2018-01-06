//store the previously computed values
//the whole kprocess is similar to a tree structure
int makeChange(int n) {
    int[] denoms = {2, 5, 10, 1};
    int[][] map = new int[n+1][denoms.length]; //to store precomputed values
    return makeChange(n, denoms, 0, map);
}

int makeChange(int amount, int[] denoms, int index, int[][] map) {
    if (map[amount][index] > 0) {// retrieve value
        return map[amount][index];
    }
    if (index >= denoms.length()-1) {
        return 1;
    }
    int ways = 0;
    for (int i = 0; i*denoms[index] <= amount; i++) {
        ways += makeChange(amount-i*denoms[index], denoms, index+1, map);
    }
    map[amount][index] = ways;
    return ways;
































}
