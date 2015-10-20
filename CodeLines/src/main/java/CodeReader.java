

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class CodeReader {

    Path fileName = Paths.get("/src/main/java", "CodeReader.java");
    private List<String> content;
    private Boolean showComment;
    private Boolean bracketCount;
    private Boolean emptyCount;
    private Boolean showOutput;
    private Boolean isCommentActive = false;
    private Integer lineCountInActiveMode = 0;

    public CodeReader(String Path) {
        load(Path);
        askAboutComments();
        askAboutBrackets();
        askAboutEmptyLines();
        askAboutOutput();
        System.out.println();

        parseContent();

        showLineCount();

    }

    public void load(String Path) {
        try {
            content = Files.readAllLines(fileName, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void askAboutComments() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Do yo want to count comment line? (y/n)");
        char comment = 0;
        try {
            comment = (char) br.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (comment) {
            case 'y':
                showComment = true;
                break;
            case 'n':
                showComment = false;
                break;
            default:
                System.out.println("Wrong key - ShowComments disabled");
                showComment = false;
                break;
        }
    }

    public void askAboutBrackets() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nDo yo want to count Bracket only Lines? (y/n)");
        char x = 0;
        try {
            x = (char) br.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (x) {
            case 'y':
                bracketCount = true;
                break;
            case 'n':
                bracketCount = false;
                break;
            default:
                System.out.println("Wrong key - Bracket Count enabled");
                bracketCount = true;
                break;
        }
    }

    public void askAboutEmptyLines() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nDo yo want to count empty Lines? (y/n)");
        char empty = 0;
        try {
            empty = (char) br.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (empty) {
            case 'y':
                emptyCount = true;
                break;
            case 'n':
                emptyCount = false;
                break;
            default:
                System.out.println("Wrong key - EmptyLine Count disabled");
                emptyCount = true;
                break;
        }
    }

    public void askAboutOutput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nDo yo want to see Output lines? (y/n)");
        char output = 0;
        try {
            output = (char) br.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (output) {
            case 'y':
                showOutput = true;
                break;
            case 'n':
                showOutput = false;
                break;
            default:
                System.out.println("Wrong key - NoOutput disabled");
                showOutput = false;
                break;
        }
    }

    public void parseContent() {
        content.forEach(this::parseLine);
    }

    public void parseLine(String line) {
        String parsed = line.trim();
        if (parseEmpty(parsed)) return;
        if (parseBrackets(parsed)) return;
        if (parseComment(parsed)) return;

        lineCountInActiveMode++;

        showCurrentLine(line);
    }

    public Boolean parseBrackets(String line) {
        return (!bracketCount && line.length() == 1);
    }

    public Boolean parseEmpty(String line) {
        return !emptyCount && line.length() == 0;
    }

    public Boolean parseComment(String line) {
        if (showComment) return false;
        if (line.startsWith("//")) {
            return true;
        }
        if (line.contains("/*")) {
            isCommentActive = true;
            if (line.startsWith("/*")) {
                return true;
            }
        }
        if (line.contains("*/")) {
            isCommentActive = false;
            if (line.startsWith("*/")) {
                return true;
            }
            if (line.endsWith("*/")) {
                return true;
            }
        }
        return isCommentActive;
    }

    public void showCurrentLine(String line) {
        if (showOutput)
            System.out.println("\t" + line);
    }

    public void showLineCount() {
        System.out.println("In this Configuration there is " + lineCountInActiveMode + " lines");
    }
}

