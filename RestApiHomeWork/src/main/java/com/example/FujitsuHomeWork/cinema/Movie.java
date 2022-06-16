package com.example.FujitsuHomeWork.cinema;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.example.FujitsuHomeWork.cinema.Constants.*;

public class Movie {
    private String title, released;
    private List<String> actors;
    private List<String> genre;
    private float rating;
    private int payBox;
    private float price;
    private long releaseDay;

    private int rentDays;
    private long rentDate;

    /**
     * Movie that have metadata, and that client can rent
     * @param title of movie
     * @param genre list of genres
     * @param released day
     * @param actors list of actors
     * @param rating on IMDB
     * @param payBox box-office
     */
    public Movie(String title, List<String> genre, String released, List<String> actors, float rating, int payBox) {
        this.title = title;
        this.genre = genre;
        this.released = released;
        this.actors = actors;
        this.rating = rating;
        this.payBox = payBox;
        this.rentDays = -1;
        this.rentDate = -1;
        formatReleaseDay();
        setPrice();
    }

    /**
     * Format released variable without word,
     * and set releaseDay with int
     */
    private void formatReleaseDay() {
        try {
            SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
            String month = released.substring(3, 6);
            released = released.replace(month, parseMonth(month));
            releaseDay = myFormat.parse(released).getTime() / convertDays;

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param days of rent
     * @return price that movie will have for some time
     */
    public float getMoviePriceForDays(int days) {
        int indexDays = 0;
        float priceByDays = 0;
        long daysRelease = releaseDay;
        while (indexDays <= days) {
            setPriceByReleaseDay(daysRelease);
            if (indexDays % 7 == 0) {
                indexDays = 0;
                days -= 7;
                priceByDays += price;
            }
            daysRelease--;
            indexDays++;
        }
        return priceByDays;
    }

    /**
     * Check movie release date with now date and set price
     * @param day of release
     */
    public void setPriceByReleaseDay(Long day) {
        long curDate = new Date().getTime() / convertDays;
        if (curDate - day < 364) {
            price = 5;
        } else if (curDate - day < 1092) {
            price = 3.49f;
        } else {
            price = 1.99f;
        }
        price = (float) (Math.round(price * 100.0) / 100.0);
    }

    public void setPrice() {
        setPriceByReleaseDay(releaseDay);
    }

    /**
     * @param month
     * @return numerical String from word String
     */
    public String parseMonth(String month) {
        return switch (month.toLowerCase()) {
            case "jan" -> "01";
            case "feb" -> "02";
            case "mar" -> "03";
            case "apr" -> "04";
            case "may" -> "05";
            case "jun" -> "06";
            case "jul" -> "07";
            case "aug" -> "08";
            case "sep" -> "09";
            case "oct" -> "10";
            case "nov" -> "11";
            case "dec" -> "12";
            default -> "";
        };
    }

    public float getPrice() {
        setPrice();
        return price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getPayBox() {
        return payBox;
    }

    public void setPayBox(int payBox) {
        this.payBox = payBox;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    /**
     * @return -1, if rent days is -1, or check rent date and return rentDays
     */
    public int getRentDays() {
        if (rentDays == -1) return rentDays;
        else return (int) (rentDays - (getNowDate() - getRentDate()));
    }

    public void setRentDays(int rentDays) {
        this.rentDays = rentDays;
    }

    public void setRentDateNull() {
        this.rentDate = -1;
    }

    public long getRentDate() {
        return rentDate;
    }

    public void setRentDate() {
        this.rentDate = getNowDate();
    }

    public long getNowDate() {
        return new Date().getTime() / convertDays;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", released='" + released + '\'' +
                ", actors=" + actors +
                ", genre=" + genre +
                ", rating=" + rating +
                ", payBox=" + payBox +
                ", price=" + price +
                '}';
    }
}
