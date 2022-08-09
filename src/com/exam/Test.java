package com.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zkp
 * @version 1.0
 */
public class Test {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        String line = scanner.nextLine();
        scanner = new Scanner(line);
        while (scanner.hasNextInt()){
            list.add(scanner.nextInt());
        }
        System.out.println(list.toString());
    }
}
