package farey;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        FareyLinkedListImpl sequence = new FareyLinkedListImpl();
        sequence.runFarey(n);
        sequence.show();

        System.out.println();
        System.out.println();

        FareySequenceGeneratorArrayImpl line = new FareySequenceGeneratorArrayImpl();
        line.generate(n);
        line.print();
    }
}