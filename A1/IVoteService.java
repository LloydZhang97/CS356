import java.util.*;

public class IVoteService
{
    private Map<Integer,Set<String>> roster = new HashMap<Integer,Set<String>>();
    private String question;

    public IVoteService()
    {
    }

    public void Initialize()
    {
        //load question
    }

    public void Start()
    {

    }

    /**
    *  Method to assign question to be asked by IVoteService
    */
    public void AssignQuestion( String question )
    {
        this.question = question;
    }

    public void AddAnswerForStudent( Set<String> answer, int studentId )
    {
        roster.put( studentId, answer );
    }

    public void GetResults()
    {
        Map<String, Integer> results = new HashMap<String, Integer>();
        for( Map.Entry<Integer, Set<String>> entry : roster.entrySet() )
        {
            Set<String> studentAnswers = entry.getValue();
            for( String answer: studentAnswers )
            {
                if( results.get( answer ) == null )
                {
                    results.put( answer, 1 );
                }
                else
                {
                    results.put( answer, (Integer)( (int)results.get( answer ) + 1 ) );
                }
            }
        }
        System.out.println( "Results tabulated... Drumroll please...\n" );
        System.out.println( question );
        Set<String> outputs = new TreeSet<String>();
        for( Map.Entry<String, Integer> entry : results.entrySet() )
        {
            outputs.add( "\t" + entry.getKey() + ": "+ entry.getValue() + "\n" );
        }
        for( String output: outputs )
        {
            System.out.print( output );
        }
    }
}
