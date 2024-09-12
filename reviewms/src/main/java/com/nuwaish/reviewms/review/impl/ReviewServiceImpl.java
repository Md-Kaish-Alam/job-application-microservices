package com.nuwaish.reviewms.review.impl;

import com.nuwaish.reviewms.review.Review;
import com.nuwaish.reviewms.review.ReviewRepository;
import com.nuwaish.reviewms.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReviewByCompanyId(Long companyId, Review review) {
        if (companyId != null && review != null) {
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean updateReviewById(Long reviewId, Review updatedReviewData) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {
            review.setTitle(updatedReviewData.getTitle());
            review.setDescription(updatedReviewData.getDescription());
            review.setRating(updatedReviewData.getRating());
            review.setCompanyId(updatedReviewData.getCompanyId());
            reviewRepository.save(review);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteReviewById(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
         if (review != null) {
             reviewRepository.delete(review);
             return true;
         }
        return false;
    }
}
