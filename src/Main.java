import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void createFile(String path, StringBuilder sb) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                sb.append("Файл" + " ").append(path).append(" ").append("был создан\n");
            } else {
                sb.append("Файл" + " ").append(path).append(" ").append("не был создан (уже создан или ошибка)\n");
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createDir(String path, StringBuilder sb) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                sb.append("Директория" + " ").append(path).append(" ").append("была создана\n");
            } else {
                sb.append("Директория" + " ").append(path).append(" ").append("не была создана (уже создана или ошибка)\n");
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        ArrayList<String> filepaths = new ArrayList<>();
        filepaths.add("/Users/maximkorchagin/Documents/Games/src");
        filepaths.add("/Users/maximkorchagin/Documents/Games/res");
        filepaths.add("/Users/maximkorchagin/Documents/Games/savegames");
        filepaths.add("/Users/maximkorchagin/Documents/Games/temp");
        filepaths.add("/Users/maximkorchagin/Documents/Games/src/main");
        filepaths.add("/Users/maximkorchagin/Documents/Games/res/test");
        filepaths.add("/Users/maximkorchagin/Documents/Games/src/main/Main.java");
        filepaths.add("/Users/maximkorchagin/Documents/Games/src/main/Utils.java");
        filepaths.add("/Users/maximkorchagin/Documents/Games/res/drawables");
        filepaths.add("/Users/maximkorchagin/Documents/Games/res/vectors");
        filepaths.add("/Users/maximkorchagin/Documents/Games/res/icons");
        filepaths.add("/Users/maximkorchagin/Documents/Games/temp/temp.txt");


        filepaths.forEach(e -> {
            if (e.contains(".")) {
                createFile(e, sb);
            } else {
                createDir(e,sb);
            }
        });

        try (FileOutputStream fos = new FileOutputStream("/Users/maximkorchagin/Documents/Games/temp/temp.txt")) {
            byte[] bytes = sb.toString().getBytes();
            fos.write(bytes, 0, bytes.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


