import java.util.*;
import java.io.*;
import java.io.File;
import java.nio.charset.Charset; 
import java.nio.file.Files;
import java.util.stream.Collectors;
public class Words
{
     private static List<String> eng_words = Arrays.asList("row", "ring", "know", "work","king", "else", "dream","kreeg",
                                            "son","sun","bon","bus","sub","buns","bread","cat","drum","prize");


    private static List<String> eng_words = list.stream().map( s -> s.toLowerCase() ).filter( s->s.chars().allMatch(Character::isLetter)).collect( Collectors.toList() );
    
    public static void main( String[] args ) throws IOException
    {

        // System.out.println( "Read " + lowercase.size() + " words" );

        findOptions( "working" );
    }

    private static void findOptions( String string )
    {
         
        
        int[] freq = toFreq( string );
        for ( String l : lowercase )
        {
            int[] freqIn = toFreq( l );
            if ( isEnglishWord( freq, freqIn ) )
            {
                System.out.println( l );
            }
        }
    }

    // private static boolean isEnglishWord(String str)
    // {
    //     return matches( freq, freqIn );
    // }
    /**
     * Returns true if all the frequencies of the letters match.
     * 
     * @param freq
     * @param freqIn
     * @return
     */
    private static boolean isEnglishWord( int[] freq, int[] freqIn )
    {
        for ( int i = 0; i < 26; i++ )
        {
            if ( freq[i] == 0 && freqIn[i]>0)
            {
                return false;
            }
            else if (freq[i] < freqIn[i])
            {
                return false;
            }

        }
        return true;
    }

    /**
     * Encode a word in to a freqceny array. int[0] = #a's, int[1] = #b's etc.
     * 
     * @param string
     * @return
     */
    private static int[] toFreq( String string )
    {
        int[] freq = new int[26];
        for ( char c : string.toCharArray() )
        {
            if ( ( c - 'a' ) >= 0 && ( c - 'a' ) < 26 )
            {
                freq[c - 'a']++;
            }
        }
        return freq;
    }
}
