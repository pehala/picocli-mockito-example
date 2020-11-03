package org.example;

import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.mockito.Mockito.*;

class CheckSumTest {

    @Test
    void testSpy() {
        CheckSum launcher = spy(CheckSum.class);

        new CommandLine(launcher);
    }

    @Test
    void testMock() {
        CheckSum checkSum = mock(CheckSum.class);
        new CommandLine(checkSum);
    }

    @Test
    void testMockWithoutAnnotations() {
        CheckSum checkSum = mock(CheckSum.class, withSettings().withoutAnnotations());
        new CommandLine(checkSum);
    }

    @Test
    void testNormal() {
        new CommandLine(new CheckSum());
    }
}