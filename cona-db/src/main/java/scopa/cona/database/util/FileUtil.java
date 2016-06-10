package scopa.cona.database.util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by panda on 5/15/16.
 */
public class FileUtil {
    public static final Logger logger = Logger.getLogger(FileUtil.class);

    public static String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();
        String         ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }

    public static void writeFile(String writtenFilePath, String content) {
        try {
            FileWriter jsonFile = new FileWriter(writtenFilePath);
            jsonFile.write(content);
            jsonFile.flush();
            jsonFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String convertFilePathToString(String jsonFilePath) throws IOException {
        return readFile(jsonFilePath);
    }
}
