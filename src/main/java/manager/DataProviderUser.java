package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginDataSuccess(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setEmail("ssa@gmail.com").setPassword("Ssa12345$")});
        list.add(new Object[]{new User().setEmail("saa@gmail.com").setPassword("Saa12345$")});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginDataWrongEmail(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setEmail("ssagmail.com").setPassword("Ssa12345$")});
        list.add(new Object[]{new User().setEmail("@gmail.com").setPassword("Ssa12345$")});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginDataWrongEmailEmpty(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setEmail("").setPassword("Ssa12345$")});
        return list.iterator();
    }
}
