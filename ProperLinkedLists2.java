// Rachel Shindelus
// properLinkedList.java
// Project 1
import java.util.*;

public class ProperLinkedLists2<T> // Main Class
{   
   private Node<String> head;
   private Node<String> tail;
   private int size;
      
   public ProperLinkedLists2()     // constructor
   {
      head = null;
      tail = null;
      size = 0;
   }   
   
   public static String about()  // About()
   {
      final String aboutString = "Author: Rachel Shindelus\n"
                       + "Writing this code for project1 in CSC130.\n"
                       + "Purpose: Create our own linked-list class.\n";
      return aboutString;
   }
   
   void addHead(String value) // AddHead(String value)
   {
      Node<String> newNode = new Node<>(value);
      newNode.next = head;
      head = newNode;
      size++;
   }
   
   public void addTail(String value)   // AddTail(String value)
   {
      Node<String> newNode = new Node<>(value);
        if (tail == null)
        {
           head = newNode;
        }
        else
        {
           tail.next = newNode;
        }
        tail = newNode;
        size++;
   }
   
   String removeHead()     // RemoveHead()
   {
      if(head != null)
      {
         String value = head.data;
         head = head.next;
         size--;
         return value;
      }
      return null;
   }
   
   public boolean isEmpty()   //  IsEmpty()
   {
      if (size == 0)
      {
         return true;
      }
      return false;
   }
   
   public void printList()    // PrintList()
   {
      Node<String> current = head;
      while (current != null) {
         System.out.print(current.data + " -> ");
         current = current.next;
      }
      System.out.println("null");
   }
   
   private static class Node<String>  //Node class
   {
   String data;
   Node<String> next;
   String item;
    
   public Node(String data)   // Node(string)
   {
      this.data = data;
      this.next = null;
   }
   
   public Node getNext()   // Next
   {
      return next;
   }
   
   public String getValue()   // Value
   {
      return data;
   }
   
   public void printList()       // PrintList()
   {
      System.out.print(data + " -> ");
      if (next != null) {
         next.printList();
      } 
      else 
      {
         System.out.println("null");
      }
    }  
    }
    
   public class Stack<T>      // Stack Class
   {
   private ProperLinkedLists2<T> list;
   String item;
   
   public Stack()       // Constructor
   {
      list = new ProperLinkedLists2<>();
   }
   
   public String about()      // String About()
   {
       return list.about();
   }
   
   public void push(String item)    // Push(String item)
   {
      list.addHead(item);
   }
    
   public String pop()     // Pop() 
   {
      return list.removeHead();
   }
    
   public boolean isEmpty()      // IsEmpty()
   {
      return list.isEmpty();
   }
}

   public class Queue<T>      // Queue Class
   {
      private ProperLinkedLists2<String> list;
      String data;
      
      public Queue()    // Constructor
      {
         list = new ProperLinkedLists2<>();
      }
      
      public String about()         // About() 
      {
         return list.about();
      }
      
      public void enqueue(String data)    // Enqueue(String item)
      {
        list.addTail(data);
      }
      
      public String dequeue()       // Dequeue() 
      {
         return list.removeHead();
      }
      
      public boolean isEmpty()      // IsEmpty() 
      {
         return list.isEmpty();
      }
   }
         
      public static void main(String[] args) // Main
      {
         ProperLinkedLists2<String> myList = new ProperLinkedLists2<>();
         ProperLinkedLists2<String>.Stack<String> myStack = myList.new Stack<>();
         ProperLinkedLists2<String>.Queue<String> myQueue = myList.new Queue<>();
    
         myList.addHead("happy");
         myList.addTail("sad");
         myList.addTail("mad");

         myStack.push("upset");
         myStack.push("excited");
         myStack.push("tired");

         myQueue.enqueue("sleepy");
         myQueue.enqueue("stressed");
         myQueue.enqueue("scared");

         System.out.println("List:");
         myList.printList();

         System.out.println("Stack:");
         while (!myStack.isEmpty()) 
         {
            System.out.println("Popped: " + myStack.pop());
         }

         System.out.println("Queue:");
         while (!myQueue.isEmpty()) 
         {
            System.out.println("Dequeued: " + myQueue.dequeue());
         }
    
      }
}

