package entities;

import config.Config;

import java.io.Serializable;

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SlangEntity)) {
            return false;
        }
        SlangEntity other = (SlangEntity) o;
        return word.equals(other.word) && definition.equals(other.definition);
    }

    @Override
    public String toString() {
        return word + Config.PROPERTY_SEPARATOR  + definition;
    }
}
