// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

// 有效字符串需满足：

// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
// 注意空字符串可被认为是有效字符串。




class Solution {


    //solv1: 暴力法，不断replace匹配的括号, 只要找到匹配的括号对就替换成empty string
    //Time: O(n^2)
    //Space: 
    // public boolean isValid(String s) {
    //     int len = s.length();
    //     if (s == null) 
    //         return true;
        
    //     if (len % 2 != 0)
    //         return false;

    //     for (int i=0; i<len/2; i++) {
    //         s = s.replaceAll("\\(\\)", "");
    //         s = s.replaceAll("\\[\\]", "");
    //         s = s.replaceAll("\\{\\}", "");
    //     }
    
    //     return s.isEmpty();
    // }

    //solv2: Stack

    private static final Map<Character, Character> map = createMap();
    private static Map<Character, Character> createMap() {
        Map<Character, Character> map = new HashMap<> ();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        return Collections.unmodifiableMap(map);
    }

    public boolean isValid(String s) {
        int len = s.length();
        LinkedList<Character> stack = new LinkedList<> ();
        
        if (s == null) 
            return true;
        
        if (len % 2 != 0)
            return false;

        for (char c:s.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.addFirst(c);
            }else {
                char top = stack.isEmpty() ? '?' : stack.poll();
                if (top != map.get(c))
                    return false;
            }
        }

    
        return stack.isEmpty();
    }
}