package com.tgrajkowski.model.job;

//import org.apache.poi.hssf.record.formula.functions.Int;

import com.tgrajkowski.model.job.active.title.ActiveTitle;
import com.tgrajkowski.model.job.active.user.ActiveUser;
import com.tgrajkowski.model.job.daily.JobDaily;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class JobDaoIml {
    @PersistenceContext
    private EntityManager em;

    static final String JOBS_FOR_EACH_DAY = "Jobs-For-Each-Day";
    static final String DATA_FOR_MONTHLY_CHART = "Data-For-Monthly-Chart";
    static final String THE_MOST_ACTIVE_USER ="The-Most-Active-User";
    static final String THE_MOST_ACTIVE_TITLE ="The-Most-Active-Title";

    public List<JobDaily> findjobsForEachDay() {
        Query query = em.createNativeQuery(
                "select date_trunc('day', date), count(id) from jobs group by date_trunc('day', date) ORDER BY date_trunc('day', date) DESC",
                JOBS_FOR_EACH_DAY);
        return query.getResultList();
    }

    public List<JobDaily> findDataForMonthlyChart() {
        Query query = em.createNativeQuery(
                "SELECT DATE_TRUNC('day', date) AS date_trunc, count(id) " +
                        "FROM jobs " +
                        "WHERE date >= DATE_TRUNC('month', NOW()) " +
                        "GROUP BY date_trunc " +
                        "ORDER BY date_trunc DESC",
                DATA_FOR_MONTHLY_CHART);
        return query.getResultList();
    }

    public List<ActiveUser> findTheMostActiveUsers() {
        Query query = em.createNativeQuery(
                "SELECT u.login, count(*) count " +
                        "FROM users u " +
                        "INNER JOIN jobs j ON u.id = j.user_id " +
                        "WHERE date >= DATE_TRUNC('month', NOW()) " +
                        "GROUP BY u.login ORDER BY count DESC LIMIT 10;",
                THE_MOST_ACTIVE_USER
        );
        return query.getResultList();
    }

    public List<ActiveTitle> findTheMostActiveTitle() {
        Query query =  em.createNativeQuery(
                "SELECT j.title, count(*) count " +
                        "FROM users u " +
                        "INNER JOIN jobs j ON u.id = j.user_id " +
                        "WHERE date >= DATE_TRUNC('month', NOW()) " +
                        "GROUP BY j.title " +
                        "ORDER BY count DESC LIMIT 10;", THE_MOST_ACTIVE_TITLE);
        return query.getResultList();
    }
}
