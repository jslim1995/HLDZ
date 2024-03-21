package Hash.JS;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * PhoneKeMon
 */
public class PhoneKeMon {
    public int solution(int[] nums) {
        // Set<Integer> setNums = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        // if(nums.length/2 >= setNums.size()) {
        //     return setNums.size();
        // } else {
        //     return nums.length/2;
        // }

        return Integer.min(nums.length/2, Arrays.stream(nums).boxed().collect(Collectors.toSet()).size());
    }
}