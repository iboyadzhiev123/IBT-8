package helpers;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesHelper {
    private static boolean caseSensitive = false;

    public static boolean getCaseSensitive() {
        return caseSensitive;
    }

    public static void setCaseSensitive(boolean value) {
        caseSensitive = value;
    }

    //a method which currently isn't used anywhere. Leaving it for now in case somthing like that is
    // needed in the future
    public static String getValue(String propKey) {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "config.properties";
        Properties props = new Properties();
        String propValue = "";
        try {
            props.load(new FileInputStream(appConfigPath));
            propValue = props.getProperty(propKey);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return propValue;
    }

    public static void initialize() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "config.properties";
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(appConfigPath));
            setCaseSensitive(Boolean.parseBoolean(props.getProperty("caseSensitive")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args){
        String str = "Lorem ipsum dolor sit amet,   consectetur adipiscing elit, sed do    eiusmod tempor";
        char ch = ' ';
        String regex = "(\\s)+(\\s)";
        String newStr = str.replaceAll(regex,Character.toString(ch));
        System.out.println(String.format("The old: %s\nThe new: %s", str, newStr));
//        //str.replaceFirst("(.*)a(.*)", "b");
//        //System.out.println(str);
//        //String res = str.replaceFirst("a", "b");
//        //String res = StringHelper.replaceCharFirst(str,'a', '');
//        //String res = str.replaceFirst("a", "");
//        String str1 = StringHelper.removeCharFirst(str,'a');
//        //System.out.println(str1);
//        String res1 = StringHelper.removeCharFirst(str1,'z');
//        System.out.println(res1);
//
//        String str2 = "CucumberaazzAAZZ";
//        String str3 = StringHelper.removeAll(str2, 'Z');
//        System.out.println(str3);

    }

}
