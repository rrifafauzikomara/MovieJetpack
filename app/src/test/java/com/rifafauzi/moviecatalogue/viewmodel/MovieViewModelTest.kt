package com.rifafauzi.moviecatalogue.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rifafauzi.moviecatalogue.helper.repository.Repository
import com.rifafauzi.moviecatalogue.model.Movies
import com.rifafauzi.moviecatalogue.utils.FakeData
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.Mockito

class MovieViewModelTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var viewModel: MovieViewModel? = null
    private val repository  = Mockito.mock(Repository::class.java)
    private lateinit var movies: Movies

    @Before
    fun setUp() {
        viewModel = MovieViewModel(repository)
        movies = Movies(
                "/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg",
                "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
                "2019-07-12",
                420818,
                "The Lion King"
        )
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getListMovies() {
        val moviesList = MutableLiveData<List<Movies>>()
        moviesList.value = FakeData.generateDummyMovies()
        Mockito.`when`(repository.getMovieList()).thenReturn(moviesList)
        val observer = Mockito.mock(Observer::class.java)
        viewModel?.listMovies?.observeForever(observer as Observer<List<Movies>>)
        Mockito.verify(repository).getMovieList()
    }

    @Test
    fun getDetailMovie() {
        val moviesDetail = MutableLiveData<Movies>()
        moviesDetail.value = FakeData.getMovieDetail()
        Mockito.`when`(repository.getMovieDetail(moviesDetail.value!!.id.toString())).thenReturn(moviesDetail)
        val observer = Mockito.mock(Observer::class.java)
        viewModel?.getDetailMovie(moviesDetail.value!!.id.toString())?.observeForever(observer as Observer<Movies>)
        Mockito.verify(repository).getMovieDetail(moviesDetail.value!!.id.toString())
        assertEquals( moviesDetail.value!!.id, viewModel?.getDetailMovie(moviesDetail.value!!.id.toString())?.value?.id)
        assertEquals(moviesDetail.value!!.title, viewModel?.getDetailMovie(moviesDetail.value!!.id.toString())?.value?.title)
        assertEquals(moviesDetail.value!!.overview, viewModel?.getDetailMovie(moviesDetail.value!!.id.toString())?.value?.overview)
        assertEquals(moviesDetail.value!!.posterPath, viewModel?.getDetailMovie(moviesDetail.value!!.id.toString())?.value?.posterPath)
        assertEquals(moviesDetail.value!!.releaseDate, viewModel?.getDetailMovie(moviesDetail.value!!.id.toString())?.value?.releaseDate)
    }
}