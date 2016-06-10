package scopa.cona.service.load;

import org.apache.log4j.Logger;
import scopa.cona.constant.FileExt;
import scopa.cona.constant.FileName;
import scopa.cona.util.FileUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by panda on 6/9/16.
 */
public class LoadParseDataViewJson {

    public static final Logger logger = Logger.getLogger(LoadParseDataViewJson.class);

    public static List<File> loadFile(String dirPath) {
        List<File> fileList = FileUtil.getFileListFromDir(dirPath, FileExt.json.toString(), new ArrayList<File>());
        dispatchParseFile(fileList);
        return fileList;
    }

    public static void dispatchParseFile(List<File> fileList) {

        for (File file : fileList) {

                String filePath = file.getAbsolutePath();
                String parentFileName = file.getParentFile().getName();
                String parentPFileName = file.getParentFile().getParentFile().getName();
                FileReader fileReader = null;

                try {
                    fileReader = new FileReader(filePath);
                } catch (FileNotFoundException e) {
                    logger.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
                            "File" + filePath + " not found.");
                }


                if (parentPFileName.contains(FileName.dictionary.toString())) {
                    switch (parentFileName) {
                        case "entity":
                            ParseDictJson.parseEntity(fileReader);
                            break;
                        case "event":
                            ParseDictJson.parseEvent(fileReader);
                            break;
                        case "relationship":
                            ParseDictJson.parseRelation(fileReader);
                            break;
                        default:
                            break;
                    }
                } else if (parentPFileName.contains(FileName.mapping.toString())) {
                    switch (parentFileName) {
                        case "entity":
                            logger.info("yyyyyyyyyyyyyyy" + filePath);
                            ParseMappingJson.parseEntity(fileReader);
                            break;
                        case "event":
                            ParseMappingJson.parseEvent(fileReader);
                            break;
                        case "relationship":
                            ParseMappingJson.parseRelation(fileReader);
                            break;
                        default:
                            break;
                    }
                }
        }
    }
}
