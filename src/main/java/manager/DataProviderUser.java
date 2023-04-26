package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    @DataProvider
    public Iterator<Object[]> loginDataFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/file.csv.csv"));
        String line = reader.readLine();
        while (line!=null)
        {
            String[] all = line.split(",");
            list.add(new Object[]{new User().setEmail(all[0]).setPassword(all[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
