package patterns.Adapter;

public class TimeAdapter implements TotalTime {
    private Time time;

    public TimeAdapter(Time time) {
        this.time = time;
    }

    @Override
    public int getTotalSecond() {
        return time.getSeconds() + time.getMinutes() * 60 + time.getHours() * 3600;
    }
}
