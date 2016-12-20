package it.valdar.adventofcode.day7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by valdar on 02/12/16.
 */
public class Functions {

    private final static char empty = ' ';
    private final static char open = '[';
    private final static char close = ']';

    public static boolean parse(String input) {
        char one = empty;
        char two = empty;
        char three = empty;
        char four = empty;
        int brakets = 0;

        boolean temporaryFound = false;
        boolean abbaFound = false;
        boolean abbaFoundInBrakets = false;

        for( char c : input.toCharArray() ){
            if ( c == open ){
                brakets++;
                one = empty;
                two = empty;
                three = empty;
                four = empty;
            } else if ( c == close && temporaryFound && brakets > 0){
                brakets--;
                abbaFoundInBrakets = true;
                temporaryFound = false;
                one = empty;
                two = empty;
                three = empty;
                four = empty;
            } else if ( c == close && brakets > 0 ){
                brakets--;
                one = empty;
                two = empty;
                three = empty;
                four = empty;
            } else if( one == empty ){
                one = c;
            } else if ( two == empty && c != one){
                two = c;
            } else if (three == empty && c == two){
                three = c;
            } else if (three == empty && c != two){
                one = two;
                two = c;
            } else if( four == empty && c != one && c == three){
                three = empty;
                two  = empty;
                one = c;
            } else if ( four == empty && c != one ) {
                one = three;
                two = c;
                three = empty;
            } else if( four == empty && c == one && brakets == 0 ){
                abbaFound = true;
                one = empty;
                two = empty;
                three = empty;
            } else if( four == empty && c == one && brakets > 0 ){
                temporaryFound = true;
                one = empty;
                two = empty;
                three = empty;
            }

        }

        if( temporaryFound ){
            abbaFound = true;
        }

        return abbaFoundInBrakets ? false : abbaFound;
    }

    public static boolean parse2(String input) {
        char one = empty;
        char two = empty;
        char three = empty;
        int brakets = 0;

        Set<String> temporaryFound = new HashSet<>();
        Set<String> abaFound = new HashSet<>();
        Set<String> abaFoundInBrakets = new HashSet<>();

        for( char c : input.toCharArray() ){
            if ( c == open ){
                brakets++;
                one = empty;
                two = empty;
                three = empty;
            } else if ( c == close && brakets > 0 ){
                brakets--;
                one = empty;
                two = empty;
                three = empty;
                abaFoundInBrakets.addAll( temporaryFound );
                temporaryFound = new HashSet<>();
            } else if( one == empty ){
                one = c;
            } else if ( two == empty && c != one){
                two = c;
            } else if ( two == empty && c == one){
                one = c;
            } else if( three == empty && c != one && c == two){
                one = c;
                two = empty;
            } else if( three == empty && c != one && c != two){
                one = two;
                two = c;
            } else if( three == empty && c == one && brakets == 0 ){
                char[] aba = {one, two, c};
                abaFound.add( new String( aba ) );
                one = two;
                two = c;
            } else if( three == empty && c == one && brakets > 0 ){
                char[] aba = {one, two, c};
                temporaryFound.add( new String( aba ) );
                one = two;
                two = c;
            }

        }

        abaFound.addAll( temporaryFound );

        return supportSSL( abaFound, abaFoundInBrakets );
    }

    private static boolean supportSSL( Set<String> aba, Set<String> abaInBrackets){
        for( String currAba : aba){
            if( abaInBrackets.contains( fromAbaToBab(currAba) ) ){
                return true;
            }
        }

        return false;
    }

    private static String fromAbaToBab(String input){
        if(input.length()!=3){
            throw new RuntimeException( "Aba strings must be of size 3!!!" );
        }

        if(input.charAt(0) != input.charAt(2) || input.charAt(0) == input.charAt(1) || input.charAt(2) == input.charAt(1) ){
            throw new RuntimeException( "Aba strings ["+input+"] must be of the form ABA!!!" );
        }


        char[] bab = {input.charAt(1), input.charAt(0), input.charAt(1)};

        return new String(bab);
    }

}