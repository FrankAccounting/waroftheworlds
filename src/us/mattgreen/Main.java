package us.mattgreen;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static FileInput indata = new FileInput("the_book.csv");
    private final static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args) {
        String line;
        String[] words;
        Object wordFound;
     //   String[] fields;

        while ((line = indata.fileReadLine()) != null) {
            // Remove anything that's not a letter or space
            line = line.replaceAll("[^a-zA-Z ]","")
                    .toLowerCase().trim();
            // Don't process lines with no characters
            if (line.isEmpty()) {
                continue;
            }
            // Split string over one or more spaces
            words = line.split(" +");
            
            for (String s : words) {
                wordFound = map.get(s);
                if (wordFound == null) {
                    map.put(s, 1);
                }
                else {
                    map.put(s, map.get(s) + 1);
                }

            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
    
}