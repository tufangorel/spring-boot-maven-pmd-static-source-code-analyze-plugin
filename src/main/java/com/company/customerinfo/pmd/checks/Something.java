package com.company.customerinfo.pmd.checks;

import java.io.File;  // not referenced or required
import java.util.*;   // not referenced or required

public class Something {

    private static final int FOO = 2; // Unused
    private final int i = 5; // Unused
    private int j = 6;

    public int addOne() {
        return j++;
    }

    public void doSomething() {
        int i = 5; // Unused
    }
}
