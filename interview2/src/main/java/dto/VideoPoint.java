package dto;


public class VideoPoint {
    private double start;
    private double stop;

    public VideoPoint(double start, double stop) {
        this.start = start;
        this.stop = stop;
    }

    public double calculateTimePlay() {
        return (stop - start);
    }

    public double getStart() {
        return start;
    }

    public double getStop() {
        return stop;
    }

    public void setStart(double start) {
        this.start = start;
    }

    public void setStop(double stop) {
        this.stop = stop;
    }
}
