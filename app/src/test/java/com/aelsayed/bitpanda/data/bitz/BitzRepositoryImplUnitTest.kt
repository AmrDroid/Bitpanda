package com.aelsayed.bitpanda.data.bitz

import com.aelsayed.bitpanda.data.bitz.entity.BitzFactory.Companion.providesBitz
import com.aelsayed.bitpanda.data.bitz.datasource.BitzRemoteDataSource
import com.aelsayed.bitpanda.data.bitz.repository.BitzRepositoryImpl
import com.aelsayed.bitpanda.data.extension.assertGeneralsError
import com.aelsayed.bitpanda.data.extension.assertGeneralsSuccess
import com.aelsayed.bitpanda.data.extension.getSingleError
import com.aelsayed.bitpanda.data.extension.getSingleResultSuccess
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BitzRepositoryImplUnitTest {

    private lateinit var bitzRepositoryImpl: BitzRepositoryImpl

    @Mock
    private lateinit var bitzRemoteDataSource: BitzRemoteDataSource

    @Before
    fun setUp() {
        bitzRepositoryImpl = BitzRepositoryImpl(bitzRemoteDataSource)
    }

    @Test
    fun `getBitz should return a bitz`() {
        whenever(bitzRemoteDataSource.getBitz())
            .thenReturn(getSingleResultSuccess(providesBitz()))

        val testObserver = bitzRemoteDataSource.getBitz().test()

        testObserver.assertGeneralsSuccess {
            it != null
        }
    }

    @Test
    fun `getBitz should not return a bitz in case of an error`() {
        whenever(bitzRemoteDataSource.getBitz())
            .doReturn(getSingleError())

        val testObserver = bitzRemoteDataSource.getBitz().test()

        testObserver.assertGeneralsError()
    }

}