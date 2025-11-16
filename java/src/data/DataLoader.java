package data;

import java.util.List;

/*Base data loader interface for loading data
* from text files*/
public interface DataLoader<T> {
    /*Method for loading data from text files
    * resourcePath: file path of text file
    * returns: list of a given type of data*/
    List<T> load(String resourcePath);
}
