class jv{
public static int[] array(int s, int[] a){
  int[] result = new int[] {-1};
  int sum = 0;
  int left = 0;
  int right =0;

while (right <a.length){
  sum += a[right];
  while(left <right&& sum>s){sum -= a[left++];}
    if(sum == s){
      result = new int[] {left+1, right+1};
    }
  right++;
}

for(int i=0;i<result.length;i++){System.out.println(result[i]);}
return result;

}
}

class findLongestSubArraybySum {
public static void main(String args[]){
  jv j =new jv();
  int b[] ={1,2,3,4,4,1,1,2,3,4,5,0,0,0,9,9};
  int target = 15;
  System.out.println( j.array(target,b));
  }
}
