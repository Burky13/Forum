package forum.services.rating;

import forum.entity.Comment;
import forum.entity.Rating;
import forum.entity.User;

public interface RatingService {
    double getAvgRating(Long id);
    double getUserRating(User user);
    void changeRating(Long id, Rating r);
}
