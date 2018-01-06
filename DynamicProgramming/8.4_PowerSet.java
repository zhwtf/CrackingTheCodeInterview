//get all the subsets of a set

//method 1: we compute P(n-1), clone the results and tehn add an to each of these cloned sets.

ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
    ArrayList<ArrayList<Integer>> allsubsets;
    //base case ---index start with 0;
    if (set.size() == index) {
        allsubsets = new ArraysList<ArrayList<Integer>>();
        allsubsets.add(new ArrayList<Integer>());
        //return allsubsets;
    } else {
        allsubsets = getSubsets(set, index+1);
        ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
        int item = set.get(index);
        for (ArrayList<Integer> sub : allsubsets) {
            ArrayList<Integer> newsub = new ArrayList<Integer>();
            newsub.addAll(sub);
            newsub.add(item);
            moreSubsets.add(newsub);
        }
        allsubsets.addAll(moreSubsets);
    }
    return allsubsets;


}
