/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poly.btl.helper;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class Validator {
    public static boolean checkEmpty(JTextField field , StringBuilder sb , String msg){
       boolean ok = false;
        
        if(field.getText().equals("")){
            sb.append(msg).append("\n");
            field.setBackground(Color.red);
            ok=true;
        }else{
                field.setBackground(Color.white);
                }
        return ok;
    }
     public static boolean checkEmail(JTextField field , StringBuilder sb){
        boolean ok = true;
        if(! checkEmpty( field , sb , "Email chưa nhập")){
            return false; 
        }
            Pattern pattern = Pattern.compile("\\w+@\\+w+\\.\\w+");
            Matcher matcher = pattern.matcher(field.getText());
                if(!matcher.find()){
                    sb.append("Email khong hợp lệ ");
                     field.setBackground(Color.red);
                     ok = false;
                }    
       if(ok) {
              field.setBackground(Color.white);  
                }
        return ok;
    }
}
