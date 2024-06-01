import java.util.*;

public class StrongestValues {
    public static int[] getStrongest(int[] nums, int k) {
        int[] out = new int[k];
        Map<Integer,List<Integer>> temp = new HashMap<>();
        Arrays.sort(nums);
        int len = nums.length;
        int med = nums[(len-1)/2];
        for(int i=0; i<nums.length; i++){
            int diff = Math.abs(nums[i]-med);
            List<Integer> list1 = new ArrayList<>();
            if(temp.containsKey(diff)){
                list1 = temp.get(diff);
            }
            list1.add(nums[i]);
            temp.put(diff,list1);
        }

        List<Integer> keys = new ArrayList<>();
        for(int key : temp.keySet()){
            keys.add(key);
        }
        Collections.sort(keys);
        int keyLen = keys.size();
        int i = 0;

        while(i<out.length){
            List<Integer> myList = temp.get(keys.get(--keyLen));
            Collections.sort(myList);
            for(int p=myList.size()-1; p>=0 && i<out.length; p--){
                out[i++] = myList.get(p);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,3,5,5};
        System.out.println(Arrays.toString(getStrongest(nums,2)));
    }
}
