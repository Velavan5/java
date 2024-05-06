import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
       // String champion = null;
        int count = 4;
System.out.println(StdRandom.bernoulli(1.0 / count));
        // while (!StdIn.isEmpty())
        // {
        //     String currentWord = StdIn.readString();
        //     count++;
        //     if (StdRandom.bernoulli(1.0 / count))
        //     {
        //         champion = currentWord;
        //     }
        // }

        // if (champion != null){
        //     StdOut.println( champion);
        // } else{
        //     StdOut.println("No words were entered.");
        // }
    }
}
