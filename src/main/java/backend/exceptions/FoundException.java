package backend.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class FoundException
{
    public static void catchException(Exception e) throws FileNotFoundException {
        FoundException s = new FoundException();
        FileOutputStream streamToFile = new FileOutputStream(new File("exception.txt"), true);
        PrintStream ps = new PrintStream(streamToFile);
        e.printStackTrace(ps);
    }
}
