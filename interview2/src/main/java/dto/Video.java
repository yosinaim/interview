package dto;


import java.util.List;

public class Video {

    private String name;
    private String downloadUrl;
    private double longestValidPeriod; //the longest time that the video played without freeze
    private double aggregatedValidVideoPeriodsPercentage;

    private List<VideoPoint> videoPoints;

    public Video(String name, String downloadUrl, List<VideoPoint> videoPoints) {
        this.name = name;
        this.downloadUrl = downloadUrl;
        this.videoPoints = videoPoints;
        calculateVideoData(videoPoints);

    }

    private void calculateVideoData(List<VideoPoint> videoPoints) {
        double lvp = 0;
        double sumValidVideoPeriods = 0;
        double videoMaxTime = 0;
        for(VideoPoint vp : videoPoints) {
            double currentValidTime = vp.calculateTimePlay();
            lvp = Math.max(lvp, currentValidTime);
            sumValidVideoPeriods += currentValidTime;
            videoMaxTime = vp.getStop();
        }

        this.longestValidPeriod = lvp;
        this.aggregatedValidVideoPeriodsPercentage = ((sumValidVideoPeriods / videoMaxTime ) * 100);

    }

    public int getNumberOffFreeze() {
        return videoPoints.size() - 1;
    }

    public String getName() {
        return name;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public double getLongestValidPeriod() {
        return longestValidPeriod;
    }

    public double getAggregatedValidVideoPeriodsPercentage() {
        return aggregatedValidVideoPeriodsPercentage;
    }

    public List<VideoPoint> getVideoPoints() {
        return videoPoints;
    }



}
