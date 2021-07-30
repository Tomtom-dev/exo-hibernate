package org.formhib.repositories;

import org.formhib.models.CategoryEntity;
import org.formhib.models.CategoryEntity;
import org.formhib.utils.SessionHibernate;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository extends MysqlRepository<CategoryEntity> {
}
