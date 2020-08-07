/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MI_MAK.widget;

import com.toedter.calendar.JCalendar;
import java.awt.BorderLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Imam-pc
 */
public class JCalendarExt extends JCalendar{
    
    /**
         *
         * @param date
         * @param locale
         * @param monthSpinner
         * @param weekOfYearVisible
         * @param colorWeekend
         *      <br>When false, week-first-day will be painted in red, as in  <code>JDayChooser</code>.
         *      <br>When true, week-last-day will be painted in red.
         */

        public JCalendarExt(Date date, Locale locale, boolean monthSpinner, boolean weekOfYearVisible,
                boolean colorWeekend) {

            super(date, locale, monthSpinner, weekOfYearVisible);

            remove(dayChooser);

            //add the extended date chooser
            dayChooser = new JDayChooserExt(weekOfYearVisible) ;
            dayChooser.addPropertyChangeListener(this);
            ((JDayChooserExt) dayChooser).setColorWeekend(colorWeekend);

            monthChooser.setDayChooser(dayChooser);
            yearChooser.setDayChooser(dayChooser);

            add(dayChooser, BorderLayout.CENTER);

        }

        @Override
        public void setCalendar(Calendar c) {

            getDayChooser().setCalendar(c);
            super.setCalendar(c);
        }
    
}
