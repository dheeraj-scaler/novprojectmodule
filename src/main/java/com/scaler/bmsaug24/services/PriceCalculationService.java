package com.scaler.bmsaug24.services;

import com.scaler.bmsaug24.models.Show;
import com.scaler.bmsaug24.models.ShowSeat;
import com.scaler.bmsaug24.models.ShowSeatType;
import com.scaler.bmsaug24.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculationService {

    ShowSeatTypeRepository  showSeatTypeRepository;

    public PriceCalculationService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int getPrice(List<ShowSeat> showSeats, Show show) {
        // get showseatType by showid
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAll();

        int amount = 0;

        for(ShowSeat showSeat : showSeats) {
            for(ShowSeatType showSeatType: showSeatTypes) {
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }


        return amount;
    }

}
