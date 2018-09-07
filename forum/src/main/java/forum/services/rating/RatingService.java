package forum.services.rating;

import forum.Entity.Rating;

public interface RatingService {
    void changeRating(Rating rating);
    double getAvgRating(long commentID);
}
