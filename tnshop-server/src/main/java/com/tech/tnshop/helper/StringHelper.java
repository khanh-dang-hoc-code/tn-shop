package com.tech.tnshop.helper;

/*
 * @created 01/04/2023 - 05:50
 * @project tn-shop
 * @author  ngockhanh
 */
public class StringHelper {

    private StringHelper () {

    }
   public  static boolean isEmpty(String s) {
       return s == null || s.isEmpty();
   }

   public static boolean isNotEmpty(String s) {
       return !isEmpty(s);
   }
}
