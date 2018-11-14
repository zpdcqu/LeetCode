import java.util.Arrays;

class Sort{
    public static void main(String[] args) {
        int[] nums = {1,4,2,7,3,9,6};
       System.out.println("123");
         System.out.println(Arrays.toString( bubble_sort(nums)));
        System.out.println(Arrays.toString( insert_sort(nums)));
        System.out.println(Arrays.toString( selection_sort(nums)));
        System.out.println(Arrays.toString( quick_sort(nums,0,nums.length-1)));
    }
    
    public static int[] bubble_sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]>nums[j]){
                   int temp = nums[i];
                   nums[i] = nums[j] ;
                   nums[j] = temp;
                }      
            }           
        }
        return nums;       
    }

    public static int[] insert_sort(int[] nums) {
      //  int head = nums[i];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j]<nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j]  = temp;
                }
                
            }
            
        }
        return nums;
        
    }

    public static int[] selection_sort(int[] nums) {
        int length = nums.length-1;
        while(length>=0){
            int index = length;
            for (int i = 0; i < length; i++) {
                if (nums[i]<nums[index]) {
                   index = i;
                }
                
            }
            int temp = nums[index];
            nums[index] = nums[length];
            nums[length] = temp;
            length--;
        }
        return nums;        
    }

    public static int[]  quick_sort(int[] nums,int start,int end) {
        int i = start;
        int j = end;
        int key  = nums[i];

        while (i>=j) {
            //和最右边的比较
            while (i<j && key<=nums[j]) {
                j--;
            }
            nums[i] = nums[j];
            while (i<j && key>=nums[i]) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = key;
        quick_sort(nums, start, i-1);
        quick_sort(nums, i+1, end);
        return nums;
    }
}