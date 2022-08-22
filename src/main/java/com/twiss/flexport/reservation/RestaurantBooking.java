package com.twiss.flexport.reservation;

import java.time.LocalDate;
import java.util.Date;

/**
 * 餐厅预定系统
 * @Author: Twiss
 * @Date: 2022/8/22 11:27 上午
 */
public class RestaurantBooking {
    class User {
        int userId;
        String name;
        LocalDate dateOfBirth;
        String phoneNum;
        String emailId;
        String sex;
    }

    class Reservation{
        int reservationId;
        Date timeOfReservation;
        int peopleCount;
        ReservationStatus status;
        String note;
        Date checkInTime;
        int bookUserId;
    }

    class Table{
        int tableId;
        TableStatus status;
    }

    class Restaurant{
        int restaurantId;
        String restaurantName;
        int restaurantCode;
        int maxCapacity;
        int locationIdentifier;
    }

    class TableSeat{
        int tableSeatNumber;
        SeatType type;
    }

    class BookInfo{
        int bookId;
        BookStatus status;
        int tableId;
        int mealId;
    }

    class Bill{
        int billId;
        double amount;
        double tip;
        double tax;
        boolean isPaid;
    }

    class Payment{
        int paymentId;
        double amount;
        Date creationData;
    }

    class Meal{
        int mealId;
        int mealItemId;
    }

    class MealItem{
        int mealItemId;
        String title;
        String description;
        double price;
    }

    class Address {

        String city;
        String pinCode;
        String state;
        String streetNo;
        String landmark;
    }
}
