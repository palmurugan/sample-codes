package com.quantiphi.scheduler.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.quantiphi.scheduler.dto.User;
import com.quantiphi.scheduler.function.CheckedFunction;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CSVDataReadService implements DataReadService {

    private static final String INPUT_PATH = "E:/tmp/input/input.csv";

    /**
     * Function to get the instance of CSVReader
     */
    private final CheckedFunction<String, CSVReader> getCSVReader = (path) -> new CSVReader(new FileReader(path));

    /**
     * Function to convert the String array to an Object
     */
    private final Function<String[], User> convertToUser = (data) -> {
        User user = new User();
        user.setId(Long.parseLong(data[0]));
        user.setName(data[1]);
        user.setAge(Integer.parseInt(data[2]));
        return user;
    };

    /**
     * @return List with User Object
     * @throws IOException
     * @throws CsvException
     */
    @Override
    public List<User> readData() throws IOException, CsvException {
        return getCSVReader.apply(INPUT_PATH).readAll().stream().map(convertToUser).collect(Collectors.toList());
    }
}
