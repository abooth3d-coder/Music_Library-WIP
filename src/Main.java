//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args)
    {
        MusicManager musicManager = new MusicManager();
    }

    public static Scanner getScanner()
    {
        return SCANNER;
    }
}