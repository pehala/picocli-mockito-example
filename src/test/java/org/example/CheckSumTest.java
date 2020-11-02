package org.example;

import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.mockito.Mockito.spy;

class CheckSumTest {

    @Test
    void testSpy() {
        CheckSum launcher = spy(new CheckSum());

        new CommandLine(launcher);
    }

    @Test
    void testNormal() {
        new CommandLine(new CheckSum());
    }
}