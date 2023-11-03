package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void fitsMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("Выкатка");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void fitsTwoMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("Приложение");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void negativeMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("Проработка");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void fitsSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Позвонить");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void negativeSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Написать");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void fitsEpic() {
        String[] subtasks = {"Пойти гулять", "Купить торт"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("Купить торт");
        boolean expected = true;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void negativeEpic() {
        String[] subtasks = {"Пойти гулять", "Купить торт"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("Поехать гулять");
        boolean expected = false;
        Assertions.assertEquals(expected, actual);

    }
}
