public void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        
        reverse(s, 0, s.length - 1);
 }
    
    public void reverse(char[] str, int begin, int end) {
        if (begin >= end) {
            return;
        }
        char ch = str[begin];
        str[begin] = str[end];
        str[end] = ch;
        reverse(str, begin + 1, end - 1);
    }
