//Student Name: Yasmin Woodlock
//Student ID: 22336877

import java.util.*;
import java.io.*;

/*
 * This program reads applicant grades from a CSV (Comma Separated Values) file and calculates
 * each applicant's points total. To use the program you need to specify the CSV filename and the
 * cutoff value. Use the following format
 *
 *             ApplicantAnalysis filepath cutoff
 *
 * If the filepath contains spaces then enclose it in quotation marks (e.g. "The filename has spaces.CSV").
 */
public class ApplicantAnalysis {
    public static void main(String[] args) {
        if(args.length == 2) {
            // File containing applicant information
            String filePath = args[0];
            // Course points cutoff
            int cutoff = Integer.parseInt(args[1]);
            // TreeMap stores the applicant Number and associated points total (i.e. ID ---> Points)
            TreeMap<String,Integer> candidateScores = calculateApplicantScores(filePath);
            if(candidateScores != null) {
                // LinkedList stores a list of applicantNumbers containing the applicants with Points >= cutoff
                LinkedList<String> chosenApplicants = select(candidateScores,cutoff);
                // Uses LinkedList toString method to display list of successful applicantNumbers
                if(chosenApplicants != null) {
                    System.out.println(chosenApplicants);
                    String expectedOutput = "[21219388, 21236556, 21270186, 21321912, 21483698, 21497189, 21745566, 21767774, 21803928, 21905621, 21942586]";
                    if(chosenApplicants.toString().compareTo(expectedOutput) != 0) {
                        System.out.println("Output is NOT correct");
                    }
                } else {
                    System.out.println("There are no applicants with sufficient points for the course!");
                }
            } else {
                System.out.println("There are no applicants for the course!");
            }
        } else {
            // Program command line is incorrect
            System.out.println("Command Line format error.");
            System.out.println("Use 'ApplicantAnalysis filepath cutoff'");
            System.out.println("For example - ApplicantAnalysis LM999.CSV 390'");
        }
    }

    public static TreeMap<String,Integer> calculateApplicantScores(String filePath) {
        try {
            // Create a File object to access the file
            File fileHandle = new File(filePath);
            // Create an instance of the Scanner to actually read the file
            Scanner csvFile = new Scanner(fileHandle);
            // TreeMap stores the applicant applicantNumber and associated points total (i.e. ID ---> Points)
            TreeMap<String,Integer> candidates = new TreeMap<>();
            // Read through the CSV file of Applicant Numbers and  LCE grades  
            // and calculate the applicant points scores

            while(csvFile.hasNext()){
                // Read the next applicant data line (applicantNumber followed by grades - comma separated)
                String applicantDetails = csvFile.nextLine();
                // Find end of applicant Number (i.e. first comma)
                int posFirstComma = applicantDetails.indexOf(",");
                // Extract the applicant Exam Number
                String applicantID = applicantDetails.substring(0,posFirstComma);
                // Extract the part of the CSV line that contains the grades (i.e. from position after first comma)
                String applicantGrades = applicantDetails.substring(posFirstComma+1);
                // Use String split operation to create array from grades
                String[] grades = applicantGrades.split(",");
                // For testing purposes we might want to display the data
                System.out.printf("\n%s Start Applicant %s %s \n","-".repeat(25),applicantID,"-".repeat(25));
                System.out.printf("\nApplicant Grades : %s\n",applicantGrades);
                // Use the "pointsScore" method to calculate the applicants points total
                int applicantScore = pointsScore(grades);
                System.out.printf("\nApplicant Score : %d\n",applicantScore);
                // add the applicantNumber and points score to the TreeMap
                candidates.put(applicantID,applicantScore);
                System.out.printf("%s End Applicant %s %s \n","-".repeat(25),applicantID,"-".repeat(25));
            }
            // Return the TreeMap
            return candidates;
        } catch (IOException e) {
            // If there is some problem with the file we just report it
            System.out.printf("Cannot access the file named '%s'!\n",filePath);
            return null;
        }
    }

    public static LinkedList<String> select(TreeMap<String, Integer> candidateScores, int cutoff){
        LinkedList<String> applicantAccept = new LinkedList<>();

        for (Map.Entry<String, Integer> applicant : candidateScores.entrySet()){
            if (applicant.getValue() >= cutoff){
                applicantAccept.add(applicant.getKey());
            }
        }

        if (applicantAccept.size() == 0){
            return null;
        }
        else{
            return applicantAccept;
        }
    }

    //I put this in to its own method for ease of clarity, and so I wouldn't need to keep generating the same Hashmap
    static HashMap<String, Integer> gradeScores = genGradeScores();
    private static HashMap<String, Integer> genGradeScores(){
        HashMap<String, Integer> getGrades = new HashMap<>();

        getGrades.put("H1", 100);
        getGrades.put("H2", 88);
        getGrades.put("H3", 77);
        getGrades.put("H4", 66);
        getGrades.put("H5", 56);
        getGrades.put("H6", 46);
        getGrades.put("H7", 37);
        getGrades.put("H8", 0);

        getGrades.put("O1", 56);
        getGrades.put("O2", 46);
        getGrades.put("O3", 37);
        getGrades.put("O4", 28);
        getGrades.put("O5", 20);
        getGrades.put("O6", 12);
        getGrades.put("O7", 0);
        getGrades.put("O8", 0);

        //blanks give a score of 0. This will also sort the blanks to be last in the array.
        //This accepts a situation if someone got 4 grades, 2 blank entries is still valid, but having only 4 entries is invalid.
        getGrades.put("", 0);

        return getGrades;
    }

    public static int pointsScore(String[] subjectGrades){
        int score = 0;
        //In this case, I am assuming that the input data will have at least 6 entries on each line.

        try {
            /*this sorts the given list based on the points assigned to the grade. I have done this with a lambda expression, however I could have also done this with:

            Arrays.sort(subjectGrades, new Comparator<String>() {
                public int compare(String a, String b) {
                    return gradeScores.get(b)-gradeScores.get(a);
                }
            });*/

            Arrays.sort(subjectGrades, (a, b) -> {
                return gradeScores.get(b) - gradeScores.get(a);
            });

            for (int count = 0; count < 6; count++) {
                score += gradeScores.get(subjectGrades[count]);
            }
        } catch (NullPointerException e) {
            System.out.println("One of the grades in not inputted correctly: " + e.getMessage());

            //This is so you can be aware that this failed. (I don't make it 0, because it is possible for someone to get a 0 score, and then this applicant would get overlooked)
            score = -1;
        }


        return score;
    }
}