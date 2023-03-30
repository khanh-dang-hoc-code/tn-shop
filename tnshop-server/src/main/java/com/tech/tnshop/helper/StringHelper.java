package com.tech.tnshop.helper;

public class StringHelper {
   public  static boolean isEmpty(String s) {
       return s == null || s.isEmpty();
   }

   public static boolean isNotEmpty(String s) {
       return !isEmpty(s);
   }
}
