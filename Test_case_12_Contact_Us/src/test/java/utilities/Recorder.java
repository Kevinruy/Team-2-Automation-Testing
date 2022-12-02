package utilities;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;
public class Recorder extends ScreenRecorder {
    // to record the screen from your Java code
//static we can access to this variable without an instance of the class
    public static ScreenRecorder screenRecorder;
    public String name;

    // set the graphics configuration
    public Recorder(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
                    Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name)
            throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    @Override
//CREATE THE VIDEO
    protected File createMovieFile(Format fileFormat) throws IOException {
//If moviefolder doesn't exist
        if (!movieFolder.exists()) {
//create the specified directory path
            movieFolder.mkdirs();
        }
//if the file isn't a directory.
        else if (!movieFolder.isDirectory()) {
//display this message
            throw new IOException("\"" + movieFolder + "\" is not a directory.");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
//return a new file with path and date
        return new File(movieFolder,
                name + "-" + dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat));
    }
    //Start recording
    public static void startRecord(String methodName) throws Exception {
        File file = new File("./test-out/"); //Path where video recording would be saved
        //Dimension screenSize = Toolkit.getDefaultToolkit().getBestCursorSize();
        //Screensize  of the video
        int width =2000;
        int height = 1200;
        //shape of the video screen
        Rectangle captureSize = new Rectangle(0, 0, width, height);
        //configuration of the environment of the video
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
                getDefaultScreenDevice()
                .getDefaultConfiguration();
        screenRecorder = new Recorder(gc, captureSize,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
                        Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null, file, methodName);
        //after configuration start recording
        screenRecorder.start();
    }
    //STOP RECORDING
    public static void stopRecord() throws Exception {
        screenRecorder.stop();
    }
}




