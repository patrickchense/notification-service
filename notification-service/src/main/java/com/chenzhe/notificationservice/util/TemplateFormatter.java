package com.chenzhe.notificationservice.util;

import com.chenzhe.userservice.entity.User;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateFormatter {

    private static final String fieldStart = "\\{\\{";
    private static final String fieldEnd = "\\}\\}";

    private static final String regex = fieldStart + "([^}]+)" + fieldEnd;
    private static final Pattern pattern = Pattern.compile(regex);

    public static String format(String format, User user) throws Exception {
        Matcher m = pattern.matcher(format);
        String result = format;
        while (m.find()) {
            String[] found = m.group(1).split("\\.");
            Field f = user.getClass().getDeclaredField(found[1]);
            f.setAccessible(true);
            String newVal = f.get(user).toString();
            result = result.replaceFirst(regex, newVal);
        }
        return result;
    }
}
