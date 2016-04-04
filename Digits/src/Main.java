import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List newList;
		ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
		ArrayList<Integer> array0 = new ArrayList<Integer>();
		array0.add(1);
		array0.add(2);
		array0.add(3);
		array0.add(5);
		array0.add(6);
		array0.add(7);
		list.add(array0);
		ArrayList<Integer> array1 = new ArrayList<Integer>();
		array1.add(3);
		array1.add(6);
		list.add(array1);
		ArrayList<Integer> array2 = new ArrayList<Integer>();
		array2.add(1);
		array2.add(3);
		array2.add(4);
		array2.add(5);
		array2.add(7);
		list.add(array2);
		ArrayList<Integer> array3 = new ArrayList<Integer>();
		array3.add(1);
		array3.add(3);
		array3.add(4);
		array3.add(6);
		array3.add(7);
		list.add(array3);
		ArrayList<Integer> array4 = new ArrayList<Integer>();
		array4.add(2);
		array4.add(3);
		array4.add(4);
		array4.add(6);
		list.add(array4);
		ArrayList<Integer> array5 = new ArrayList<Integer>();
		array5.add(1);
		array5.add(2);
		array5.add(4);
		array5.add(6);
		array5.add(7);
		list.add(array5);
		ArrayList<Integer> array6 = new ArrayList<Integer>();
		array6.add(1);
		array6.add(2);
		array6.add(4);
		array6.add(5);
		array6.add(6);
		array6.add(7);
		list.add(array6);
		ArrayList<Integer> array7 = new ArrayList<Integer>();
		array7.add(1);
		array7.add(3);
		array7.add(6);
		list.add(array7);
		ArrayList<Integer> array8 = new ArrayList<Integer>();
		array8.add(1);
		array8.add(2);
		array8.add(3);
		array8.add(4);
		array8.add(5);
		array8.add(6);
		array8.add(7);
		list.add(array8);
		ArrayList<Integer> array9 = new ArrayList<Integer>();
		array9.add(1);
		array9.add(2);
		array9.add(3);
		array9.add(4);
		array9.add(6);
		array9.add(7);
		list.add(array9);
		
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		
		while (num > 0) {
			int k = in.nextInt();
			int n = in.nextInt();
			in.nextLine();
			int res = 1;
			while (k > 0) {
				int temp = 0;
				String[] line = in.nextLine().trim().split("\\s+");
				ArrayList<Integer> value = new ArrayList<Integer>();
				for (String s : line) {
					if (s.equals(""))	continue;
					int number = Integer.parseInt(s);
					for (int j = 0; j <= 9; j++) {
						if (!list.get(j).contains(number)) {
							value.add(j);
						}
					}
				}
				for (int j = 0; j <=9; j++) {
					if (j > n/(int)(Math.pow(10, k-1)))	break;
					if (!value.contains(j)) {
						temp++;
					}
				}
				res *= temp;
				k--;
			}
			System.out.println(res);
			num--;
		}
	}
	
	

}
