package com.sinau.movielocker.utils

import com.sinau.movielocker.data.MovieEntity
import com.sinau.movielocker.data.TvShowEntity

object DataDummy {

    fun generateDummyMovie(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(MovieEntity(
            1,
            "Alita",
            "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa.",
            "14 Februari 2019",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
            "https://www.themoviedb.org/t/p/original/aQXTw3wIWuFMy0beXRiZ1xVKtcf.jpg",
            7.2
        ))

        movies.add(MovieEntity(
            2,
            "Aquaman",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "26 Desember 2018",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
            "https://www.themoviedb.org/t/p/original/skauHPLA4so9PqOuu3jhWmiWnFd.jpg",
            6.9
        ))

        movies.add(MovieEntity(
            3,
            "Bohemian Rhapsody",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            "30 Oktober 2018",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
            "https://www.themoviedb.org/t/p/original/xCovjYbHFUo8diFPzMwGj23VbWL.jpg",
            8.0
        ))

        movies.add(MovieEntity(
            4,
            "Cold Pursuit",
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
            "08 Februari 2019",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
            "https://www.themoviedb.org/t/p/original/3nRAYvw47ymAC7isQg12av1Dgeg.jpg",
            5.7
        ))

        movies.add(MovieEntity(
            5,
            "How to Train Your Dragon: The Hidden World",
            "Ketika Hiccup memenuhi mimpinya untuk menciptakan utopia naga yang damai, penemuan Toothless 'dari pasangan yang tak teruji dan sukar ditangkap membuat Night Fury menjauh. Ketika bahaya meningkat di rumah dan pemerintahan Hiccup sebagai kepala desa diuji, baik naga dan pengendara harus membuat keputusan yang mustahil untuk menyelamatkan jenis mereka.",
            "09 Januari 2019",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bCYRgsT0Kndh23a6kHazBdXWCn1.jpg",
            "https://www.themoviedb.org/t/p/original/5XnMD0UKNXE7FdrfvWeOaeOEsHB.jpg",
            7.8
        ))

        movies.add(MovieEntity(
            6,
            "Avengers: Infinity War",
            "Karena Avengers dan sekutunya terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh seorang pahlawan, bahaya baru telah muncul dari bayangan kosmik: Thanos. Seorang lalim penghujatan intergalaksi, tujuannya adalah untuk mengumpulkan semua enam Batu Infinity, artefak kekuatan yang tak terbayangkan, dan menggunakannya untuk menimbulkan kehendak memutar pada semua realitas. Segala sesuatu yang telah diperjuangkan oleh Avengers telah berkembang hingga saat ini - nasib Bumi dan keberadaannya sendiri tidak pernah lebih pasti.",
            "27 April 2018",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
            "https://www.themoviedb.org/t/p/original/lmZFxXgJE3vgrciwuDib0N8CfQo.jpg",
            8.3
        ))

        movies.add(MovieEntity(
            7,
            "Mortal Engines",
            "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
            "14 Desember 2018",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg",
            "https://www.themoviedb.org/t/p/original/rxYG6Sj95as9rv9wKIHUx6ATWd3.jpg",
            6.2
        ))

        movies.add(MovieEntity(
            8,
            "Overlord",
            "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
            "09 November 2018",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/l76Rgp32z2UxjULApxGXAPpYdAP.jpg",
            "https://www.themoviedb.org/t/p/original/nMo6AWCYagsNoopuDF5xKzNGcNO.jpg",
            6.7
        ))

        movies.add(MovieEntity(
            9,
            "Ralph Breaks the Internet",
            "Petualangan Baru Ralph dan Vanellope akan berlanjut dalam Ralph Breaks the Internet. 6 tahun pasca Wreck-It Ralph, Ralph dan Vanellope kini semakin jauh menjelajah ke dunia maya.",
            "21 November 2018",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/44cb3fCGKUaSxxIjI2ejrgeYfye.jpg",
            "https://www.themoviedb.org/t/p/original/88poTBTafMXaz73vYi3c74g0y2k.jpg",
            7.2
        ))

        movies.add(MovieEntity(
            10,
            "Spider-Man: Into the Spider-Verse",
            "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
            "14 Desember 2018",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/3cZn1k8x0bikrDKEy9ZKJ6Vdj30.jpg",
            "https://www.themoviedb.org/t/p/original/jqwM0nhOLEFI1HHBabwr80Od3TC.jpg",
            8.4
        ))

        movies.add(MovieEntity(
            11,
            "T-34",
            "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
            "01 Januari 2019",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/3nag9eCEMIo4yVZD7sKLodEPe8T.jpg",
            "https://www.themoviedb.org/t/p/original/daJjtHlqvph7R1Uw1DFUIF0FJe4.jpg",
            7.0
        ))

        return movies
    }

    fun generateDummyTvShow(): List<TvShowEntity> {
        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(TvShowEntity(
            1,
            "The Arrow",
            "Arrow adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow.",
            "10 Oktober 2012",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
            "https://www.themoviedb.org/t/p/original/elbLQbocvW9vwrHRjYTSjXr5BX5.jpg",
            6.7
        ))

        tvShow.add(TvShowEntity(
            2,
            "Doom Patrol",
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            "15 Februari 2019",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/kOAn06LmRCg4YiSStwrGL6UOQ3a.jpg",
            "https://www.themoviedb.org/t/p/original/b7unxzWSFfj7i6UVmuPixxxXFOF.jpg",
            7.7
        ))

        tvShow.add(TvShowEntity(
            3,
            "Dragon Ball (ドラゴンボール)",
            "Dahulu kala di pegunungan, seorang master pertempuran yang dikenal sebagai Gohan menemukan seorang bocah aneh yang ia beri nama Goku. Gohan membesarkannya dan melatih Goku dalam seni bela diri sampai dia mati. Bocah muda dan sangat kuat itu sendirian, tetapi mudah dikelola. Kemudian suatu hari, Goku bertemu dengan seorang gadis remaja bernama Bulma, yang pencariannya untuk bola naga membawanya ke rumah Goku. Bersama-sama, mereka berangkat untuk menemukan ketujuh bola naga dalam sebuah petualangan yang akan mengubah hidup Goku selamanya. Lihat bagaimana Goku bertemu teman-teman seumur hidupnya Bulma, Yamcha, Krillin, Master Roshi dan banyak lagi.",
            "26 Februari 1986",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/n7WLT6AEcwBtDhIfxjBOBAU9FAV.jpg",
            "https://www.themoviedb.org/t/p/original/nokCMxb0u5YtLsu7RGs4oUiA8DK.jpg",
            8.2
        ))

        tvShow.add(TvShowEntity(
            4,
            "Fairy Tail (フェアリーテイル)",
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
            "12 Oktober 2009",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/r6SjKZSsVbdwVZhdutu4qvRe63c.jpg",
            "https://www.themoviedb.org/t/p/original/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg",
            7.8
        ))

        tvShow.add(TvShowEntity(
            5,
            "Family Guy",
            "Seri animasi animasi Freakin 'Sweet yang sakit, terpelintir, dan salah, menampilkan petualangan keluarga Griffin yang disfungsional. Peter yang kikuk dan Lois yang sudah lama menderita memiliki tiga anak. Stewie (bayi yang brilian tetapi sadis yang bertekad membunuh ibunya dan mengambil alih dunia), Meg (yang tertua, dan merupakan gadis yang paling tidak populer di kota) dan Chris (anak tengah, dia tidak terlalu cerdas tetapi memiliki hasrat untuk film ). Anggota terakhir keluarga itu adalah Brian - anjing yang bisa bicara dan lebih dari sekadar hewan peliharaan, ia menjaga Stewie, sementara menghirup Martinis dan memilah-milah masalah hidupnya sendiri.",
            "31 Januari 1999",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/k9DaMmzL1cRkHbxrCBlP9rb9B5B.jpg",
            "https://www.themoviedb.org/t/p/original/4h4HETnteDE5wAEptaghTO7KS9Q.jpg",
            7.1
        ))

        tvShow.add(TvShowEntity(
            6,
            "Grey's Anatomy",
            "Ikuti kehidupan pribadi dan profesional sekelompok dokter di Rumah Sakit Gray Sloan Memorial di Seattle.",
            "27 Maret 2005",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
            "https://www.themoviedb.org/t/p/original/423ZsS0NqAH5u20qHsPdrTGICye.jpg",
            8.2
        ))

        tvShow.add(TvShowEntity(
            7,
            "Hanna",
            "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
            "28 Maret 2019",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iYUtjx1EN4SVTgxd2TB4cZTGSQb.jpg",
            "https://www.themoviedb.org/t/p/original/ufTMyMIdns5cbbBRgMKHrNIXYvM.jpg",
            7.6
        ))

        tvShow.add(TvShowEntity(
            8,
            "Marvel's Iron Fist",
            "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
            "17 Maret 2017",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7uCpMX3ktMdztlezDBRiMstmapC.jpg",
            "https://www.themoviedb.org/t/p/original/usaahoewrcCAD0fFOb9DoUg8hOR.jpg",
            6.6
        ))

        tvShow.add(TvShowEntity(
            9,
            "Naruto Shippuden",
            "Naruto Shippuuden adalah kelanjutan dari serial TV animasi asli Naruto. Kisah ini berkisah tentang Uzumaki Naruto yang lebih tua dan sedikit lebih matang dan upayanya untuk menyelamatkan temannya Uchiha Sasuke dari cengkeraman Shinobi seperti ular, Orochimaru. Setelah 2 setengah tahun, Naruto akhirnya kembali ke desanya Konoha, dan mulai mewujudkan ambisinya, meskipun itu tidak akan mudah, karena Ia telah mengumpulkan beberapa musuh (lebih berbahaya), seperti organisasi shinobi. ; Akatsuki.",
            "15 Februari 2007",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qOxedwaJzdms2alAmIEHEnDeDzg.jpg",
            "https://www.themoviedb.org/t/p/original/dTFnU3EQB79aDM4HnUj06Y9Xbq1.jpg",
            8.6
        ))

        tvShow.add(TvShowEntity(
            10,
            "Simpsons",
            "Bertempat di Springfield, kota rata-rata di Amerika, pertunjukan ini berfokus pada kejenakaan dan petualangan sehari-hari keluarga Simpson; Homer, Marge, Bart, Lisa dan Maggie, serta ribuan pemain virtual. Sejak awal, serial ini telah menjadi ikon budaya pop, menarik ratusan selebriti menjadi bintang tamu. Acara ini juga menjadi terkenal karena satirnya yang tak kenal takut terhadap kehidupan politik, media, dan Amerika secara umum.",
            "17 Desember 1989",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/k5UALlcA0EnviaCUn2wMjOWYiOO.jpg",
            "https://www.themoviedb.org/t/p/original/qLTucZq7cti7C5WbfwbbHA14iYY.jpg",
            7.9
        ))

        return tvShow
    }
}