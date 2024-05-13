package com.lanqiaobeitiku;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(System.out))));
    static BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
    static StringTokenizer st;
    static {
        try {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            while (n-- > 0) sb.append(br.readLine()).append(' ');
            st = new StringTokenizer(sb.toString());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        long num = 0L;
        int binary = 10;
        String option = null;
        String method = null;
        boolean accept = true;
        while (st.hasMoreElements()) {
            String s = (String) st.nextElement();
            switch (s) {
                case "ADD":
                case "SUB":
                case "MUL":
                case "DIV":
                case "MOD":
                    method = s;
                    accept = false;
                    break;
                case "NUM":
                    long num2 = Long.parseLong((String) st.nextElement(), binary);
                    if (accept) {
                        num = num2;
                    } else {
                        switch (method) {
                            case "ADD":
                                num += num2;
                                break;
                            case "SUB":
                                num -= num2;
                                break;
                            case "MUL":
                                num *= num2;
                                break;
                            case "DIV":
                                num /= num2;
                                break;
                            case "MOD":
                                num %= num2;
                                break;
                        }
                        accept = true;
                    }
                    break;
                case "CHANGE":
                    binary = Integer.parseInt((String) st.nextElement());
                    break;
                case "CLEAR":
                    num = 0L;
                    accept = true;
                    break;
                case "EQUAL":
                    pw.println(Long.toString(num, binary).toUpperCase());
                    break;
                default:
                    if ("CLEAR".equals(option)) {
                        num = Long.parseLong(s, binary);
                    }
                    break;
            }
            option = s;
        }
        pw.close();
    }

}