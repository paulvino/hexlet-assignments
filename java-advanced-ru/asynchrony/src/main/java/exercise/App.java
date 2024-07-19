package exercise;

import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String file1Path, String file2Path, String destPath) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Path path1 = Paths.get(file1Path);
                Path path2 = Paths.get(file2Path);
                Path destFilePath = Paths.get(destPath);

                if (!Files.exists(path1) || !Files.exists(path2)) {
                    throw new NoSuchFileException("NoSuchFileException: Один или оба исходных файла не существуют.");
                }

                String content1 = Files.readString(path1);
                String content2 = Files.readString(path2);
                String combinedContent = content1 + content2;

                Files.writeString(destFilePath, combinedContent);

                return "Файл успешно создан и сохранен в: " + destFilePath;
            } catch (NoSuchFileException e) {
                System.out.println("Exception: " + e.getMessage());
                return "Operation failed: " + e.getMessage();
            } catch (Exception e) {
                System.out.println("An error occured: " + e.getMessage());
                return "Operation failed: " + e.getMessage();
            }
        });
    }
    // END

    public static void main(String[] args) {
        // BEGIN
        CompletableFuture<String> result = unionFiles(
                "src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/result.txt");

        result.thenAccept(System.out::println);

        result.join();
        // END
    }
}

