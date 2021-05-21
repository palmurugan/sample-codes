package com.quantiphi.scheduler.service;

import com.opencsv.exceptions.CsvException;
import com.quantiphi.scheduler.dto.User;

import java.io.IOException;
import java.util.List;

public interface DataReadService {

    List<User> readData() throws IOException, CsvException;
}
