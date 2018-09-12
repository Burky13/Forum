package forum.services.rating;

import forum.entity.Comment;
import forum.entity.Rating;
import forum.entity.User;

public interface RatingService {
    void changeRating(Rating rating);
    double getAvgRating(Comment comment);
    double getUserRating(User user);
}
