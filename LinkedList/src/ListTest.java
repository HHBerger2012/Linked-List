import java.util.*;

public class ListTest
{
    public static void main(String[] args)
    {
        MyLinkedList<String> list0 = new MyLinkedList<String>();
        MyLinkedList<String> list1 = new MyLinkedList<String>();
        MyLinkedList<String> list2 = new MyLinkedList<String>();
        
        list1.addFirst("node1");
        System.out.println("1-element list: " + list1);
        list2.addFirst("node2"); list2.addFirst("node1");
        System.out.println("2-element list: " + list2);
        
        System.out.println("\nTesting getFirst...");
        System.out.println(list0.getFirst());
        System.out.println(list1.size() + " " + list1);
        System.out.println(list1.getFirst().equals("node1")?"PASSED":"**FAILED**");
        System.out.println(list2.size() + " " + list2);
        System.out.println(list2.getFirst().equals("node1")?"PASSED":"**FAILED**");
        
        System.out.println("\nTesting getLast...");
        System.out.println(list0.getLast());
        System.out.println(list1.size() + " " + list1);
        System.out.println(list1.getLast().equals("node1")?"PASSED":"**FAILED**");
        System.out.println(list1.size() + " " + list1);
        System.out.println(list2.size() + " " + list2);
        System.out.println(list2.getLast().equals("node2")?"PASSED":"**FAILED**");
        System.out.println(list2.size() + " " + list2);
      
        System.out.println("\nTesting add...");
        MyLinkedList<String> list3 = new MyLinkedList<String>();
        MyLinkedList<String> list4 = new MyLinkedList<String>();
        list3.add("node1"); list3.add("node2"); list3.add("node3");
        System.out.println("3-element list: " + list3);
        list4.add("node1"); list4.add("node2"); list4.add("node3"); list4.add("node4");
        System.out.println("4-element list: " + list4);
        
        
        System.out.println("\nTesting set...");
        MyLinkedList<String> test = new MyLinkedList<String>();
        System.out.println("  empty list test = " + ((test.set(2,"bad") == null)?"PASSED":"**FAILED**"));
        test.addFirst("Mark");
        test.addFirst("Sohaib");
        test.addFirst("Salman");
        System.out.println("  return value test = " + ((test.set(1,"Nora")).equals("Sohaib")?"PASSED":"**FAILED**"));
        System.out.println("  non-empty test = " + ((test.get(0).equals("Salman") && test.get(1).equals("Nora") &&
                           test.get(2).equals("Mark"))?"PASSED":"**FAILED**"));
  
        System.out.println("\nTesting addAfter...");
        MyLinkedList<String> other = new MyLinkedList<String>();
        other.add("one");
        other.add("two");
        other.add("three");
        other.add("four");
        System.out.println(other.size() + " " + other);
          other.addAfter(2,"three.5");
          System.out.println((other.get(3).equals("three.5")?"PASSED":"**FAILED**"));
          System.out.println(other.size() + " " + other);
        
          System.out.println("\nTesting lastIndex...");
          System.out.println((test.lastIndex("Salman")==0)?"PASSED":"**FAILED**");
          test.addFirst("Mark");
          System.out.println((test.lastIndex("Mark")==3)?"PASSED":"**FAILED**");

        System.out.println("\nTesting clone...");
        MyLinkedList<String> empty = new MyLinkedList<String>();
        list1 = empty.clone();
        System.out.println("  empty list test = " + (list1.isEmpty()?"PASSED":"**FAILED**"));
        MyLinkedList<String> another = other.clone();
        System.out.println(another.size() + " " + another);
        System.out.println("  making sure nodes not shared...");
        other.remove("two");
        System.out.println(other.size() + " " + other);
        System.out.println(another.size() + " " + another);

        System.out.println("\nTesting removeAll...");
        MyLinkedList<String> myList = new MyLinkedList<String>();
        System.out.println("Before... ");
        myList.add("dog");
        myList.add("cat");
        myList.add("horse");
        myList.add("fish");
        myList.add("cat");
        myList.add("lion");
        myList.add("cat");
        System.out.println(myList);
        myList.removeAll("cat");
        System.out.println("After removeAll('cat')...");
        System.out.println(myList);
        MyLinkedList<String> list7 = new MyLinkedList<String>();
        list7.add(101);
        list7.add(27);
        list7.add(34);
        list7.add(22);
        list7.add(54);
        System.out.println("Removing an element not in the list... Before...");
        System.out.println(list7);
        myList.removeAll(3);
        System.out.println("After removeAll(3)...");
        System.out.println(list7);



        System.out.println("\nTesting equals...");
        System.out.println("  reflexive test = " + (list2.equals(list2)?"PASSED":"**FAILED**"));
        MyLinkedList<String> emptyList = new MyLinkedList<String>();
        list0.clear();
        list1.clear();
        list1.add("node1");
        System.out.println("  empty list test/true = " + (emptyList.equals(list0)?"PASSED":"**FAILED**"));
        System.out.println("  empty list test1/false = " + (!emptyList.equals(list1)?"PASSED":"**FAILED**"));
        System.out.println("  empty list test2/false = " + (!list1.equals(emptyList)?"PASSED":"**FAILED**"));
        list0.add("node1");
        System.out.println("  singleton test = " + (list0.equals(list1)?"PASSED":"**FAILED**"));
        System.out.println("  subset inclusion 1/false = " + (!list1.equals(list2)?"PASSED":"**FAILED**"));
        System.out.println("  subset inclusion 2/false = " + (!list2.equals(list1)?"PASSED":"**FAILED**"));
        list0.add("node2"); list0.add("node3"); list0.add("node4");
        list0.add("node5"); list0.add("node6"); list0.add("node7");
        list4.add("node5"); list4.add("node6"); list4.add("node7");
        System.out.println("  7-element test/true = " + (list0.equals(list4)?"PASSED":"**FAILED**"));
        list0.remove("node4");
        list0.add("node5");
        System.out.println("  7-element test/false = " + (!list0.equals(list4)?"PASSED":"**FAILED**"));
        System.out.println("  7-element test/false = " + (!list4.equals(list0)?"PASSED":"**FAILED**"));

        System.out.println("\nTesting split...");
        MyLinkedList<String> result;
        list0=new MyLinkedList<String>();
        list1=new MyLinkedList<String>();
        list1.add("node1");
        list2=new MyLinkedList<String>();
        list2.add("node1");
        list2.add("node2");
        list3=new MyLinkedList<String>();
        list3.add("node1"); list3.add("node2"); list3.add("node3");
        list4=new MyLinkedList<String>();
        list4.add("node1"); list4.add("node2"); list4.add("node3"); list4.add("node4");
        MyLinkedList<String> list5 = new MyLinkedList<String>();
        list5.add("node1"); list5.add("node2"); list5.add("node3"); list5.add("node4");
        list5.add("node5");
        MyLinkedList<String> list6 = new MyLinkedList<String>();
        list6.add("node1"); list6.add("node2"); list6.add("node3"); list6.add("node4");
        list6.add("node5"); list6.add("node6");
        System.out.print("SPLIT ");
        System.out.println(list0.size() + " " + list0);
        result = list0.split();
        System.out.println("  list " + list0.size() + " " + list0);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list1.size() + " " + list1);
        result = list1.split();
        System.out.println("  list " + list1.size() + " " + list1);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list2.size() + " " + list2);
        result = list2.split();
        System.out.println("  list " + list2.size() + " " + list2);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list3.size() + " " + list3);
        result = list3.split();
        System.out.println("  list " + list3.size() + " " + list3);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list4.size() + " " + list4);
        result = list4.split();
        System.out.println("  list " + list4.size() + " " + list4);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list5.size() + " " + list5);
        result = list5.split();
        System.out.println("  list " + list5.size() + " " + list5);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list6.size() + " " + list6);
        result = list6.split();
        System.out.println("  list " + list6.size() + " " + list6);
        System.out.println("  result " + result.size() + " " + result);
        
        System.out.println();
        System.out.println("Testing doubler");
        MyLinkedList<String> lastI = new MyLinkedList<String>();
        lastI.add(1);
        lastI.add(2);
        lastI.add(3);
        lastI.add(4);
        lastI.add(5);
        lastI.add(6);
        System.out.println("Before... "+lastI.size()+"   "+lastI);
        lastI.doubler();
        System.out.println("After... "+lastI.size());
        System.out.print("   "+lastI);
        
        System.out.println();
        System.out.println();
        System.out.println("Testing Sublist");
        MyLinkedList<String>testList=new MyLinkedList<String>();
        System.out.println("Before...");
        testList.add("dog");
        testList.add("pig");
        testList.add("horse");
        testList.add("fish");
        testList.add("cow");
        testList.add("lion");
        testList.add("cat");
        System.out.println(testList);
        System.out.println("After...");
        System.out.println(testList.sublist(3, 6));

    }
}
