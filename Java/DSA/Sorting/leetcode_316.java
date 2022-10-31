public static String removeDuplicateLetters(String s) {
    Stack<Character> stack = new Stack<>();
    int[] cnt = new int[26];
    boolean[] inStack = new boolean[26];
    int len = s.length();
    for (int i = 0; i < len; i++) {
        cnt[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < len; i++) {
        char ch = s.charAt(i);
        cnt[ch - 'a']--;
        if (inStack[ch - 'a']) {
            continue;
        }
        while (!stack.empty() && stack.peek() > ch) {
            if (cnt[stack.peek() - 'a'] <= 0) {
                break;
            }

            inStack[stack.pop() - 'a'] = false;
        }

        stack.push(ch);
        inStack[ch - 'a'] = true;
    }

    StringBuilder sb = new StringBuilder(stack.size());
    while (!stack.empty()) {
        sb.append(stack.pop());
    }

    return sb.reverse().toString();
}
