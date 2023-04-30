package Pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data    //getter-setter ve toString() hazirlar
@NoArgsConstructor  //parametresiz consructor hazirlar
@AllArgsConstructor  //parametreli consructor hazirlar



public class PojoHerokuAppBookingDates {
    /*
    {
    	 "checkin" : "2021-06-01",
    	 "checkout" : "2021-06-10"
     }
     */
    private String checkin;
    private String checkout;
}
