import java.util.*;

public class SumThread extends Thread {
    int[] myarray;
    public SumThread(int[] array)
    {
        myarray = array;
    }
    public void run()
    {
        if(this.getName().equals("forwards"))
        {
            System.out.println("forwards thread sorting...");
            bubblesort(myarray);
        }
        if(this.getName().equals("backwards"))
        {
            System.out.println("backwards thread sorting...");
            reversebubblesort(myarray);
        }
        System.out.println("Thread " + this.getName() + " FINISHED");
    }


    public static void main(String[] args)
    {
        int arraysize;
        Scanner cin = new Scanner(System.in);

        //creating the array of user size
        System.out.println("This program will simultaneously sort bubble your array forwards and backwards to see which method requires less swaps");
        System.out.print("Enter an integer size of array: ");
        arraysize = cin.nextInt();
        int[] array = new int[arraysize];

        //getting inputs from user to populate array, then print the array;
        for(int i = 0; i < arraysize; i++)
        {
            System.out.print("Enter value " + (i + 1) + ": ");
            array[i] = cin.nextInt();
        }
        System.out.println("Array: ");
        printArray(array);

        //creating two threads, naming them appropriately, and starting them
        System.out.println("Sorting clones of your array simultaneously");
        SumThread thread1 = new SumThread(array.clone());
        SumThread thread2 = new SumThread(array.clone());
        thread1.setName("forwards");
        thread2.setName("backwards");
        thread1.start();
        thread2.start();




    }

    public static void printArray(int[] array)
        {
            System.out.print("{ ");
            for(int i = 0; i < array.length; i++)
            {
                System.out.print(array[i] + " ");
            }
            System.out.print("}");
        System.out.println();
    }

    public static void bubblesort(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            for(int j = 0; j < array.length - 1; j++)
            {
                if(array[j] > array[j + 1])
                {

                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void reversebubblesort(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            for(int j = array.length - 1; j > 0; j--)
            {
                if(array[j] > array[j - 1])
                {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
}
