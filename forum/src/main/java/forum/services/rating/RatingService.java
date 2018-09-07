package forum.services.rating;

import forum.entity.Rating;

public interface RatingService {
    void changeRating(Rating rating);
    double getAvgRating(long commentID, String type);
}
