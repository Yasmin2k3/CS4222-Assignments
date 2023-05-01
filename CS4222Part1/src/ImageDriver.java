//Student Name: Yasmin Woodlock
//ID Number: 22336877
public class ImageDriver {

    public static void main(String[] args) {
        //this is used to test if toString works.
        //I would have preferred to use this one - or two - arrays as test cases, but I encountered an issue where
        //if I put this array into two new objects, manipulated one of those objects, that manipulation would persist for
        //the second object.
        //This is due to the Image class assigning its 2d array to the parameter 2d array rather than 'cloning' it
        int[][] grid = {
                {0, 1, 2, 3, 4, 5, 6},
                {10, 11, 12, 13, 14, 15, 16},
                {20, 21, 22, 23, 24, 25, 26},
                {30, 31, 32, 33, 34, 35, 36},
                {40, 41, 42, 43, 44, 45, 46},
                {50, 51, 52, 53, 54, 55, 56}};


        //I don't need System.out.println(__.toString()) because it already overrides the in built toString method.
        Image testToString = new Image(grid);
        System.out.println("Test 1: the inputted values are shown neatly in a grid:");
        System.out.println(testToString);

        System.out.println("Test 2: flip horizontal works:\nInput:");
        testHorizontal();

        System.out.println("Test 3: vertical works:\nInput:");
        testVertical();

        System.out.println("Test 4: rotate clockwise works:\nInput:");
        testClockwise();

        System.out.println("Test 5: rotate anticlockwise works:\nInput:");
        testAntiClockwise();

        System.out.println("Test 6: What happens when an empty array is given:\nInput:");
        testEmptyArray();

        System.out.println("Test 7: What happens when an empty array is asked to be manipulated\nInput:");
        testEmptyArrayManipulation();

        System.out.println("Test 8: Test that the class can represent the cumulative effect of the various manipulations applied to the original image:\nInput:");
        testCumulative();
    }

    //I need to compare output and expected output with every test, so I made this a function. Now I don't have to keep repeating this.
    public static String compareResult(Image expectedResult, Image givenResult) {
        //using this if statement, so we know that the output is exactly what is expected
        if (expectedResult.toString().equals(givenResult.toString())) {
            return "Expected Result:\n" + expectedResult + "\nOutput:\n" + givenResult + "\nWorks\n";
        } else {
            return "Expected Result:\n" + expectedResult + "\nOutput:\n" + givenResult + "\nDoes not work\n";
        }

    }

    //made the tests functions for ease of comprehension. I could have put this all in the main, but I found it easier to understand and
    //see what data we are testing if it is separated.
    //testing to see if the horizontal flip works on its own
    public static void testHorizontal() {
        int[][] input = {
                {0, 1, 2, 3, 4, 5, 6},
                {10, 11, 12, 13, 14, 15, 16},
                {20, 21, 22, 23, 24, 25, 26},
                {30, 31, 32, 33, 34, 35, 36},
                {40, 41, 42, 43, 44, 45, 46},
                {50, 51, 52, 53, 54, 55, 56}};
        int[][] expectedHorizontalFlip = {
                {6, 5, 4, 3, 2, 1, 0},
                {16, 15, 14, 13, 12, 11, 10},
                {26, 25, 24, 23, 22, 21, 20},
                {36, 35, 34, 33, 32, 31, 30},
                {46, 45, 44, 43, 42, 41, 40},
                {56, 55, 54, 53, 52, 51, 50}};

        Image test = new Image(input);
        Image expectedResults = new Image(expectedHorizontalFlip);

        System.out.println(test);
        test.flip(true);
        System.out.println(compareResult(expectedResults, test));
    }

    //testing to see if the vertical flip works on its own
    public static void testVertical() {
        int[][] input = {
                {0, 10, 20, 30, 40, 50},
                {1, 11, 21, 31, 41, 51},
                {2, 12, 22, 32, 42, 52},
                {3, 13, 23, 33, 43, 53},
                {4, 14, 24, 34, 44, 54},
                {5, 15, 25, 35, 45, 55}};
        int[][] expectedVerticalFlip = {
                {5, 15, 25, 35, 45, 55},
                {4, 14, 24, 34, 44, 54},
                {3, 13, 23, 33, 43, 53},
                {2, 12, 22, 32, 42, 52},
                {1, 11, 21, 31, 41, 51},
                {0, 10, 20, 30, 40, 50}};

        Image test = new Image(input);
        Image expectedResults = new Image(expectedVerticalFlip);
        System.out.println(test);
        test.flip(false);
        System.out.println(compareResult(expectedResults, test));
    }

    //testing to see if rotating clockwise works on its own
    public static void testClockwise() {
        int[][] input = {
                {0, 1},
                {10, 11},
                {20, 21},
                {30, 31},
                {40, 41},
                {50, 51}};
        int[][] expectedClockwise = {
                {50, 40, 30, 20, 10, 0},
                {51, 41, 31, 21, 11, 1}};

        Image test = new Image(input);
        Image expectedResults = new Image(expectedClockwise);
        System.out.println(test);
        test.rotate(true);
        System.out.println(compareResult(expectedResults, test));
    }

    //testing to see of rotating anticlockwise works on its own
    public static void testAntiClockwise() {
        int[][] input = {
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                {10, 11, 12, 13, 14, 15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
                {30, 31, 32, 33, 34, 35, 36, 37, 38, 39},
                {40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
                {50, 51, 52, 53, 54, 55, 56, 57, 58, 59}};
        int[][] expectedAnti = {
                {9, 19, 29, 39, 49, 59},
                {8, 18, 28, 38, 48, 58},
                {7, 17, 27, 37, 47, 57},
                {6, 16, 26, 36, 46, 56},
                {5, 15, 25, 35, 45, 55},
                {4, 14, 24, 34, 44, 54},
                {3, 13, 23, 33, 43, 53},
                {2, 12, 22, 32, 42, 52},
                {1, 11, 21, 31, 41, 51},
                {0, 10, 20, 30, 40, 50}};

        Image test = new Image(input);
        Image expectedResults = new Image(expectedAnti);
        System.out.println(test);
        test.rotate(false);
        System.out.println(compareResult(expectedResults, test));
    }

    //testing to see what happens when the program is given empty arrays
    public static void testEmptyArray() {
        int[][] input = {{}};
        String expectedOutput = "";

        Image test = new Image(input);
        System.out.println(test);
        System.out.println("Expected Output:\n" + expectedOutput);
        //put an if statement here because it didn't fit the parameters of my method, as I needed to compare a string, not two Images
        if (expectedOutput.equals(test.toString())) {
            System.out.println("Works\n");
        } else {
            System.out.println("Does not work\n");
        }
    }

    //testing to see what happens when an empty array is asked to be manipulated
    public static void testEmptyArrayManipulation() {
        int[][] input = {{}};
        String expectedOutput = "";

        Image test = new Image(input);
        System.out.println(test);
        System.out.println("Expected Output:\n" + expectedOutput);
        test.flip(true);
        //put an if statement here because it didn't fit the parameters of my method, as I needed to compare a string, not two Images
        if (expectedOutput.equals(test.toString())) {
            System.out.println("Works\n");
        } else {
            System.out.println("Does not work\n");
        }
    }

    //testing to see if the program can handle multiple manipulations
    public static void testCumulative() {
        //with this test, I am going to rotate anticlockwise and flip the image vertically
        //if the outcome is as expected, this shows that the methods can handle multiple manipulations
        int[][] input = {
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                {10, 11, 12, 13, 14, 15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
                {30, 31, 32, 33, 34, 35, 36, 37, 38, 39},
                {40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
                {50, 51, 52, 53, 54, 55, 56, 57, 58, 59}};
        int[][] expectedCumulative = {
                {0, 10, 20, 30, 40, 50},
                {1, 11, 21, 31, 41, 51},
                {2, 12, 22, 32, 42, 52},
                {3, 13, 23, 33, 43, 53},
                {4, 14, 24, 34, 44, 54},
                {5, 15, 25, 35, 45, 55},
                {6, 16, 26, 36, 46, 56},
                {7, 17, 27, 37, 47, 57},
                {8, 18, 28, 38, 48, 58},
                {9, 19, 29, 39, 49, 59}};

        Image test = new Image(input);
        Image expectedResults = new Image(expectedCumulative);
        System.out.println(test);
        test.rotate(false);
        test.flip(false);
        System.out.println(compareResult(expectedResults, test));
    }
}
