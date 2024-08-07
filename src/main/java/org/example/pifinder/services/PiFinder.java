package org.example.pifinder.services;

import java.io.IOException;

public interface PiFinder {
    public String parsingFileWithPi() throws IOException;
    public int searchForNumberIndex(String number);
    public String searchForSubstringsFromIndex(String pi, int index );
}
