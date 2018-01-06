//URLify: Write a method to replace all spaces in a string with '%20'.

//use two pass approach

void replaceSpaces(char[] str, int trueLength) {
    int spaceCount = 0;
    int index = 0;
    for (int i = 0; i < trueLength; i++) {
        if (str[i] == ' ') {
            spaceCount++;
        }
    }
    index = trueLength + spaceCount*2;

    if (trueLength < str.length) {
        str[trueLength] = '\0';//End array???
    }
    //from back at index position
    for (int k = trueLength-1; k >= 0; k--) {
        if (str[k] == ' ') {
            str[index] = '0';
            str[index-1] = '2';
            str[index-2] = '%';
            index = index - 3;
        } else {
            str[index] = str[k];
            index--;
        }
    }
}
