import java.io.*;

public class App {

    public static void main(String[] args) {
        String function = args[0];
        String fileSource = args[1];
        int key = Integer.parseInt(args[2]);

        StringBuilder sb = new StringBuilder();
        try  {
            BufferedReader reader = new BufferedReader(new FileReader(fileSource));
            while(reader.ready()) {
                sb.append((char)reader.read());
            }
        }
        catch (IOException e) {
            System.out.println("Something done wrong" + e.getMessage());;
        }

        String replacementFileName = "(" + function + "d).txt";
        String DestinationFile = fileSource.replaceAll("\\.txt", replacementFileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DestinationFile))) {
            writer.write(Decoder.decode(sb.toString(), key, Decoder.engAlphabet));
        }
        catch (IOException e) {
            System.out.println("Something done wrong" + e.getMessage());
        }
    }
}
