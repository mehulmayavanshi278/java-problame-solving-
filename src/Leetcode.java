import java.util.*;

public class Leetcode {




    public  static void PrintSingleArray(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]  + " ");
        }

    }


    public boolean check175(int[] a){
        boolean isSorted=true;
        int count=0;
        if(a[0]<a[a.length-1]){
            count++;
        }

        for(int i=1;i<a.length;i++){
            if(a[i-1]>a[i]){
                count++;
            }
            if(count>1){
                return false;
            }
        }

        return  isSorted;
    }


    int findMinOfRoatetedArr(int[] a){
        int left=0;
        int right=a.length-1;
        while(left<right){
         int mid = left + (right-left)/2;
         if(a[mid]>a[right]){
             left=mid+1;
         }else{
             right=mid;
         }
        }
        return a[left];
    }


    public int removeDuplicates26(int[] a) {
        int index=1;
        int elm=a[0];



        for(int i=1;i<a.length;i++){
            if(elm==a[i]){
                continue;
            }else{
                elm=a[i];
                a[index]=a[i];
                index++;
            }
        }

        // PrintArray(a);
//        System.arraycopy(a , 0 , a , 0 , index+1 > a.length ? a.length  : index+1);

      PrintSingleArray(a);

        return index;

    }

    public static void rotateArray189HLPR(int[] a , int start , int end){
        while(start!=end && start<end){
            int temp=a[start];
            a[start]=a[end];
            a[end]=temp;
            start++;
            end--;
        }
    }

    int[] rotateArray189(int[] a , int k){
        int p=k;
        if(k>a.length){
            p = k%a.length;
        }
        rotateArray189HLPR(a , 0 , a.length-1);
        rotateArray189HLPR(a,0,p-1);
        rotateArray189HLPR(a , p , a.length-1);
        PrintSingleArray(a);
        return a;
    }

   public static void  PrintSingleList(List<Integer> list){
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i) + " ");
        }
    }

    List<Integer> unionOfTheArray(int[] a ,  int[] b){
        List<Integer> list = new ArrayList<>();
        int i=0,j=0;

        while(i!=a.length && j!=b.length){
            if(a[i]==b[j]){
                list.add(a[i]);
                i++;
                j++;
                continue;
            }

            if(a[i]<b[j]){
                if(list.size()!=0 && list.get(list.size()-1)!=a[i]){
                    list.add(a[i]);
                }
                i++;
            }else{
                if(list.size()!=0 && list.get(list.size()-1)!=b[j]){
                    list.add(b[j]);
                }
                j++;
            }

            System.out.print(i+" and " + j +" : " + list);

        }

        System.out.print(i +  " and " + j);
        while(i!=a.length){

            if(list.size()!=0 && list.get(list.size()-1)!=a[i]){
                list.add(a[i]);
            }
            i++;

        }
        while(j!=b.length){

            if(list.size()!=0 && list.get(list.size()-1)!=b[j]){
                list.add(b[j]);
            }
            j++;

        }

        return list;
    }

    int findMaxConsecutiveOnes(int[] a){
        int index=0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
           if(a[i]!=1){
               index=i;
           }
           max= Math.max(max, i-index);
        }
        return max;
    }






    public static int sum=0;
    public static int max=0;
    public  static void lenOfLongSubarrHLPR(int[] a, List<Integer> list, int index , int target){
       if(index<a.length){

           if(target>=0){
               if(target==0){
                   System.out.println("list : " + list);
                   max= Math.max(max , list.size());
               }
               target-=a[index];
               list.add(a[index]);
               lenOfLongSubarrHLPR(a , list , index+1 , target);
               list.remove(list.size()-1);
           }else if(target<0){
               return;
           }
       }

    }
    int lenOfLongSubarr(int[] a , int k){
        List<Integer> list = new ArrayList<>();
         for(int i=0;i<a.length;i++){
             lenOfLongSubarrHLPR(a, list, i , k);
        }

         System.out.println(max);
         return  max;
    }


    int[] twoSum(int[] a, int target){

     return new int[]{};
    }

    int maxSubArray(int[] a){
       int max = a[0];
       int sum=a[0];
       for(int i=1;i<a.length;i++){
           sum+=a[i];
           if(a[i]>sum){
               sum=a[i];
           }
           max = Math.max(max ,sum);
       }
       return max;
    }

    public static void pairWithMaxSumHLPR(int[] a , int index , int minVal , int maxVal , List<Integer> list){
        if(index<a.length){
           minVal = Math.min(minVal,a[index]);
           maxVal = Math.max(maxVal,a[index]);
           list.add(a[index]);
            System.out.println(list);
           if(list.size()!=1){
               max = Math.max(max , minVal+maxVal);
               System.out.println("index:" + index + " minVal " + minVal + " maxValue " + maxVal);
               System.out.println("max is:" + max);
           }
           pairWithMaxSumHLPR(a , index+1 ,minVal, maxVal , list);
            list.remove(list.size()-1);
        }
    }
    int pairWithMaxSum(int[] a){
        for(int i=0;i<a.length;i++){
            List<Integer> list = new ArrayList<>();
            pairWithMaxSumHLPR(a, i, a[i] , a[i], list);
        }
        System.out.println(max);
        return max;
    }

    public static void PrintDoubleArray(int[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }

    int[][] rotate(int[][] a){
        int rows = a.length;
        int cols = a[0].length;

        for (int i = 0; i < rows; i++) {      // transform the metrics
            for (int j = i + 1; j < cols; j++) {
                // Swap elements across the main diagonal
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        for(int i=0;i<a.length;i++){           //  reverse the rows of the array
            for(int j=0;j<a[i].length/2;j++){
                int temp = a[i][j];
                a[i][j] = a[i][a[i].length-1-j];
                a[i][a[i].length-1-j] = temp;
            }
        }
        return a;
    }



    public  void subarraySumHLPR(int[] a , int index , int target, int sum){

        if(index>=a.length){
            return;
        }
        sum+=a[index];
        if(target==sum){
            System.out.println("index:" + index);
            max++;
        }
        if(index<a.length){
            subarraySumHLPR(a , index+1 , target , sum);
        }


    }
    int subarraySum(int[] a , int k){
       for(int i=0;i<a.length;i++){
           subarraySumHLPR(a , i , k , 0);
       }
       return max;
    }


    List<Integer> majorityElement(int[] a){
        List<Integer> list = new ArrayList<>();
        Map<Integer , Integer> hashmap = new HashMap<>();
        for(int i=0;i<a.length;i++){

            hashmap.put(a[i],hashmap.getOrDefault(a[i],0)+1);
            if(hashmap.getOrDefault(a[i] , 0)==(a.length/3)+1){
                list.add(a[i]);
            }
        }

        System.out.println(hashmap);

        return list;
    }

    int maxLenWithSum0(int[] a){
        int max=0;
        Map<Integer , Integer> hashmap= new HashMap();
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            if(sum==0){
                max=i+1;
            }
            else {

                if(hashmap.get(sum)==null){
                    hashmap.put(sum , i);
                }else{
                    max = Math.max(max, i-hashmap.get(sum));
                }
            }

            }



        return max;

    }

    int[][] mergeInterval(int[][] a){
        int i=0,j=0;
        Arrays.sort(a, Comparator.comparingInt(arr -> arr[0]));
        while (i<a.length){
            while(a[j][0]<a[i][1]){
                if(a[j][1]>a[0][i]){
                    j=i;
                }
                i++;
            }
        }
        return a;
    }

    int binarySearch(int[] a , int k){
        int left=0,right=a.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            System.out.println(mid);
            if(a[mid]==k){
                return mid;
            } else if (k<a[mid]) {
                right=mid-1;
            }else{
               left=mid+1;
            }
        }
        return -1;
    }


    int findFloor(int[] a , int k){
        int left=0,right=a.length-1;
        int ans=-1;
        while (left<=right){
            int mid =(right+left)/2;
            System.out.println("mid:"+mid);
            if(a[mid]<=k){
                ans=mid;
            }
            if(a[mid]>k){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }


        return  ans;

    }

    int getFloorAndCeil(int[] a , int k){
        int left=0,right=a.length-1;
        int ans=-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(a[mid]>=k){
                ans=mid;
            }
            if(a[mid]<k){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }

    int searchInsert(int[] a , int k){
        int left=0,right=a.length-1;
        int ans=0;
        while (left<=right){
            int mid = (left+right)/2;
            if(a[mid]<k){
                ans=mid+1;
            }
            if(k<=a[mid]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }

    int searchInRotatedArray(int[] a , int k){
        int left=0,right=a.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(a[mid]==k){
                return mid;
            }
            if(a[left]<=a[mid]){
                if(k>=a[left] && k<=a[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if( k>=a[left] || k<=a[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return -1;
    }


    int findMinInRotatedArray(int[] a){
        int min = Integer.MAX_VALUE;
        int left=0,right=a.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(a[left]<=a[mid]){
                min = Math.min(min , a[left]);
                left=mid+1;
            }else{
                min = Math.min(min , a[mid]);
                right=mid-1;
            }
        }
        return min;
    }

    int findKRotation(List<Integer> a){

        int left=0,right=a.size()-1;
        while (left<=right){
            int mid =  (left+right)/2;
            if(a.get(left) <= a.get(mid)){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }

    int floorSqrt(int num){      //  1 2 3 4 5
        int left=1,right=num;
        int ans=1;
        while (left<=right){
            int mid = (left+right)/2;
            if(mid*mid <= num  && (mid+1)*(mid+1)>num){
                return mid;
            }
            if(mid*mid<num){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }



    int NthRoot(int num , int k){
        int left=1,right=num/k;
        while (left<=right){
            int mid = (left+right)/2;
            System.out.println("mid:"+mid);
            if(Math.pow(mid,k)==num){
                return mid;
            }
            if(Math.pow(mid,k)<num){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }


    int minEatingSpeedHLPR(int[] a , int mid){
        int summ=0;
        for(int i=0;i<a.length;i++){
           double ans = (double)a[i]/(double)mid;
           summ+=Math.ceil(ans);
        }
        System.out.println("");
        return summ;
    }
    int minEatingSpeed(int[] a , int h){
      int left=1;
      int right=a[0];
      for(int i=0;i<a.length;i++){
          if(a[i]>right){
              right=a[i];
          }
      }
      while (left<=right){
         int mid= (left+right)/2;
         int summ = minEatingSpeedHLPR(a,mid);
         System.out.println("mid-->" + mid + "  sum-->" + summ);
          if (summ <= h) {
              right = mid - 1;  // Try for a smaller speed
          } else {
              left = mid + 1;   // Increase the speed
          }
      }
      return left;
    }



    int smallestDivisorHLPR(int[] a , int mid){
        int summ=0;
        for(int i=0;i<a.length;i++){
            double ans = (double)a[i]/(double)mid;
            summ+=Math.ceil(ans);
        }
        System.out.println("");
        return summ;
    }
    int smallestDivisor(int[] a , int k){
        int left=1;
        int right=a[0];
        for(int i=0;i<a.length;i++){
            if(a[i]>right){
                right=a[i];
            }
        }

        while (left<=right){
            int mid = (left+right)/2;
            int summ = smallestDivisorHLPR(a,mid);
            if(summ<=k){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        return left;
    }



    int shipWithinDaysHLPR(int[] a, int mid){
        int days=0;
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            if(sum==mid){
                days++;
                sum=0;
                continue;
            } else if (sum>mid) {
                days++;
                sum=a[i];
            }else{

            }

        }
        days++;

        return days;
    }

    int shipWithinDays(int[] a , int k){
        int left=a[0];
        int right=0;
        for(int i=0;i<a.length;i++){
            right+=a[i];
            if(a[i]>left){
                left=a[i];
            }
        }
        int ans=sum;
        while (left<=right){
            int mid = (left+right)/2;
            int days = shipWithinDaysHLPR(a,mid);
            System.out.println("mid-->"+mid+" days-->"+days);

            if(days<=k){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
//        System.out.println("hello world");
        Leetcode L1 = new Leetcode();



//    Arrays problame


//        1752. Check if Array Is Sorted and Rotated
//          int[] a = {3,4,5,1,2};
////        int[] a = {2,1,3,4};
//          boolean res =  L1.check175(a);
//          System.out.println(res);


//          minimum of roateted array
//            int[] a = {3,4,5,1,2};
//            int[] a = {7,8,1,2,3,4,5,6};
//            int res = L1.findMinOfRoatetedArr(a);
//            System.out.println("min is:" + res);

//          26 remove duplicates
//            int[] a = {0,0,1,1,1,2,2,3,3,4};
//            int res = L1.removeDuplicates26(a);
//            System.out.println(res);

//        189. Rotate Array
//               int[] nums = {1,2,3,4,5,6,7,8};
//               int k = 3;
//               int[] nums = {1,2};
//               int k = 3;
//               int[] res =L1.rotateArray189(nums,k);
//               PrintSingleArray(res);

//        Union of Two Sorted Array
//         int[] a = {1,2,3,4,5};
//         int[] b = {1,2,3,6,7};
//         List<Integer> list =  L1.unionOfTheArray(a,b);
//         PrintSingleList(list);


//        485. Max Consecutive Ones
//          int[] a = {1,0,1,1,0,1};
//          int res = L1.findMaxConsecutiveOnes(a);
//          System.out.print(res);

//        Longest Sub-Array with Sum K
//            int[] a = {10, 5, 2, 7, 1, 9};
//            int k=15;
////            int[] a = {-1,2,3};
////            int k = 6;
//            int res = L1.lenOfLongSubarr(a,k);
//            System.out.print(res);



//        1 two sum
//          int[] a = {3,2,4};
//          int target=6;
//          int[] res= L1.twoSum(a,target);
//          PrintSingleArray(res);

//        53. Maximum Subarray
//           int[] a = {-2,1,-3,4,-1,2,1,-5,4};
//           int res = L1.maxSubArray(a);
//           System.out.print(res);


//        Maximum Score from Subarray Minimum
//             int[] a = {4,3,1,5,6};
//             int[] a = {5, 4, 3, 1, 6};
//             int res = L1.pairWithMaxSum(a);
//             System.out.println(res);

//        48. Rotate Image
//               int[][] a = {{1,2,3} , {4,5,6},{7,8,9}};
//               int[][] res =  L1.rotate(a);
//               PrintDoubleArray(res);

//        560. Subarray Sum Equals K
//               int[] a = {-1,-1,1};
//               int k=0;
////                 int[] a = {1,1,1};
////                 int k=2;
//               int res = L1.subarraySum(a , k);
//               System.out.println(res);



//        229. Majority Element II
//               int[] a = {3,2,3};
////               int[] a = {1};
////               int[] a = {1,2};
//               List<Integer> res=L1.majorityElement(a);
//               PrintSingleList(res);

//           Largest subarray with 0 sum
//          int[] a = {15,-2,2,-8,1,7,10,23};
//          int res =  L1.maxLenWithSum0(a);
//          System.out.println(res);

//         56. Merge Intervals
//             int[][] a = {{1,3},{2,6},{8,10},{15,18}};
//             int[][] res = L1.mergeInterval(a);
//             PrintDoubleArray(res);

//        704. Binary Search
//               int[] a = {-1,0,3,5,9,12};
//               int target= 9;
//               int res = L1.binarySearch(a,target);
//               System.out.println(res);

//        Floor in a Sorted Array
//           int[] a = {1,2,8,10,11,12,19};
//           int k=0;
////           int k=5;
//           int res =  L1.findFloor(a,k);
//           System.out.println(res);

//        Ceil The Floo
//            int[] a = {1,2,8,10,11,12,19};
//            int k=13;
//            int res = L1.getFloorAndCeil(a , k);
//            System.out.println(res);

//        35. Search Insert Position
//              int[] a = {1,3,5,6};
//              int target=2;
//              int res = L1.searchInsert(a,target);
//              System.out.println(res);

//        33. Search in Rotated Sorted Array
////              int[] a = {4,5,6,7,0,1,2};
//              int[] a = {1,0,1,1,1};
//              int target=0;
//              int res =  L1.searchInRotatedArray(a , target);
//              System.out.println(res);

//        153. Find Minimum in Rotated Sorted Array\
//               int[] a = {4,5,6,7,0,1,2};
//               int res = L1.findMinInRotatedArray(a);
//               System.out.println(res);

//        Find Kth Rotation
//        List<Integer> a = new ArrayList<>(List.of(5, 1, 2, 3, 4));
//        List<Integer> a = new ArrayList<>(List.of(39,6,11, 14, 18, 36, 37, 38));
//          int res = L1.findKRotation(a);
//          System.out.println(res);


//        Square root of a numbe
//           int x=2;
//           int res = L1.floorSqrt(x);
//           System.out.println(res);

//        Find Nth root of M
//            int num=9;
//            int k=2;
//            int res= L1.NthRoot(num , k);
//            System.out.println(res);

////        875. Koko Eating Bananas
////             int[] a = {30,11,23,4,20};
////             int[] a = {3,6,7,11};
////             int h = 5;
////             int h = 8;
////             int h = 6;
//               int[] a= {312884470};
//               int h=312884469;
//             int res =  L1.minEatingSpeed(a,h);
//             System.out.println(res);



//        1283. Find the Smallest Divisor Given a Threshold
//               int[] a = {44,22,33,11,1};
//               int k=5;
//               int res = L1.smallestDivisor(a ,k);
//               System.out.println(res);

//        1011. Capacity To Ship Packages Within D Days
//                int[] a = {1,2,3,4,5,6,7,8,9,10};
                int[] a = {1,2,3,4,5,6,7,8,9,10};
//                int k=5;
                int k=1;
                int res = L1.shipWithinDays(a,k);
                System.out.println(res);

    }

}
