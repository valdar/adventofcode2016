package it.valdar.adventofcode.day9;

import java.util.function.Function;

/**
 * Created by valdar on 02/12/16.
 */
public class Functions {

    private final static char delimiter = 'x';
    private final static char open = '(';
    private final static char close = ')';

    public static long decompress(String compressString){
        return decompressSize( compressString, s -> new Long(s.length()) );
    }

    public static long decompress2(String compressString) {
        return decompressSize( compressString, function() );
    }

    private static Function<String, Long> function() {
        return s -> decompressSize( s,  function() );
    }

    public static long decompressSize(String compressString, Function<String, Long> evaluateLenght) {
        long size = 0;

        State currentStatus = State.COPYING;
        String compressPart = new String();
        String compressPartLength = new String();
        String compressPartRepetitions = new String();
        int compressPartCount = 0;

        for( char c : compressString.toCharArray() ){
            switch ( currentStatus ){
                case COPYING: {
                    if( c != open ){
                        size++;
                    } else {
                        currentStatus = State.READING_COMPRESS_TAG_LENGTH;
                    }
                    break;
                }
                case READING_COMPRESS_TAG_LENGTH: {
                    if( c != delimiter ){
                        compressPartLength = compressPartLength+c;
                    } else {
                        currentStatus = State.READING_COMPRESS_TAG_TIMES;
                    }
                    break;
                }
                case READING_COMPRESS_TAG_TIMES: {
                    if( c != close ){
                        compressPartRepetitions = compressPartRepetitions+c;
                    } else {
                        compressPartCount = Integer.parseInt( compressPartLength );
                        currentStatus = State.READING_COMPRESS_STRING;
                    }
                    break;
                }
                case READING_COMPRESS_STRING: {
                    if( compressPartCount > 1 ){
                        compressPart = compressPart+c;
                        compressPartCount--;
                    } else {
                        compressPart = compressPart+c;

                        size += ( Integer.parseInt( compressPartRepetitions ) * evaluateLenght.apply( compressPart ) );

                        compressPart = new String();
                        compressPartLength = new String();
                        compressPartRepetitions = new String();
                        compressPartCount = 0;
                        currentStatus = State.COPYING;
                    }
                    break;
                }
            }
        }

        return size;
    }

    private enum State{
        COPYING,
        READING_COMPRESS_TAG_LENGTH,
        READING_COMPRESS_TAG_TIMES,
        READING_COMPRESS_STRING;
    }
}