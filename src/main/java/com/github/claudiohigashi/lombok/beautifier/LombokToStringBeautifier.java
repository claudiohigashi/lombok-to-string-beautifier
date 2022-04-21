package com.github.claudiohigashi.lombok.beautifier;

public class LombokToStringBeautifier {
    public static void main(String[] args) {
        String toString = "BinaryTreeNode(value=8, left=BinaryTreeNode(value=4, left=BinaryTreeNode(value=2, left=BinaryTreeNode(value=1, left=null, right=null), right=BinaryTreeNode(value=3, left=null, right=null)), right=BinaryTreeNode(value=6, left=BinaryTreeNode(value=5, left=null, right=null), right=BinaryTreeNode(value=7, left=null, right=null))), right=BinaryTreeNode(value=12, left=BinaryTreeNode(value=10, left=BinaryTreeNode(value=9, left=null, right=null), right=BinaryTreeNode(value=11, left=null, right=null)), right=BinaryTreeNode(value=14, left=BinaryTreeNode(value=13, left=null, right=null), right=BinaryTreeNode(value=15, left=null, right=null))))";
        System.out.println(beautifyLombokToStringObject(toString));
    }

    public static String beautifyLombokToStringObject(String toString) {
        Context ctx = new Context(toString);
        beautifyLombokToStringObject(ctx);
        return ctx.stringBuilder.toString();
    }

    private static void beautifyLombokToStringObject(Context ctx) {
        while (true) {
            writeAWord(ctx);
            if (ctx.isEndOfChars()) {
                break;
            }

            ctx.appendChar();
            if (ctx.isOneOf("([")) {
                ctx.level++;
                newLineAndIdent(ctx);
            } else if (ctx.isOneOf(")]")) {
                ctx.level--;
                if (ctx.index + 1 < ctx.chars.length && ctx.chars[ctx.index + 1] != ',') {
                    newLineAndIdent(ctx);
                }
            } else if (ctx.isCurrentChar(',')) {
                newLineAndIdent(ctx);
            }
            ctx.index++;
        }
    }

    private static void writeAWord(Context ctx) {
        // skip spaces in the beginning
        while (ctx.isNotEndOfChars() && ctx.isCurrentChar(' ')) {
            ctx.index++;
        }

        // write the word
        while (!ctx.isEndOfChars() && !ctx.isOneOf("()[],=")) {
            ctx.appendChar();
            ctx.index++;
        }
    }

    private static void newLineAndIdent(Context ctx) {
        ctx.stringBuilder.append('\n');
        for (int i = 0; i < ctx.level; i++) {
            ctx.stringBuilder.append("    ");
        }
    }

    static class Context {
        int index;
        int level;
        char[] chars;
        StringBuilder stringBuilder;

        public Context(String toString) {
            this.chars = toString.toCharArray();
            this.stringBuilder = new StringBuilder();
        }

        public void appendChar() {
            stringBuilder.append(chars[index]);
        }

        public boolean isNotEndOfChars() {
            return index < chars.length;
        }

        public boolean isEndOfChars() {
            return index >= chars.length;
        }

        public boolean isOneOf(String string) {
            return index < chars.length && string.indexOf(chars[index]) != -1;
        }

        public boolean isCurrentChar(char c) {
            return index < chars.length && chars[index] == c;
        }
    }
}
