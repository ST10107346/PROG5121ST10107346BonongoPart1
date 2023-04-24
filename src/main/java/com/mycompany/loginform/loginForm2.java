
package com.mycompany.loginform;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
//BonongoST10107346
public class loginForm2 {
    public void userInput(){
 Scanner x = new Scanner(System.in);
 System.out.println("Enter your username");
 String username = x.nextLine();
 System.out.println("Enter your password");
 String password = x.nextLine();
 System.out.println("Please confirm password");
 String confirm = x.nextLine();
 System.out.println("Enter your first name");
 String firstName = x.nextLine();
 System.out.println("Enter your surname");
 String surname = x.nextLine();
 
 if(username.length()<=5 && username.contains ("_")){
        System.out.println("Username is captured successfully");
 }else{
     System.out.println("\nUsername is not enterred correctely and please ensure it contains an"
             + " underscore with no more than 5 characters");
    }
 List<String> errorList = new ArrayList<String>();
 
 while (!isValid(password, confirm, errorList)) {
     System.out.println("\nPassword is not correct, please make sure that password is entered "
             + "correctly and has atleast "
             + "8 characters, a special character a single digit and a capital letter");
     for (String error : errorList){
         System.out.println(error);
     }
     System.out.println("Please enter the password: ");
     password = x.nextLine();
     System.out.println("Please confirm your password: ");
     confirm = x.nextLine();
 }
 System.out.println("\nPassword correct!");
 
    }
    private static boolean isValid(String password, String confirm, List<String> errorList){
        Pattern specialCharPattern = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
        Pattern UpperCasePattern = Pattern.compile("[A-Z]");
        Pattern lowerCasePattern = Pattern.compile("[a-z]");
        Pattern digitCasePattern = Pattern.compile("[0-9]");
        errorList.clear();
        
        boolean flag = true;
        if (password.length() > 8) {
            errorList.add("Password must have atleast 8 characters");
            flag = false;
            
        }
        if (!password.equals(confirm)){
            errorList.add("Passwords do not match");
            flag = false;
        }
        if (!specialCharPattern.matcher(password).find()) {
            errorList.add("Password must have a special character");
            flag = false;
        }
        if (!UpperCasePattern.matcher(password).find()) {
            errorList.add("Password must have atleast one capital letter");
            flag = false;
        }
        if (!lowerCasePattern.matcher(password).find()) {
            errorList.add("Password must have lowercase characters!!");
            flag = false;
        }
        if (!digitCasePattern.matcher(password).find()) {
            errorList.add("Password must have atleast one digit!!");
           
            flag = false;
        }
        
        return flag;
}
}