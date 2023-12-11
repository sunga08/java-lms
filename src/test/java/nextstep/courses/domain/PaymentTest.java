package nextstep.courses.domain;

import nextstep.courses.exception.PaymentException;
import nextstep.payments.domain.Payment;
import nextstep.users.domain.NsUserTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PaymentTest {

    @Test
    @DisplayName("결제 금액이 일치하는지 확인한다.")
    void 결제_금액_일치() {
        
    }
}
