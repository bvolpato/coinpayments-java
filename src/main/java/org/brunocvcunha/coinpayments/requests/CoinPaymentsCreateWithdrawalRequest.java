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
import org.brunocvcunha.coinpayments.model.CreateWithdrawalResponse;
import org.brunocvcunha.coinpayments.model.ResponseWrapper;
import org.brunocvcunha.coinpayments.requests.base.CoinPaymentsPostRequest;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CoinPaymentsCreateWithdrawalRequest extends CoinPaymentsPostRequest<ResponseWrapper<CreateWithdrawalResponse>> {

    @NonNull
    private double amount;

    @Builder.Default private boolean addTransactionFee = false;

    @NonNull
    private String currency;

    @Builder.Default private String withdrawCurrency = "";

    @NonNull
    private String address;

    @Builder.Default private String destinationTag = "";
    @Builder.Default private String ipnURL = "";
    @Builder.Default private boolean autoConfirm = true;
    @Builder.Default private String note = "";

    @Override
    public String getUrl () {
        return "";
    }

    @Override
    public String getPayload () {
        return "cmd=create_withdrawal" + "&amount=" + amount + "&add_tx_fee=" + ( addTransactionFee ? 1 : 0 ) + "&currency=" + currency + "&currency2=" + withdrawCurrency + "&address=" + address + "&dest_tag=" + destinationTag + "&ipn_url=" + ipnURL + "&auto_confirm=" + ( autoConfirm ? 1 : 0 ) + "&note=" + note;
    }

    @Override
    public ResponseWrapper<CreateWithdrawalResponse> parseResult ( int resultCode, String content ) throws JsonProcessingException {
        ResponseWrapper<CreateWithdrawalResponse> wrapper = parseJson( content, new TypeReference<ResponseWrapper<CreateWithdrawalResponse>>() {} );
        return wrapper;
    }
}
