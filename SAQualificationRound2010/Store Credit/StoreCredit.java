/*

You receive a credit C at a local store and would like to buy two items.
You first walk through the store and create a list L of all available items.
From this list you would like to buy two items that add up to the entire value of the credit.
The solution you provide will consist of the two integers indicating the positions of the items
in your list (smaller number first).

Input

The first line of input gives the number of cases, N. N test cases follow. For each test case there will be:

One line containing the value C, the amount of credit you have at the store.
One line containing the value I, the number of items in the store.
One line containing a space separated list of I integers. Each integer P indicates the price of an item in the store.
Each test case will have exactly one solution.

Output

For each test case, output one line containing "Case #x: " followed by the indices of the two items
whose price adds up to the store credit. The lower index should be output first.

Limits

5 ≤ C ≤ 1000
1 ≤ P ≤ 1000

Small dataset

N = 10
3 ≤ I ≤ 100

Large dataset

N = 50
3 ≤ I ≤ 2000

Sample

Input:
3
100
3
5 75 25
200
7
150 24 79 50 88 345 3
8
8
2 1 9 4 4 56 90 3

Output:
Case #1: 2 3
Case #2: 1 4
Case #3: 4 5

*/

import java.util.*;

class StoreCredit{
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int cases = sc.nextInt();
    int count = 1;

    while(cases>0){
      findPair(sc, cases, count);
      count++;
      cases--;
    }
  }

  public static void findPair(Scanner sc, int cases, int count){
    int target = sc.nextInt();
    int size = sc.nextInt();
    ArrayList<Integer> lst = new ArrayList<Integer>();
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i = 0; i < size; i++){
      int num = sc.nextInt();
      lst.add(num);
      map.put(num, i);
    }
    int diff = target - lst.get(0);
    int index1 = 0, index2 = 0;
    for(int i = 0; i < lst.size(); i++){
      diff = target - lst.get(i);
      if(map.containsKey(diff) && map.get(diff) != i){
        //System.out.println("A: " + lst.get(i));
        index1 = i;
        break;
      }
    }
    for(int i = 0; i < lst.size(); i++){
      if(lst.get(i) == diff && index1 != i){
        index2 = i;
        break;
      }
    }
    index1++;
    index2++;
    System.out.println("Case #" + count + ": " + index1 + " " + index2);
  }
}
