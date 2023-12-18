import java.util.Random;

public class arrayTest3 {
    public static void main(String[] args) {
        int[] arr =new int[100];
        int avg=0;
        int sum=0;
        int count=0;
        Random r =new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i]= r.nextInt(100)+1;
        }
        for (int i = 0; i < arr.length; i++) {
            sum=sum+arr[i];
        }
        avg=sum/arr.length;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<avg){
                count++;
            }
        }
        System.out.println("数组的数据和为"+sum);
        System.out.println("数据的平均值为"+avg);
        System.out.println("一共有"+count+"个数据比平均数小");
        

    }
}
