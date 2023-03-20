package by.teachmeskills.homeworks.hm_31032023.zip;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    private static final String FILE1_PATH = "D:\\Study\\TMS\\hm_31032023\\file1.txt";
    private static final String FILE2_PATH = "D:\\Study\\TMS\\hm_31032023\\file2.txt";
    private static final String FILE3_PATH = "D:\\Study\\TMS\\hm_31032023\\file3.txt";
    private static final String FILE1_NAME = "file1.txt";
    private static final String FILE2_NAME = "file2.txt";
    private static final String FILE3_NAME = "file3.txt";
    private static final String ARCHIVE_PATH = "D:\\Study\\TMS\\hm_31032023\\archive.zip";

    public static void main(String[] args) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(ARCHIVE_PATH))) {
            putInArchive(zos, FILE1_PATH, FILE1_NAME);
            putInArchive(zos, FILE2_PATH, FILE2_NAME);
            putInArchive(zos, FILE3_PATH, FILE3_NAME);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void putInArchive(ZipOutputStream zos, String filePath, String fileName) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            ZipEntry entry = new ZipEntry(fileName);
            zos.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zos.write(buffer);
            zos.closeEntry();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
