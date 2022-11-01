package calc;

public class WaterCalculator3 {

    public long calculateWaterAmount(int[] landscape) {
        if (landscape.length < 3) {
            return 0;
        }
        long volume = 0;
        int leftPeak = findLeftPeak(0, landscape);
        int rightPeak = findRightPeak(landscape.length - 1, landscape);
        int i;
        while (leftPeak < rightPeak) {
            if (landscape[leftPeak] <= landscape[rightPeak]) {
                for (i = leftPeak + 1; i < landscape.length && landscape[leftPeak] > landscape[i]; i++) {
                    volume += landscape[leftPeak] - landscape[i];
                }
                leftPeak = findLeftPeak(i, landscape);
            } else {
                for (i = rightPeak - 1; i >= 0 && landscape[rightPeak] > landscape[i]; i--) {
                    volume += landscape[rightPeak] - landscape[i];
                }
                rightPeak = findRightPeak(i, landscape);
            }
        }
        return volume;
    }

    int findLeftPeak(int current, int[] landscape) {
        int leftMax = landscape[current];
        int i = current;
        while (i < landscape.length && landscape[i] >= leftMax) {
            leftMax = landscape[i];
            i++;
        }
        return i - 1;
    }

    int findRightPeak(int current, int[] landscape) {
        int rightMax = landscape[current];
        int i = current;
        while (i >= 0 && landscape[i] >= rightMax) {
            rightMax = landscape[i];
            i--;
        }
        return i + 1;
    }

}
