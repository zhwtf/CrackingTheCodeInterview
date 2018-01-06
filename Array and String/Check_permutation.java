//Given two strings, write a method to decide if one is a permutation of the
//other.

//method 1: sort the two string and compare
String sort(String str) {
    char[] content = str.toCharArray();
    java.util.Arrays.sort(content);
    return new String(content);
}

boolean permutation(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    return sort(s).equals(sort(t));
}

//method 2: check if the two strings have identical character counts
boolean permutation(String s, String t){
    if (s.length() != t.length()) {
        return false;
    }
    //Assume 128 characters
    int[] letters = new int[128];
    char[] hold = s.toCharArray();
    for (char c : hold) {
        letters[c]++;
    }

    char[] h2 = t.toCharArray();
    for (char c2 : h2) {
        letters[c2]--;
        if (letters[c2] < 0) {
            return false;
        }
    }
    return true;
    

}
