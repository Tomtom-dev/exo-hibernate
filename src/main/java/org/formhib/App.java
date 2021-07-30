package org.formhib;

import org.formhib.models.CategoryEntity;
import org.formhib.repositories.CategoryRepository;
import org.formhib.utils.SessionHibernate;

public class App {
    public static void main(String[] args) {

        CategoryRepository categoryRepository =new CategoryRepository();
        CategoryEntity cat = new CategoryEntity();
        cat.setCode(5198465);
        cat.setLibelle("blamable87");
        categoryRepository.save(cat);


    }

}
