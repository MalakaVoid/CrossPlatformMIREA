package ru.mirea.azbukin.rickmorty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Info {

    @JsonProperty
    private int count;

    @JsonProperty
    private int pages;

    public int getCount() {
        return count;
    }

    public int getPages() {
        return pages;
    }

}
