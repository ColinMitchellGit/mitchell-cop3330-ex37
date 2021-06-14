/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Colin Mitchell
 */

package ex37;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.lang.*;
import static java.lang.Integer.parseInt;

public class App
{
    public static void main( String[] args )
    {
        inputLoop();
    }

    public static void inputLoop() {
        Scanner input = new Scanner(System.in);

        int length = 0;
        int special_chars = 0;
        int numbers = 0;

        while(true) {
            try{
                System.out.print("What's the minimum length? ");
                length = parseInt(input.nextLine());
                System.out.print("How many special characters? ");
                special_chars = parseInt(input.nextLine());
                System.out.print("How many numbers? ");
                numbers = parseInt(input.nextLine());

                if(length - special_chars >= special_chars && length - numbers >= numbers) {
                    break;
                }
                System.out.println("There needs to be at least as many letters as numbers and special characters.");
            }catch(Exception e) {
                System.out.println("Invalid Input.");
            }
        }

        String password = generatePasswords(length, special_chars, numbers);
        System.out.println("Your password is " + password);
    }

    public static String generatePasswords(int length, int special, int nums)
    {
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*";
        String numbers = "1234567890";

        Random random = new Random();

        ArrayList<Character> chars = new ArrayList<>();

        for(int i=0; i<special; i++){
            chars.add(specialCharacters.charAt(random.nextInt(specialCharacters.length())));
        }

        for(int i=0; i<nums; i++){
            chars.add(numbers.charAt(random.nextInt(numbers.length())));
        }

        for(int i=chars.size()-1; i<length; i++){
            chars.add(letters.charAt(random.nextInt(letters.length())));
        }

        Collections.shuffle(chars);

        String password = "";

        for(Character s : chars) {
            password += Character.toString(s);
        }

        return password;
    }
}