import java.util.Scanner;

/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
    * Constructs the object.
    */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
            default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(
        final Scanner s, final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (questionCount == 0) {
            System.out.println("Quiz does not have questions");
            return;
        }
        String responses = s.nextLine();
        String[] c = responses.split(":");
        String[] checkQuestion = c[1].split(",");
        int flag = Integer.parseInt(c[2]);
        final int z = 4;
        final int y = 5;
        final int x = 3;
        if (c.length < y) {
            System.out.println("Error! Malformed question");
            return;
        }
        if (c[0].length() == 0) {
            System.out.println("Error! Malformed question");
            return;
        }
        if (c[0].equals(null)) {
            System.out.println("Error! Malformed question");
        }
        int penalty = Integer.parseInt(c[z]);
        if (penalty > 0) {
            System.out.println("Invalid penalty for " + c[0]);
            return;
        }
        int marks = Integer.parseInt(c[x]);
        if (marks < 0) {
            System.out.println("Invalid max marks for " + c[0]);
            return;
        }
        if (checkQuestion.length < z) {
            System.out.println(c[0] + " does not have enough answer choices");
            return;
        }

        if (flag > z) {
            System.out.println(
                "Error! Correct answer choice number is out of range for question text 1");
            return;
        }
        System.out.println(questionCount + " are added to the quiz");
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(
        final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
    }

    /**.
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
    }
}
