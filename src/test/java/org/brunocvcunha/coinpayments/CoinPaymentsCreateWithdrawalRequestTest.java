package org.brunocvcunha.coinpayments;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.brunocvcunha.coinpayments.model.CreateWithdrawalResponse;
import org.brunocvcunha.coinpayments.model.ResponseWrapper;
import org.brunocvcunha.coinpayments.requests.CoinPaymentsCreateWithdrawalRequest;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoinPaymentsCreateWithdrawalRequestTest {
    @Test(expected = JsonProcessingException.class)
    public void throwJsonProcessingExceptionOnParsingError() throws JsonProcessingException {
        final CoinPaymentsCreateWithdrawalRequest request =
                new CoinPaymentsCreateWithdrawalRequest(0.0, "BTC", "fake_address");
        request.parseResult(500, "{\"error\":\"That amount is larger than your balance!\",\"result\":[]}");
    }

    @Test
    public void successfullyOkResponseToResponseObject() throws JsonProcessingException {
        final CoinPaymentsCreateWithdrawalRequest request =
                new CoinPaymentsCreateWithdrawalRequest(0.0, "BTC", "fake_address");
        final String content = "{" +
                "\"error\":\"That amount is larger than your balance!\"," +
                "\"result\":{\"id\": \"fake_id\", \"status\": 200,\"amount\": 1.0, \"error\": \"ok\", \"note\": \"note\"}" +
                "}";
        final ResponseWrapper<CreateWithdrawalResponse> response = request.parseResult(200, content);
        assertNotNull(response);
        assertNotNull(response.getResult());
    }
}
