import java.util.Scanner;

public class TreePiece {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        //�־��� ���� �Է¹ޱ�
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt();
        }
		
		// �������� �����ϱ�
		int tmp = 0;
		
		for (int j=0;j<5;j++){
            for (int i = 0; i < 4; i++) {
                if(nums[i]>nums[i+1]){
                    tmp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = tmp;
                    for (int num : nums) {
                        System.out.print(num+" ");
                    }
                    System.out.println();
                }
            }
        }
	}

}
