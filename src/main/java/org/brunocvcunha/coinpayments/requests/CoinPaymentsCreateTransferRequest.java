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
import org.brunocvcunha.coinpayments.model.CreateTransferResponse;
import org.brunocvcunha.coinpayments.model.ResponseWrapper;
import org.brunocvcunha.coinpayments.requests.base.CoinPaymentsPostRequest;

import com.fasterxml.jackson.core.type.TypeReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CoinPaymentsCreateTransferRequest extends CoinPaymentsPostRequest<ResponseWrapper<CreateTransferResponse>>  {
	
    @NonNull
    private double amount;

    @NonNull
    private String currency;

    @Builder.Default
    private String merchant = "";
    
    @Builder.Default
    private String pbntag = "";

    @Builder.Default private boolean autoConfirm = true;


	@Override
	public String getUrl() {
		return "";
	}

    @Override
    public String getPayload() {
    	String p = (!merchant.isEmpty()) ? "&merchant=" + merchant : "&pbntag" + pbntag;
        return "cmd=create_transfer" + "&amount=" + amount + p + "&currency=" + currency + "&auto_confirm=" + ( autoConfirm ? 1 : 0 );
    }

	@Override
	public ResponseWrapper<CreateTransferResponse> parseResult(int resultCode, String content) throws JsonProcessingException {
        ResponseWrapper<CreateTransferResponse> wrapper = parseJson( content, new TypeReference<ResponseWrapper<CreateTransferResponse>>() {} );
        return wrapper;
	}

}
