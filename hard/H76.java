package hard;

import java.util.HashMap;

/**
 * 功能描述
 *
 * @author: 邱彦祥
 * @date: 2023-03-06 19:42
 */
public class H76 {
    public String minWindow(String source, String target){
        char[] sourceArray = source.toCharArray();
        char[] targetArray = target.toCharArray();

        HashMap<Character,Integer> needs = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();

        int num = 0;
        int left =0, right = 0;
        int start =0, len = Integer.MAX_VALUE;
        //将目标字符串拆解
        for(char c : targetArray){
            needs.put(c,needs.getOrDefault(c,0)+1);
        }
        while (right < source.length()){
            char cur = sourceArray[right++];
            if(needs.containsKey(cur)){
                window.put(cur,window.getOrDefault(cur,0)+1);
                if (window.get(cur).equals(needs.get(cur))){
                    num++;
                }
            }
            while (num == needs.size()){
                if(right - left < len){
                    start = left;
                    len = right - left;
                }
                char temp = sourceArray[left++];
                if(needs.containsKey(temp)){
                    window.put(temp, window.get(temp) - 1);
                    if(window.get(temp) < needs.get(temp)){
                        num--;
                    }
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : source.substring(start,start+len);
    }
}
