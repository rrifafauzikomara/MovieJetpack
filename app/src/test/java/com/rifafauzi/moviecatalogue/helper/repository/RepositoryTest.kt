package com.rifafauzi.moviecatalogue.helper.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.rifafauzi.moviecatalogue.helper.remote.RemoteDataSource
import com.rifafauzi.moviecatalogue.model.Movies
import com.rifafauzi.moviecatalogue.model.TvShow
import com.rifafauzi.moviecatalogue.utils.FakeData
import com.rifafauzi.moviecatalogue.utils.LiveDataTestUtil
import org.junit.*
import org.mockito.Mockito

class RepositoryTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remoteRepository = Mockito.mock(RemoteDataSource::class.java)
    private val dataRepositoryTest = FakeRepository(remoteRepository)

    private val movieList = FakeData.generateDummyMovies()
    private val movieDetail = FakeData.getMovieDetail()
    private val movieId = movieList[0].id.toString()
    private lateinit var movie : Movies

    private val tvShowsList = FakeData.generateDummyTvShow()
    private val tvShowsDetail = FakeData.getTvShowsDetail()
    private val tvShowId = tvShowsList[0].id.toString()
    private lateinit var tvShow : TvShow



    @Before
    fun setUp() {
        movie = Movies(
                "/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg",
                "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
                "2019-07-12",
                420818,
                "The Lion King"
        )

        tvShow = TvShow(
                "/b71BaRjp9TwxUZodLGgSRIlkfL8.jpg",
                "The dramatisation of one of the most notorious killing sprees in British history.",
                "",
                11634,
                ""
        )
    }

    @After
    fun tearDown() {

    }

    @Test
    fun getTvShowsDetail() {
        Mockito.doAnswer {
            val callback = it.arguments[1] as RemoteDataSource.GetTvShowDetailCallback
            callback.onTvShowDetailLoaded(tvShowsDetail)
            null
        }.`when`(remoteRepository).getTvShowDetail(
                Mockito.eq(tvShowId),
                Mockito.any(RemoteDataSource.GetTvShowDetailCallback::class.java))

        val result = LiveDataTestUtil.getValue(dataRepositoryTest.getTvShowsDetail(tvShowId))
        Mockito.verify(
                remoteRepository,
                Mockito.times(1)).getTvShowDetail(Mockito.eq(tvShowId), Mockito.any(RemoteDataSource.GetTvShowDetailCallback::class.java))
        Assert.assertEquals(tvShowsDetail.id, result.id)

    }

    @Test
    fun getTvShowsList() {
        Mockito.doAnswer {
            val callback = it.arguments[0] as RemoteDataSource.GetTvShowCallback
            callback.onTvShowLoaded(tvShowsList)
            null
        }.`when`(remoteRepository).getListTvShow(Mockito.any(RemoteDataSource.GetTvShowCallback::class.java))

        val result = LiveDataTestUtil.getValue(dataRepositoryTest.getTvShowsList())
        Mockito.verify(remoteRepository, Mockito.times(1)).getListTvShow(Mockito.any(RemoteDataSource.GetTvShowCallback::class.java))

        Assert.assertEquals(tvShowsList.size, result.size)
    }

    @Test
    fun getMovieDetail() {
        Mockito.doAnswer {
            val callback = it.arguments[1] as RemoteDataSource.GetMoviesDetailCallback
            callback.onMoviesDetailLoaded(movieDetail)
            null
        }.`when`(remoteRepository).getMoviesDetail(Mockito.eq(movieId), Mockito.any(RemoteDataSource.GetMoviesDetailCallback::class.java))

        val result = LiveDataTestUtil.getValue(dataRepositoryTest.getMovieDetail(movieId))
        Mockito.verify(
                remoteRepository,
                Mockito.times(1)).getMoviesDetail(Mockito.eq(movieId), Mockito.any(RemoteDataSource.GetMoviesDetailCallback::class.java))
        Assert.assertEquals(movieDetail.id, result.id)
    }

    @Test
    fun getMovie() {
        Mockito.doAnswer {
            val callback = it.arguments[0] as RemoteDataSource.GetMoviesCallback
            callback.onMoviesLoaded(movieList)
            null
        }.`when`(remoteRepository).getListMovies(Mockito.any(RemoteDataSource.GetMoviesCallback::class.java))

        val result = LiveDataTestUtil.getValue(dataRepositoryTest.getMovieList())
        Mockito.verify(remoteRepository, Mockito.times(1)).getListMovies(Mockito.any(RemoteDataSource.GetMoviesCallback::class.java))

        Assert.assertEquals(movieList.size, result.size)
    }

}