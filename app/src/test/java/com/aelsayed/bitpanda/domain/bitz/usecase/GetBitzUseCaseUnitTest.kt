package com.aelsayed.bitpanda.domain.bitz.usecase

import com.aelsayed.bitpanda.domain.bitz.entity.BitzFactory.Companion.providesBitz
import com.aelsayed.bitpanda.domain.bitz.repository.BitzRepository
import com.aelsayed.bitpanda.domain.extension.*
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetBitzUseCaseUnitTest {

    private lateinit var getBitzUseCase: GetBitzUseCase

    @Mock
    private lateinit var bitzRepository: BitzRepository

    @Before
    fun setUp() {
        getBitzUseCase = GetBitzUseCase(bitzRepository)
    }

    @Test
    fun `invoke should return a bitz`() {
        whenever(bitzRepository.getBitz())
            .thenReturn(getSingleSuccess(providesBitz()))

        val testObserver = getBitzUseCase(Unit).testAwait()

        testObserver.assertGeneralsSuccess {
            it != null
        }
    }

    @Test
    fun `invoke should not return a bitz in case of an error`() {
        whenever(bitzRepository.getBitz())
            .doReturn(getSingleError())

        val testObserver = getBitzUseCase(Unit).testAwait()

        testObserver.assertGeneralsError()
    }

}