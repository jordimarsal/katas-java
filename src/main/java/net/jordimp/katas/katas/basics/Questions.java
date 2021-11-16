package net.jordimp.katas.katas.basics;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Questions {

    private Questions(){}

    public static void validIdentifiers() {
        final String abc = "abc";
        final String _abc = "_abc";
        final String $while = "$while";

        log.debug(abc);
        log.debug(_abc);
        log.debug($while);
    }

    public static String operations() {
        int a = 4;
        int b = 8;
        int c = -5;
        log.debug("++c = -4 ");
        log.debug("b-- =  8");
        log.debug("a-- =  4");
        log.debug("c-- = -4");
        return a / b + "\n" + (++c * b--) + " " + a-- * b / c--;
    }

    public static String segments() {
        final String one = "one";
        final String two = "two";
        final String One = new String(one);
        final String Two = two;

        if (one == One) {
            log.debug("Java is fun!");
        }
        if (one.equals(One) == true) {
            log.debug("Programming needs practice.");
        }
        if (one == Two) {
            log.debug("OOP is the way!");
        }
        if (two.equals(Two) == true) {
            log.debug("Explore the world of Java.");
        }
        return "";
    }

}
