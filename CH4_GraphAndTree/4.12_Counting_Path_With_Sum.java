//counting the number of path summing to a number;
//use hashmap to store the running sum and its counts;

int countPathWithSum(TreeNode root, int targetSum) {
    return countPathWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
}

int countPathWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
    if (node == null) {
        return 0; //base case;

    }

    //Count paths with sum ending at the current node;
    runningSum += node.data;
    int sum = runningSum - targetSum;
    int totalPaths = pathCount.getOrDefault(sum, 0);

    // if runningSum equals target sum, then one additional path starts at root.
    // Add in this path;
    if (runningSum == targetSum) {
        totalPaths++;
    }

    // Increment pathCount, recurse, then decrement pathCount;
    IncrementHashTable(pathCount, runningSum, 1); //Increment pathCount;
    totalPaths += countPathWithSum(node.left, targetSum, runningSum, pathCount);
    totalPaths += countPathWithSum(node.right, targetSum, runningSum, pathCount);
    IncrementHashTable(pathCount, runningSum, -1); //decrement pathCount;

    return totalPaths;
}

void IncrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
    int newCount = hashTable.getOrDefault(key, 0) + delta;
    if (newCount == 0) { //Remove the key when its value is 0 to reduce space usage
        hashTable.remove(key);
    } else {
        hashTable.put(key, newCount);
    }
}
