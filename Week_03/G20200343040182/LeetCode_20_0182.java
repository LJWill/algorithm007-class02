// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
// 有效字符串需满足：
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
// 注意空字符串可被认为是有效字符串。

// 输入: "()[]{}"
// 输出: true



class Solution {

    //sovl1: recurrsion
    //time: O(2^N)
    //space: O(1)
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<> ();
        _recur(0, 0, n, "", output);

        return output;
    }

    public void _recur(int left, int right, int n, String s, List<String> output) {
        // left parenthesis and right parenthesis exhauseted
        if (left == n && right == n) {
            output.add(s);
            return;
        }
            

        if (left < n)
            _recur(left+1, right, n, s+"(", output);
        
        //if right < left, then right must < n
        if (left > right)
            _recur(left, right+1, n, s+")", output);


    }
}