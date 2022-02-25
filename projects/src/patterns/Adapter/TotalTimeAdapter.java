package patterns.Adapter;

public class TotalTimeAdapter implements Time {
    private TotalTime totalTime;

    public TotalTimeAdapter(TotalTime totalTime) {
        this.totalTime = totalTime;
    }


    @Override
    public int getSeconds() {
        return totalTime.getTotalSecond() % 60;
    }

    @Override
    public int getMinutes() {
        return (totalTime.getTotalSecond() / 60) % 60;
    }

    @Override
    public int getHours() {
        return totalTime.getTotalSecond() / 3600;
    }
}
