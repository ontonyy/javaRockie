package structural.proxy.youtube;

public class Manager {
    private YoutubeLib youtubeLib;

    public Manager(YoutubeLib youtubeLib) {
        this.youtubeLib = youtubeLib;
    }

    public void renderVideo() {
        youtubeLib.listVideos();
    }

    public void startSession() {
        youtubeLib.startVideo();
    }
}
