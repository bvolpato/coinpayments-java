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
import org.brunocvcunha.coinpayments.model.AddressResponse;
import org.brunocvcunha.coinpayments.model.ResponseWrapper;
import org.brunocvcunha.coinpayments.requests.base.CoinPaymentsPostRequest;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CoinPaymentsGetCallbackAddressRequest extends CoinPaymentsPostRequest<ResponseWrapper<AddressResponse>> {

    @NonNull
    private String currency;

    @Builder.Default private String IPNUrl = "";

    @Override
    public String getUrl () {
        return "";
    }

    @Override
    public String getPayload () {
        return "cmd=get_callback_address" + "&currency=" + currency + "&ipn_url=" + IPNUrl;
    }

    @Override
    public ResponseWrapper<AddressResponse> parseResult ( int resultCode, String content ) throws JsonProcessingException {
        ResponseWrapper<AddressResponse> wrapper = parseJson( content, new TypeReference<ResponseWrapper<AddressResponse>>() {} );
        return wrapper;
    }

}
