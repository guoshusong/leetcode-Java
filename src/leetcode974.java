import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @author: GuoShuSong
 * @create: 2020-05-27 08:17
 **/
public class leetcode974 {
    public int subarraysDivByK(int[] A, int K) {
        int count = 0;
        for(int i = 0;i < A.length; i++){
            int sum = 0;
            for (int j = i; j < A.length ; j++){
                sum+=A[j];
                if (sum % K == 0){
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * 哈希表 + 逐一统计
     *  public int subarraysDivByK(int[] A, int K) {
     *         Map<Integer, Integer> record = new HashMap<>();
     *         record.put(0, 1);
     *         int sum = 0, ans = 0;
     *         for (int elem: A) {
     *             sum += elem;
     *             // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
     *             int modulus = (sum % K + K) % K;
     *             int same = record.getOrDefault(modulus, 0);
     *             ans += same;
     *             record.put(modulus, same + 1);
     *         }
     *         return ans;
     *     }
     */

/**
 * 哈希表 + 单次统计
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            record.put(modulus, record.getOrDefault(modulus, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry: record.entrySet()) {
            ans += entry.getValue() * (entry.getValue() - 1) / 2;
        }
        return ans;
    }
*/
}
