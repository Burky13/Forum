package forum.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class RudeWords implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String rudeWord;

    public RudeWords(){

    }
    public RudeWords(String rudeWord){
        this.rudeWord = rudeWord;
    }

    public String getRudeWord() {
        return rudeWord;
    }

    public void setRudeWord(String rudeWord) {
        this.rudeWord = rudeWord;
    }

    public long getId() {
        return id;
    }
}
