package org.formhib;
import org.formhib.models.CategoryEntity;
import org.formhib.repositories.CategoryRepository;
import org.formhib.utils.SessionHibernate;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.sql.Timestamp;

public class App {
    public static void main(String[] args) {

        CategoryRepository categoryRepository =new CategoryRepository();
        CategoryEntity cat = new CategoryEntity();
        cat.setCode(5198465);

        Date date=new Date();
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-mm-dd");
        String datetext = df2.format(date);

        cat.setStamp(datetext);
        cat.setId(1);
        cat.setLibelle("blamable87");
        categoryRepository.save(cat);
    }



}
