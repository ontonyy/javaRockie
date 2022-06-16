package structural.adapter.time;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Time time = new Time() {
            @Override
            public int getSeconds() {
                return LocalTime.now().getSecond();
            }

            @Override
            public int getMinutes() {
                return LocalTime.now().getMinute();
            }

            @Override
            public int getHours() {
                return LocalTime.now().getHour();
            }
        };

        TotalTime totalTime = new TimeAdapter(time);
        System.out.println(totalTime.getTotalSecond());

        TotalTime totalTime1 = new TotalTime() {
            @Override
            public int getTotalSecond() {
                LocalTime time = LocalTime.now();
                return time.getSecond() + time.getMinute() * 60 + time.getHour() * 3600;
            }
        };

        Time time1 = new TotalTimeAdapter(totalTime1);
        System.out.println(time1.getSeconds());
        System.out.println(time1.getMinutes());
        System.out.println(time1.getHours());
    }
}
