//compress the strings
//aaabbc ---> a3b2c1

String compress(String str) {
    StringBuilder compressed = new StringBuilder();
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
        count++;
        if (i + 1 > str.length() || str.charAt(i) != str.charAt(i+1)) {
            compressed.append(str.charAt(i));
            compressed.append(count);
            count = 0;
        }
    }

    return compressed.length() < str.length() ? compressed.toString() : str;
}
