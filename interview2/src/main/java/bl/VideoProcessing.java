package bl;

import dto.Video;

public class VideoProcessing {

    public static Video process(String videoUrl) {
        //download video
        downloadVideo(videoUrl);

        //run filter on video
        filerVideo();



        return null;//new Video();
    }

    private static void downloadVideo(String videoUrl) {

    }

    private static void filerVideo() {

    }

}
