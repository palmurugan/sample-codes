package com.quantiphi.scheduler.service;

import com.opencsv.CSVWriter;
import com.quantiphi.scheduler.function.CheckedFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;

@Service
public class CSVDataWriteService implements DataWriteService {

    private static final Logger logger = LoggerFactory.getLogger(CSVDataWriteService.class);
    private static final String OUTPUT_PATH = "E:/tmp/output/output.csv";

    /**
     * Function to create a File writer
     */
    private final CheckedFunction<String, Writer> getWriter = path -> Files.newBufferedWriter(Paths.get(OUTPUT_PATH));

    /**
     * Function to create a CSV writer with required parameter
     */
    private final Function<Writer, CSVWriter> getCSVWriter = writer ->
            new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);


    @Override
    public void writeData() {

    }
}
