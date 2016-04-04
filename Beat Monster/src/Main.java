import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			int num = in.nextInt();
			int a = in.nextInt();
			
			while (num > 0) {
				int b = in.nextInt();
				
				if ( a >= b )	a += b;
				else a += maxCommonDivisor(a, b);
				
				num--;
			}
			System.out.println(a);
		}
	}
	
    private static int maxCommonDivisor(int n, int m) {  

        while (m % n != 0) {// 在余数不能为0时,进行循环  
            int temp = m % n;  
            m = n;  
            n = temp;  
        }  
        return n;// 返回最大公约数  
    }  

}
