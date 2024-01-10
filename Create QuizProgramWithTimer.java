import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Quiz {
    private String question;
    private String[] options;
    private int correctOptionIndex;

    public Quiz(String question, String[] options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public boolean answerQuestionWithTimer() {
        QuestionTimer timer = new QuestionTimer();
        Timer questionTimer = new Timer();

        System.out.println(question);
        for (String option : options) {
            System.out.println(option);
        }

        // Timer set to 30 seconds
        questionTimer.schedule(timer, 30000); 

        Scanner scanner = new Scanner(System.in);
        System.out.print("Your Answer (A/B/C/D): ");

        String userAnswer;
        do {
            userAnswer = scanner.nextLine().toUpperCase();
            if (timer.isTimeOut()) {
                // Time's up
                return false; 
            }
        } while (!userAnswer.matches("[A-D]") && !timer.isTimeOut());
        // Cancel the timer
        questionTimer.cancel(); 

        int selectedOptionIndex = userAnswer.charAt(0) - 'A';
        if (selectedOptionIndex == correctOptionIndex) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("Incorrect!");
            return false;
        }
    }

    static class QuestionTimer extends TimerTask {
        private boolean timeOut = false;

        @Override
        public void run() {
            timeOut = true;
            System.out.println("\nTime's up!");
        }

        public boolean isTimeOut() {
            return timeOut;
        }
    }
}

public class QuizProgramWithTimer {
    private static int score = 0;
    private static final Quiz[] quizzes = prepareQuizzes();

    public static void main(String[] args) {
        startQuiz();
        displayResult();
    }

    private static void startQuiz() {
        for (Quiz quiz : quizzes) {
            boolean answered = quiz.answerQuestionWithTimer();
            if (answered) {
                score++;
            }
            System.out.println();
        }
    }

    private static Quiz[] prepareQuizzes() {
        Quiz[] quizzes = {
                new Quiz("Q.1 The term 'Cloud' in cloud-computing refers to.....",
                     new String[]{"A. The Internet", "B. Cumulus Clouds", "C. A Computer", "D. Thin Clients"},
                     0),
            new Quiz("Q.2 Virtual Machines (VMs) are offered in cloud by",
                     new String[]{"A. SaaS", "B. PaaS", "C. Iaas", "D. None of these"},
                     2),
            new Quiz("Q.3 'Cloud' in cloud computing represents What?",
                     new String[]{"A. Wireless", "B. Hard drives", "C. People", "D. Internet"},
                     3),
            new Quiz("Q.4 What widely used service is built on cloud-computing technology?",
                     new String[]{"A. twitter", "B. skype", "C. gmail", "D. all of the above"},
                     3),
            new Quiz("Q.5 Amazon's Elastic Compute Cloud (EC2) is a well known.....",
                     new String[]{"A. Virtual machine", "B. Cloud Storage", "C. PaaS", "D. SoA"},
                     0),
            new Quiz("Q.6 Which of the following is Cloud Platform by Amazon?",
                     new String[]{"A. Azure", "B. AWS", "C. Cloudera", "D. All of the mentioned"},
                     1),
            new Quiz("Q.7 Docker is generally configured to use TCP port .... while managing encrypted traffic.",
                     new String[]{"A. 3306", "B. 53378", "C. 2375", "D. 2376"},
                     3),
            new Quiz("Q.8 To overcome the lag in the operating speeds of the I/O device and processor we use .....",
                     new String[]{"A. buffer spaces", "B. status flags", "C. interrupt signals", "D. exceptions"},
                     0),
            new Quiz("Q.9 What is the typical range of transmission distance in a ZigBee network?",
                     new String[]{"A. 5 m.", "B. 50 m.", "C. 500 m.", "D. 5 km"},
                     2),
            new Quiz("Q.10 Which of the following is not a cloud stakeholder?",
                     new String[]{"A. cloud providers", "B. clients", "C. Service providers", "D. cloud users"},
                     2),
        };
        return quizzes;
    }

    private static void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your final score is: " + score + "/" + quizzes.length);
    }
}
