package com.javier.delivery;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.javier.domain.FactoryFloorGrid;
import com.javier.usecases.State;
import com.javier.usecases.StateFactory;

@ExtendWith(MockitoExtension.class)
public class CliPresenterTest {
    Scanner mockScanner = Mockito.mock(Scanner.class);
    State mockState = Mockito.mock(State.class);
    FactoryFloorGrid grid = new FactoryFloorGrid(5, 5);
    static MockedStatic<StateFactory> mockStateFactory;

    @Spy
    CliPresenter cliPresenter = new CliPresenter(mockScanner, mockState);

    @BeforeAll
    public static void beforeAll() {
        mockStateFactory = Mockito.mockStatic(StateFactory.class);
    }

    @BeforeEach
    public void setup() {
        mockStateFactory.when(StateFactory::create).thenReturn(mockState);
        Mockito.when(mockScanner.nextLine()).thenReturn("5 5", "1 2 N", "LMLMLMLMM", "exit");
        Mockito.when(mockState.input("5 5")).thenReturn(mockState);
        Mockito.when(mockState.input("1 2 N")).thenReturn(mockState);
        Mockito.when(mockState.input("LMLMLMLMM")).thenReturn(mockState);
        Mockito.when(mockState.getGrid()).thenReturn(grid);
    }

    @AfterEach
    public void tearDown() {
        Mockito.reset(mockScanner, mockState);
    }

    @Test
    public void shouldRender() {
        Mockito.when(mockState.getGrid()).thenReturn(grid);

        cliPresenter.render();

        Mockito.verify(cliPresenter, Mockito.times(1)).printFormatted(grid);
    }

    @Test
    public void whenStateDontReturnGrid_shouldThrow() {
        Mockito.when(mockState.getGrid()).thenReturn(null);

        assertThrows(RuntimeException.class, () -> cliPresenter.render());
    }
}
