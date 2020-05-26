import java.util.BitSet;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * @program: leetcode
 * @author: GuoShuSong
 * @create: 2020-05-26 08:27
 **/
public class leetcode287 {

    public int findDuplicate(int[] nums) {
        BitSet bitSet = new BitSet(nums.length);
        for (int temp:
             nums) {
            if (bitSet.get(temp)){
                return temp;
            }
            else{
                bitSet.set(temp);
            }
        }
        return 0;
    }
    /**
     * public int findDuplicate(int[] nums) {
     *         int slow = 0, fast = 0;
     *         do {
     *             slow = nums[slow];
     *             fast = nums[nums[fast]];
     *         } while (slow != fast);
     *         slow = 0;
     *         while (slow != fast) {
     *             slow = nums[slow];
     *             fast = nums[fast];
     *         }
     *         return slow;
     *     }
     */
}
