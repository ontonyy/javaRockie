package structural.facade.video;

public class VideoConverter {
    public void convert(String filename, String format) {
        VideoCodec codec = switch (format.toLowerCase()) {
            case "mp4" -> new MPEG4CompressionCodec();
            case "ogg" -> new OggCompressionCodec();
            case "file" -> new VideoFile();
            case "audio" -> new AudioMixer();
            default -> new CodecFactory();
        };
        System.out.println(codec);
    }
}

class VideoFile implements VideoCodec {}

class OggCompressionCodec implements VideoCodec {}

class MPEG4CompressionCodec implements VideoCodec {}

class CodecFactory implements VideoCodec {}

class BitrateReader implements VideoCodec {}

class AudioMixer implements VideoCodec {}
