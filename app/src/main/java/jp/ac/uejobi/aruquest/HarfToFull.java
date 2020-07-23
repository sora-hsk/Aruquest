package jp.ac.uejobi.aruquest;

/**
 * Created by uejobi on 2018/11/21.
 */

public class HarfToFull {
    public static String changeNumHalfToFull(String str) {
        String result = null;
        if(str != null) {
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < sb.length(); i++) {
                int c = (int) sb.charAt(i);
                if (c >= 0x30 && c <= 0x39) {
                    sb.setCharAt(i, (char) (c + 0xFEE0));
                }
            }
            result = sb.toString();
        }
        return result;
    }
}
