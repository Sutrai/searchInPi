package org.example.pifinder.services.impl;

import org.example.pifinder.services.PiFinder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class PiFinderImpl implements PiFinder {

    @Override
    public String piSearch(String number) throws IOException {
        Resource resource = new ClassPathResource("100m.txt");
        String piNumber = new String(Files.readAllBytes(Paths.get(resource.getURI())));
        if (piNumber.contains(number)){
            return "1";
        } return "0";
    }
}
