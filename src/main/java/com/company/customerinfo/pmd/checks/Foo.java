package com.company.customerinfo.pmd.checks;

import java.util.*;

public abstract class Foo {

    private StringBuffer buffer;    // potential memory leak as an instance variable;
    private String ip = "127.0.0.1";     // not recommended

    int method1() {
        return 1;
    }

    int method2() {
        return 2;
    }

    private String[] x;

    public void foo(String[] param) {
        this.x = param;
    }

    void bar() {
        try {
            // do something
            Hashtable h = new Hashtable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void foo() {
        try {
            // do something
        } catch (Exception e) {
            e = new NullPointerException(); // not recommended
        }

        try {
            // do something
        } catch (RuntimeException e) {
            e = new RuntimeException(); // won't compile
        }
    }

    private void greet(String name) {
        name = name.trim();
        System.out.println("Hello " + name);

        // preferred
        String trimmedName = name.trim();
        System.out.println("Hello " + trimmedName);
    }

    public interface ConstantInterface {
        public static final int CONST1 = 1; // violation, no fields allowed in interface!
        static final int CONST2 = 1;        // violation, no fields allowed in interface!
        final int CONST3 = 1;               // violation, no fields allowed in interface!
        int CONST4 = 1;                     // violation, no fields allowed in interface!
    }

    void bar(int a) {
        switch (a) {
            case 1:  // do something
                break;
            default:  // the default case should be last, by convention
                break;
            case 2:
                break;
        }
    }

    List<String> barWithList(int a) {
        // this is double-brace initialization
        return new ArrayList<String>() {{
            add("a");
            add("b");
            add("c");
        }};

    }

    void loop(List<String> l) {
        for (int i = 0; i < l.size(); i++) { // pre Java 1.5
            System.out.println(l.get(i));
        }

        for (String s : l) {        // post Java 1.5
            System.out.println(s);
        }
    }

    boolean bar1(String x) {
        return x.equals("2"); // should be "2".equals(x)
    }

    boolean bar2(String x) {
        return x.equalsIgnoreCase("2"); // should be "2".equalsIgnoreCase(x)
    }

    boolean bar3(String x) {
        return (x.compareTo("bar") > 0); // should be: "bar".compareTo(x) < 0
    }

    boolean bar4(String x) {
        return (x.compareToIgnoreCase("bar") > 0); // should be: "bar".compareToIgnoreCase(x) < 0
    }

    boolean bar5(String x) {
        return x.contentEquals("bar"); // should be "bar".contentEquals(x)
    }

    // sub-optimal approach
    private ArrayList<Integer> list1 = new ArrayList<>();

    public HashSet<Integer> getFoo1() {
        return new HashSet<Integer>();
    }

    // preferred approach
    private List<Integer> list = new ArrayList<>();

    public Set<Integer> getFoo() {
        return new HashSet<Integer>();
    }

    String name1;            // separate declarations
    String lastname1;

    String name2, lastname2;  // combined declaration, a violation

    String name3,
            lastname3;        // combined declaration on multiple lines, no violation by default.
    // Set property strictMode to true to mark this as violation.

    boolean bar(String x) {
        return x.equalsIgnoreCase("2"); // should be "2".equalsIgnoreCase(x)
    }
}