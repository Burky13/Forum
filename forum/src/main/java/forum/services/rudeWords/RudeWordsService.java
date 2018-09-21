package forum.services.rudeWords;

import forum.entity.RudeWords;

import java.util.List;

public interface RudeWordsService {

    List<RudeWords> getAllWords();
    void addWord(RudeWords rudeWords);
    void delete(Long id);
    boolean findWord(String word);
    List<String> allRudeWords();
}
