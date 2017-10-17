import java.util.*;
import java.io.*;

public class SimulationDriver{

    public static void main( String[] args )
    {
        System.out.println( "Welcome to the IVoter Simulation!" );

        ArrayList<IQuestion> test = new ArrayList<IQuestion>();
        Map<Integer,Student> roster = new HashMap<Integer,Student>();

        System.out.println( "Loading question(s) from file...");
        try
        {
            FileReader fileReader = new FileReader( "questions.txt" );
            BufferedReader in = new BufferedReader( fileReader );
            String inputLine = "";
            while( true )
            {
                inputLine = in.readLine();
                if( inputLine == null )
                {
                    break;
                }
                if( inputLine.charAt(0) == '#' )
                {
                    continue;
                }
                String questionType = "";
                String questionContent = "";
                String[] questionAnswers = {};
                if( inputLine.equals( "question") )
                {
                    inputLine = in.readLine();
                    questionType = inputLine.split(":")[1];
                    inputLine = in.readLine();
                    questionContent = inputLine.split(":")[1];
                    inputLine = in.readLine();
                    questionAnswers = inputLine.split(":")[1].split(",");
                }

                IQuestion question;
                if( questionType.equals( "single" ) )
                {
                    question = new SingleQuestion( questionContent, questionAnswers );
                }
                else if( questionType.equals( "multiple" ) )
                {
                    question = new MultipleQuestion( questionContent, questionAnswers );
                }
                else
                {
                    throw new Exception( "[Simulation Driver] Unknown question type encountered" );
                }
                test.add( question );
            }
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }

        System.out.println( "Questions loaded... Creating students..." );
        int numOfStudents = 30 + (int)( Math.random() * 90 );
        for( int index = 0; index < numOfStudents; ++index )
        {
            Integer studentId = 100000 + (int)( Math.random() * 899999 );
            Student student = new Student( studentId );
            roster.put( studentId, student );
        }

        System.out.printf( "%d Students created... Loading IVoteService...\n", numOfStudents );
        IVoteService iVoteService = new IVoteService();

        System.out.println( "Finished Loading IVoteService service..." );
        for( IQuestion question : test )
        {
            System.out.printf( "\nStudents are now answering question: %s\n", question.GetContent() );
            iVoteService.AssignQuestion( question.GetContent() );
            for( Map.Entry<Integer, Student> entry : roster.entrySet() )
            {
                entry.getValue().AssignQuestion( question );
                for( int index = 0; index < 1 + ( Math.random() * 3 ); ++index )
                {
                    entry.getValue().Think();
                    iVoteService.AddAnswerForStudent( entry.getValue().GetAnswer(), entry.getKey() );
                }
            }
            System.out.println( "Students have finished answering the questions...");
            iVoteService.GetResults();
        }
    }

}
