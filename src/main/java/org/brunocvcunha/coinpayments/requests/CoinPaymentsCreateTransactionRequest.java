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
package org.brunocvcunha.coinpayments.requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.*;
import lombok.extern.log4j.Log4j;
import org.brunocvcunha.coinpayments.model.CreateTransactionResponse;
import org.brunocvcunha.coinpayments.model.ResponseWrapper;
import org.brunocvcunha.coinpayments.requests.base.CoinPaymentsPostRequest;

/**
 * CoinPaymentsCreateTransactionRequest
 * 
 * @author Bruno Candido Volpato da Cunha
 *
 */
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Log4j
public class CoinPaymentsCreateTransactionRequest
        extends CoinPaymentsPostRequest<ResponseWrapper<CreateTransactionResponse>> {

    @NonNull
    private double amount;

    @NonNull
    private String currencyPrice;

    @NonNull
    private String currencyTransfer;

    @Builder.Default private String address = "";

    @Builder.Default private String buyerEmail = "";
    @Builder.Default private String buyerName = "";
    @Builder.Default private String itemName = "";
    @Builder.Default private String itemCode = "";
    @Builder.Default private String invoice = "";
    @Builder.Default private String custom = "";
    @Builder.Default private String callbackUrl = "";
    @Builder.Default private long timeout = 7200;           //expiration of transaction in seconds

    @Override
    public String getUrl() {
        return "";
    }

    @Override
    public String getPayload() {
        return "cmd=create_transaction" + "&amount=" + amount + "" + "&currency1=" + currencyPrice + "&currency2="
                + currencyTransfer + "&address=" + address + "&buyer_email=" + buyerEmail + "&buyer_name=" + buyerName
                + "&item_name=" + itemName + "&item_number=" + itemCode + "&invoice=" + invoice + "&custom=" + custom
                + "&ipn_url=" + callbackUrl + "&timeout=" + timeout;
    }

    @Override
    public ResponseWrapper<CreateTransactionResponse> parseResult(int statusCode, String content) throws JsonProcessingException {
        log.debug("parsing CreateTransactionResponse:  "+ content + ", statusCode: " + statusCode);
        ResponseWrapper<CreateTransactionResponse> wrapper = parseJson(content,
                new TypeReference<ResponseWrapper<CreateTransactionResponse>>() {
                });
        return wrapper;
    }

}
