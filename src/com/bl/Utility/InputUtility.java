package com.bl.Utility;

import java.util.Scanner;

public class InputUtility{
    private final static Scanner sc = new Scanner(System.in);
    public static int getIntValue()
    {
        return sc.nextInt();
    }
    public static String getStringValue()
    {
        return sc.next();
    }
	
}
