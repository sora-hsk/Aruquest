package jp.ac.uejobi.aruquest;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by uejobi on 2018/11/07.
 */

public class MultiLineText {

    public static void drawNewlineTextMessageWindow(Canvas canvas, String text, String name, float x, float y, float width, float height, int lineMax, int charPerLine, Paint font, Paint mw, Paint border){
        float lineHeight = height / (lineMax + 1);
        float charWidth = width / (charPerLine + 1);
        font.setTextSize(lineHeight);
        font.setTextScaleX(charWidth * 2 / lineHeight);
        int startIndex = 0;
        int lineNum = 1;
        canvas.drawRect(x, y, x + width, y + height, mw);
        canvas.drawRect(x, y, x + width, y + height, border);
        if(name != null) {
            canvas.drawRect(x, y - lineHeight - lineHeight / 8, x + charWidth * (name.length() + 1), y - lineHeight / 8, mw);
            canvas.drawRect(x, y - lineHeight - lineHeight / 8, x + charWidth * (name.length() + 1), y - lineHeight / 8, border);
            canvas.drawText(name, x + charWidth / 2, y - lineHeight / 6 - lineHeight / 4, font);
        }
        for(int i = 0; i < text.length(); i++) {
            if(i - startIndex == charPerLine && text.length() != 0){
                if(String.valueOf(text.charAt(i)).equals("\\")) {
                    canvas.drawText(text, startIndex, i, x + charWidth / 2, y + lineHeight * lineNum, font);
                    startIndex = i + 1;
                    lineNum++;
                }
                else if(!String.valueOf(text.charAt(i)).equals("\\")){
                    canvas.drawText(text, startIndex, i, x + charWidth / 2, y + lineHeight * lineNum, font);
                    startIndex = i;
                    lineNum++;
                }
            }
            else if (String.valueOf(text.charAt(i)).equals("\\") && text.length() != 0) {
                canvas.drawText(text, startIndex, i, x + charWidth / 2, y + lineHeight * lineNum, font);
                startIndex = i + 1;
                lineNum++;
            }
            if(i == text.length() - 1 && text.length() != 0){
                canvas.drawText(text, startIndex, i + 1, x + charWidth / 2, y + lineHeight * lineNum, font);
                startIndex = i + 1;
                lineNum++;
            }
            if(lineNum > lineMax){
                break;
            }
        }
    }

    public static void drawNewlineTextMessageWindowVerticalCenter(Canvas canvas, String text, String name, float x, float y, float width, float height, int lineMax, int charPerLine, Paint paint, Paint mw, Paint border){
        float lineHeight = height / (lineMax + 1);
        float charWidth = width / (charPerLine + 1);
        paint.setTextSize(lineHeight);
        paint.setTextScaleX(charWidth * 2 / lineHeight);
        int startIndex = 0;
        int lineNum = 1;
        canvas.drawRect(x, y, x + width, y + height, mw);
        canvas.drawRect(x, y, x + width, y + height, border);
        if(name != null) {
            canvas.drawRect(x, y - lineHeight - lineHeight / 8, x + charWidth * (name.length() + 1), y - lineHeight / 8, mw);
            canvas.drawRect(x, y - lineHeight - lineHeight / 8, x + charWidth * (name.length() + 1), y - lineHeight / 8, border);
            canvas.drawText(name, x + charWidth / 2, y - lineHeight / 6 - lineHeight / 4, paint);
        }
        for(int i = 0; i < text.length(); i++) {
            if(i - startIndex == charPerLine && text.length() != 0){
                if(String.valueOf(text.charAt(i)).equals("\\")) {
                    canvas.drawText(text, startIndex, i, x + charWidth / 2, y + lineHeight * lineNum + lineHeight / 4, paint);
                    startIndex = i + 1;
                    lineNum++;
                }
                else if(!String.valueOf(text.charAt(i)).equals("\\")){
                    canvas.drawText(text, startIndex, i, x + charWidth / 2, y + lineHeight * lineNum + lineHeight / 4, paint);
                    startIndex = i;
                    lineNum++;
                }
            }
            else if (String.valueOf(text.charAt(i)).equals("\\") && text.length() != 0) {
                canvas.drawText(text, startIndex, i, x + charWidth / 2, y + lineHeight * lineNum + lineHeight / 4, paint);
                startIndex = i + 1;
                lineNum++;
            }
            if(i == text.length() - 1 && text.length() != 0){
                canvas.drawText(text, startIndex, i + 1, x + charWidth / 2, y + lineHeight * lineNum + lineHeight / 4, paint);
                startIndex = i + 1;
                lineNum++;
            }
            if(lineNum > lineMax){
                break;
            }
        }
    }

    public static void drawNewlineTextMessageWindowVerticalCenterLessSpace(Canvas canvas, String text, String name, float x, float y, float width, float height, int lineMax, int charPerLine, Paint paint, Paint mw, Paint border){
        float lineHeight = height / lineMax;
        float charWidth = width / (charPerLine + 1);
        paint.setTextSize(lineHeight);
        paint.setTextScaleX(charWidth * 2 / lineHeight);
        int startIndex = 0;
        int lineNum = 1;
        canvas.drawRect(x, y, x + width, y + height, mw);
        canvas.drawRect(x, y, x + width, y + height, border);
        if(name != null) {
            canvas.drawRect(x, y - lineHeight - lineHeight / 8, x + charWidth * (name.length() + 1), y - lineHeight / 8, mw);
            canvas.drawRect(x, y - lineHeight - lineHeight / 8, x + charWidth * (name.length() + 1), y - lineHeight / 8, border);
            canvas.drawText(name, x + charWidth / 2, y - lineHeight / 6 - lineHeight / 4, paint);
        }
        for(int i = 0; i < text.length(); i++) {
            if(i - startIndex == charPerLine && text.length() != 0){
                if(String.valueOf(text.charAt(i)).equals("\\")) {
                    canvas.drawText(text, startIndex, i, x + charWidth / 2, y + lineHeight * lineNum - lineHeight / 4, paint);
                    startIndex = i + 1;
                    lineNum++;
                }
                else if(!String.valueOf(text.charAt(i)).equals("\\")){
                    canvas.drawText(text, startIndex, i, x + charWidth / 2, y + lineHeight * lineNum - lineHeight / 4, paint);
                    startIndex = i;
                    lineNum++;
                }
            }
            else if (String.valueOf(text.charAt(i)).equals("\\") && text.length() != 0) {
                canvas.drawText(text, startIndex, i, x + charWidth / 2, y + lineHeight * lineNum - lineHeight / 4, paint);
                startIndex = i + 1;
                lineNum++;
            }
            if(i == text.length() - 1 && text.length() != 0){
                canvas.drawText(text, startIndex, i + 1, x + charWidth / 2, y + lineHeight * lineNum - lineHeight / 4, paint);
                startIndex = i + 1;
                lineNum++;
            }
            if(lineNum > lineMax){
                break;
            }
        }
    }

    public static void drawNewlineTextVerticalCenterLessSpace(Canvas canvas, String text, String name, float x, float y, float width, float height, int lineMax, int charPerLine, Paint paint){
        float lineHeight = height / lineMax;
        float charWidth = width / (charPerLine + 1);
        paint.setTextSize(lineHeight);
        paint.setTextScaleX(charWidth * 2 / lineHeight);
        int startIndex = 0;
        int lineNum = 1;
        if(name != null) {
            canvas.drawText(name, x + charWidth / 2, y - lineHeight / 6 - lineHeight / 4, paint);
        }
        for(int i = 0; i < text.length(); i++) {
            if(i - startIndex == charPerLine && text.length() != 0){
                if(String.valueOf(text.charAt(i)).equals("\\")) {
                    canvas.drawText(text, startIndex, i, x + charWidth / 2, y + lineHeight * lineNum - lineHeight / 4, paint);
                    startIndex = i + 1;
                    lineNum++;
                }
                else if(!String.valueOf(text.charAt(i)).equals("\\")){
                    canvas.drawText(text, startIndex, i, x + charWidth / 2, y + lineHeight * lineNum - lineHeight / 4, paint);
                    startIndex = i;
                    lineNum++;
                }
            }
            else if (String.valueOf(text.charAt(i)).equals("\\") && text.length() != 0) {
                canvas.drawText(text, startIndex, i, x + charWidth / 2, y + lineHeight * lineNum - lineHeight / 4, paint);
                startIndex = i + 1;
                lineNum++;
            }
            if(i == text.length() - 1 && text.length() != 0){
                canvas.drawText(text, startIndex, i + 1, x + charWidth / 2, y + lineHeight * lineNum - lineHeight / 4, paint);
                startIndex = i + 1;
                lineNum++;
            }
            if(lineNum > lineMax){
                break;
            }
        }
    }

    public static void drawMessageWindow(Canvas canvas, float x, float y, float width, float height, Paint mw, Paint border){
        canvas.drawRect(x, y, x + width, y + height, mw);
        canvas.drawRect(x, y, x + width, y + height, border);
    }

    public static void drawMultilineText(Canvas canvas, String text, float x, float y, float width, float height, Paint paint) {
        final float lineHeight = paint.getTextSize();
        final int len = text.length();
        float sumHeight = lineHeight;
        int index = 0;
        while (index < len && sumHeight <= height) {
            final int count = paint.breakText(text, index, len, true, width, null);
            if (count == 0) {
                break;
            }
            canvas.drawText(text, index, index + count, x, y + sumHeight, paint);
            index += count;
            sumHeight += lineHeight;
        }
    }
}
