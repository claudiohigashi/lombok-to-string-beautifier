package com.github.claudiohigashi.lombok.beautifier;

public class LombokToStringBeautifier {
    public static void main(String[] args) {
        String toString = "BinaryTreeNode(value=8, left=BinaryTreeNode(value=4, left=BinaryTreeNode(value=2, left=BinaryTreeNode(value=1, left=null, right=null), right=BinaryTreeNode(value=3, left=null, right=null)), right=BinaryTreeNode(value=6, left=BinaryTreeNode(value=5, left=null, right=null), right=BinaryTreeNode(value=7, left=null, right=null))), right=BinaryTreeNode(value=12, left=BinaryTreeNode(value=10, left=BinaryTreeNode(value=9, left=null, right=null), right=BinaryTreeNode(value=11, left=null, right=null)), right=BinaryTreeNode(value=14, left=BinaryTreeNode(value=13, left=null, right=null), right=BinaryTreeNode(value=15, left=null, right=null))))";
        System.out.println(beautifyLombokToStringObject(toString));
    }

    public static String beautifyLombokToStringObject(String toString) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = toString.toCharArray();
        beautifyLombokToStringObject(stringBuilder, chars, new Context());
        return stringBuilder.toString();
    }

    private static void beautifyLombokToStringObject(StringBuilder stringBuilder, char[] chars, Context context) {
        while (context.pos < chars.length && chars[context.pos] != '(' && chars[context.pos] != ',' && chars[context.pos] != ')') {
            stringBuilder.append(chars[context.pos]);
            context.pos++;
        }
        if (context.pos >= chars.length) {
            return;
        }

        stringBuilder.append(chars[context.pos]);
        if (chars[context.pos] == '(') {
            context.level++;
        } else if (chars[context.pos] == ')') {
            context.level--;
            context.pos++;
            while (context.pos < chars.length && chars[context.pos] == ')') {
                context.level--;
                newLineAndIdent(stringBuilder, context.level);
                stringBuilder.append(chars[context.pos]);
                context.pos++;
            }
            if (context.pos >= chars.length) {
                return;
            }
            stringBuilder.append(chars[context.pos]);
        }
        newLineAndIdent(stringBuilder, context.level);
        context.pos++;
        if (context.pos < chars.length && chars[context.pos] == ' ') {
            context.pos++;
        }
        beautifyToStringAttributeName(stringBuilder, chars, context);
    }

    private static void beautifyToStringAttributeName(StringBuilder stringBuilder, char[] chars, Context context) {
        while (context.pos < chars.length && chars[context.pos] != '=') {
            stringBuilder.append(chars[context.pos]);
            context.pos++;
        }
        beautifyLombokToStringObject(stringBuilder, chars, context);
    }

    private static void newLineAndIdent(StringBuilder stringBuilder, int level) {
        stringBuilder.append('\n');
        for (int i = 0; i < level; i++) {
            stringBuilder.append("    ");
        }
    }

    static class Context {
        int pos;
        int level;
    }
}
