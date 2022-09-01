package egorov.org.genres;

import egorov.org.Music;

public class JazzMusic implements Music {
    @Override
    public String getSong() {
        return "Take five";
    }
}