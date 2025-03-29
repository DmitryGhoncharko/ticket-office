package cinema.ticketoffice.service;

import cinema.ticketoffice.dto.ReviewDTO;
import cinema.ticketoffice.mapper.ReviewMapper;
import cinema.ticketoffice.model.Review;
import cinema.ticketoffice.model.User;
import cinema.ticketoffice.repository.ReviewRepository;
import cinema.ticketoffice.repository.UserRepository;
import cinema.ticketoffice.service.userdetails.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService extends GenericService<Review, ReviewDTO> {

    private UserRepository userRepository;

    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        repository = reviewRepository;
        mapper = reviewMapper;
    }


    @Override
    public ReviewDTO create(ReviewDTO reviewDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long userId = Long.valueOf(((CustomUserDetails) authentication.getPrincipal()).getUserId());
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            Review review = mapper.toEntity(reviewDTO);
            review.setUser(user);
            review.setCreatedBy(authentication.getName());
            review.setCreatedWhen(LocalDateTime.now());
            return mapper.toDTO(repository.save(review));
        }
        return null;
    }


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
