import java.util.*;

public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<=cpdomains.length-1;i++) {
            String[] t = cpdomains[i].split(" ");
            int n = Integer.valueOf(t[0]);
            String[] r = t[1].split("\\.");
            for (int j = 0; j <= r.length - 1; j++) {
                //切割子数组
                String[] sub = Arrays.copyOfRange(t, i, t.length);
                //从i开始到t.length结束
                String d = String.join(".", sub);
                int oldCount = map.getOrDefault(d, 0);
                map.put(d, oldCount + n);
            }
        }
        List<String> result=new ArrayList<>();
        for(Map.Entry<String,Integer> e :map.entrySet()){
            String d=e.getKey();
            int n=e.getValue();
            result.add(n+" "+d);
        }
        return result;
    }
}
