package org.example.pifinder.services.impl;

import org.example.pifinder.services.PiFinder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class PiFinderImpl implements PiFinder {

    @Override
    public String parsingFileWithPi(){
        Resource resource = new ClassPathResource("100m.txt");
        try {
            return new String(Files.readAllBytes(Paths.get(resource.getURI())));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int searchForNumberIndex(String number) {
        String pi = parsingFileWithPi();
        int index = pi.indexOf(number);
        searchForSubstringsFromIndex(pi, index);
        return index;
    }

    @Override
    public String searchForSubstringsFromIndex(String pi, int index ) {
        int start = Math.max(0, index - 10);
        int end = Math.min(pi.length(), index + 10);
        return pi.substring(start, end);
    }



}
