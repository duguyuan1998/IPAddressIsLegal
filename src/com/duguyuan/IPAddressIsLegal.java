package com.duguyuan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class IPAddressIsLegal {

    public static final String LEGAL = "该IP地址可以访问网络";
    public static final String ILLEGAL = "该IP地址不允许访问网络";

    public static String ipIsLegal(String ipAddress) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("src/white_list.txt");
            br = new BufferedReader(fr);
            String line = null;
            while((line = br.readLine()) != null) {
                if (line.equals(ipAddress)) {
                    return LEGAL;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ILLEGAL;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ipAddress = in.nextLine();
        System.out.println(ipIsLegal(ipAddress));
        in.close();
    }

}
