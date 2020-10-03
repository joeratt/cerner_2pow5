import java.util.*;
import java.util.stream.*;
/**
 * cerner_2^5_2020
 * convert an absolute unix path with unix path progressions
 */
public class UnixPath {
    public static void main(String args[]) {
        final String path = args[0];
        Stack<String> pathStack = new Stack<String>();

        String[] splitPath = path.split("/");

        for(String pathPart: splitPath) {
            if(pathPart == null || pathPart.isEmpty() || ".".equals(pathPart)) {
                continue;
            }
            if("..".equals(pathPart)) {
                if(!pathStack.isEmpty()) {
                    pathStack.pop();
                }
            }
            else {
                pathStack.push(pathPart);
            }
        }

        Object[] finalPathParts =  pathStack.toArray();
        String finalPath = "/" + Arrays.stream(finalPathParts).map(Object::toString).collect(Collectors.joining("/"));
        System.out.println(finalPath);
    }
}