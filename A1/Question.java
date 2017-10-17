import java.util.*;

public class Question implements IQuestion
{
    protected String content;
    protected String[] choices;

    public String GetContent()
    {
        return content;
    }

    public String[] GetChoices()
    {
        return choices;
    }

    public Set<String> AnswerQuestion()
    {
        return null;
    }
}
