package org.eco.mubisoft.good_and_cheap.metric.statistic;



import org.eco.mubisoft.good_and_cheap.metric.domain.service.MetricService;
import org.eco.mubisoft.good_and_cheap.user.domain.model.AppUser;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class ActionCounter {


    private MetricService metricService;

    public ActionCounter(MetricService metricService) {
        this.metricService = metricService;
    }

    public void increment(AppUser appUser, String buttonName) {
        record(1, appUser, buttonName);
    }

    private void record(double count, AppUser appUser, String buttonName) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = format.format(cal.getTime());

        Date date = null;
        try {
            date = format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        metricService.setMetric(buttonName, (int) count,date,appUser);
    }

}
