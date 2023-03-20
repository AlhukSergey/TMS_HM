package by.teachmeskills.homeworks.hm_31032023.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {
    private static final String FILE1_PATH = "D:\\Study\\TMS\\hm_31032023\\file1.txt";
    private static final String FILE2_PATH = "D:\\Study\\TMS\\hm_31032023\\file2.txt";
    private static final String FILE3_PATH = "D:\\Study\\TMS\\hm_31032023\\file3.txt";
    private static final String FILE1_NAME = "file1.txt";
    private static final String FILE2_NAME = "file2.txt";
    private static final String FILE3_NAME = "file3.txt";
    private static final String ARCHIVE_PATH = "D:\\Study\\TMS\\hm_31032023\\archive.zip";
    private static final String NEW_ARCHIVE_PATH = "D:\\Study\\TMS\\hm_31032023\\archive1.zip";

    public static void main(String[] args) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(ARCHIVE_PATH))) {
            putInArchive(zos, FILE1_PATH, FILE1_NAME);
            putInArchive(zos, FILE2_PATH, FILE2_NAME);
            putInArchive(zos, FILE3_PATH, FILE3_NAME);
            System.out.println("The files was successfully archived!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        File file = new File(ARCHIVE_PATH);
        System.out.println(file.getName());
        File newFile = new File(NEW_ARCHIVE_PATH);
        if (file.renameTo(newFile)) {
            System.out.println("The file successfully renamed.");
        } else {
            System.out.println("The file wasn't renamed.");
        }
        System.out.println(newFile.getName());

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(NEW_ARCHIVE_PATH))) {
            ZipEntry zipEntry;
            String archiveName;

            while ((zipEntry = zis.getNextEntry()) != null) {
                archiveName = zipEntry.getName();
                System.out.printf("File name : %s. \n", archiveName);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        deleteDirectory(Path.of(NEW_ARCHIVE_PATH));
        deleteDirectory(Path.of(ARCHIVE_PATH));
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

    private static void deleteDirectory(Path directory) {
        try {
            Files.walk(directory).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
