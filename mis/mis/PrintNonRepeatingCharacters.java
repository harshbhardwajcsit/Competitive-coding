package mis;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 Given an input stream of n characters consisting only of small case alphabets the task is to find the first non repeating character each time a character is inserted to the stream.


 Example
 Flow in stream : a, a, b, c, b
 a goes to stream : 1st non repeating element a (a)
 a goes to stream : no non repeating element -1 (a, a)
 b goes to stream : 1st non repeating element is b (a, a, b)
 c goes to stream : 1st non repeating element is b (a, a, b, c)

 Output: a -1 b b c
 */
public class PrintNonRepeatingCharacters {
    public static void printFirstNonRepeatingCharacters(Character [] characters) {
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();
        Character nonRepeating = characters[0];
        for (Character character : characters) {
            if (!frequencyMap.containsKey(character)) {
                frequencyMap.put(character, 1);
                if (nonRepeating == null) {
                    nonRepeating = character;
                }
            } else {
                frequencyMap.put(character, frequencyMap.get(character) + 1);
                nonRepeating = getNextNonRepeatingCharacter(character, frequencyMap);
            }
            if (nonRepeating == null) {
                System.out.println(-1);
            } else {
                System.out.println(nonRepeating);
            }
        }

    }

    public static Character getNextNonRepeatingCharacter(char key, Map<Character, Integer> map) {
        Character nextNonRepeating = null;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            Character k = e.getKey();
            Integer v = e.getValue();
            if (v == 1) {
                nextNonRepeating = k;
                break;
            }
        }
        return nextNonRepeating;
    }

    public static void main(String[] args) {
        Character [] characters1 = {'a', 'a', 'b', 'c', 'b'};
        Character [] characters2 = {'a', 'a', 'b', 'c', 'b', 'd', 'e', 'c'};
        printFirstNonRepeatingCharacters(characters1);
//      printFirstNonRepeatingCharacters(characters2);
    }
}
