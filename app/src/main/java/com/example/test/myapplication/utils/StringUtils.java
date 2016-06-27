package com.example.test.myapplication.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/6/17.
 */
public class StringUtils {

    private StringUtils() {
        throw new AssertionError();
    }


    /**
     * is null or its length is 0 or it is made by space
     * <p/>
     * <pre>
     * isBlank(null) = true;
     * isBlank(&quot;&quot;) = true;
     * isBlank(&quot;  &quot;) = true;
     * isBlank(&quot;a&quot;) = false;
     * isBlank(&quot;a &quot;) = false;
     * isBlank(&quot; a&quot;) = false;
     * isBlank(&quot;a b&quot;) = false;
     * </pre>
     *
     * @param str str
     * @return if string is null or its size is 0 or it is made by space, return
     * true, else return false.
     */
    public static boolean isBlank(String str) {

        return (str == null || str.trim().length() == 0);
    }


    /**
     * is null or its length is 0
     * <p/>
     * <pre>
     * isEmpty(null) = true;
     * isEmpty(&quot;&quot;) = true;
     * isEmpty(&quot;  &quot;) = false;
     * </pre>
     *
     * @param str str
     * @return if string is null or its size is 0, return true, else return
     * false.
     */
    public static boolean isEmpty(CharSequence str) {

        return (str == null || str.length() == 0);
    }


    /**
     * get length of CharSequence
     * <p/>
     * <pre>
     * length(null) = 0;
     * length(\"\") = 0;
     * length(\"abc\") = 3;
     * </pre>
     *
     * @param str str
     * @return if str is null or empty, return 0, else return {@link
     * CharSequence#length()}.
     */
    public static int length(CharSequence str) {

        return str == null ? 0 : str.length();
    }


    /**
     * null Object to empty string
     * <p/>
     * <pre>
     * nullStrToEmpty(null) = &quot;&quot;;
     * nullStrToEmpty(&quot;&quot;) = &quot;&quot;;
     * nullStrToEmpty(&quot;aa&quot;) = &quot;aa&quot;;
     * </pre>
     *
     * @param str str
     * @return String
     */
    public static String nullStrToEmpty(Object str) {

        return (str == null
                ? ""
                : (str instanceof String ? (String) str : str.toString()));
    }


    /**
     * @param str str
     * @return String
     */
    public static String capitalizeFirstLetter(String str) {

        if (isEmpty(str)) {
            return str;
        }

        char c = str.charAt(0);
        return (!Character.isLetter(c) || Character.isUpperCase(c))
                ? str
                : new StringBuilder(str.length()).append(
                Character.toUpperCase(c))
                .append(str.substring(1))
                .toString();
    }


    /**
     * encoded in utf-8
     *
     * @param str �ַ���
     * @return ����һ��utf8���ַ���
     */
    public static String utf8Encode(String str) {

        if (!isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(
                        "UnsupportedEncodingException occurred. ", e);
            }
        }
        return str;
    }


    /**
     * @param href �ַ���
     * @return ����һ��html
     */
    public static String getHrefInnerHtml(String href) {

        if (isEmpty(href)) {
            return "";
        }

        String hrefReg = ".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*";
        Pattern hrefPattern = Pattern.compile(hrefReg,
                Pattern.CASE_INSENSITIVE);
        Matcher hrefMatcher = hrefPattern.matcher(href);
        if (hrefMatcher.matches()) {
            return hrefMatcher.group(1);
        }
        return href;
    }


    /**
     * @param source �ַ���
     * @return ����htmL���ַ���
     */
    public static String htmlEscapeCharsToString(String source) {

        return StringUtils.isEmpty(source)
                ? source
                : source.replaceAll("&lt;", "<")
                .replaceAll("&gt;", ">")
                .replaceAll("&amp;", "&")
                .replaceAll("&quot;", "\"");
    }


    /**
     * @param s str
     * @return String
     */
    public static String fullWidthToHalfWidth(String s) {

        if (isEmpty(s)) {
            return s;
        }

        char[] source = s.toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (source[i] == 12288) {
                source[i] = ' ';
                // } else if (source[i] == 12290) {
                // source[i] = '.';
            } else if (source[i] >= 65281 && source[i] <= 65374) {
                source[i] = (char) (source[i] - 65248);
            } else {
                source[i] = source[i];
            }
        }
        return new String(source);
    }


    /**
     * @param s �ַ���
     * @return ���ص���ֵ
     */
    public static String halfWidthToFullWidth(String s) {

        if (isEmpty(s)) {
            return s;
        }

        char[] source = s.toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (source[i] == ' ') {
                source[i] = (char) 12288;
                // } else if (source[i] == '.') {
                // source[i] = (char)12290;
            } else if (source[i] >= 33 && source[i] <= 126) {
                source[i] = (char) (source[i] + 65248);
            } else {
                source[i] = source[i];
            }
        }
        return new String(source);
    }


    /**
     * @param str ��Դ
     * @return �����ַ����л�
     */

    public static String replaceBlanktihuan(String str) {

        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }


    /**
     * �жϸ������ַ����Ƿ�Ϊnull�����ǿյ�
     *
     * @param string �������ַ���
     */
    public static boolean isEmpty(String string) {
        return string == null || "".equals(string.trim());
    }


    /**
     * �жϸ������ַ����Ƿ�Ϊnull�Ҳ�Ϊ��
     *
     * @param string �������ַ���
     */
    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }


    /**
     * �жϸ������ַ��������е������ַ����Ƿ�Ϊnull�����ǿյ�
     *
     * @param strings �������ַ���
     */
    public static boolean isEmpty(String... strings) {
        boolean result = true;
        for (String string : strings) {
            if (isNotEmpty(string)) {
                result = false;
                break;
            }
        }
        return result;
    }


    /**
     * �жϸ������ַ����������Ƿ�ȫ������Ϊnull�Ҳ�Ϊ��
     *
     * @param strings �������ַ�������
     * @return �Ƿ�ȫ������Ϊnull�Ҳ�Ϊ��
     */
    public static boolean isNotEmpty(String... strings) {
        boolean result = true;
        for (String string : strings) {
            if (isEmpty(string)) {
                result = false;
                break;
            }
        }
        return result;
    }


    /**
     * ����ַ�����null���߿վͷ���""
     */
    public static String filterEmpty(String string) {
        return StringUtils.isNotEmpty(string) ? string : "";
    }


    /**
     * �ڸ������ַ����У����µ��ַ��滻���оɵ��ַ�
     *
     * @param string  �������ַ���
     * @param oldchar �ɵ��ַ�
     * @param newchar �µ��ַ�
     * @return �滻����ַ���
     */
    public static String replace(String string, char oldchar, char newchar) {
        char chars[] = string.toCharArray();
        for (int w = 0; w < chars.length; w++) {
            if (chars[w] == oldchar) {
                chars[w] = newchar;
                break;
            }
        }
        return new String(chars);
    }


    /**
     * �Ѹ������ַ����ø������ַ��ָ�
     *
     * @param string �������ַ���
     * @param ch     �������ַ�
     * @return �ָ����ַ�������
     */
    public static String[] split(String string, char ch) {
        ArrayList<String> stringList = new ArrayList<String>();
        char chars[] = string.toCharArray();
        int nextStart = 0;
        for (int w = 0; w < chars.length; w++) {
            if (ch == chars[w]) {
                stringList.add(new String(chars, nextStart, w - nextStart));
                nextStart = w + 1;
                if (nextStart ==
                        chars.length) {    //�����һλ�Ƿָ���Ļ����������һ���յ��ַ������ָ�������ȥ
                    stringList.add("");
                }
            }
        }
        if (nextStart <
                chars.length) {    //������һλ���Ƿָ����Ļ����ͽ����һ���ָ�������һ���ַ��м�������ַ�����Ϊһ���ַ�����ӵ��ָ�������ȥ
            stringList.add(new String(chars, nextStart,
                    chars.length - 1 - nextStart + 1));
        }
        return stringList.toArray(new String[stringList.size()]);
    }


    /**
     * ����������ַ����ĳ��ȣ���������ǣ�һ�����ֵĳ���Ϊ2��һ���ַ��ĳ���Ϊ1
     *
     * @param string �������ַ���
     * @return ����
     */
    public static int countLength(String string) {
        int length = 0;
        char[] chars = string.toCharArray();
        for (int w = 0; w < string.length(); w++) {
            char ch = chars[w];
            if (ch >= '\u0391' && ch <= '\uFFE5') {
                length++;
                length++;
            } else {
                length++;
            }
        }
        return length;
    }


    private static char[] getChars(char[] chars, int startIndex) {
        int endIndex = startIndex + 1;
        //�����һ��������
        if (Character.isDigit(chars[startIndex])) {
            //�����һ��������
            while (endIndex < chars.length &&
                    Character.isDigit(chars[endIndex])) {
                endIndex++;
            }
        }
        char[] resultChars = new char[endIndex - startIndex];
        System.arraycopy(chars, startIndex, resultChars, 0, resultChars.length);
        return resultChars;
    }


    /**
     * �Ƿ�ȫ������
     */
    public static boolean isAllDigital(char[] chars) {
        boolean result = true;
        for (int w = 0; w < chars.length; w++) {
            if (!Character.isDigit(chars[w])) {
                result = false;
                break;
            }
        }
        return result;
    }


    /**
     * ɾ�������ַ��������еľɵ��ַ�
     *
     * @param string Դ�ַ���
     * @param ch     Ҫɾ�����ַ�
     * @return ɾ������ַ���
     */
    public static String removeChar(String string, char ch) {
        StringBuffer sb = new StringBuffer();
        for (char cha : string.toCharArray()) {
            if (cha != '-') {
                sb.append(cha);
            }
        }
        return sb.toString();
    }


    /**
     * ɾ�������ַ����и���λ�ô����ַ�
     *
     * @param string �����ַ���
     * @param index  ����λ��
     */
    public static String removeChar(String string, int index) {
        String result = null;
        char[] chars = string.toCharArray();
        if (index == 0) {
            result = new String(chars, 1, chars.length - 1);
        } else if (index == chars.length - 1) {
            result = new String(chars, 0, chars.length - 1);
        } else {
            result = new String(chars, 0, index) +
                    new String(chars, index + 1, chars.length - index);
            ;
        }
        return result;
    }


    /**
     * ɾ�������ַ����и���λ�ô����ַ�
     *
     * @param string �����ַ���
     * @param index  ����λ��
     * @param ch     ���ͬ����λ�ô����ַ���ͬ���򽫸���λ�ô����ַ�ɾ��
     */
    public static String removeChar(String string, int index, char ch) {
        String result = null;
        char[] chars = string.toCharArray();
        if (chars.length > 0 && chars[index] == ch) {
            if (index == 0) {
                result = new String(chars, 1, chars.length - 1);
            } else if (index == chars.length - 1) {
                result = new String(chars, 0, chars.length - 1);
            } else {
                result = new String(chars, 0, index) +
                        new String(chars, index + 1, chars.length - index);
                ;
            }
        } else {
            result = string;
        }
        return result;
    }


    /**
     * �Ը������ַ������пհ׹���
     *
     * @param string �������ַ���
     * @return ����������ַ�����һ���հ��ַ�������ô����null�����򷵻ر���
     */
    public static String filterBlank(String string) {
        if ("".equals(string)) {
            return null;
        } else {
            return string;
        }
    }


    /**
     * �������ַ����и�����������ַ�ת����Сд
     *
     * @param str        �����ַ�����
     * @param beginIndex ��ʼ������������
     * @param endIndex   ������������������
     * @return �µ��ַ���
     */
    public static String toLowerCase(String str, int beginIndex, int endIndex) {
        return str.replaceFirst(str.substring(beginIndex, endIndex),
                str.substring(beginIndex, endIndex)
                        .toLowerCase(Locale.getDefault()));
    }


    /**
     * �������ַ����и�����������ַ�ת���ɴ�д
     *
     * @param str        �����ַ�����
     * @param beginIndex ��ʼ������������
     * @param endIndex   ������������������
     * @return �µ��ַ���
     */
    public static String toUpperCase(String str, int beginIndex, int endIndex) {
        return str.replaceFirst(str.substring(beginIndex, endIndex),
                str.substring(beginIndex, endIndex)
                        .toUpperCase(Locale.getDefault()));
    }


    /**
     * �������ַ���������ĸתΪСд
     *
     * @param str �����ַ���
     * @return �µ��ַ���
     */
    public static String firstLetterToLowerCase(String str) {
        return toLowerCase(str, 0, 1);
    }


    /**
     * �������ַ���������ĸתΪ��д
     *
     * @param str �����ַ���
     * @return �µ��ַ���
     */
    public static String firstLetterToUpperCase(String str) {
        return toUpperCase(str, 0, 1);
    }


    /**
     * ���������ַ���MD5����
     *
     * @param string �������ַ���
     * @return MD5���ܺ����ɵ��ַ���
     */
    public static String MD5(String string) {
        String result = null;
        try {
            char[] charArray = string.toCharArray();
            byte[] byteArray = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                byteArray[i] = (byte) charArray[i];
            }

            StringBuffer hexValue = new StringBuffer();
            byte[] md5Bytes = MessageDigest.getInstance("MD5")
                    .digest(byteArray);
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }

            result = hexValue.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * �жϸ������ַ����Ƿ���һ���ض����ַ�����ͷ�����Դ�Сд
     *
     * @param sourceString �������ַ���
     * @param newString    һ���ض����ַ���
     */
    public static boolean startsWithIgnoreCase(String sourceString, String newString) {
        int newLength = newString.length();
        int sourceLength = sourceString.length();
        if (newLength == sourceLength) {
            return newString.equalsIgnoreCase(sourceString);
        } else if (newLength < sourceLength) {
            char[] newChars = new char[newLength];
            sourceString.getChars(0, newLength, newChars, 0);
            return newString.equalsIgnoreCase(String.valueOf(newChars));
        } else {
            return false;
        }
    }


    /**
     * �жϸ������ַ����Ƿ���һ���ض����ַ�����β�����Դ�Сд
     *
     * @param sourceString �������ַ���
     * @param newString    һ���ض����ַ���
     */
    public static boolean endsWithIgnoreCase(String sourceString, String newString) {
        int newLength = newString.length();
        int sourceLength = sourceString.length();
        if (newLength == sourceLength) {
            return newString.equalsIgnoreCase(sourceString);
        } else if (newLength < sourceLength) {
            char[] newChars = new char[newLength];
            sourceString.getChars(sourceLength - newLength, sourceLength,
                    newChars, 0);
            return newString.equalsIgnoreCase(String.valueOf(newChars));
        } else {
            return false;
        }
    }


    /**
     * ����ַ������ȣ�����ַ����ĳ��ȳ���maxLength���ͽ�ȡǰmaxLength���ַ�������ĩβƴ��appendString
     */
    public static String checkLength(String string, int maxLength, String appendString) {
        if (string.length() > maxLength) {
            string = string.substring(0, maxLength);
            if (appendString != null) {
                string += appendString;
            }
        }
        return string;
    }


    /**
     * ����ַ������ȣ�����ַ����ĳ��ȳ���maxLength���ͽ�ȡǰmaxLength���ַ�������ĩβƴ�ϡ�
     */
    public static String checkLength(String string, int maxLength) {
        return checkLength(string, maxLength, "��");
    }
}