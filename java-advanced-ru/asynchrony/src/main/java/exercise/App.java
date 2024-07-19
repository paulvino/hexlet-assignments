package exercise;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

class App {

    // BEGIN
    private static Path getFullPath(String filePath) {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

    public static CompletableFuture<String> unionFiles(String file1Path, String file2Path, String destPath) {

        CompletableFuture<String> content1 = CompletableFuture.supplyAsync(() -> {
            String content = "";

            try {
                content = Files.readString(getFullPath(file1Path));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return content;
        });

        CompletableFuture<String> content2 = CompletableFuture.supplyAsync(() -> {
            String content = "";

            try {
                content = Files.readString(getFullPath(file2Path));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return content;
        });

        return content1.thenCombine(content2, (cont1, cont2) -> {
            String union = cont1 + cont2;
            try {
                Files.writeString(getFullPath(destPath), union, StandardOpenOption.CREATE);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return "ok!";

        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception – " + ex.getMessage());
            return "Unknown";
        });
    }

    public static CompletableFuture<Long> getDirectorySize(String path) {
        var directory = new File(path);

        if (!directory.isDirectory()) {
            return CompletableFuture.completedFuture(0L);
        }

        File[] files = directory.listFiles();

        CompletableFuture<Long>[] fileSizes = Arrays.stream(files)
                .filter(File::isFile)
                .map(file -> CompletableFuture.supplyAsync(() -> file.length()))
                .toArray(CompletableFuture[]::new);

        return CompletableFuture.allOf(fileSizes)
                .thenApply(v -> Arrays.stream(fileSizes)
                    .mapToLong(CompletableFuture::join)
                    .sum());

    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> result = unionFiles(
                "src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/dest.txt");

        CompletableFuture<Long> size = getDirectorySize("src/main/resources");
        result.get();
        System.out.println("done");
        System.out.println(size.get());
        // END
    }
}

