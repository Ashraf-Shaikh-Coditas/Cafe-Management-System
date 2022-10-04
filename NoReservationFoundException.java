public class NoReservationFoundException extends RuntimeException {
    public NoReservationFoundException(String message) {
        System.err.println("No Reservation details found : "+message);
    }
}
