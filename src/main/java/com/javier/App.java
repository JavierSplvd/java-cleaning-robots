package com.javier;

import com.javier.delivery.CliPresenter;
import com.javier.delivery.Presenter;

public class App {
    public static void main(String[] args) {
        Presenter presenter = new CliPresenter();
        presenter.render();
    }
}
