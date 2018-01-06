// Dec 28 2017
/*
Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?
*/

//Assume only 128 characters

boolean isUniqueChars(String str) {
    if (str.length() > 128) {
        return false;
    }

    boolean[] charSet = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
        int hold = str.charAt(i);
        if (charSet(hold) == true) {
            return false;
        }
        charSet(hold) = true;
    }
    return true;
}
