package com.epam.lab;

import com.google.common.base.Stopwatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

import static com.epam.lab.Constants.FILE_200MB;
import static com.epam.lab.Constants.REWRITTEN_FILE_200MB;
import static com.epam.lab.Constants.USER_DIR;

class Solution {
    private final static Logger LOG = LogManager.getLogger(Solution.class);

    static void writeUsingBufferWriter(int bufferSize) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(System.getProperty(USER_DIR) + FILE_200MB)), bufferSize);
             BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(
                     new FileOutputStream(System.getProperty(USER_DIR) + REWRITTEN_FILE_200MB)))) {
            int symbol;
            while ((symbol = reader.read()) != -1) {
                char text = (char) symbol;
                fileWriter.write(text);
            }
        } catch (FileNotFoundException e) {
            LOG.info("File not found. " + e.getMessage());
        } catch (Exception e) {
            LOG.info("Some problem with file. ");
        }
        LOG.info(String.format("Buffer size: %d, spent time: %d second", bufferSize, stopwatch.elapsed().getSeconds()));
    }

    static void writeUsingFileWriter() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        try (FileReader reader = new FileReader(System.getProperty(USER_DIR) + FILE_200MB);
             FileWriter fileWriter = new FileWriter(System.getProperty(USER_DIR) + REWRITTEN_FILE_200MB)) {
            int symbol;
            while ((symbol = reader.read()) != -1) {
                char text = (char) symbol;
                fileWriter.write(text);
            }
        } catch (FileNotFoundException e) {
            LOG.info("File not found. " + e.getMessage());
        } catch (Exception exception) {
            LOG.info(exception.getMessage());
        }
        LOG.info(String.format("Spent time: %d second", stopwatch.elapsed().getSeconds()));
    }

    static void writeUsingOutputStreamWriter() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        try (InputStreamReader reader = new InputStreamReader(
                new FileInputStream(System.getProperty(USER_DIR) + FILE_200MB));
             OutputStreamWriter fileWriter = new OutputStreamWriter(
                     new FileOutputStream(System.getProperty(USER_DIR) + REWRITTEN_FILE_200MB))) {
            int symbol;
            while ((symbol = reader.read()) != -1) {
                char text = (char) symbol;
                fileWriter.write(text);
            }
        } catch (FileNotFoundException e) {
            LOG.info("File not found. " + e.getMessage());
        } catch (Exception e) {
            LOG.info("Some problem with file. ");
        }
        LOG.info(String.format("Spent time: %d second", stopwatch.elapsed().getSeconds()));
    }
}