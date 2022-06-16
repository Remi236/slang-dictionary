package entities;

import java.io.Serializable;
import java.util.Scanner;

public class SlangEntity  implements Serializable {
    private static final long serialVersionUID = -6500665823330706018L;
    String word;
    String definition;

    public String getWord() { return word; }

    public String getDefinition() { return definition; }

    public void setWord(String word) { this.word = word; }

    public void setDefinition(String definition) { this.definition = definition; }

    public SlangEntity() {
        setWord("");
        setDefinition("");
    }

    public SlangEntity(String word, String definition) {
        setWord(word);
        setDefinition(definition);
    }

    public SlangEntity(SlangEntity s){
        setWord(s.getWord());
        setDefinition(s.getDefinition());
    }

    public void scanSlang() {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập slang word: ");
        word = in.nextLine();
        System.out.println("Nhập định nghĩa của slang word: ");
        definition = in.nextLine();
    }

    public void showSlang() {
        System.out.println("Slang word: "+ word);
        System.out.println("Định nghĩa: "+ definition);
    }
}
