import java.util.Arrays;

class Sort{
    public static void main(String[] args) {
        int[] nums = {1,4,2,7,3,9,6};
       
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

    public static int[] quick_sort(int[] a,int low,int high){
        int start = low;
        int end = high;
        int key = a[low];
        
        
        while(end>start){
            //从后往前比较
            while(end>start&&a[end]>=key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if(a[end]<=key){
            int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while(end>start&&a[start]<=key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
               start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if(start>low) quick_sort(a,low,start-1);//左边序列。第一个索引位置到关键值索引-1
        if(end<high) quick_sort(a,end+1,high);//右边序列。从关键值索引+1到最后一个
        return a;
    }
    
}