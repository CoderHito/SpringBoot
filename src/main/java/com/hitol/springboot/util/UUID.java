package com.hitol.springboot.util;

public class UUID {
    public static String getUuid() {
        return java.util.UUID.randomUUID().toString().replace("-", "");

    }

    public static void main(String[] args) {
//        System.out.println(UUID.getUuid());
//        System.out.println(java.util.UUID.randomUUID().toString().replace("-", "").length());

        String base = "AKB48女子团体写真";
        String s1 = "http://mm.chinasareview.com/wp-content/uploads/2011a/12/07/02.jpg";
        String s11 = "http://mm.chinasareview.com/wp-content/uploads/2011a/12/07/02.jpg";
        String s2 = "http://mm.chinasareview.com/wp-content/uploads/2011a/12/07/01.jpg";
        String s3 = "http://mm.chinasareview.com/wp-content/uploads/2011a/12/07/04.jpg";
        String s4 = "http://mm.chinasareview.com/wp-content/uploads/2011a/12/07/03.jpg";
        String s5 = "http://mm.chinasareview.com/wp-content/uploads/2011a/12/07/05.jpg";
        String s6 = "http://mm.chinasareview.com/wp-content/uploads/2011a/12/07/06.jpg";

        System.out.println((base + s1).hashCode());
        System.out.println((base + s11).hashCode());
        System.out.println((base + s2).hashCode());
        System.out.println((base + s3).hashCode());
        System.out.println((base + s4).hashCode());
        System.out.println((base + s5).hashCode());
        System.out.println((base + s6).hashCode());

    }
}
