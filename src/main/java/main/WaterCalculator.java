package main;

public class WaterCalculator {

    public long calculateWaterAmount(int[] landscape) {
        if (landscape.length < 3) {
            return 0;
        }
        int[] peaks = new int[landscape.length / 2 + 1];
        peaks[0] = findLeftPeak(landscape);
        int i = 0;
        int nextPeak = findNextPeak(peaks[i], landscape);
        while (nextPeak > 0) {
            i = putPeak(nextPeak, peaks, i + 1, landscape);
            nextPeak = findNextPeak(peaks[i], landscape);
        }
        long volume = 0;
        int leftPeak = peaks[0];
        int k = 1;
        while (k < peaks.length && peaks[k] > 0) {
            volume += fillWater(leftPeak, peaks[k], landscape);
            leftPeak = peaks[k];
            k++;
        }
        return volume;
    }

    private int putPeak(int nextPeak, int[] peaks, int peakPos, int[] landscape) {
        peaks[peakPos] = nextPeak;
        int j = peakPos - 1;
        while (j > 0 &&
                landscape[peaks[j]] < landscape[nextPeak] &&
                landscape[peaks[j]] <= landscape[peaks[j - 1]]) {
            peaks[j + 1] = 0;
            peaks[j] = nextPeak;
            j--;
        }
        return j + 1;
    }

    int findLeftPeak(int[] landscape) {
        int leftPeak = 0;
        int i = 1;
        while (i < landscape.length && landscape[i] >= landscape[leftPeak]) {
            leftPeak = i;
            i++;
        }
        return leftPeak;
    }

    int findNextPeak(int peakPos, int[] landscape) {
        int i = peakPos;
        // Go to the bottom
        while (i < landscape.length - 1 && landscape[i] >= landscape[i + 1]) {
            i++;
        }
        if (i == landscape.length - 1) {
            return -1;
        }
        // Find next peak
        int rightPeak = i;
        i++;
        while (i < landscape.length && landscape[i] > landscape[rightPeak]) {
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
