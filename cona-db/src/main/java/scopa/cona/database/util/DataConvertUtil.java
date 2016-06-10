package scopa.cona.database.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * Created by panda on 5/16/16.
 */
public class DataConvertUtil {
    public static String implode(Object[] array, Object seperator) {
        StringBuffer out = new StringBuffer();
        String sepStr = seperator.toString();
        boolean first = true;
        for (Object elem: array) {
            if (null == elem)
                continue;

            if (first)
                first = false;
            else
                out.append(seperator);
            out.append(elem);
        }
        return out.toString();
    }

    public static String implodeInt(Integer[] array) {
        return implode(array, ",");
    }

    public static String implodeString(String[] array) {
        return implode(array, ",");
    }

    public static String[] explodeString(String str) {
        List<String> strList = explodeString(str, ",");
        String[] strArr = new String[strList.size()];
        return strList.toArray(strArr);
    }

    public static List<Object> explode(String str, String seperator) {
        StringTokenizer st = new StringTokenizer(str, seperator);
        List<Object> array = new ArrayList<Object>();
        for (; st.hasMoreTokens();) {
            array.add(st.nextToken());
        }
        return array;
    }

    public static List<Integer> explodeInt(String str, String seperator) {
        List<Object> arrayObject = explode(str, ",");
        List<Integer> arrayInt = new ArrayList<>();
        for (Object object : arrayObject) {
            arrayInt.add((Integer)object);
        }
        return arrayInt;
    }

    public static List<String> explodeString(String str, String seperator) {
        List<Object> arrayObject = explode(str, ",");
        List<String> arrayInt = new ArrayList<>();
        for (Object object : arrayObject) {
            arrayInt.add((String)object);
        }
        return arrayInt;
    }

}
