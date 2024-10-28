package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        // Описываем, что загрузится по адресу /
        app.get("/hello", ctx -> {
                    var name = ctx.queryParam("name");
            if (name != null && !name.isEmpty()) {
                ctx.result("Hello, " + name + "!");
            } else {
                ctx.result("Hello, World!");
            }
                });
        app.post("users", ctx -> ctx.result("POST /users"));
        app.start(7070); // Стартуем веб-сервер
    }
}
