package org.example.pifinder.services.impl;

import jakarta.annotation.PostConstruct;
import org.example.pifinder.services.PiFinder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class PiFinderImpl implements PiFinder {

    private static String pi;

    @PostConstruct
    public void init() {
        try {
            pi = Files.readString(Paths.get(new ClassPathResource("100m.txt").getURI()));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read pi file", e);
        }
    }

    @Override
    public List<String> findIndex(String number) {
        List<String> resultArr = new ArrayList<>();
        int index = pi.indexOf(number);

        if (index == -1) {
            resultArr.add("Number not found in pi");
        } else {
            String before = getSubstringBefore(index);
            String after = getSubstringAfter(index, number.length());
            addResult(resultArr, before, number, after, index);
        }
        return resultArr;
    }

    private String getSubstringBefore(int index) {
        int startIndex = Math.max(0, index - 10);
        return pi.substring(startIndex, index);
    }

    private String getSubstringAfter(int index, int length) {
        int endIndex = Math.min(pi.length(), index + length + 10);
        return pi.substring(index + length, endIndex);
    }

    private void addResult(List<String> resultArr, String before, String number, String after, int index) {
        resultArr.add(before);
        resultArr.add(number);
        resultArr.add(after);
        resultArr.add(String.valueOf(index));
    }
}

