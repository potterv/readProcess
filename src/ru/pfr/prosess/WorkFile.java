package ru.pfr.prosess;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WorkFile {
    public void copy(File pathSource, File pathTo) throws IOException {
        Files.copy(pathSource.toPath(),pathTo.toPath());
    }

}
