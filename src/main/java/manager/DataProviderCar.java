package manager;

import models.Car;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderCar {

    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addDataNewCarSuccess(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("M3")
                .year("2022")
                .fuel("Petrol")
                .seats(5)
                .carClass("C")
                .carRegNumber("198-72613-003")
                .price(50)
                .about("Very nice car")
                .build()});
        list.add(new Object[]{Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Nissan")
                .model("A2")
                .year("2004")
                .fuel("Petrol")
                .seats(5)
                .carClass("C")
                .carRegNumber("198-72613-004")
                .price(50)
                .build()});
        return list.iterator();
    }
}
