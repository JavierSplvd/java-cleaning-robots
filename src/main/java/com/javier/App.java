package com.javier;

import java.util.Scanner;

import com.javier.delivery.CliState;
import com.javier.delivery.CreateGridState;
import com.javier.delivery.Renderer;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CliState state = new CreateGridState();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            state = state.input(input);
        }

        if (state.getGrid() != null) {
            Renderer.render(state.getGrid());
        } else {
            System.out.println("No grid created.");
        }
        scanner.close();

    }
}
