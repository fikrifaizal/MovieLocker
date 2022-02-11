package com.sinau.movielocker.utils

import com.sinau.movielocker.data.source.local.entity.MovieEntity
import com.sinau.movielocker.data.source.local.entity.TvShowEntity
import com.sinau.movielocker.data.source.remote.response.movie.MovieResponse
import com.sinau.movielocker.data.source.remote.response.tvshow.TvShowResponse

object DataDummy {

    fun generateDummyMovie(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
            425909,
            "Ghostbusters: Afterlife",
            "When a single mom and her two kids arrive in a small town, they begin to discover their connection to the original Ghostbusters and the secret legacy their grandfather left behind.",
            "2021-11-11",
            124,
            "/sg4xJaufDiQl7caFEskBtQXfD4x.jpg",
            "/EnDlndEvw6Ptpp8HIwmRcSSNKQ.jpg",
            7.7
        ))

        movies.add(
            MovieEntity(
            524434,
            "Eternals",
            "The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants.",
            "2021-11-03",
            156,
            "/bcCBq9N1EMo3daNIjWJ8kYvrQm6.jpg",
            "/k2twTjSddgLc1oFFHVibfxp2kQV.jpg",
            7.3
        ))

        movies.add(
            MovieEntity(
            585083,
            "Hotel Transylvania: Transformania",
            "When Van Helsing's mysterious invention, the 'Monsterfication Ray', goes haywire, Drac and his monster pals are all transformed into humans, and Johnny becomes a monster. In their new mismatched bodies, Drac and Johnny must team up and race across the globe to find a cure before it's too late, and before they drive each other crazy.",
            "2022-01-13",
            87,
            "/teCy1egGQa0y8ULJvlrDHQKnxBL.jpg",
            "/m3Ys7UDzUzOyoPYKzp4GhKKokUr.jpg",
            7.6
        ))

        movies.add(
            MovieEntity(
            568124,
            "Encanto",
            "The tale of an extraordinary family, the Madrigals, who live hidden in the mountains of Colombia, in a magical house, in a vibrant town, in a wondrous, charmed place called an Encanto. The magic of the Encanto has blessed every child in the family with a unique gift from super strength to the power to heal—every child except one, Mirabel. But when she discovers that the magic surrounding the Encanto is in danger, Mirabel decides that she, the only ordinary Madrigal, might just be her exceptional family's last hope.",
            "2021-11-24",
            102,
            "/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg",
            "/3G1Q5xF40HkUBJXxt2DQgQzKTp5.jpg",
            7.8
        ))

        movies.add(
            MovieEntity(
            438695,
            "Sing 2",
            "Buster and his new cast now have their sights set on debuting a new show at the Crystal Tower Theater in glamorous Redshore City. But with no connections, he and his singers must sneak into the Crystal Entertainment offices, run by the ruthless wolf mogul Jimmy Crystal, where the gang pitches the ridiculous idea of casting the lion rock legend Clay Calloway in their show. Buster must embark on a quest to find the now-isolated Clay and persuade him to return to the stage.",
            "2021-12-01",
            110,
            "/aWeKITRFbbwY8txG5uCj4rMCfSP.jpg",
            "/tutaKitJJIaqZPyMz7rxrhb4Yxm.jpg",
            8.3
        ))

        movies.add(
            MovieEntity(
            425909,
            "Ghostbusters: Afterlife",
            "When a single mom and her two kids arrive in a small town, they begin to discover their connection to the original Ghostbusters and the secret legacy their grandfather left behind.",
            "2021-11-11",
            124,
            "/sg4xJaufDiQl7caFEskBtQXfD4x.jpg",
            "/EnDlndEvw6Ptpp8HIwmRcSSNKQ.jpg",
            7.7
        ))

        movies.add(
            MovieEntity(
            860623,
            "Last Man Down",
            "After civilization succumbs to a deadly pandemic and his wife is murdered, a special forces soldier abandons his duty and becomes a hermit in the Nordic wilderness. Years later, a wounded woman appears on his doorstep. She's escaped from a lab and her pursuers believe her blood is the key to a worldwide cure. He's hesitant to get involved, but all doubts are cast aside when he discovers her pursuer is none other than Commander Stone, the man that murdered his wife some years ago.",
            "2021-10-19",
            87,
            "/4B7liCxNCZIZGONmAMkCnxVlZQV.jpg",
            "/t4To8feUSysyBs4tlBAbXIrKlCv.jpg",
            6.7
        ))

        movies.add(
            MovieEntity(
            460458,
            "Resident Evil: Welcome to Raccoon City",
            "Once the booming home of pharmaceutical giant Umbrella Corporation, Raccoon City is now a dying Midwestern town. The company’s exodus left the city a wasteland…with great evil brewing below the surface. When that evil is unleashed, the townspeople are forever…changed…and a small group of survivors must work together to uncover the truth behind Umbrella and make it through the night.",
            "2021-11-24",
            107,
            "/7uRbWOXxpWDMtnsd2PF3clu65jc.jpg",
            "/o76ZDm8PS9791XiuieNB93UZcRV.jpg",
            6.1
        ))

        movies.add(
            MovieEntity(
            624860,
            "The Matrix Resurrections",
            "Plagued by strange memories, Neo's life takes an unexpected turn when he finds himself back inside the Matrix.",
            "2021-12-16",
            148,
            "/8c4a8kE7PizaGQQnditMmI1xbRp.jpg",
            "/eNI7PtK6DEYgZmHWP9gQNuff8pv.jpg",
            6.8
        ))

        movies.add(
            MovieEntity(
            580489,
            "Venom: Let There Be Carnage",
            "After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady.",
            "2021-09-30",
            97,
            "/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg",
            "/vIgyYkXkg6NC2whRbYjBD7eb3Er.jpg",
            7.1
        ))

        movies.add(
            MovieEntity(
            811592,
            "One Shot",
            "An elite squad of Navy SEALs, on a covert mission to transport a prisoner off a CIA black site island prison, are trapped when insurgents attack while trying to rescue the same prisoner.",
            "2021-11-05",
            97,
            "/3OXiTjU30gWtqxmx4BU9RVp2OTv.jpg",
            "/srJ7haOhfykoPOYPQrstOaFem08.jpg",
            6.8
        ))

        return movies
    }

    fun generateDummyTvShow(): List<TvShowEntity> {
        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(
            TvShowEntity(
                966,
                "Hollyoaks",
                "The daily soap that follows the loves, lives and misdemeanours of a group of people living in the Chester village of Hollyoaks where anything could, and frequently does, happen...",
                "1995-10-23",
                30,
                "/bpmLMZP3M1vLujPqHnOTnKVjRJY.jpg",
                "/r8CGqB8IJNbA1IruHWquS7YttNB.jpg",
                5.2
            ))

        tvShow.add(
            TvShowEntity(
            85552,
            "Euphoria",
            "A group of high school students navigate love and friendships in a world of drugs, sex, trauma, and social media.",
            "2019-06-16",
            60,
            "/jtnfNzqZwN4E32FGGxx1YZaBWWf.jpg",
            "/oKt4J3TFjWirVwBqoHyIvv5IImd.jpg",
            8.4
        ))

        tvShow.add(
            TvShowEntity(
            110492,
            "Peacemaker",
            "The continuing story of Peacemaker – a compellingly vainglorious man who believes in peace at any cost, no matter how many people he has to kill to get it – in the aftermath of the events of “The Suicide Squad.”",
            "2022-01-13",
            46,
            "/hE3LRZAY84fG19a18pzpkZERjTE.jpg",
            "/ctxm191q5o3axFzQsvNPlbKoSYv.jpg",
            8.6
        ))

        tvShow.add(
            TvShowEntity(
            115036,
            "The Book of Boba Fett",
            "Legendary bounty hunter Boba Fett and mercenary Fennec Shand must navigate the galaxy’s underworld when they return to the sands of Tatooine to stake their claim on the territory once ruled by Jabba the Hutt and his crime syndicate.",
            "2021-12-29",
            46,
            "/gNbdjDi1HamTCrfvM9JeA94bNi2.jpg",
            "/sjx6zjQI2dLGtEL0HGWsnq6UyLU.jpg",
            8.1
        ))

        tvShow.add(
            TvShowEntity(
            99966,
            "All of Us Are Dead",
            "A high school becomes ground zero for a zombie virus outbreak. Trapped students must fight their way out — or turn into one of the rabid infected.",
            "2022-01-28",
            61,
            "/ze4lhw0oLBHYmlM2KuZjBg0Sq6H.jpg",
            "/8Xs20y8gFR0W9u8Yy9NKdpZtSu7.jpg",
            8.4
        ))

        tvShow.add(
            TvShowEntity(
            153748,
            "Big Brother Famosos",
            "Big Brother Famosos is the celebrity version of Big Brother Portugal.",
            "2002-09-08",
            60,
            "/ynFd1Xmr2r05qPqalNZnh2uxuJ0.jpg",
            "/z18KvDvFftrNyAMPOVFHkt8Bj8E.jpg",
            4.5
        ))

        tvShow.add(
            TvShowEntity(
            116416,
            "Big Brother 7/7",
            "",
            "2021-01-11",
            46,
            "/iUYrQyv0p4UncFolsROm81VNbcB.jpg",
            "/ykbaElzavtSbsYG5KbG3pEpREtK.jpg",
            5.1
        ))

        tvShow.add(
            TvShowEntity(
            60574,
            "Peaky Blinders",
            "A gangster family epic set in 1919 Birmingham, England and centered on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby, who means to move up in the world.",
            "2013-09-12",
            59,
            "/pE8CScObQURsFZ723PSW1K9EGYp.jpg",
            "/wiE9doxiLwq3WCGamDIOb2PqBqc.jpg",
            8.6
        ))

        tvShow.add(
            TvShowEntity(
            63174,
            "Lucifer",
            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            "2016-01-25",
            53,
            "/ekZobS8isE6mA53RAiGDG93hBxL.jpg",
            "/ktDJ21QQscbMNQfPpZBsNORxdDx.jpg",
            8.5
        ))

        tvShow.add(
            TvShowEntity(
            77169,
            "Cobra Kai",
            "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
            "2018-05-02",
            30,
            "/6POBWybSBDBKjSs1VAQcnQC1qyt.jpg",
            "/35SS0nlBhu28cSe7TiO3ZiywZhl.jpg",
            8.2
        ))

        return tvShow
    }

    fun generateRemoteDummyMovie(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()

        movies.add(MovieResponse(
            "/EnDlndEvw6Ptpp8HIwmRcSSNKQ.jpg",
            "When a single mom and her two kids arrive in a small town, they begin to discover their connection to the original Ghostbusters and the secret legacy their grandfather left behind.",
            "Ghostbusters: Afterlife",
            "2021-11-11",
            7.7,
            124,
            425909,
            "/sg4xJaufDiQl7caFEskBtQXfD4x.jpg"
        ))

        movies.add(MovieResponse(
            "/p3ajeXwrCczDh8eYsT8ryTvvfwm.jpg",
            "An ex-NYPD officer-turned-sheriff of a small rural Georgia town has to contend with a gang of thieves who have taken a wealthy doctor hostage.",
            "American Siege",
            "2022-01-07",
            5.0,
            90,
            766907,
            "/daeVrgyj0ue8qb3AHyU3UeCwoZz.jpg"
        ))

        movies.add(MovieResponse(
            "/dK12GIdhGP6NPGFssK2Fh265jyr.jpg",
            "An Interpol-issued Red Notice is a global alert to hunt and capture the world's most wanted. But when a daring heist brings together the FBI's top profiler and two rival criminals, there's no telling what will happen.",
            "Red Notice",
            "2021-11-04",
            6.8,
            117,
            524434,
            "/lAXONuqg41NwUMuzMiFvicDET9Y.jpg"
        ))

        movies.add(MovieResponse(
            "/iQFcwSGbZXMkeyKrxbPnwnRo5fl.jpg",
            "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
            "Spider-Man: No Way Home",
            "2021-12-15",
            8.4,
            148,
            634649,
            "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
        ))

        movies.add(MovieResponse(
            "/5MJt6g7k9gADQH4xHn5mOEMa3Vr.jpg",
            "When Van Helsing's mysterious invention, the 'Monsterfication Ray', goes haywire, Drac and his monster pals are all transformed into humans, and Johnny becomes a monster. In their new mismatched bodies, Drac and Johnny must team up and race across the globe to find a cure before it's too late, and before they drive each other crazy.",
            "Hotel Transylvania: Transformania",
            "2022-01-13",
            7.6,
            87,
            585083,
            "/9nR1xIcDo84gbbNZeFb9NCZYTdw.jpg"
        ))

        movies.add(MovieResponse(
            "/k2twTjSddgLc1oFFHVibfxp2kQV.jpg",
            "The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants.",
            "Eternals",
            "2021-11-03",
            7.2,
            156,
            524434,
            "/bcCBq9N1EMo3daNIjWJ8kYvrQm6.jpg"
        ))

        movies.add(MovieResponse(
            "/3G1Q5xF40HkUBJXxt2DQgQzKTp5.jpg",
            "The tale of an extraordinary family, the Madrigals, who live hidden in the mountains of Colombia, in a magical house, in a vibrant town, in a wondrous, charmed place called an Encanto. The magic of the Encanto has blessed every child in the family with a unique gift from super strength to the power to heal—every child except one, Mirabel. But when she discovers that the magic surrounding the Encanto is in danger, Mirabel decides that she, the only ordinary Madrigal, might just be her exceptional family's last hope.",
            "Encanto",
            "2021-11-24",
            7.8,
            102,
            568124,
            "/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg"
        ))

        movies.add(MovieResponse(
            "/tutaKitJJIaqZPyMz7rxrhb4Yxm.jpg",
            "Buster and his new cast now have their sights set on debuting a new show at the Crystal Tower Theater in glamorous Redshore City. But with no connections, he and his singers must sneak into the Crystal Entertainment offices, run by the ruthless wolf mogul Jimmy Crystal, where the gang pitches the ridiculous idea of casting the lion rock legend Clay Calloway in their show. Buster must embark on a quest to find the now-isolated Clay and persuade him to return to the stage.",
            "Sing 2",
            "2021-12-01",
            8.3,
            110,
            438695,
            "/aWeKITRFbbwY8txG5uCj4rMCfSP.jpg"
        ))

        movies.add(MovieResponse(
            "/t4To8feUSysyBs4tlBAbXIrKlCv.jpg",
            "After civilization succumbs to a deadly pandemic and his wife is murdered, a special forces soldier abandons his duty and becomes a hermit in the Nordic wilderness. Years later, a wounded woman appears on his doorstep. She's escaped from a lab and her pursuers believe her blood is the key to a worldwide cure. He's hesitant to get involved, but all doubts are cast aside when he discovers her pursuer is none other than Commander Stone, the man that murdered his wife some years ago.",
            "Last Man Down",
            "2021-10-19",
            6.7,
            87,
            860623,
            "/4B7liCxNCZIZGONmAMkCnxVlZQV.jpg"
        ))

        movies.add(MovieResponse(
            "/srJ7haOhfykoPOYPQrstOaFem08.jpg",
            "An elite squad of Navy SEALs, on a covert mission to transport a prisoner off a CIA black site island prison, are trapped when insurgents attack while trying to rescue the same prisoner.",
            "One Shot",
            "2021-11-05",
            6.8,
            97,
            811592,
            "/3OXiTjU30gWtqxmx4BU9RVp2OTv.jpg"
        ))

        movies.add(MovieResponse(
            "/o76ZDm8PS9791XiuieNB93UZcRV.jpg",
            "Once the booming home of pharmaceutical giant Umbrella Corporation, Raccoon City is now a dying Midwestern town. The company’s exodus left the city a wasteland…with great evil brewing below the surface. When that evil is unleashed, the townspeople are forever…changed…and a small group of survivors must work together to uncover the truth behind Umbrella and make it through the night.",
            "Resident Evil: Welcome to Raccoon City",
            "2021-11-24",
            6.1,
            107,
            460458,
            "/7uRbWOXxpWDMtnsd2PF3clu65jc.jpg"
        ))

        return movies
    }

    fun generateRemoteDummyTvShow(): List<TvShowResponse> {
        val tvShow = ArrayList<TvShowResponse>()

        tvShow.add(TvShowResponse(
            "/oKt4J3TFjWirVwBqoHyIvv5IImd.jpg",
            "2019-06-16",
            "A group of high school students navigate love and friendships in a world of drugs, sex, trauma, and social media.",
            8.4,
            "Euphoria",
            listOf(60),
            85552,
            "/jtnfNzqZwN4E32FGGxx1YZaBWWf.jpg"
        ))

        tvShow.add(TvShowResponse(
            "/ctxm191q5o3axFzQsvNPlbKoSYv.jpg",
            "2022-01-13",
            "The continuing story of Peacemaker – a compellingly vainglorious man who believes in peace at any cost, no matter how many people he has to kill to get it – in the aftermath of the events of “The Suicide Squad.”",
            8.6,
            "Peacemaker",
            listOf(46),
            110492,
            "/hE3LRZAY84fG19a18pzpkZERjTE.jpg"
        ))

        tvShow.add(TvShowResponse(
            "/sjx6zjQI2dLGtEL0HGWsnq6UyLU.jpg",
            "2021-12-29",
            "Legendary bounty hunter Boba Fett and mercenary Fennec Shand must navigate the galaxy’s underworld when they return to the sands of Tatooine to stake their claim on the territory once ruled by Jabba the Hutt and his crime syndicate.",
            8.1,
            "The Book of Boba Fett",
            listOf(39,53),
            115036,
            "/gNbdjDi1HamTCrfvM9JeA94bNi2.jpg"
        ))

        tvShow.add(TvShowResponse(
            "/8Xs20y8gFR0W9u8Yy9NKdpZtSu7.jpg",
            "2022-01-28",
            "A high school becomes ground zero for a zombie virus outbreak. Trapped students must fight their way out — or turn into one of the rabid infected.",
            8.8,
            "All of Us Are Dead",
            listOf(60),
            99966,
            "/pTEFqAjLd5YTsMD6NSUxV6Dq7A6.jpg"
        ))

        tvShow.add(TvShowResponse(
            "/r8CGqB8IJNbA1IruHWquS7YttNB.jpg",
            "1995-10-23",
            "The daily soap that follows the loves, lives and misdemeanours of a group of people living in the Chester village of Hollyoaks where anything could, and frequently does, happen...",
            5.2,
            "Hollyoaks",
            listOf(30),
            966,
            "/bpmLMZP3M1vLujPqHnOTnKVjRJY.jpg"
        ))

        tvShow.add(TvShowResponse(
            "/pkOSjcllDSs4WP9i8DGkw9VgF5Q.jpg",
            "2015-07-06",
            "",
            7.7,
            "Wer weiß denn sowas?",
            listOf(45),
            63452,
            "/abKjah96esLWObidBcWmvKJv61E.jpg"
        ))

        tvShow.add(TvShowResponse(
            "/pkKUW6wk2yfPc66YF7647ARi6uv.jpg",
            "2009-10-05",
            "Audience members dress up in outlandish costumes to get host Wayne Brady's attention in an attempt to make deals for trips, prizes, cars or cash, while trying to avoid the dreaded Zonks.",
            5.5,
            "Let's Make a Deal",
            listOf(0),
            114439,
            "/8lQkzJCwPpB0P6GieQeojUOW6PU.jpg"
        ))

        tvShow.add(TvShowResponse(
            "/4tYspgwxmK2XRjhi71tuY6R2iGv.jpg",
            "2020-07-15",
            "Married Alma spends a fateful weekend away from home that ignites passion, ends in tragedy and leads her to question the truth about those close to her.",
            7.3,
            "Dark Desire",
            listOf(35),
            105214,
            "/uxFNAo2A6ZRcgNASLk02hJUbybn.jpg"
        ))

        tvShow.add(TvShowResponse(
            "/vjcuLy14kxgxCaBToAudZWrGQQh.jpg",
            "2021-01-18",
            "Three lucky contestants put their pop culture knowledge to the test to complete iconic, People Puzzler crosswords. The player with the most points at the end of three rounds wins the game and goes on to play the \"Fast Puzzle Round\" for an enormous cash prize.",
            5.5,
            "People Puzzler",
            listOf(23),
            117031,
            "/gELQSCY5KKIGQAmOHbcgcRGNlp5.jpg"
        ))

        tvShow.add(TvShowResponse(
            "/l6zdjUDOaklBWfxqa7AtbLr2EnA.jpg",
            "2021-12-13",
            "A drama depicting a sweet twist in love between the parents and children of three families around the love of two main characters.",
            4.5,
            "Love Twist",
            listOf(30),
            135753,
            "/5bTF522eYn6g6r7aYqFpTZzmQq6.jpg"
        ))

        return tvShow
    }
}