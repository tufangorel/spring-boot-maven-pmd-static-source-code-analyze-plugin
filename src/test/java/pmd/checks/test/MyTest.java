package pmd.checks.test;

import org.junit.jupiter.api.Test;

class MyTest { // not public, that's fine

    @Test
    public void testBad() { } // should not have a public modifier

    @Test
    protected void testAlsoBad() { } // should not have a protected modifier

    @Test
    private void testNoRun() { } // should not have a private modifier

    @Test
    void testGood() { } // package private as expected
}
