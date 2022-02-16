package ex02.movieApp001;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
//        if (discountPolicy == null) {
//            return fee;
//        }
//  할인 금액에 대한 역할을 Movie 클래스에서 예외로 처리하게 되어 역할과 책임에 대한 옳은 방법이 아니다.
//  이를 해결하기 위해 NoneDiscountPolicy 클래스를 추가하게 되었다.
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}
