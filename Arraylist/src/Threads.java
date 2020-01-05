class Threads {

    public static int majorityElement(int[] num) {
        //0(n) time and 0(1) extra space
//1 5 2 5 5 5
        int major = Integer.MIN_VALUE, count = 0;
        for (int i = 0; i < num.length; i++) {
            if (count == 0) {
                count=1;
                major = num[i];
            } else if (major == num[i]) {
                count++;
            } else count--;

        }
        return major;
// 1 5 2 5 4
// 1 2 4 5 5
//        int result = 0, count = 0;
//
//        for(int i = 0; i<num.length; i++ ) {
//            if(count == 0){
//                result = num[ i ];
//                count = 1;
//            }else if(result == num[i]){
//                count++;
//            }else{
//                count--;
//            }
//        }
//
//        return result;



        //0(n) time and 0(n) space, but 0(1) for access and search
//        Map<Integer,Integer> map = new HashMap<>();
//        int count=1;
//        for(int i=0;i<num.length;i++){
//            if(!map.containsKey(num[i])){
//
//                map.put(num[i],count);
//            }
//            else
//                map.put(num[i],map.get(num[i])+1);
//        }
//        System.out.println(map);
//        int res=0;
//        int max = Collections.max(map.values());
//        for(Map.Entry<Integer,Integer> entry :map.entrySet()) {
//            if (entry.getValue() == max) {
//                res=entry.getKey();
//            //    System.out.println(entry.getKey());
//
//            }
//        }
        //return res;

    }

    public static void main(String[] args) {
        int[] num={1,5,2,5,5,5};
       // Arrays.sort(num);
//        Map<Integer,Integer> map = new HashMap<>();
//
//        for(int i=0;iM)
        //System.out.println(num[num.length/2]);
//
//        int count = 1, max = 1;
//
//        for (int i = 1; i < num.length; i++) {
//            if (num[i] >= num[i - 1]) {
//                count++;
//            } else {
//                count = 1;
//            }
//
//            if (count > max) {
//                max = count;
//            }
//        }
//
//        System.out.println(max);

        //return nums[nums.length/2];
        System.out.println(majorityElement(num));


    }

}