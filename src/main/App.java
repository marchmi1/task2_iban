package main;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class App {

        // Parameters
        static String iban;
        static final String WHITE_SPACE = "\\s+";


        // Methods
        /**
         * 
         * @param input string for the change
         * @return string with changed order of characters - first 4 characters will be moved to last 4 places
         */
        public static String change4FirstTo4Last(String input)
        {    
            String changedInput;
            changedInput = input.substring(4,input.length())+input.substring(0, 4);
            return changedInput; 
        }
/**
 * 
 * @param input IBAN
 * @return return string with all the Upper Letters are changed to specific value given by the task
 */        public static String lettersToNumbersAlternative(String input) 
        {
            List<Character> chars = input.chars().mapToObj(e->(char)e).collect(Collectors.toList());
            for (char character : chars){
                int ascii = (int) character;
                if (ascii > 64 && ascii < 91) 
                {
                    ascii = ascii - 55;
                    // due to replacing one letter with a two digit number i needed to make it so both of them are read as strings that's why used "" + variable
                    input = input.replace("" + character, "" + ascii);  
                }
            }
            
            return input;
        }
/**
 * in this translator we change each letter to a number, based on given values from specification
 * 
 * @param input IBAN
 * @return based translator returns IBAN without letters
 */
        public static String lettersToNumbers(String input) 
        {
            List<Character> chars = input.chars().mapToObj(e->(char)e).collect(Collectors.toList());
            String number;
            String letter;
            for(char singleChar : chars){
                letter = "" + singleChar;
            switch (letter){
                case "A":
                {
                number = "10";
                break;
                }
                case "B":
                {
                number = "11";
                break;
                }
                case "C":
                {
                number = "12";
                break;
                }
                case "D":
                {
                number = "13";
                break;
                }
                case "E":
                {
                number = "14";
                break;
                }
                case "F":
                {
                number = "15";
                break;
                }
                case "G":
                {
                number = "16";
                break;
                }
                case "H":
                {
                number = "17";
                break;
                }
                case "I":
                {
                number = "18";
                break;
                }
                case "J":
                {
                number = "19";
                break;
                }
                case "K":
                {
                number = "20";
                break;
                }
                case "L":
                {
                number = "21";
                break;
                }
                case "M":
                {
                number = "22";
                break;
                }
                case "N":
                {
                number = "23";
                break;
                }
                case "O":
                {
                number = "24";
                break;
                }   
                case "P":
                {
                number = "25";
                break;
                }   
                case "Q":
                {
                number = "26";
                break;
                }   
                case "R":
                {
                number = "27";
                break;
                }   
                case "S":
                {
                number = "28";
                break;
                }   
                case "T":
                {
                number = "29";
                break;
                }   
                case "U":
                {
                number = "30";
                break;
                }   
                case "V":
                {
                number = "31";
                break;
                }   
                case "W":
                {
                number = "32";
                break;
                }   
                case "X":
                {
                number = "33";
                break;
                }   
                case "Y":
                {
                number = "34";
                break;
                }   
                case "Z":
                {
                number = "35";
                break;
                }
                default:
                number = letter;
                
            }
            input = input.replace(letter, number); 
            
        }
        return input;
        }
/**
 * 
 * @param input IBAN
 * @return validate IBAN value if MODULO from value is 1 then yes
 */

        public static Boolean validateIban(String input)
        {
            boolean temp = false;
            BigInteger d = new BigInteger(input);
            BigInteger n = BigInteger.valueOf(97);
            BigInteger z = d.mod(n);
            if (z.equals(BigInteger.ONE)) {
                temp = true;
            }
            return temp;
            
        }
/**
 * 
 * @param input IBAN
 * @return validates if IBAN is in valid length
 */
        public static Boolean validateLengthOfIban(String input)
        {
            boolean temp = false;
            if(input.length()<44 && input.length()>13){
                temp = true;
            }
            return temp;
            
        }
/**
 * 
 * @param input IBAN 
 * @return IBAN string without WHITE_SPACES
 */
        public static String removeWhitespace(String input)
        {
            input = input.replaceAll(WHITE_SPACE,"");
            return input;
        }

        // Main
        /**
         * 
         * @param args arguments given, in this case different String IBANs
         * @throws Exception when there is a invalid Character or any other problem not taken into account
         */
        public static void main(String[] args) throws Exception {
           
                for(int i=0; i < args.length; i++){
                    try {
                    iban = args[i];
                    iban = removeWhitespace(iban);
                    if (validateLengthOfIban(iban) == true){                
                        iban = change4FirstTo4Last(iban);
                        iban = lettersToNumbersAlternative(iban);
                        if (validateIban(iban)){
                            System.out.println("this is a valid iban: " + args[i]);
                        } 
                        else {
                            System.out.println("this is an invalid iban (not a modulo 97 value) " + args[i]);
                        }
                    }
                    else {
                        System.out.println("this is incorect length for IBAN: " + iban.length());
                    }}
                    catch (Exception e) {
                        System.out.println(iban + " this is an invalid IBAN");
                    }
            
            

                    
        }
    }
}
