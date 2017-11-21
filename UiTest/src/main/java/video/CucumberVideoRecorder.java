package video;

/**
 * Created by osolomin on 17.11.17.
 */
public class CucumberVideoRecorder {

//    private IVideoRecorder recorder;
//
//    public CucumberVideoRecorder(){
//      //  System.setProperty("video.folder","/build/video");
//       // System.setProperty("recorder.type","ogg");
//        //System.setProperty("video.frame.rate","12");
//    }
//
//    public void start(){
//        recorder = RecorderFactory.getRecorder(VideoRecorder.conf().recorderType());
//        recorder.start();
//    }
//
//    public void start(String hubUrl){
//        recorder = RecorderFactory.getRecorder(VideoRecorder.conf().recorderType());
//        recorder.start();
//    }
//
//    public File stopRecording(String filename) {
//        if (recorder != null) {
//            return recorder.stopAndSave(filename);
//        }
//        return null;
//    }
//
//    @Attachment(value = "video", type = "video/mp4")
//    public byte[] attachment() {
//        try {
//            File video = VideoRecorder.getLastRecording();
//            return Files.readAllBytes(Paths.get(video.getAbsolutePath()));
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new byte[0];
//        }
//    }
}
