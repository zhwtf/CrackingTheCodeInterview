//get all the permutation of a string

ArrayList<String> getPerms(String str) {
    if (str == null) {
        return null;
    }

    ArrayList<String> perm = new ArrayList<String>();

    if (str.length() == 0) {
        //base case;
        perm.add("");
        return perm;
    }

    //get the first character
    char first = str.charAt(0);
    String remain = str.substring(1);
    ArrayList<String> words = getPerms(remain);
    for (String word : words) {
        //insert the character at each position of the word
        for (int j == 0; j <= word.length(); j++) {
            String s = insertCharAt(word, first, j);
            perm.add(s);
        }
    }
    return perm;
}

// insert char c at index i in word
String insertCharAt(String word, char c, int i) {
    String start = word.substring(0, i);
    String end = word.substring(i);
    return start + c + end;
}
