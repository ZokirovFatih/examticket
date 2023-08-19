
//todo - in this class create two methods that can handle file copying
// 1.first method must include src file and from it your method will have to
// create another duplicate file. Then name of duplicate file should be like
// notes.txt => notes(1).txt
// 2.second method must include as an input two parameters , scr file and
// destination file. This method will reads from src file and writes to
// destination file.
// 3.For the class involve logger to log method operation details.
// When your methods throws an exception log error message to the console
// When copy file successfully finishes log info about it.
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class Streams {
        private static final Logger logger = Logger.getLogger(Streams.class.getName());
        public static void copyFileAndCreateDuplicate(File src) throws IOException {
            if (!src.exists()) {
                logger.log(Level.SEVERE, "src файл не найден");
                return;
            }
            String fileName = src.getName();
            int dotIndex = fileName.lastIndexOf('.');
            String name = dotIndex > 0 ? fileName.substring(0, dotIndex) : fileName;
            String extension = dotIndex > 0 ? fileName.substring(dotIndex) : "";
            String newName = name + "(1)" + extension;
            File dest = new File(src.getParentFile(), newName);
            copyFileUsingChannel(src, dest);
            logger.log(Level.INFO, "Файл {0} успешно скопирован в {1}", new Object[]{src, dest});
        }

        public static void copyFile(File src, File dest) throws IOException {
            if (!src.exists()) {
                logger.log(Level.SEVERE, "Файл src не существует");
                return;
            }
            if (dest.isDirectory()) {
                logger.log(Level.SEVERE, "Файл dest не может быть директорией");
                return;
            }
            copyFileUsingChannel(src, dest);
            logger.log(Level.INFO, "Файл {0} успешно скопирован в {1}", new Object[]{src, dest});
        }

        private static void copyFileUsingChannel(File source, File dest) throws IOException {
            FileChannel sourceChannel = null;
            FileChannel destChannel = null;
            try {
                sourceChannel = new FileInputStream(source).getChannel();
                destChannel = new FileOutputStream(dest).getChannel();
                destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
            } finally {
                sourceChannel.close();
                destChannel.close();
            }
        }


        public static void main(String[] args) throws IOException {

        }
    }
