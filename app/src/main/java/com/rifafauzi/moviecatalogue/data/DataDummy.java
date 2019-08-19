package com.rifafauzi.moviecatalogue.data;

import com.rifafauzi.moviecatalogue.model.MovieModel;
import com.rifafauzi.moviecatalogue.model.TvShowModel;

import java.util.ArrayList;

public class DataDummy {

    public static ArrayList<MovieModel> generateDummyMovies() {
        ArrayList<MovieModel> movies = new ArrayList<>();

        movies.add(new MovieModel(
                "m1",
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "movie_a_start_is_born",
                "October 3, 2018",
                "https://youtu.be/nSbzyEJ8X9E"));
        movies.add(new MovieModel(
                "m2",
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "movie_alita",
                "January 31, 2019",
                "https://youtu.be/aj8mN_7Apcw"));
        movies.add(new MovieModel(
                "m3",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "movie_aquaman",
                "December 7, 2018",
                "https://youtu.be/WDkg3h8PCVU"));
        movies.add(new MovieModel(
                "m4",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "movie_bohemian",
                "October 24, 2018",
                "https://youtu.be/HlRd9Zy25zo"));
        movies.add(new MovieModel(
                "m5",
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "movie_cold_persuit",
                "February 7, 2019",
                "https://youtu.be/0phuNQQ_gHI"));
        movies.add(new MovieModel(
                "m6",
                "Creed",
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                "movie_creed",
                "November 25, 2015",
                "https://youtu.be/Uv554B7YHk4"));
        movies.add(new MovieModel(
                "m7",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "movie_crimes",
                "November 14, 2018",
                "https://youtu.be/5sEaYB4rLFQ"));
        movies.add(new MovieModel(
                "m8",
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "movie_glass",
                "January 16, 2019",
                "https://youtu.be/95ghQs5AmNk"));
        movies.add(new MovieModel(
                "m9",
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "movie_how_to_train",
                "January 3, 2019",
                "https://youtu.be/qNGLuCijKZ0"));
        movies.add(new MovieModel(
                "m10",
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "movie_infinity_war",
                "April 25, 2018",
                "https://youtu.be/sAOzrChqmd0"));

        return movies;

    }

    public static ArrayList<TvShowModel> generateDummyTvShow() {
        ArrayList<TvShowModel> tvShow = new ArrayList<>();

        tvShow.add(new TvShowModel(
                "tv1",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "tvshow_arrow",
                "October 10, 2012",
                "https://youtu.be/hTv13EjlLNg"));
        tvShow.add(new TvShowModel(
                "tv2",
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "tvshow_doom_patrol",
                "February 15, 2019",
                "https://youtu.be/6wtGnnLfTqA"));
        tvShow.add(new TvShowModel(
                "tv3",
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure that would change Goku's life forever. See how Goku met his life long friends Bulma, Yamcha, Krillin, Master Roshi and more. And see his adventures as a boy, all leading up to Dragonball Z and later Dragonball GT.",
                "tvshow_dragon_ball",
                "February 26, 1986",
                "https://youtu.be/y_0APzy4BcU"));
        tvShow.add(new TvShowModel(
                "tv4",
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "tvshow_fairytail",
                "October 12, 2009",
                "https://youtu.be/29jsKEZN1ag"));
        tvShow.add(new TvShowModel(
                "tv5",
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "tvshow_family_guy",
                "January 31, 1999",
                "https://youtu.be/t3VtKdoPIYE"));
        tvShow.add(new TvShowModel(
                "tv6",
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "tvshow_flash",
                "October 7, 2014",
                "https://youtu.be/Yj0l7iGKh8g"));
        tvShow.add(new TvShowModel(
                "tv7",
                "Game of Thrones",
                "Leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "tvshow_god",
                "April 17, 2011",
                "https://youtu.be/BpJYNVhGf1s"));
        tvShow.add(new TvShowModel(
                "tv8",
                "Gotham",
                "Before there was Batman, there was GOTHAM. Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "tvshow_gotham",
                "October 10, 2012",
                "https://youtu.be/0d1zpt6k5OI"));
        tvShow.add(new TvShowModel(
                "tv9",
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "tvshow_grey_anatomy",
                "March 27, 2005",
                "https://youtu.be/q1pcpgREQ5c"));
        tvShow.add(new TvShowModel(
                "tv10",
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "tvshow_hanna",
                "March 28, 2019",
                "https://youtu.be/wp6myRLnhAs"));

        return tvShow;
    }

}
