package com.javier;

import com.javier.delivery.Presenter;
import com.javier.delivery.PresenterFactory;

public class App {
    public static void main(String[] args) {
        Presenter presenter = PresenterFactory.create();
        presenter.render();
    }
}
