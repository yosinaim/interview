package api;

import bl.VideosHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@RestController
public class RestResource {

    @RequestMapping(value = {"/videos/{urls}"}, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public String postVideosUrl(@RequestBody String urls) {
        //VideosHolder videosHolder = new VideosHolder();
        return "hello";
    }

    @RequestMapping(value = {"/videos/{urls}"}, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public String getVideosUrl(@PathVariable String urls) {
        //Objects.requireNonNull(urls);

        Set<String> videoUrl = new HashSet<String>(Arrays.asList(urls.split(";")));

        VideosHolder videosHolder = new VideosHolder(videoUrl);
        videosHolder.processing();

        return "hello";
    }


}
