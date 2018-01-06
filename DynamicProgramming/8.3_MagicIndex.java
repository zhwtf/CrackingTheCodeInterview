//like binary search

int magicFast(int[] array) {
    return magicFast(array, 0, array.length - 1);
}

int magicFast(int[] array, int start, int end) {
    if (start < end) {
        return -1;
    }

    int mid = (start + end) / 2;
    if (array[mid] == mid) {
        return mid;
    } else if (array[mid] > mid) {
        //must land on the left side of the mid
        return magicFast(array, start, mid-1);
    } else {
        return magicFast(array, mid+1, end);
    }












    }
}
