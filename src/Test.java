import java.io.Serializable;
import java.util.ArrayList;

public class Test implements Serializable {
    private String name;
    private ArrayList<Question> questions = new ArrayList<Question>();
    public Test(String name) {this.name = name;}
    public void addQuestion(Question question) {questions.add(question);}
    public String getName() {return name;}
    public ArrayList getQuestions() {return questions;}
}
