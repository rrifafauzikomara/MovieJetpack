package com.rifafauzi.moviecatalogue.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rifafauzi.moviecatalogue.helper.repository.Repository
import com.rifafauzi.moviecatalogue.model.TvShow
import com.rifafauzi.moviecatalogue.utils.FakeData
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.Mockito

class TvShowViewModelTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var viewModel: TvShowViewModel? = null
    private var repository = Mockito.mock(Repository::class.java)
    private lateinit var tvshow: TvShow


    @Before
    fun setUp() {
        viewModel = TvShowViewModel(repository)
        tvshow =  TvShow(
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
    fun getListTvShow() {
        val tvShowsList = MutableLiveData<List<TvShow>>()
        tvShowsList.value = FakeData.generateDummyTvShow()
        Mockito.`when`(repository.getTvShowsList()).thenReturn(tvShowsList)
        val observer = Mockito.mock(Observer::class.java)
        viewModel?.listTvShow?.observeForever(observer as Observer<List<TvShow>>)
        Mockito.verify(repository).getTvShowsList()
    }

    @Test
    fun getDetailTvShow() {
        val tvShowDetail = MutableLiveData<TvShow>()
        tvShowDetail.value = FakeData.getTvShowsDetail()
        Mockito.`when`(repository.getTvShowsDetail(tvShowDetail.value!!.id.toString())).thenReturn(tvShowDetail)
        val observer = Mockito.mock(Observer::class.java)
        viewModel?.getDetailTvShow(tvShowDetail.value!!.id.toString())?.observeForever(observer as Observer<TvShow>)
        Mockito.verify(repository).getTvShowsDetail(tvShowDetail.value!!.id.toString())
        assertEquals(tvShowDetail.value!!.id, viewModel?.getDetailTvShow(tvShowDetail.value!!.id.toString())?.value?.id)
        assertEquals(tvShowDetail.value!!.name, viewModel?.getDetailTvShow(tvShowDetail.value!!.id.toString())?.value?.name)
        assertEquals(tvShowDetail.value!!.overview, viewModel?.getDetailTvShow(tvShowDetail.value!!.id.toString())?.value?.overview)
        assertEquals(tvShowDetail.value!!.posterPath, viewModel?.getDetailTvShow(tvShowDetail.value!!.id.toString())?.value?.posterPath)
        assertEquals(tvShowDetail.value!!.releaseDate, viewModel?.getDetailTvShow(tvShowDetail.value!!.id.toString())?.value?.releaseDate)
    }
}