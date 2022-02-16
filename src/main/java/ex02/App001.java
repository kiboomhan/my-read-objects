package ex02;

import ex02.movieApp001.*;

import java.time.*;

public class App001 {

    public static void main(String[] args) {

        Movie avatar = new Movie("아바타",
                Duration.ofMillis(120),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11,59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));
        System.out.println(avatar);

        Movie titanic = new Movie("타이타닉",
                Duration.ofMillis(180),
                Money.wons(11000),
                new PercentDiscountPolicy(0.1,
                        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16,59)),
                        new SequenceCondition(2),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))));
        System.out.println(titanic);

        // 할인정책 없는 스타워즈
        Movie starWars = new Movie("스타워즈",
                Duration.ofMinutes(210),
                Money.wons(10000),
                new NoneDiscountPolicy());

        // 상속보다는 합성을 사용하면 갖는 이점
        avatar.changeDiscountPolicy(new PercentDiscountPolicy(0.1,
                new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16,59)),
                new SequenceCondition(2),
                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))));


        Screening screening = new Screening(avatar, 1, LocalDateTime.of(2022, Month.FEBRUARY.getValue(), 14, 10, 00));
        screening.reserve(new Customer(), 1);

    }
}
