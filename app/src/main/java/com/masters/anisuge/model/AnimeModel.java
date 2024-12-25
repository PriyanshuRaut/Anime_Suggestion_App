package com.masters.anisuge.model;

import java.util.List;

public class AnimeModel {

    public static class Pagination {
        public int lastVisiblePage;
        public boolean hasNextPage;
        public int currentPage;
        public PaginationItems items;
    }

    public static class PaginationItems {
        public int count;
        public int total;
        public int perPage;
    }

    public static class ImageSet {
        public String imageUrl;
        public String smallImageUrl;
        public String largeImageUrl;
    }

    public static class TrailerImages {
        public String imageUrl;
        public String smallImageUrl;
        public String mediumImageUrl;
        public String largeImageUrl;
        public String maximumImageUrl;
    }

    public static class Trailer {
        public String youtubeId;
        public String url;
        public String embedUrl;
        public TrailerImages images;
    }

    public static class Title {
        public String type;
        public String title;
    }

    public static class AiredProp {
        public int day;
        public int month;
        public int year;
    }

    public static class Aired {
        public String fromDate;
        public String toDate;
        public Prop prop;
        public String string;

        public static class Prop {
            public AiredProp from;
            public AiredProp to;
        }
    }

    public static class Producer {
        public int malId;
        public String type;
        public String name;
        public String url;
    }

    public static class Studio {
        public int malId;
        public String type;
        public String name;
        public String url;
    }

    public static class Genre {
        public int malId;
        public String type;
        public String name;
        public String url;
    }

    public static class AnimeData {
        public int malId;
        public String url;
        public ImageSet images;
        public Trailer trailer;
        public boolean approved;
        public List<Title> titles;
        public String title;
        public String titleEnglish;
        public String titleJapanese;
        public List<String> titleSynonyms;
        public String type;
        public String source;
        public int episodes;
        public String status;
        public boolean airing;
        public Aired aired;
        public String duration;
        public String rating;
        public double score;
        public int scoredBy;
        public int rank;
        public int popularity;
        public int members;
        public int favorites;
        public String synopsis;
        public String background;
        public String season;
        public int year;
        public Broadcast broadcast;
        public List<Producer> producers;
        public List<Producer> licensors;
        public List<Studio> studios;
        public List<Genre> genres;
        public List<Genre> explicitGenres;
        public List<Genre> themes;
        public List<Genre> demographics;

        public static class Broadcast {
            public String day;
            public String time;
            public String timezone;
            public String string;
        }
    }

    public Pagination pagination;
    public List<AnimeData> data;
}
