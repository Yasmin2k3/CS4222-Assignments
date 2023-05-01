//Student Name: Yasmin Woodlock
//Student ID: 22336877

public class DictionaryDriver {
    public static void main(String[] args){
        System.out.println("Testing the dictionary with the given arguments:\n");
        if (args.length != 3){
            System.out.println("invalid input. Please enter the file path, the minimum number and maximum number for the size of words you would like to add.");
        } else{
            //these were required to be initialised
            String testFilePath = args[0];
            int min;
            int max;
            try{
                min = Integer.parseInt(args[1]);
            } catch (NumberFormatException ex){
                System.out.println("Invalid input for minimum: " + ex.getMessage());
                return;
            }
            try{
                max = Integer.parseInt(args[2]);
            } catch (NumberFormatException ex){
                System.out.println("Invalid input for maximum: " + ex.getMessage());
                return;
            }

            testFileFail();

            System.out.println();

            testAdd(testFilePath, min, max);

            System.out.println();

            testInDictionary(testFilePath, min, max);

            System.out.println();

            testNextWord(testFilePath, min, max);
        }
    }

    private static void testFileFail(){
        System.out.println("Testing that an error is printed when given an invalid file name.");
        System.out.println("Expected Result: An error is thrown");
        System.out.print("Output: ");
        new Dictionary("False.abc", 1, 2);
    }

    private static void testAdd(String filepath, int min, int max){
        Dictionary f = new Dictionary(filepath, min, max);

        System.out.println("Adding the string 'Bigger          ' to the dictionary.");
        System.out.println("Expected Result: true if bigger is within the minimum and maximum parameters. If it isn't is should return false.");
        System.out.printf("Output: %s\n", f.add("Bigger          "));
        System.out.printf("Ensuring 'bigger' is in the dictionary: %s\n", f.inDictionary("BIgger"));
    }

    private static void testInDictionary(String filepath, int min, int max){
        Dictionary f = new Dictionary(filepath, min, max);

        System.out.println("Expected results: fire will be in the dictionary, flabbergasted will not. This is case insensitive.");
        System.out.printf("is fire (put as fiRe) in the dictionary: %s\n", f.inDictionary("fiRe"));
        System.out.printf("is flabbergasted (put as flabBErgasTed) in the dictionary: %s\n", f.inDictionary("flabBErgasTed"));
    }

    private static void testNextWord(String filepath, int min, int max){
        Dictionary f = new Dictionary(filepath, min, max);

        System.out.printf("Expected Result: A capitalised word with length of %s to %s will be outputted\n", min, max);
        System.out.printf("Output: %s\n", f.nextWord());
    }
}