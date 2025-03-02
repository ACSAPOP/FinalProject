package com.AndreaPop.Automation.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CSVReader {
    public static List<Map<String,String>> readCSV(String filePath) {
        List<Map<String,String>> recordsList = new ArrayList<>();

        try (Reader reader = new FileReader(filePath)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .get()
                    .parse(reader);

            for (CSVRecord record : records) {
                recordsList.add(record.toMap());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return recordsList;
    }
}
