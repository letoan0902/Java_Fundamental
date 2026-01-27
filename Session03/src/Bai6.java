public class Bai6 {
    public static int[] mergeBooks(int[] a, int[] b) {
        if (a == null) a = new int[0];
        if (b == null) b = new int[0];

        int[] temp = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            int va = a[i];
            int vb = b[j];

            int pick;
            if (va < vb) {
                pick = va;
                i++;
            } else if (vb < va) {
                pick = vb;
                j++;
            } else {
                pick = va;
                i++;
                j++;
            }

            if (k == 0 || temp[k - 1] != pick) {
                temp[k++] = pick;
            }
        }

        while (i < a.length) {
            int pick = a[i++];
            if (k == 0 || temp[k - 1] != pick) temp[k++] = pick;
        }

        while (j < b.length) {
            int pick = b[j++];
            if (k == 0 || temp[k - 1] != pick) temp[k++] = pick;
        }

        int[] merged = new int[k];
        System.arraycopy(temp, 0, merged, 0, k);
        return merged;
    }

    public static void display(int[] arr, String label) {
        System.out.print(label + ": [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] arrayFirst = {1, 3, 5, 7, 9};
        int[] arraySecond = {2, 3, 5, 6, 8, 9, 10};

        display(arrayFirst, "Kho cũ");
        display(arraySecond, "Lô mới");

        int[] arrayMerge = mergeBooks(arrayFirst, arraySecond);
        display(arrayMerge, "Kho tổng (đã gộp & lọc trùng)");
    }
}
