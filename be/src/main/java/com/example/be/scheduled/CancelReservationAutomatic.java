package com.example.be.scheduled;

import com.example.be.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CancelReservationAutomatic {

    private boolean shouldRun = false;

    @Scheduled(fixedDelay = 30000, initialDelay = 30000)
    public void cancelReservation(Long seatId) {
        if (shouldRun) {
            // Thực hiện công việc cần lên lịch
            System.out.println("Cron job executed!");
            shouldRun = false;  // Đảm bảo chỉ chạy một lần
        }
    }

    public void activateTask() {
        shouldRun = true;
    }
}
