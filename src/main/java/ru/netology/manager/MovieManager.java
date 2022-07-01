package ru.netology.manager;

public class MovieManager {

    private String[] movies = new String[0];
    private int limit;

    public MovieManager() {
        limit = 10;
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public void add(String movie) {
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] finsLast() {
        String[] ans;
        if (limit < movies.length) {
            ans = new String[limit];
        } else {
            ans = new String[movies.length];
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = movies[movies.length - i - 1];
        }
        return ans;
    }
}

