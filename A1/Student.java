import java.util.*;

public class Student
{
    private int studentId;
    private Set<String> answer;
    private IQuestion question;

    public Student( int studentId )
    {
        this.studentId = studentId;
    }

    public Set<String> GetAnswer()
    {
        return answer;
    }

    public void AssignQuestion( IQuestion question )
    {
        this.question = question;
    }

    public void Think()
    {
        answer = question.AnswerQuestion();
    }
}
