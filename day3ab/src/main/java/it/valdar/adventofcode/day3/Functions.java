package it.valdar.adventofcode.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by valdar on 02/12/16.
 */
public class Functions {

    public static long countPossibleTrianglesByRow(Stream<String> stream) {
        return
                stream.map( String::trim ).map( s -> {
                    String[] chunks = s.split("  ");
                    Integer[] edges = Arrays.stream( chunks )
                            .map(String::trim)
                            .filter( str -> !str.equals("")  )
                            .map(s1 -> Integer.parseInt(s1) )
                            .toArray( size -> new Integer[size] );
                    return edges[0]+edges[1] > edges[2] &&  edges[0]+edges[2] > edges[1] && edges[1]+edges[2] > edges[0];
                } ).filter( b -> b  ).count();
    }

    public static long countPossibleTrianglesByColumn(Stream<String> stream) {
        Integer[] numberByRow =
                stream.map( String::trim ).flatMap( s ->
                        Arrays.stream( s.split("  ") )
                                .map(String::trim)
                                .filter( str -> !str.equals("")  )
                                .map(s1 -> Integer.parseInt(s1) )
                ).toArray( size -> new Integer[size] );

        Map<Integer,List<Integer>> columnMapping =  IntStream.range(0, numberByRow.length).boxed().collect( Collectors.groupingBy(i -> (i % 3) )  ) ;

        List<Integer> numberByColumn = new ArrayList<>();
        for( Integer currKey : columnMapping.keySet() ){
            numberByColumn.addAll( columnMapping.get(currKey) );
        }

        Integer[] trinagle = new Integer[3];
        int counter = 0;
        int result = 0;
        for( Integer currIndex : numberByColumn ){
            Integer type = counter;
            if ( type == 0 ){
                trinagle[0]=numberByRow[currIndex];
                counter = 1;
            } else if ( type == 1 ) {
                trinagle[1]=numberByRow[currIndex];
                counter = 2;
            } else if ( type == 2 ) {
                trinagle[2]=numberByRow[currIndex];
                counter = 0;
                if(trinagle[0]+trinagle[1] > trinagle[2]
                        &&  trinagle[0]+trinagle[2] > trinagle[1]
                        && trinagle[1]+trinagle[2] > trinagle[0]){
                    result++;
                }
            } else {
                throw new RuntimeException( "Urecognized case!!!" );
            }
        }

        return result;
    }

}