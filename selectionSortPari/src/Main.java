public class Main {
    public static void main(String[] args) {
        int[] numeriDaOrdinare = {2, 3, 1, 9, 4, 7, 4, 2, 1, 6};
        selectionSortPari(numeriDaOrdinare);
        for (int i : numeriDaOrdinare) {
            System.out.println(i);
        }
    }

    public static void selectionSortPari(int[] nums) {
        int min;
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min] && nums[min] % 2 == 0 && nums[j] % 2 == 0) {
                    min = j;
                }
            }
            temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
    }
}