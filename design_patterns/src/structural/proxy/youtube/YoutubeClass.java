package structural.proxy.youtube;

public class YoutubeClass implements YoutubeLib {
    @Override
    public void listVideos() {
        System.out.println("Videos was listed...");
    }

    @Override
    public void startVideo() {
        System.out.println("Start first video in list");
    }
}
