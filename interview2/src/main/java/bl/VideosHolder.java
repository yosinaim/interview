package bl;


import dto.ResponseData;
import dto.Video;
import dto.VideoPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class VideosHolder {

    private Set<String> urls;
    private List<Video> videos;

    public VideosHolder(Set<String> urls) {
        this.urls = urls;
        this.videos = new ArrayList<Video>();
    }

    public void processing() {

        for(String url : urls) {

            //download video + filter

            // create video object and add it to the list
            this.videos.add(null);
        }

    }

    private boolean isAllVideosAreInSync() {
        boolean result = true;
        List<VideoPoint> videoPoints = null;

        for(Video video : this.videos) {
            if(videoPoints == null) {
                //first cycle just need to fill data
                videoPoints = new ArrayList<VideoPoint>(video.getVideoPoints());
                continue; //next cycle
            }


            // in case number of freeze is diff then we can stop because they are not sync
            if(videoPoints.size() != video.getVideoPoints().size()) {
                result = false;
                break;
            }


            for(int i=0; i < video.getVideoPoints().size(); i++) {

                //in case that the diff is more than 500 ms then it not sync and we can stop checking
                if((Math.abs(video.getVideoPoints().get(i).getStart() - videoPoints.get(i).getStart()) > 500) ||
                        (Math.abs(video.getVideoPoints().get(i).getStop() - videoPoints.get(i).getStop()) > 500)) {
                    result = false;
                    break;
                }

                //need to update the max and min
                videoPoints.get(i).setStart(Math.min(videoPoints.get(i).getStart(), video.getVideoPoints().get(i).getStart()));
                videoPoints.get(i).setStop(Math.max(videoPoints.get(i).getStop(), video.getVideoPoints().get(i).getStop()));
            }



        }

        return result;
    }

    public String buildJson() {


        boolean isSync = isAllVideosAreInSync();

        ResponseData response = new ResponseData();
        response.all_videos_freeze_frame_synced = isSync;
        response.videos = this.videos;

        return "";
        //return new Gson.toJson(response);
    }

}
