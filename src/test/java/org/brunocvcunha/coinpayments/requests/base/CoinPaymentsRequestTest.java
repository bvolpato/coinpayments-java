/**
 * Copyright (C) 2018 Bruno Candido Volpato da Cunha (brunocvcunha@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.brunocvcunha.coinpayments.requests.base;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.brunocvcunha.coinpayments.model.BasicInfoResponse;
import org.brunocvcunha.coinpayments.model.ResponseWrapper;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;

public class CoinPaymentsRequestTest {

    @Test
    public void parseJsonUsesProvidedTypeReference() {
        TestRequest request = new TestRequest();
        ResponseWrapper<BasicInfoResponse> response = request.parseJson(
            "{\"error\":\"ok\",\"result\":{\"username\":\"bruno\",\"merchant_id\":\"123\",\"public_name\":\"Bruno\"}}",
            new TypeReference<ResponseWrapper<BasicInfoResponse>>() {}
        );

        assertEquals("ok", response.getError());
        assertEquals("bruno", response.getResult().getUsername());
        assertEquals("123", response.getResult().getMerchantId());
        assertEquals("Bruno", response.getResult().getPublicName());
    }

    private static class TestRequest extends CoinPaymentsRequest<ResponseWrapper<BasicInfoResponse>> {

        @Override
        public String getUrl() {
            return null;
        }

        @Override
        public String getMethod() {
            return null;
        }

        @Override
        public ResponseWrapper<BasicInfoResponse> execute() throws ClientProtocolException, IOException {
            return null;
        }

        @Override
        public ResponseWrapper<BasicInfoResponse> parseResult(int resultCode, String content) {
            return null;
        }
    }
}
