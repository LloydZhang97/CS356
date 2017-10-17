import java.util.*;

public interface IQuestion{

    public String GetContent();

    public String[] GetChoices();

    public Set<String> AnswerQuestion();

}
