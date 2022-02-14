package com.sinau.movielocker.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.sinau.movielocker.R
import com.sinau.movielocker.utils.DataDummy
import com.sinau.movielocker.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTvShow = DataDummy.generateDummyTvShow()

    @Before
    fun setup() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyMovie[0].overview)))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(withText(dummyMovie[0].releaseDate)))
        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration)).check(matches(withText(timeConverter(dummyMovie[0].runtime))))
        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(withText("${dummyMovie[0].voteAverage} / 10")))
        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_backdrop)).check(matches(isDisplayed()))

        onView(withId(R.id.cv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.cv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.cv_rating)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShows() {
        onView(withText(R.string.tv_show)).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShow.size
            )
        )
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText(R.string.tv_show)).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShow[0].name)))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyTvShow[0].overview)))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(withText(dummyTvShow[0].firstAirDate)))
        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration)).check(matches(withText(timeConverter(dummyTvShow[0].episodeRunTime))))
        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(withText("${dummyTvShow[0].voteAverage} / 10")))
        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_backdrop)).check(matches(isDisplayed()))

        onView(withId(R.id.cv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.cv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.cv_rating)).check(matches(isDisplayed()))
    }

    @Test
    fun testfavoriteMovie() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.fab_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.fab_favorite)).perform(click())

        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.favorite)).perform(click())

        onView(withId(R.id.rv_favorite_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyMovie[0].overview)))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(withText(dummyMovie[0].releaseDate)))
        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration)).check(matches(withText(timeConverter(dummyMovie[0].runtime))))
        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(withText("${dummyMovie[0].voteAverage} / 10")))
        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_backdrop)).check(matches(isDisplayed()))

        onView(withId(R.id.cv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.cv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.cv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.fab_favorite)).perform(click())

        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.status)).check(matches(isDisplayed()))
    }

    @Test
    fun testFavoriteTvShow() {
        onView(withText(R.string.tv_show)).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.fab_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.fab_favorite)).perform(click())

        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.favorite)).perform(click())

        onView(withText(R.string.favorite_tv_show)).perform(click())
        onView(withId(R.id.rv_favorite_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShow[0].name)))
        onView(withId(R.id.tv_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(matches(withText(dummyTvShow[0].overview)))
        onView(withId(R.id.tv_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_date)).check(matches(withText(dummyTvShow[0].firstAirDate)))
        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration)).check(matches(withText(timeConverter(dummyTvShow[0].episodeRunTime))))
        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(withText("${dummyTvShow[0].voteAverage} / 10")))
        onView(withId(R.id.iv_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_backdrop)).check(matches(isDisplayed()))

        onView(withId(R.id.cv_release)).check(matches(isDisplayed()))
        onView(withId(R.id.cv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.cv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.fab_favorite)).perform(click())

        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.status)).check(matches(isDisplayed()))
    }

    @Test
    fun getFavoriteActivity() {
        onView(withId(R.id.favorite)).perform(click())
        onView(withId(R.id.tabs_fav)).check(matches(isDisplayed()))
        onView(withText(R.string.favorite_movie)).perform(click())
        onView(withText(R.string.favorite_tv_show)).perform(click())
    }

    // bolehkah membuat suatu method di kelas testing?
    private fun timeConverter(time: Int): String {
        return if (time > 60) {
            val timeInHour = time / 60
            val timeInMinute = time - (timeInHour * 60)
            "$timeInHour h $timeInMinute m"
        } else {
            "$time m"
        }
    }
}