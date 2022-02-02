package com.twiss.microsoft;

import java.util.regex.Pattern;

/**
 * @Author: Twiss
 * @Date: 2022/2/2 3:47 下午
 */
public class ValidateIpAddress {

    public String validByRegex(String IP) {
        String chunkIPV4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        Pattern pattenIPV4 = Pattern.compile("^(" + chunkIPV4 + "\\.){3}" + chunkIPV4 + "$");

        String chunkIPV6 = "[0-9a-fA-F]{1,4}";
        Pattern patternIPV6 = Pattern.compile("^(" + chunkIPV6 + "\\:){7}" + chunkIPV6 + "$");
        if (IP.contains(".")) {
            return (pattenIPV4.matcher(IP).matches()) ? "IPv4" : "Neither";
        } else if (IP.contains(":")) {
            return (patternIPV6.matcher(IP).matches()) ? "IPv6" : "Neither";
        }
        return "Neither";
    }

    public static void main(String[] args) {
        String ip = "192.168.1.1";
        String res = new ValidateIpAddress().validByRegex(ip);
        System.out.println(res);
    }
}
