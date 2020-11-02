package org.example;

import picocli.CommandLine;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/**
 * Hello world!
 *
 */
@CommandLine.Command(name = "checksum",
        mixinStandardHelpOptions = true,
        version = "checksum 4.0",
        description = "Prints the checksum (MD5 by default) of a file to STDOUT.",
        subcommands = SubCommand.class
)
class CheckSum implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", description = "The file whose checksum to calculate.")
    private File file;

    @CommandLine.Option(names = {"-a", "--algorithm"}, description = "MD5, SHA-1, SHA-256, ...")
    private String algorithm = "MD5";

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        byte[] fileContents = Files.readAllBytes(file.toPath());
        byte[] digest = MessageDigest.getInstance(algorithm).digest(fileContents);
        System.out.printf("%0" + (digest.length*2) + "x%n", new BigInteger(1, digest));
        return 0;
    }

    // this example implements Callable, so parsing, error handling and handling user
    // requests for usage help or version help can be done with one line of code.
    public static void main(String... args) {
        int exitCode = new CommandLine(new CheckSum()).execute(args);
        System.exit(exitCode);
    }
}

@CommandLine.Command(name = "convert",
        mixinStandardHelpOptions = true,
        description = "Converts all tracks in the folder into v2 track file versions",
        version = "1.0")
class SubCommand implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return 0;
    }
}