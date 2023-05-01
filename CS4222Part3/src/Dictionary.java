//Student Name: Yasmin Woodlock
//Student ID: 22336877

import java.io.*;
import java.util.*;

public class Dictionary {
    ArrayList<String> words;
    int shortest;
    int longest;

    public Dictionary(String filepath, int shortest, int longest){
        try{
            this.words = new ArrayList<>();
            this.shortest = shortest;
            this.longest = longest;

            String[] wordList;

            File f = new File(filepath);
            Scanner inputFile = new Scanner(f);

            while (inputFile.hasNext()){
                wordList = inputFile.next().split(",");

                for (String word : wordList){
                    word = cleanWord(word);  //putting this here to use in the comparisons and to add the word.
                    if (validWord(word)) {
                        words.add(word);
                    }
                }

            }

            Collections.sort(words);

        }catch(FileNotFoundException e){
            System.out.println("File does not exist: " + e.getMessage());
        }

    }

    public boolean add(String word){
        //putting this here to use in the comparisons and to add the word.
        String cleanedWord = cleanWord(word);

        if (validWord(cleanedWord)) {

            int wordIndex = (Collections.binarySearch(words, cleanedWord.toUpperCase())) * -1;
            words.add(wordIndex, cleanedWord);
            return true;
        }

        return false;
    }

    public String nextWord(){
        if (!words.isEmpty()){
            return(words.get((int)(Math.random() * words.size())));
        }else{
            return "";
        }
    }

    public boolean inDictionary(String word){
        return (words.contains(word.toUpperCase()));
    }

    private boolean inRange(String word){
        return (word.length() >= shortest && word.length() <= longest);
    }

    private String cleanWord(String word){
        return word.trim().toUpperCase();
    }

    private boolean validWord(String word){return (inRange(word) && !inDictionary(word));}
}