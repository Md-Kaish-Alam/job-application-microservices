package com.nuwaish.reviewms.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);

    boolean addReviewByCompanyId(Long companyId, Review review);

    Review getReviewById(Long reviewId);

    boolean updateReviewById(Long reviewId, Review updatedReviewData);

    boolean deleteReviewById(Long reviewId);
}
