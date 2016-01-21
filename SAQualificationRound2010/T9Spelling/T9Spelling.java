/*

The Latin alphabet contains 26 characters and telephones only have ten
digits on the keypad. We would like to make it easier to write a message to
your friend using a sequence of keypresses to indicate the desired characters.
The letters are mapped onto the digits as shown below. To insert the character
B for instance, the program would press 22. In order to insert two characters
in sequence from the same key, the user must pause before pressing the key a
second time. The space character ' ' should be printed to indicate a pause.
For example, 2 2 indicates AA whereas 22 indicates B.

Input

The first line of input gives the number of cases, N. N test cases follow.
Each case is a line of text formatted as

    desired_message

Each message will consist of only lowercase characters a-z and space characters
 ' '. Pressing zero emits a space.

Output

For each test case, output one line containing "Case #x: " followed by the
message translated into the sequence of keypresses.

Limits

1 ≤ N ≤ 100.

Small dataset
1 ≤ length of message in characters ≤ 15.

Large dataset
1 ≤ length of message in characters ≤ 1000.

Sample

Input:
4
hi
yes
foo  bar
hello world

Output:
Case #1: 44 444
Case #2: 999337777
Case #3: 333666 6660 022 2777
Case #4: 4433555 555666096667775553

*/


import java.util.*;

class T9Spelling{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int tests = sc.nextInt();
    sc.nextLine();

    genKeyPresses(sc, tests);

  }

  public static void genKeyPresses(Scanner sc, int cases){

    int count = 1;
    HashMap<Character, String> map = new HashMap<Character, String>();
    map.put(' ', "0");
    map.put('a', "2");
    map.put('b', "22");
    map.put('c', "222");
    map.put('d', "3");
    map.put('e', "33");
    map.put('f', "333");
    map.put('g', "4");
    map.put('h', "44");
    map.put('i', "444");
    map.put('j', "5");
    map.put('k', "55");
    map.put('l', "555");
    map.put('m', "6");
    map.put('n', "66");
    map.put('o', "666");
    map.put('p', "7");
    map.put('q', "77");
    map.put('r', "777");
    map.put('s', "7777");
    map.put('t', "8");
    map.put('u', "88");
    map.put('v', "888");
    map.put('w', "9");
    map.put('x', "99");
    map.put('y', "999");
    map.put('z', "9999");

    while(cases > 0){
      String str = sc.nextLine();
      String res = new String();
      for(int i = 0; i < str.length(); i++){
        char c = str.charAt(i);
        String val = map.get(c);
        if(res.length() != 0 && res.charAt(res.length()-1) == val.charAt(0)){
          res = res.concat(" ");
        }
        res = res.concat(val);
      }
      System.out.println("Case #" + count + ": " + res);
      cases--;
      count++;
    }

  }
}
