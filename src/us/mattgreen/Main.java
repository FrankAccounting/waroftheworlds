package us.mattgreen;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

	

public class Main {
    private FileInput indata = new FileInput("the_book.csv");
    private Map<String, Integer> map = new HashMap<String, Integer>();
    private Map<String, Integer> unqmap = new HashMap<String, Integer>();
    private Map<String, Integer> tenmap = new TreeMap<String, Integer>();
    Set<Word> wordset = new TreeSet<>();
    List<Word> toplist = new ArrayList<Word>();
    public static void main(String[] args) {
        new Main();
    }
    
    Word word = new Word(); 
    public Main() {
        String line;
        String[] words;
        
        
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
            
            // Look for each word in the map
            for (String word : words) {
                // This word isn't yet a key, init count to 1
                if (!map.containsKey(word)) {
                    map.put(word, 1);
                    
                    
                    
                    
                }
                else {
                    // Increment count using word as key
                    map.put(word, map.get(word) + 1);

                }
                
            }

            
            // Loop over entries in the map, getting each key/value pair
            
                        
            
            for(Entry<String, Integer> map : map.entrySet()) {
                Word word = new Word(); 
            	
            //for each entry in keyMap, look at the set
                String key = map.getKey();
            //define a string of the value to work with.. makes sense 
                Integer value = map.getValue(); 
                word.setWordString(key);
                word.setNumber(value);
                toplist.add(word); 
                
            //define a value of the int to work with....
                if (value == 1) {
            //if value is one
                	unqmap.put(key, value);
            //put the current value into a new map
                	unqmap.size();
                }
                
           }  
            

        }
       


        
        Set<String> keys = map.keySet(); // The set of keys in the map.

        Collection<Integer> list = map.values();
        for(Iterator<Integer> itr = list.iterator(); itr.hasNext();)
        {
            if(Collections.frequency(list, itr.next())>1)
            {
                itr.remove();
            }
        }
        
        
        System.out.println(list);

    
        
        
        
        
        
        
        Collections.sort(toplist);
        System.out.println("ArrayList in descending order:");
      for(Word num: toplist){
    	  int sortKey = num.number;
    	  String sortString= num.wordString;   
    	  
      }
      
      wordset.addAll(toplist);
  

      


      System.out.println();
    	System.out.println("number of unqiue words " + unqmap.size());

    }
	private Map<Integer, String> createMap() {
		// TODO Auto-generated method stub
		return null;
	}

	  
   
}

