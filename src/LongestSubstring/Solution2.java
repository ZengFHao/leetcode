package LongestSubstring;

class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            // 记录字符上一次出现的位置
            int[] last = new int[128];
            for (int i = 0; i < 128; i++) {
                last[i] = -1;
            }
            int len = s.length();
            int res = 0;
            int left = 0;
            for (int right = 0; right < len; right++) {
                int index = s.charAt(right);
                left = Math.max(left, last[index] + 1);
                res = Math.max(res, right - left  + 1);
            }
            return res;
        }
}
