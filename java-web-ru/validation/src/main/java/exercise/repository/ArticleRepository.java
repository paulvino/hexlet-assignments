package exercise.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import exercise.model.Article;

public class ArticleRepository {
    private static List<Article> entities = new ArrayList<Article>();

    public static void save(Article article) {
        article.setId((long) entities.size() + 1);
        entities.add(article);
    }

    public static List<Article> search(String term) {
        var users = entities.stream()
                .filter(entity -> entity.getTitle().startsWith(term))
                .toList();
        return users;
    }

    public static Article find(Long id) {
        var article = entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findAny()
                .orElse(null);
        return article;
    }

    public static Article findByTitle(String title) {
        var article = entities.stream()
                .filter(entity -> entity.getTitle().equals(title))
                .findAny()
                .orElse(null);
        return article;
    }

    public static boolean existsByTitle(String title) {
        return entities.stream()
                .anyMatch(value -> value.getTitle().equals(title));
    }

    public static List<Article> getEntities() {
        return entities;
    }

    public static void clear() {
        entities.clear();
    }
}
