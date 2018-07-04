package com.epam.lab;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

import static com.epam.lab.Solution.writeUsingFileWriter;
import static com.epam.lab.Solution.writeUsingOutputStreamWriter;

public class Main {
    private final static Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        //Comparing performance of buffered reader with different buffer size (10 different size).
        List<Integer> list = Arrays.asList(250, 200, 150, 100, 75, 50, 20, 10, 5, 1);
        LOG.info("Reading and writing using BufferWriter:");
        list.forEach(Solution::writeUsingBufferWriter);

        //Comparing performance of FileReader
        LOG.info("\nReading and writing using FileWriter:");
        writeUsingFileWriter();

        //Comparing performance of OutputStreamReader
        LOG.info("\nReading and writing using OutputStreamWriter:");
        writeUsingOutputStreamWriter();
    }
}