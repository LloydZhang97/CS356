import java.util.*;

public class SingleQuestion extends Question implements IQuestion
{
    public SingleQuestion( String questionContent, String[] choices )
    {
        this.content = questionContent;
        this.choices = choices;
    }

    public Set<String> AnswerQuestion()
    {
        Set<String> answers = new HashSet<String>();
        answers.add( choices[(int)( Math.random() * choices.length )] );
        return answers;
    }

}
