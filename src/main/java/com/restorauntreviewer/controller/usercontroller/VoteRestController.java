package com.restorauntreviewer.controller.usercontroller;
import com.restorauntreviewer.model.Vote;
import com.restorauntreviewer.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = VoteRestController.REST_URL)
public class VoteRestController {

    static final String REST_URL = "/api/v1/users";

    private final VoteService voteService;


    @Autowired
    public VoteRestController(VoteService voteService) {
    this.voteService = voteService;


    }

    @RequestMapping(value = "/vote/{restaurantId}", method = RequestMethod.POST)
    public Vote voteFor(
                        @PathVariable("restaurantId")Long restaurantId,
                        @RequestParam(value = "rate", defaultValue = "0") Double rate
                       ){

        return voteService.voteFor(restaurantId, rate);
    }
}

