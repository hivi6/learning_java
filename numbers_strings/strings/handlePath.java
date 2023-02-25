package numbers_strings.strings;

public class handlePath {
    static String convertToRegex(String path) throws IllegalArgumentException {
        String pathRegex = "";

        int i = 0;
        while (i < path.length()) {
            // start of key
            if (path.charAt(i) == '{') {
                int j = i + 1;
                String key = "";
                while (j < path.length() && (path.charAt(j) != '}' && path.charAt(j) != '/')) {
                    key += path.charAt(j++);
                }
                if (j == path.length() || path.charAt(j) == '/')
                    throw new IllegalArgumentException("doesnot expectes '/' inside {...}");
                
                i = j + 1; // ignore }

                pathRegex += "(?<" + key + ">[^/]+)";
            } else {
                pathRegex += path.charAt(i);
                i++;
            }
        }

        return "^" + pathRegex + "$";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(convertToRegex("/"));
        System.out.println(convertToRegex("/hi"));
        System.out.println(convertToRegex("/hi/{name}"));
        System.out.println(convertToRegex("/hi/{name}/devices"));
        System.out.println(convertToRegex("/hi/{name}/devices/hehe-{device}"));
    }
}
