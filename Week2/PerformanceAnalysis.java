public class PerformanceAnalysis {

    public int[] nums;
    public PerformanceAnalysis(int[] nums) {
        this.nums = nums;
    }

    public static int sum(int[] a) {
        int sum  = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
        }
        return sum;
    }
    public static int head(int[] a) {
        return a[0];
    }

    public static boolean containsDuplicates(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for(int j = i + 1; j < a.length; j++) {
                if(a[i] == a[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        for(int i = 1000; i < 16_000; i = i * 2) {
            int[] size = new int[i];
        
        for(int j = 0; j < size.length; j++) {
            size[j] = j;
        }
        int trials = 1000;
        long totalTime = 0;
        for(int k = 0; k < trials; k++) {
            long start = System.nanoTime();
            // to test change method call
            
            long end = System.nanoTime();
            totalTime = totalTime + (end-start);
        }
        double average = (double)(totalTime/trials);
        System.out.print(size + ":" + average);
        }
    }       
}