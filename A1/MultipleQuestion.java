import java.util.*;

public class MultipleQuestion extends Question implements IQuestion
{
    public MultipleQuestion( String questionContent, String[] choices )
    {
        this.content = questionContent;
        this.choices = choices;
    }

    public Set<String> AnswerQuestion()
    {
        Set<String> answers = new HashSet<String>();
        for( int index = 0; index < 1 + (int)( Math.random() * choices.length ); ++index )
        {
            answers.add( choices[(int)( Math.random() * choices.length )] );
        }
        return answers;
    }

}
