package studio8;

import java.util.HashSet;
import java.util.Set;

public class SelectAllQuestion extends MultipleChoiceQuestion {

    private Set<Character> correctAnswers;

    public SelectAllQuestion(String prompt, String answer, String[] choices) {
        // Assuming the MultipleChoiceQuestion constructor requires an additional choices parameter
        super(prompt, answer, choices.length, choices); // Points equal to the number of correct choices
        this.correctAnswers = new HashSet<>();
        for (char ch : answer.toCharArray()) {
            correctAnswers.add(ch);
        }
    }
    
    @Override
    public int checkAnswer(String givenAnswer) {
        int score = 0;
        for (char ch : givenAnswer.toCharArray()) {
            if (correctAnswers.contains(ch)) {
                score++;
            }
        }
        return score;
    }
    
    public static void main(String[] args) {
        String[] choices = {"instance variables", "git", "methods", "eclipse"};
        Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:", "13", choices);
        selectAll.displayPrompt();
        System.out.println(selectAll.checkAnswer("hi")); //no credit
        System.out.println(selectAll.checkAnswer("13")); //full credit
        System.out.println(selectAll.checkAnswer("31")); //full credit
        System.out.println(selectAll.checkAnswer("1")); //1 point
        System.out.println(selectAll.checkAnswer("3")); //1 point
        System.out.println(selectAll.checkAnswer("23")); //1 point
        System.out.println(selectAll.checkAnswer("34")); //1 point
        System.out.println(selectAll.checkAnswer("4")); //0 points
        System.out.println(selectAll.checkAnswer("124")); //1 point
        System.out.println(selectAll.checkAnswer("24")); //0 points
    }
}
