package com.restorauntreviewer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.restorauntreviewer.config.exception.NotAcceptableException;
import com.restorauntreviewer.model.Restaurant;
import com.restorauntreviewer.model.User;
import com.restorauntreviewer.model.Vote;
import com.restorauntreviewer.repository.RestaurantRepository;
import com.restorauntreviewer.repository.UserRepository;
import com.restorauntreviewer.repository.VotingRepository;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {
    public static final LocalTime DEADLINE_VOTE_HOUR = LocalTime.of(11, 0);

    private final VotingRepository votingRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;


    @Autowired
    public VoteServiceImpl(VotingRepository votingRepository, RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.votingRepository = votingRepository;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Vote voteFor(Long restaurantId, Double rate) {
        LocalDate today = LocalDate.now();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String name = ((UserDetails)principal).getUsername();

        User user = userRepository.findByUsername(name);
        if (user == null)
        {
            throw new NotAcceptableException();
        }
        LocalTime now = LocalTime.now();
        List<Vote> todaysVotes = votingRepository.getVotesByUserIdByDate(user.getId(), today);
        //Vote vote = votingRepository.findByRestaurantIdAndUserIdAndDate(restaurantId, authorizedUser.getId(), today).orElse(null);
        Vote vote = todaysVotes == null || todaysVotes.isEmpty() ? null : todaysVotes.get(0);

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        if (restaurant == null)
        {
            throw new NotAcceptableException();
        }


        if (vote == null)
        {
            vote = new Vote(today, rate);
            vote.setRestaurant(restaurant);
            vote.setUser(user);
            return votingRepository.save(vote);
        }
        else if (now.isBefore(DEADLINE_VOTE_HOUR))
        {
            vote.setRate(rate);
            vote.setRestaurant(restaurant);
            return votingRepository.save(vote);
        }
        throw new NotAcceptableException();
    }

}
