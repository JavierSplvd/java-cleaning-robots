package com.javier.delivery;

import java.util.Scanner;

import com.javier.usecases.StateFactory;

public class PresenterFactory {
    public static Presenter create() {
        return new CliPresenter(new Scanner(System.in),  StateFactory.create());
    }
}
