package com.rifafauzi.moviecatalogue.utils;

import com.rifafauzi.moviecatalogue.model.Movies;

import java.util.ArrayList;

public class FakeDataDummy {

    public static ArrayList<Movies> generateDummyMovies() {
        ArrayList<Movies> movies = new ArrayList<>();

        movies.add(new Movies(
                "m1",
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "movie_a_start_is_born",
                "October 3, 2018",
                "https://youtu.be/nSbzyEJ8X9E"));
        movies.add(new Movies(
                "m2",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "movie_alita",
                "January 31, 2019",
                "https://youtu.be/aj8mN_7Apcw"));
        movies.add(new Movies(
                "m3",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "movie_aquaman",
                "December 7, 2018",
                "https://youtu.be/WDkg3h8PCVU"));
        movies.add(new Movies(
                "m4",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "movie_bohemian",
                "October 24, 2018",
                "https://youtu.be/HlRd9Zy25zo"));
        movies.add(new Movies(
                "m5",
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "movie_cold_persuit",
                "February 7, 2019",
                "https://youtu.be/0phuNQQ_gHI"));
        movies.add(new Movies(
                "m6",
                "Creed",
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                "movie_creed",
                "November 25, 2015",
                "https://youtu.be/Uv554B7YHk4"));
        movies.add(new Movies(
                "m7",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "movie_crimes",
                "November 14, 2018",
                "https://youtu.be/5sEaYB4rLFQ"));
        movies.add(new Movies(
                "m8",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "movie_glass",
                "January 16, 2019",
                "https://youtu.be/95ghQs5AmNk"));
        movies.add(new Movies(
                "m9",
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "movie_how_to_train",
                "January 3, 2019",
                "https://youtu.be/qNGLuCijKZ0"));
        movies.add(new Movies(
                "m10",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "movie_infinity_war",
                "April 25, 2018",
                "https://youtu.be/sAOzrChqmd0"));

        return movies;

    }

}
