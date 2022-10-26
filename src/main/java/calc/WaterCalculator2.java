package calc;

public class WaterCalculator2 {

    public long calculateWaterAmount(int[] landscape) {
        if (landscape.length < 3) {
            return 0;
        }
        long volume = 0;
        int leftPeak = findLeftPeak(landscape);
        int rightPeak = findRightPeak(landscape, leftPeak);
        while (rightPeak > 0) {
            volume += fillWater(leftPeak, rightPeak, landscape);
            leftPeak = rightPeak;
            rightPeak = findRightPeak(landscape, leftPeak);
        }
        return volume;
    }

    int findLeftPeak(int[] landscape) {
        int leftPeak = 0;
        int i = 1;
        while (i < landscape.length &&
                landscape[i] >= landscape[leftPeak]) {
            leftPeak = i;
            i++;
        }
        return leftPeak;
    }

    int findRightPeak(int[] landscape, int leftPeak) {
        int nextPeak = findNextPeak(leftPeak, landscape);
        if (nextPeak < 0) {
            return nextPeak;
        }
        int rightPeak = nextPeak;
        while (landscape[nextPeak] < landscape[leftPeak]) {
            nextPeak = findNextPeak(nextPeak, landscape);
            if (nextPeak < 0) {
                return rightPeak;
            }
            if (landscape[nextPeak] >= landscape[rightPeak]) {
                rightPeak = nextPeak;
            }
        }
        return rightPeak;
    }

    int findNextPeak(int peakPos, int[] landscape) {
        int i = peakPos;
        // Go to the bottom
        while (i < landscape.length - 1 &&
                landscape[i] >= landscape[i + 1]) {
            i++;
        }
        if (i == landscape.length - 1) {
            return -1;
        }
        // Go up searching next peak
        int rightPeak = i;
        i++;
        while (i < landscape.length &&
                landscape[i] > landscape[rightPeak]) {
            rightPeak = i;
            i++;
        }
        return rightPeak;
    }

    long fillWater(int leftPeak, int rightPeak, int[] landscape) {
        int waterLevel = Math.min(landscape[leftPeak], landscape[rightPeak]);
        long volume = 0;
        for (int i = leftPeak; i <= rightPeak; i++) {
            if (landscape[i] < waterLevel) {
                volume += waterLevel - landscape[i];
            }
        }
        return volume;
    }

}
