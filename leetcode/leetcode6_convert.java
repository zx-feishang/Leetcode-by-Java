package leetcode;

/*将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

        比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

        L   C   I   R
        E T O E S I I G
        E   D   H   N
        之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

        请你实现这个将字符串进行指定行数变换的函数：

        string convert(string s, int numRows);*/

public class leetcode6_convert {
    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() <= 1) return s;
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0, index = i; index < s.length(); j++, index = (2 * numRows - 2) * j + i) {
                //  垂直列上元素
                result.append(s.charAt(index));

                // 首行尾行垂直列间无元素
                if (i == 0 || i == numRows - 1) {
                    continue;
                }

                //垂直列间元素
                if (index + (2 * numRows - 2) - 2 * i < s.length()){
                    result.append(s.charAt(index + (2 * numRows - 2) - 2 * i));
                }
            }


        }
        return result.toString();
    }
}
