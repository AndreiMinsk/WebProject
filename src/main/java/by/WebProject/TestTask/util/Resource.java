package by.WebProject.TestTask.util;

import java.util.ResourceBundle;

/**
 * util class - helps with resources
 *
 * @author Andrei Liashevich
 */
public class Resource  {

    public final static String RESOURCE_PATH = "res";

    private static ResourceBundle resource = ResourceBundle.getBundle(RESOURCE_PATH);

    public static  String getStrByKey(String key){
        return resource.getString(key);
    }
}
