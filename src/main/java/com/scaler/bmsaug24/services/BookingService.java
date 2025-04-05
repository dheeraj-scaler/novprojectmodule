package com.scaler.bmsaug24.services;

import com.scaler.bmsaug24.exceptions.SeatNotAvailableException;
import com.scaler.bmsaug24.exceptions.ShowNotFoundException;
import com.scaler.bmsaug24.exceptions.UserNotFoundException;
import com.scaler.bmsaug24.models.*;
import com.scaler.bmsaug24.repositories.ShowRepository;
import com.scaler.bmsaug24.repositories.ShowSeatRepository;
import com.scaler.bmsaug24.repositories.ShowSeatTypeRepository;
import com.scaler.bmsaug24.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    ShowRepository showRepository;
    ShowSeatRepository showSeatRepository;
    UserRepository userRepository;
    ShowSeatTypeRepository showSeatTypeRepository;
    PriceCalculationService priceCalculationService;

    public BookingService(ShowRepository showRepository, ShowSeatRepository showSeatRepository, UserRepository userRepository, ShowSeatTypeRepository showSeatTypeRepository, PriceCalculationService priceCalculationService) {
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
        this.showSeatTypeRepository = showSeatTypeRepository;
        this.priceCalculationService = priceCalculationService;
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long showId, List<Long> seatIds) throws UserNotFoundException, ShowNotFoundException, SeatNotAvailableException {
       // 1. Get user info, if not valid user, throw exception
        // 2. Get show info, if not valid show, throw exception
        // 3. Get all showSeatIds, using seatIds
        // 4. Check if all seats are available (check status)
        // 5. Take a lock
        // 6. Check the status again
        // 7. Mark the seat status to blocked
        // 8. Release the lock
        // 9 proceed to payments
        Optional<User> currUser = userRepository.findById(userId);

        if(currUser.isEmpty()) {
            // throw exception
            throw new UserNotFoundException("Invalid user");
        }

        User user = currUser.get();

        Optional<Show> show = showRepository.findById(showId);

        if(show.isEmpty()) {
            throw new ShowNotFoundException("Invalid show");
        }

        Show currShow = show.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(seatIds);

        // check is length of showSeats and seatIds are same
        // check if all the seats are available
        for(ShowSeat showSeat : showSeats) {
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new SeatNotAvailableException("Already booked, bye bye, see you soon");
            }
        }

        // mark the seats as blocked
        for(ShowSeat showSeat : showSeats) {

           showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
           showSeatRepository.save(showSeat);
        }


        Booking booking = new Booking();
        booking.setBookedBy(user);
        booking.setShowSeats(showSeats);
        booking.setAmount(priceCalculationService.getPrice(showSeats, currShow));


        // call payment service
        // make payments

        return booking;

    }
}
