package structural.proxy.youtube;

public class CachedYoutubeClass implements YoutubeLib {
    private YoutubeClass youtubeClass;
    private boolean listCache = false, startCache = false;

    public CachedYoutubeClass(YoutubeClass youtubeClass) {
        this.youtubeClass = youtubeClass;
    }

    @Override
    public void listVideos() {
        if (!listCache) {
            youtubeClass.listVideos();
            listCache = true;
        } else {
            System.out.println("Cache working");
            listCache = false;
        }
    }

    @Override
    public void startVideo() {
        if (!startCache) {
            youtubeClass.startVideo();
            startCache = true;
        } else {
            System.out.println("Start cache");
            startCache = false;
        }
    }
}
